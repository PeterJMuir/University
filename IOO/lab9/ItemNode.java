/*
 * Class Name:    ItemNode
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 09 2017, 14:09 
 * Last Modified: Tuesday, May 09 2017, 14:33
 * 
 * Class Description:
 *
 */

public class ItemNode
{
   private Item item;
   private ItemNode next;

   public ItemNode(Item item)
   {
      this.item = item;
      this.next = null;
   }

   public Item getItem()
   {
      return item;
   }

   public ItemNode getNext()
   {
      return next;
   }
   
   public void setNext(ItemNode next)
   {
      this.next = next;
   }
}
