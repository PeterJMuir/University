/*
 * Class Name:    Text
 *
 * Author:        Peter Muir
 * Creation Date: Thursday, April 27 2017, 23:01 
 * Last Modified: Friday, April 28 2017, 02:27
 * 
 * Class Description:   Creates Text (Shape) Object to be drawn in Window
 *
 */

public class Text extends Shape
{
   private String text;
   private int rowIncrement;
   private int colIncrement;

   public Text(int rowBase, int colBase, String text, int rowIncrement, int colIncrement)
   {
      super(rowBase, colBase,'\\');
      this.text = text;
      this.rowIncrement = rowIncrement;
      this.colIncrement = colIncrement;
   }

   public void draw(Window window)
   {
      for(int i = getRowBase(), j = getColBase(), k = 0; k < text.length(); ++k, i += rowIncrement, j += colIncrement)
      {
         window.insert(i,j,text.charAt(k));
      }
   }
}
