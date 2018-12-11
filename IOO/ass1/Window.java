/*
 * Class Name:    Window
 *
 * Author:        Peter Muir
 * Creation Date: Thursday, April 27 2017, 22:19 
 * Last Modified: Friday, April 28 2017, 02:27
 * 
 * Class Description:   Creates a Window object to be used with Shape subclasses
 * to draw a picture of some kind.
 *
 */
import java.util.*;
public class Window
{
   private int height;
   private int width;
   private char borderChar;
   private char[][] s;
   private ArrayList<Shape> shapes;

   public Window(int height,int width, char borderChar)
   {
      this.height = height;
      this.width = width;
      this.borderChar = borderChar;
      this.s = new char[height][width];
      for(int i = 0; i < height; ++i) Arrays.fill(s[i],' ');
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
      System.out.println("Not implemented");
   }

   public void insert(int row,int col,char c)
   {
      s[row-1][col-1] = c;
   }

   public void display()
   {
      if(s == null)
      {
         System.out.println("s is null");
      }else
      {
         //draw all shapes
         for(int x = 0; x < shapes.size(); ++x)
         {
            shapes.get(x).draw(this);
         }
         //draw top border
         for(int k = 0; k < width + 2; ++k) System.out.print(borderChar);
         System.out.println();
         //draw the array
         for(int i = 0; i < height; ++i)
         {
            System.out.print(borderChar);
            //left border
            for(int j = 0; j < width; ++j)
            {
               System.out.print(s[i][j]);
               //Shapes
            }
            System.out.println(borderChar);
            //right border
         }
         //draw bottom border
         for(int k = 0; k < width + 2;++k) System.out.print(borderChar);
         System.out.println();
      }
   }
}
