
/*
 * Class Name:    Line
 *
 * Author:        Peter Muir
 * Creation Date: Thursday, April 27 2017, 23:01 
 * Last Modified: Friday, April 28 2017, 02:21
 * 
 * Class Description:   Creates Line Objects to be drawn in Window
 *
 */

public class Line extends Shape
{
   private int length;
   private int rowIncrement;
   private int colIncrement;

   public Line(int rowBase, int colBase, int length, int rowIncrement, int colIncrement, char drawingChar)
   {
      super(rowBase, colBase, drawingChar);
      this.length = length;
      this.rowIncrement = rowIncrement;
      this.colIncrement = colIncrement;
   }

   public void draw(Window window)
   {
      for(int i = getRowBase(), j = getColBase(), k = 0; k <= length; ++k, i += rowIncrement, j += colIncrement)
      {
         window.insert(i,j,getDrawingChar());
      }
   }
   
   public void alterSize(int size)
   {
	   length = ((length+size) < 0)?0:(length+size);
   }
   
   public String toString()
   {
	   return "line\n" + super.getRowBase() + " " + super.getColBase() + " " + length
			   + " " + rowIncrement+ " " + colIncrement
			   + "\n" + super.getDrawingChar();
   }
   
   public String toSelectString()
   {
	   return String.format("line(%d,%d)(%d)(%d,%d)(%c)", super.getRowBase(), super.getColBase(), length, rowIncrement, colIncrement, super.getDrawingChar());
   }
}
