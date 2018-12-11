/*
 * Class Name:    ReceiptList
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 09 2017, 14:48 
 * Last Modified: Tuesday, May 09 2017, 15:26
 * 
 * Class Description:
 *
 */

public class ReceiptList
{
   private ReceiptNode head;

   public ReceiptList()
   {
      head = null;
   }

   public void addToEnd(Item item)
   {
      ReceiptNode next = new ReceiptNode(item);
      ReceiptNode p = head;
      if(null == head)
      {
         head = next;
      }else
      {
         while(p.getNext() != null) //get to last node
         {
            p = p.getNext();
         }
         p.setNext(next);   //once at last node, setNext to be item rather than null
      }
   }

   public ReceiptNode find(String barcode)
   {
      ReceiptNode p = head;
      while(p != null)
      {
         if(p.getItem().getBarcode().equals(barcode))
         {
            break;
         }else
         {
            p = p.getNext();
         }
      }
      if(p == null)
      {
         return null;
      }else
      {
         return p;
      }
   }

   public void increment(ReceiptNode r)
   {
      r.incrementQuantity();
   }

   public void scan(Item item)
   {
      ReceiptNode p = find(item.getBarcode());
      if(null == p)
      {
         addToEnd(item);
      }else
      {
         increment(p);
      }
   }

   public void display()
   {
      ReceiptNode p = head;
      System.out.println(getClass().getName() + "[");
      while(p != null)
      {
         System.out.print(p.toString());
         p = p.getNext();
      }
      System.out.println("]");
   }

   public void writeReceipt()
   {
      ReceiptNode p = head;
      double receiptTotal = 0;
      while(p != null)
      {
         int quantity = p.getQuantity();
         String desc = p.getItem().getDescription();
         double minorTotal = quantity * p.getItem().getPrice();
         System.out.printf("%4d %20.20s %7.2f\n", quantity, desc, p.getItem().getPrice());
         receiptTotal += minorTotal;
         p = p.getNext();
      }
      System.out.printf("%33.2f\n", receiptTotal);
   }
}
