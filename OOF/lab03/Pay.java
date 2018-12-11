/*
 * Class Name:    Pay
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 15 2016, 14:32 
 * Last Modified: Tuesday, March 15 2016, 14:52
 * 
 * Class Description:
 *
 */
import java.util.*;
import java.io.*;
public class Pay
{
   public static void main(String[] args) throws IOException
   {
      File fileOpen = new File("Employee.txt");
      Scanner fileInput = new Scanner(fileOpen);
      String name = fileInput.nextLine();
      double hours = fileInput.nextDouble();
      double rate = fileInput.nextDouble();
      double totalSales = fileInput.nextDouble();
      double bonusSales = totalSales - (200*hours);
      // if the employee has earnt a bonus, their bonus is calculated, else it
      // the bonus is 0.
      double bonusPay = (bonusSales > 0) ? (bonusSales/10) : 0;
      double totalPay = rate*hours + bonusPay;
      System.out.println(name + " must be paid: $" + totalPay);
   }
}

