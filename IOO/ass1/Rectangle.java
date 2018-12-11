/*
 * Class Name:    Rectangle
 *
 * Author:        Peter Muir
 * Creation Date: Thursday, April 27 2017, 23:01 
 * Last Modified: Friday, April 28 2017, 02:27
 * 
 * Class Description:   Creates Rectangle Objects to be drawn in Window
 *
 */

public class Rectangle extends Shape
{
   private int height;
   private int width;

   public Rectangle(int rowBase, int colBase, int height, int width, char drawingChar)
   {
      super(rowBase, colBase, drawingChar);
      this.height = height;
      this.width = width; 
   }

   public void draw(Window window)
   {
      int i = getRowBase();
      int j = getColBase();
      char c = getDrawingChar();
      //top of rectangle
      for(int k = j; k <= (j + width); ++k)
      {
         window.insert(i,k,c);
      }
      //body of rec
      for(int k = i + 1; k < (i + height); ++k)
      {

         window.insert(k,j,c);
         window.insert(k,j + width, c);
      }
      //bottom of rec
      for(int k = j; k <= (j + width); ++k)
      {
         window.insert(i + height,k,c);
      }

   }
}
