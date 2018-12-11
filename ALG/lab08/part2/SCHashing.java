import java.io.PrintWriter;
import java.util.*;

public class SCHashing  
{
   public static final int INITIAL_LENGTH = 10;
   public static final double loadFactorBound = 7;
   private ArrayList<LinkedList<Person>> personArray;
   private int numberOfElements;
   //private final double loadFactorBound = 0.5;
   private Person nonPerson = new Person("","","","","",-1);
   
   public SCHashing()
   {
      numberOfElements = 0;
      personArray = new ArrayList<LinkedList<Person>>();
      for(int i = 0; i <= INITIAL_LENGTH; ++i)
      {
         personArray.add(new LinkedList<Person>());
      }
   }


   private int hashFunction(String key)
   {
      int hashIndex = 0;
      for (int index = 0; index < key.length(); index++)
      {
         hashIndex = 31 * hashIndex + key.charAt(index);
      }
      hashIndex = Math.abs(hashIndex) % personArray.size();
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
      personArray.get(hashIndex).add(newPerson);   //get LinkedList at hashIndex location and add newPerson into it
      numberOfElements++;
      return true;
   }

   private int[] getIndex(Person v)
   {
      String key = v.getLastName() + v.getFirstName() + v.getPostCode();
      int[] hashIndex = new int[2];
      hashIndex[0] = hashFunction(key);
      hashIndex[1] = -1;
      for(int i = 0; i < personArray.get(hashIndex[0]).size(); ++i)
      {
         if(personArray.get(hashIndex[0]).get(i).compareTo(v) == 0)
         {
            hashIndex[1] = i;
            break;
         }
      }
      return hashIndex;
   }

   public Person contains(Person v)
   {
      int[] personIndex = getIndex(v);
      if(personIndex[1] != -1)
      {
      return personArray.get(personIndex[0]).get(personIndex[1]);
      }else
      {
         return null;
      }
   }

   public boolean removeElement(Person exPerson)
   {
      int[] personIndex = getIndex(exPerson);

      if(personIndex[1] == -1)
      {
         return false;
      }else if(personArray.get(personIndex[0]).get(personIndex[1]) != null)
      {
         personArray.get(personIndex[0]).remove(personIndex[1]);
         return true;
      }else
      {
         return false;
      }
   }

   public void displayElements(PrintWriter p)
   {
      for(int i = 0; i < personArray.size(); ++i)
      {
         for(int j = 0; j < personArray.get(i).size(); ++j)
         {
           // if((q != null))
           // {
               p.println(personArray.get(i).get(j));
           // }
         }
      }
   }

   public int getNumElements()
   {
      return numberOfElements;
   }

   private double getLoadFactor()
   {
      return numberOfElements/(double)personArray.size();
   }

   private void rehash()
   {
      ArrayList<LinkedList<Person>> oldPersonArray = personArray;
      int newArraySize = getPrime(oldPersonArray.size() * 2);
      personArray = new ArrayList<LinkedList<Person>>(newArraySize);
      for(int i = 0; i < newArraySize; ++i)
      {
         personArray.add(new LinkedList<Person>());
      }
      numberOfElements = 0;

      for(int i = 0; i < personArray.size(); ++i)
      {
         for(int j = 0; j < personArray.get(i).size(); ++j)
         {
           // if (p != null)
           // {
               insertElement(oldPersonArray.get(i).get(j));
           // }
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
