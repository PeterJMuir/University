import java.io.PrintWriter;

public class LinearHashing  
{
   private Person[] personArray;
   private int numberOfElements;
   private final double loadFactorBound = 0.5;
   private Person nonPerson = new Person("","","","","",-1);
   
   public LinearHashing()
   {
      numberOfElements = 0;
      personArray = new Person[getPrime(7)];
   }


   private int hashFunction(String key)
   {
      int hashIndex = 0;
      for (int index = 0; index < key.length(); index++)
      {
         hashIndex = 31 * hashIndex + key.charAt(index);
      }
      hashIndex = Math.abs(hashIndex) % personArray.length;
      return hashIndex;
   }

   public boolean insertElement(Person newPerson)
   {
      if (getLoadFactor() >= loadFactorBound)
      {
         rehash();
      }
      String key = newPerson.getLastName() + newPerson.getFirstName() + newPerson.getPostCode();
      int hashIndex = hashFunction(key);

      while((personArray[hashIndex] != null) && (personArray[hashIndex] != nonPerson))
      {
         if(hashIndex >= (personArray.length -1))
         {
            hashIndex = 0;
         }else
         {
            hashIndex++;
         }
      }

      personArray[hashIndex] = newPerson;
      numberOfElements++;
      return true;
   }

   public int getIndex(Person v)
   {
      String key = v.getLastName() + v.getFirstName() + v.getPostCode();
      int hashIndex = hashFunction(key);
      
      while(personArray[hashIndex] != null)  //until there is an empty space
      {
         if(personArray[hashIndex].compareTo(v) == 0) //compare query with stored person
         {
            break;
         }
         if(hashIndex >= (personArray.length -1))  //Wrap around
         {
            hashIndex = 0;
         }else
         {
            hashIndex++;
         }  
      }
      return hashIndex;
   }

   public Person contains(Person v)
   {
      return personArray[getIndex(v)];
   }

   public boolean removeElement(Person exPerson)
   {
      int hashIndex = getIndex(exPerson);
      if(personArray[hashIndex] != null)
      {
         personArray[hashIndex] = nonPerson;
         return true;
      }else
      {
         return false;
      }
   }

   public void displayElements(PrintWriter p)
   {
      for(Person q: personArray)
      {
         if((q != null) && (q.getPostCode() != -1))
         {
            p.println(q);
         }
      }
   }

   public int getNumElements()
   {
      return numberOfElements;
   }

   private double getLoadFactor()
   {
      return numberOfElements/(double)personArray.length;
   }

   private void rehash()
   {
      Person[] oldPersonArray = personArray;
      int newArraySize = getPrime(oldPersonArray.length * 2);
      personArray = new Person[newArraySize];
      numberOfElements = 0;

      for (int index = 0; index < oldPersonArray.length; ++index)
      {
         if (oldPersonArray[index] != null && 
             oldPersonArray[index] != nonPerson)
         {
            insertElement(oldPersonArray[index]);
         }
      }
   }

   private int getPrime(int integer)
   {
      while (!isPrime(integer))
      {
         integer++;
      }
      return integer;
   }

   private boolean isPrime(int integer)
   {
      int factor = 2;
      boolean isPrime = true;

      while (isPrime && factor*factor <= integer)
      {
         if (integer % factor == 0)
         {
            isPrime = false;
         }
         factor++;
      }
      return isPrime;
   }
}
