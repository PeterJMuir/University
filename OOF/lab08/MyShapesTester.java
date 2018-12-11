/*
 * Class Name:    MyShapesTester
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 26 2016, 13:18 
 * Last Modified: Tuesday, April 26 2016, 13:41
 * 
 * Class Description:
 *
 */

import java.util.*;
public class MyShapesTester
{
   public static void main(String[] args)
   {
      MyShapes a = new MyShapes();
      Scanner kb = new Scanner(System.in);
      System.out.print("Input the side length of your cube(0 if no cube): ");
      int side = kb.nextInt();
      System.out.print("Input the radius of your sphere(0 if no sphere): ");
      double sphRadius = kb.nextDouble();
      System.out.print("Input the length width and height of your rectangular prism <l w h> (0 0 0 if no prism): ");
      double recLength = kb.nextDouble();
      double recWidth = kb.nextDouble();
      double recHeight = kb.nextDouble();
      System.out.print("Input the radius and height of your cylinder <r h> (0 0 if no cylinder): ");
      double cylRadius = kb.nextDouble();
      double cylHeight = kb.nextDouble();

      if(0 != side)
      {
         System.out.println("The volume of your cube is: " + a.volume(side));
      }

      if(0 != sphRadius)
      {
         System.out.println("The volume of your sphere is: " + a.volume(sphRadius));
      }

      if((0 != recLength) || (0 != recWidth) || (0 != recHeight))
      {
         System.out.println("The volume of your rectangular prism is: " + a.volume(recLength,recWidth,recHeight));
      }

      if((0 != cylRadius) || (0 != cylHeight))
      {
         System.out.println("The volume of your cylinder is: " + a.volume(cylRadius,cylHeight));
      }

   }
}
