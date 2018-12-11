import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DrawingBoard {
	public static void main(String[] args)	throws FileNotFoundException, NoSuchElementException
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the window file name (or NEW):");
		String fileName = kb.nextLine();
		Window window;
		boolean quit_flag = false;
		if(fileName.equalsIgnoreCase("NEW"))
		{
			try{
			System.out.println("Enter number of rows, number of columns and character (separated by space):");
			int height = kb.nextInt();
			int width = kb.nextInt();
			char borderChar = kb.nextLine().trim().charAt(0);
			window = new Window(height,width,borderChar);
			}catch(InputMismatchException i)
			{
				System.out.println("Wrong Input");
				quit_flag = true;
				window = null;
			}catch(IndexOutOfBoundsException s)
			{
				System.out.println("Not enough Inputs");
				quit_flag = true;
				window = null;
			}
		}else
		{
			try{
				window = Window.readSpecFromFile(fileName);
			}catch(FileNotFoundException f){
				System.out.println("No File Found");
				quit_flag = true;
				window = null;
			}
		}
		String selNum = "-1";
		while(!quit_flag)
		{
			window.display();
			System.out.println("Add Erase Select Write Quit\n"
					+ "Up Down Left Right + -");
			try{
			char choice = kb.nextLine().trim().charAt(0);
			switch(choice)
			{
				case 'A':
				case 'a':
					addTo(window, kb);
					break;
				case 'E':
				case 'e':
					window.showShapes();
					String temp = kb.nextLine().trim();
					if(selNum.equals(temp))
					{
						selNum = "-1";
					}
					window.removeShape(temp);
					break;
				case 'S':
				case 's':
					window.showShapes();
					selNum = kb.nextLine().trim();
					break;
				case 'W':
				case 'w':
					System.out.print("File name: ");
					window.writeSpecToFile(kb.nextLine().trim());
					break;
				case 'Q':
				case 'q':
					System.out.println("Thank You!");
					quit_flag = true;
					break;
				case 'U':
				case 'u':
				case 'D':
				case 'd':
				case 'L':
				case 'l':
				case 'R':
				case 'r':
				case '+':
				case '-':
					window.alterShape(selNum,choice);
					break;
				default:
					System.out.println("write a valid character for menu options");	
			}
			}catch(Exception e)
			{
				System.out.println("Try again");
			}
		}
		kb.close();
	}
	
	public static void addTo(Window window, Scanner r)
	{
		System.out.println("circle rowBase colBase radius character");
		System.out.println("line rowBase colBase length rowIncrement colIncrement character");
		try{
		String[] temp = r.nextLine().split(" ");
		String shapeType = temp[0].trim();
		int rowBase = Integer.parseInt(temp[1]);
		int colBase = Integer.parseInt(temp[2]);
		int size = Integer.parseInt(temp[3]);
		char shapeChar;
		Shape shape;
			switch(shapeType)
			{
				case "line":
					int rowInc = Integer.parseInt(temp[4]);
					int colInc = Integer.parseInt(temp[5]);
					shapeChar = temp[6].trim().charAt(0);
					shape = new Line(rowBase,colBase,size,rowInc,colInc,shapeChar);
					break;
				case "circle":
					shapeChar = temp[4].trim().charAt(0);
					shape = new Circle(rowBase,colBase,size,shapeChar);
					break;
				default:
					shape = null;
			}
		window.addShape(shape);
		}catch(ArrayIndexOutOfBoundsException i)
		{
			System.out.println("not enough values");
		}catch(NumberFormatException n)
		{
			System.out.println("Please write numbers for the required fields");
		}
	}
}
