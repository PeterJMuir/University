/*
 * Class Name:    Ticket
 *
 * Author:        Peter Muir
 * Creation Date: Sunday, April 10 2016, 14:48 
 * Last Modified: Sunday, April 10 2016, 18:15
 * 
 * Class Description: Entering a valid ticket code will output the cost of the ticket.
 *
 */
import java.io.*;
import java.util.*;
public class Ticket
{
   public static void main(String[] args)
   {
      System.out.print("Please enter your ticket code ([C]DD.DDD[D]): ");
      Scanner kbd = new Scanner(System.in);
      String code = kbd.nextLine();
      if(6 <= code.length() && code.length() <= 8)            //check overall length
      {
         int a = code.indexOf('.');
         if(a != -1)                                           //if there is a period
         {
            String left = code.substring(0,a).toUpperCase();
            boolean flag1 = false;
            boolean stoprun = false;
            int i = 0;


            if(left.length() == 3)
            {
               if(left.charAt(0) == 'J' || left.charAt(0) == 'P' || left.charAt(0) == 'R')
               {
                  flag1 = true;
                  ++i;
               }else
               {
                  System.out.println("Invalid Code: Starting character must be 'J', 'P' or 'R'");
                  stoprun = true;
               }

            }


            if(left.length() == 2 || flag1 == true)
            {
               if('0' <= left.charAt(i) && left.charAt(i) <= '9' && '0' <= left.charAt(i+1) && left.charAt(i+1) <= '9')   //check that DD. are digits
               {
                 String right = code.substring(a+1);
                 if(right.length() == 3 || right.length() == 4)
                 {

                    if('0' <= right.charAt(0) && right.charAt(0) <= '9' && '0' <= right.charAt(1) && right.charAt(1) <= '9')   //check that .DD are digits
                    {
                       String basePriceStr = code.substring(a-2,a+3);
                       double basePrice = 0;
                       int k = 0;
                       for(double j = 10;j > 0.001; j /= 10, ++k)       //loop converts the base price string into a double
                       {
                          char ch = basePriceStr.charAt(k);
                          while('9' < ch || ch < '0')                   //when ch is not a digit, this loop will run:
                           {                                            //this omits the decimal point from being converted.
                              ++k;
                              ch = basePriceStr.charAt(k);
                           }
                           double convert = (ch - '0')*j;
                           basePrice += convert;
                       }
                       double cost = basePrice * 0.25;
                       if(right.length() == 4)
                       {
                          if(right.charAt(3) == '2' && right.charAt(2) == '1')
                          {
                             cost *= 1.10;
                          }else
                          {
                             System.out.println("Invalid Code: Last two digits must be '12' in that order");
                             stoprun = true;
                          }
                       }else if(right.length() == 3)
                       {
                          if(right.charAt(2) == '2')
                          {
                             cost *= 1.15;
                          }else if(right.charAt(2) != '1')
                          {
                             System.out.println("Invalid Code: The last digit must be a 1 or a 2");
                             stoprun = true;
                          }
                       }
                       if(left.length() == 3)
                       {
                          switch(left.charAt(0))
                          {
                             case 'J': cost *= 0.67;
                             break;
                             case 'R': cost *= 0.80;
                             break;
                             case 'P': cost *= 0.90;
                             break;
                             default:
                             break;
                          }
                       }
                       if(stoprun == false)
                       {
                       System.out.printf("The cost of the ticket %s is $%05.2f\n",code,cost);
                       }

                    }else
                    {
                        System.out.println("Invalid Code: The two inputs after the decimal place must be digits.");
                    }
                 }else
                 {
                    System.out.println("Invalid Code: Right side of '.' is an invalid length");
                 }
               }else
               {
                  System.out.println("Invalid Code: The two inputs before the decimal place must be digits.");
               }
            }
            else
               if(stoprun == false)
               {
                  System.out.println("Invalid Code: Left side of '.' is an invalid length");
               }
         }else
         {
            System.out.println("Invalid Code: No '.' found");
         }
      }else
      {
         System.out.println("Invalid Code: Invalid Length");
      }
   }
}

