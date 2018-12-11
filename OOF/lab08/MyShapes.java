/*
 * Class Name:    MyShapes
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 26 2016, 13:08 
 * Last Modified: Tuesday, April 26 2016, 13:17
 * 
 * Class Description:
 *
 */

public class MyShapes
{
   public int volume(int side)       //cube
   {
      return (side*side*side);
   }

   public double volume(double radius)  //sphere
   {
      return (((double)4/3)*Math.PI*Math.pow(radius,3));
   }

   public double volume(double length, double width, double height)   //rectangular prism
   {
      return (length*width*height);
   }

   public double volume(double radius, double height)  //cylinder
   {
      return (Math.PI*height*Math.pow(radius,2));
   }
}
