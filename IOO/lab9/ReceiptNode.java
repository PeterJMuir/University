/*
 * Class Name:    ReceiptNode
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 09 2017, 14:40 
 * Last Modified: Tuesday, May 09 2017, 14:47
 * 
 * Class Description:
 *
 */

public class ReceiptNode
{
   private Item item;
   private int quantity;
   private ReceiptNode next;

   public ReceiptNode(Item item)
   {
      this.item = item;
      this.quantity = 1;
      this.next = null;
   }

   public Item getItem()
   {
      return item;
   }

   public int getQuantity()
   {
      return quantity;
   }

   public ReceiptNode getNext()
   {
      return next;
   }

   public void setNext(ReceiptNode next)
   {
      this.next = next;
   }

   public void incrementQuantity()
   {
      quantity++;
   }

   public String toString()
   {
      return getClass().getName() + "[\n" + item.toString() + ", Quantity: " + quantity + "]\n";
   }
}
