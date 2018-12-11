public class ChangeTracker <T extends Comparable<T>>
{
   public T current; // the current Object
   public T original; // the original Object
   public int changes; // count number of changes
   public ChangeTracker(T original)
   {
      current = original;
      this.original = original;
      changes = 0;
   }
   public void update(T newObject)
   {
      if(0 != newObject.compareTo(current))
      {
         current = newObject;
         ++changes;
      }
   }
}
