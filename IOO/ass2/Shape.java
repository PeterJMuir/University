
/*
 * Class Name:    Shape
 *
 * Author:        Peter Muir
 * Creation Date: Thursday, April 27 2017, 22:19 
 * Last Modified: Friday, April 28 2017, 02:24
 * 
 * Class Description:   Serves as an abstract base class for other shapes to be
 * drawn on a Window object
 *
 */

public abstract class Shape
{
   private int rowBase; //start at 1
   private int colBase; //start at 1
   private char drawingChar;

   public Shape(int rowBase, int colBase, char drawingChar)
   {
      this.rowBase = rowBase;
      this.colBase = colBase;
      this.drawingChar = drawingChar;
   }

   public int getRowBase()
   {
      return rowBase;
   }

   public int getColBase()
   {
      return colBase;
   }

   public char getDrawingChar()
   {
      return drawingChar;
   }
   
   public void setRowBase(int newRowBase)
   {
	   this.rowBase = newRowBase;
   }
   public void setColBase(int newColBase)
   {
	   this.colBase = newColBase;
   }
   public abstract void alterSize(int newSize);
   public abstract void draw(Window window);
   public abstract String toString();
   public abstract String toSelectString();
}

