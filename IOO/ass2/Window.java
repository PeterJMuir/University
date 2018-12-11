// * Class Name:    Window
// *
// * Author:        Peter Muir
// * Creation Date: Thursday, April 27 2017, 22:19 
// * Last Modified: Friday, April 28 2017, 02:27
// * 
// * Class Description:   Creates a Window object to be used with Shape subclasses
// * to draw a picture of some kind.
// *
// */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Window
{
   private int height = 0;
   private int width = 0;
   private char borderChar;
   private char[][] s;
   private ArrayList<Shape> shapes;

   public Window(int height,int width, char borderChar)
   {
      this.height = height+2;
      this.width = width+2;
      this.borderChar = borderChar;
      this.s = new char[height+2][width+2];
      for(int i = 0; i < height+2; ++i) Arrays.fill(s[i],' ');
      this.shapes = new ArrayList<Shape>();
   }

   public void addShape(Shape shape)
   {
      //Start row/column at 1. i.e. for(int k = 1; k <= width; ++k) s[i-1][k-1]
      //= '!';
      shapes.add(shape);
   }

   public void removeShape(String id)
   {
	   int rowNum = Integer.parseInt(id);
	   for(int i = 0; i < shapes.size(); ++i)
	   {
		   if(rowNum == i)
		   {
			   shapes.remove(i);
		   }
	   }
   }
   
   public void showShapes()
   {
	   for(int i = 0; i < shapes.size(); ++i)
	   {
			   System.out.printf("%d: %s\n", i, shapes.get(i).toSelectString());
	   }
   }
   
   public void alterShape(String id,char choice)
   {
	   int rowNum = Integer.parseInt(id);
	   if( (0 <= rowNum) && (rowNum < shapes.size()) )
	   {
		   switch(choice)
		   {
		   	case 'U':
			case 'u':
				shapes.get(rowNum).setRowBase( shapes.get(rowNum).getRowBase() - 1 );
				break;
			case 'D':
			case 'd':
				shapes.get(rowNum).setRowBase( shapes.get(rowNum).getRowBase() + 1 );
				break;
			case 'L':
			case 'l':
				shapes.get(rowNum).setColBase( shapes.get(rowNum).getColBase() - 1 );
				break;
			case 'R':
			case 'r':
				shapes.get(rowNum).setColBase( shapes.get(rowNum).getColBase() + 1 );
				break;
			case '+':
				shapes.get(rowNum).alterSize(1);
				break;
			case '-':
				shapes.get(rowNum).alterSize(-1);
				break;
		   }
	   }
   }

   public void insert(int row,int col,char c)
   {
	   if((height > 0) && (width > 0))
	   {
		   //if row and col are within range, draw.
		   if( ( (0 < row) && (row < height-1) ) && ( (0 < col) && (col < width-1) ))
		   {
			   s[row][col] = c;
		   }
	   }
   }
   
   public void addGrid()
   {
	   if((height > 0) && (width > 0))
	   {
		   for(int rowNum = 0; rowNum < height; ++rowNum)
		   {
			   for(int colNum = 0; colNum < width; ++colNum)
			   {
				   if( (0 == rowNum) || ((height-1) == rowNum) )
				   {
					   if( (0 == colNum) || ((width-1) == colNum) )
					   {
						   s[rowNum][colNum] = borderChar;
					   }else
					   {
						   s[rowNum][colNum] = (char)((colNum % 10) + 0x30);	//convert to ASCII
					   }
				   }else
				   {
					   if( (0 == colNum) || ((width-1) == colNum) )
						{
						   s[rowNum][colNum] = (char)((rowNum % 10) + 0x30);	//convert to ASCII
						}
				   }
			   }
		   }
	   }
   }

   public void display()
   {
	  if((height == 0) && (width == 0))
      {
         System.out.println("s is not initialised");
      }else
      {
    	  addGrid();
    	  refreshImage();// clear window and draw shapes
         
         for(int i = 0; i < height;++i)
         {
        	 for(int j = 0; j < width; ++j)
        	 {
        		 System.out.print(s[i][j]);	//print the window to the screen
        	 }
        	 System.out.println();	//new line after each row is finished
         }
      }
   }
   
   public void refreshImage()
   {
	   for(int i = 1; i < height - 1; ++i)
	   {
		   for(int j = 1; j < width - 1; ++j)
		   {
			   s[i][j] = ' ';	//clear the inside of the grid
		   }
	   }
	   for(int x = 0; x < shapes.size(); ++x)
       {
          shapes.get(x).draw(this);	//draw each shape onto the window
       }
   }
   
   public void writeSpecToFile(String fileName) throws FileNotFoundException
	{
		File outFile = new File(fileName);
		PrintWriter out = new PrintWriter(outFile);
		out.printf("%d %d\n%c\n.", this.height-2, this.width-2, this.borderChar);
		for(int i = 0; i < shapes.size(); ++i)
		{
			out.print("\n" + shapes.get(i) + "\n.");
		}
		out.close();
	}
	
	public static Window readSpecFromFile(String fileName) throws FileNotFoundException
	{
		
		File inFile = new File(fileName);
		Scanner r = new Scanner(inFile);
		int h,w;
		char bC;
		h = r.nextInt();
		w = r.nextInt();
		r.nextLine();	//get rid of \n
		bC = r.nextLine().charAt(0);
		r.nextLine();	//get rid of ".\n"
		Window window = new Window(h,w,bC);
		
		String shapeType;
		int rowBase,colBase, size, rowInc, colInc;
		char shapeChar;
		Shape shape;
		while(r.hasNext())
		{
			shapeType = r.nextLine().trim();
			rowBase = r.nextInt();
			colBase = r.nextInt();
			switch(shapeType)
			{
				case "line":
					size = r.nextInt();
					rowInc = r.nextInt();
					colInc = r.nextInt();
					r.nextLine();//get rid of "\n"
					shapeChar = r.nextLine().charAt(0);
					shape = new Line(rowBase,colBase,size,rowInc,colInc,shapeChar);
					break;
				case "circle":
					size = r.nextInt();
					r.nextLine();//get rid of "\n"
					shapeChar = r.nextLine().charAt(0);
					shape = new Circle(rowBase,colBase,size,shapeChar);
					break;
				case "triangle":
					size = r.nextInt();
					rowInc = r.nextInt();
					colInc = r.nextInt();
					r.nextLine();//get rid of "\n"
					shapeChar = r.nextLine().charAt(0);
					shape = new Triangle(rowBase,colBase,size,rowInc,colInc,shapeChar);
					break;
				case "rectangle":
					size = r.nextInt();
					int recWidth = r.nextInt();
					r.nextLine();//get rid of "\n"
					shapeChar = r.nextLine().charAt(0);
					shape = new Rectangle(rowBase,colBase,size,recWidth,shapeChar);
					break;
				case "text":
					r.nextLine();	//get rid of "\n"
					String message = r.nextLine();
					rowInc = r.nextInt();
					colInc = r.nextInt();
					r.nextLine();	//get rid of "\n"
					shape = new Text(rowBase,colBase,message,rowInc,colInc);
					break;
				default:
					shape = null;
			}
			r.nextLine();	//get rid of ".\n"
			window.addShape(shape);
		}
		r.close();
		return window;
	}
}
