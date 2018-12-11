/*
 * Class Name:    Circle
 *
 * Author:        Peter Muir
 * Creation Date: Thursday, April 27 2017, 23:01 
 * Last Modified: Friday, April 28 2017, 09:52
 * 
 * Class Description:   Creates a Circle object to be drawn onto a Window
 *
 */
public class Circle extends Shape
{
   private int radius;

   public Circle(int rowBase, int colBase, int radius, char drawingChar)
   {
      super(rowBase, colBase, drawingChar);
      this.radius = radius;
   }

   public void draw(Window window)
   {
      int i = getRowBase();
      int j = getColBase();
      char c = getDrawingChar();
      //top of rectangle
      for(int k = 0; k < 20; ++k)
      {
         double alpha = k*(Math.PI *0.1); //2*PI divided by 20 points = PI/10 = PI*0.1 radians per point
/*         double tempY = radius*Math.sin(alpha);
         double tempX = radius*Math.cos(alpha);
         int row = (int)( tempY + ( (tempY % 1 <= 0.5) ? 0 : 1 ));
         int col = (int)( tempX + ( (tempX % 1 <= 0.5) ? 0 : 1 ));*/
         window.insert(i + (int)((0.5 + radius)*Math.sin(alpha)),j + (int)((0.5 + radius)*Math.cos(alpha)),c); //Add 0.5 to radius calculations for better rounding (instead of truncating)
      }
   }
}
