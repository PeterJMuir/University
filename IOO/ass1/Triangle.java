/*
 * Class Name:    Triangle
 *
 * Author:        Peter Muir
 * Creation Date: Thursday, April 27 2017, 23:01 
 * Last Modified: Friday, April 28 2017, 02:27
 * 
 * Class Description:   Creates Triangle Objects to be drawn in Window
 *
 */

public class Triangle extends Shape
{
   private int height;
   private int rowIncrement;
   private int colIncrement;

   public Triangle(int rowBase, int colBase, int height, int rowIncrement, int colIncrement, char drawingChar)
   {
      super(rowBase, colBase, drawingChar);
      this.height = height;
      this.rowIncrement = rowIncrement;
      this.colIncrement = colIncrement;
   }

   public void draw(Window window)
   {
      int i = getRowBase();
      int j = getColBase();
      char c = getDrawingChar();
      //draw base point
      window.insert(i,j,c);
      //draw sides
      for(int k = 1; k < height; ++k)
      {
         int increment = k*(colIncrement + rowIncrement);
         window.insert(i + k*(rowIncrement + colIncrement),j + k*(colIncrement + rowIncrement),getDrawingChar());
         window.insert(i + k*(rowIncrement - colIncrement),j + k*(colIncrement - rowIncrement),getDrawingChar());
      }
      int tempI = i + (rowIncrement*height);//temp vars for base of triangle
      int tempJ = j + (colIncrement*height);
      //draw base of triangle
      window.insert(tempI,tempJ, c);
      for(int k = 1; k <= height; ++k)
       {
          window.insert(tempI + k*colIncrement,tempJ + k*rowIncrement,c);
          window.insert(tempI - k*colIncrement,tempJ - k*rowIncrement,c);
       }
   }
}
