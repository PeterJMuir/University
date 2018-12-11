/*
 * Class Name:    ReceiptByC
 *
 * Author:        Peter Muir
 * Creation Date: Tuesday, January 10 2017, 16:02 
 * Last Modified: Friday, January 13 2017, 00:03
 * 
 * Class Description:
 * Receipt Object to be used with ReceiptSorter and text files with format
 * "<receiptNum>,<custNum>,$<cost>" on each line.
 *
 * This is identical to 'Receipt.java' except for the compareTo method.
 * This Receipt object will be sorted by custNum.
 *
 */

import java.util.*;

public class ReceiptByC implements Comparable<ReceiptByC>
{
   private String receiptNum;
   private String custNum;
   private String cost;
   private static int noOfComparisons;

   public ReceiptByC(String receiptNum, String custNum, String cost)
   {
      this.receiptNum = receiptNum;
      this.custNum = custNum;
      this.cost = cost;
   }

   public ReceiptByC(Receipt r)  //for constructing from a Receipt Object
   {
      this.receiptNum = r.getReceiptNum();
      this.custNum = r.getCustNum();
      this.cost = r.getCost();
   }

   public String toString()
   {
      return receiptNum + "," + custNum + ",$" + cost;
   }

   public int compareTo(ReceiptByC r)  //override compareTo to change what the sorters are sorting by
   {
      ++noOfComparisons;

      return this.custNum.compareTo(r.custNum);
   }

   public String getReceiptNum()
   {
      return this.receiptNum;
   }

   public String getCustNum()
   {
      return this.custNum;
   }

   public String getCost()
   {
      return this.cost;
   }

   public static int getCounter()
   {
      return noOfComparisons;
   }

   public static void resetCounter()
   {
      noOfComparisons = 0;
   }
}
