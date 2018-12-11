/*
 * Class Name:    StockList
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 09 2017, 14:12 
 * Last Modified: Tuesday, May 09 2017, 14:39
 * 
 * Class Description:
 *
 */

public class StockList
{
   private ItemNode head;

   public StockList()
   {
      head = null;
   }

   public void addToFront(Item item)
   {
      ItemNode p = new ItemNode(item);
      if(head != null)
      {
         p.setNext(head);
      }
      head = p;
   }

   public Item find(String barcode)
   {
      ItemNode p = head;
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
         return p.getItem();
      }
   }

   public void display()
   {
      ItemNode p = head;
      while(true)
      {
         if(p == null)
         {
            break;
         }else
         {
            System.out.println(p.getItem());
            p = p.getNext();
         }
      }
   }


}
