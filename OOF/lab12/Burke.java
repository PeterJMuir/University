/*
 * Class Name:    Burke
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 24 2016, 13:38 
 * Last Modified: Tuesday, May 24 2016, 14:04
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Burke
{
   public static void main(String[] args)
   {
      String name = "Snap Dragon";
      String comments = "Snaps, be wary";
      Plant planty = new Plant(name,comments);
      planty.display();
      Edible fruit = new Edible("Apple","tastes good as, aye","Spring",false);
      fruit.display();
      Poisonous mushroom = new Poisonous("Spinal Tap","This one goes to eleven", 11);
      mushroom.display();
   }
}
