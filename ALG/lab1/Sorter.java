/*
 * Class Name:    Sorter
 *
 * Will contain a collection of sorts that can take an AbstractList
 * container of Comparable objects and sort the elements in the container 
 * using the compareTo method of the objects within.
 * 
 * Revision History
 * 
 * Author:              Richard Tresider
 * Date:                Mar 09 2008
 * Description:         Changed to interface Comparable<T>
 *                      The original class was written under Java 1.4
 *                      which used interface Comparable
 *                      From Java 1.5 this interface is now a generic
 *                      interface.
 *  
 *                      This becomes a potential problem for older code
 *                      that implements just interface Comparable.
 *                      However, since the inputs are generic based
 *                      containers, the decision was taken to also
 *                      update the Comparable interface.
 *
 *                      See the Person class also in this directory
 *                      for the changes required to a class to
 *                      actually implement Comparable<T>. One of the maim
 *                      changes is that the class now explicitly includes
 *                      its type
 *
 *                      public class Person implements Comparable<Person>
 *            
 *                      The compare method of the Person class now takes
 *                      a Person object reference, rather than an
 *                      Object object reference.
 */

import java.util.*;

public class Sorter
{
   /* Utility method only available to the sorts within the class 
    */

   private static <T extends Comparable<T> > void swap (AbstractList<T> container, 
                                                   int i, int j)
   {
      T temp = container.get(i);
      container.set(i, container.get(j));
      container.set(j, temp);
   }

   /* Gnome sort, this implementation based on the pseudocoded algorithm at
    * "http://en.wikipedia.org/wiki/Gnome_sort"
    */ 

   public static <T extends Comparable<T> > void gnomeSort
                                                  (AbstractList<T> container)
   {
      for (int i = 1; i < container.size();)
      {
         if (container.get(i-1).compareTo(container.get(i)) < 0)
         {
            ++i;
         }
         else
         {
            swap(container, i-1, i);
            --i;
            if (i == 0)
            {
               i = 1;
            }
         }
      }
   }

   public static <T extends Comparable<T> > void quickSortMOT(AbstractList<T> container)
   {
      quickSortMOT(container,0,container.size()-1);
      return;
   }

   private static <T extends Comparable<T> > void quickSortMOT(AbstractList<T> container, int left, int right)
   {
      if(left >= right)
      {
         return;
      }
      else
      {
         int pivotIndex = partitionMOT(container,left, right);
         quickSort(container, left, pivotIndex -1);
         quickSort(container, pivotIndex + 1, right);
      }
   }

   private static <T extends Comparable<T> > int partitionMOT(AbstractList<T> container, int left, int right)
   {
      int mid = medianOf3(container,left,right);
      T pivot = container.get(mid);
      swap (container,mid,right);      //variable left is left pointer
                                       //variable right is right pointer
      while( left < right )
      {
         //Move left pointer over elements that are <= pivot
         while( left < right && container.get(left).compareTo(pivot) <= 0)
         {
            left++;
         }

         if(left < right)
         {
            swap(container,left,right); //container[left] is now pivot
            right--;
         }
         //Move right pointer over elements that are >= pivot
         while( left < right && container.get(right).compareTo(pivot) >= 0)
         {
            right--;
         }

         if(left < right)
         {
            swap(container,left,right);//container[right] is now the pivot
            left++;
         }
      }
      //At this point left == right
      return left;
   }

   private static <T extends Comparable<T> > int medianOf3(AbstractList<T> container, int left, int right)
   {
      int mid = (left + right)/2;
      if(container.get(left).compareTo(container.get(mid)) > 0)
      {
         swap(container,left,mid);
      }
      if(container.get(left).compareTo(container.get(right)) > 0)
      {
         swap(container,left,right);
      }
      if(container.get(mid).compareTo(container.get(right)) > 0)
      {
         swap(container,mid,right);
      }
      return mid;
   }

   public static <T extends Comparable<T> > void quickSort(AbstractList<T> container, int left, int right)
   {
      if(left >= right)
      {
         return;
      }
      else
      {
         int pivotIndex = partition(container,left, right);
         quickSort(container, left, pivotIndex -1);
         quickSort(container, pivotIndex + 1, right);
      }
   }

   private static <T extends Comparable<T> > int partition(AbstractList<T> container, int left, int right)
   {
      int mid = (left + right)/2;
      T pivot = container.get(mid);
      swap (container,mid,right);      //variable left is left pointer
                                       //variable right is right pointer
      while( left < right )
      {
         //Move left pointer over elements that are <= pivot
         while( left < right && container.get(left).compareTo(pivot) <= 0)
         {
            left++;
         }

         if(left < right)
         {
            swap(container,left,right); //container[left] is now pivot
            right--;
         }
         //Move right pointer over elements that are >= pivot
         while( left < right && container.get(right).compareTo(pivot) >= 0)
         {
            right--;
         }

         if(left < right)
         {
            swap(container,left,right);//container[right] is now the pivot
            left++;
         }
      }
      //At this point left == right
      return left;
   }

   public static <T extends Comparable<T> > void mergeSort(AbstractList<T> container, int first, int last)
   {
      if(first == last) //list has 1 element. Therefore it is sorted.
      {
         return;
      }
    //  System.out.println(container.size());

      int mid = (first + last)/2;
      mergeSort(container, first, mid);      //sort left list
      mergeSort(container, mid + 1, last);   //sort right list
//      System.out.println(container.toString() + "\nfirst: " + first + "\nmid: " +mid + "\nlast: " + last);
      merge(container, first,mid,last);      //merge them
   }

   public static <T extends Comparable<T> > void merge(AbstractList<T> container, int firstLeft, int lastLeft, int lastRight)
   {
      //create a temp array
      List<T> temp = new ArrayList<T>((lastRight-firstLeft)+1);
      //System.out.println(temp.size());
      //Set up indexes
      int firstRight = lastLeft + 1;
      int indexLeft = firstLeft;
      int indexRight = firstRight;
      int indexTemp = 0;

      while( indexLeft <= lastLeft && indexRight <= lastRight) //Merge elements until one half is exhausted
      {
       //System.out.println("indexLeft: " + indexLeft + "\nindexRight: " + indexRight + "\nindexTemp: " + indexTemp);
       //System.out.println(temp.toString());
         if(container.get(indexLeft).compareTo(container.get(indexRight)) <= 0)
         {
            temp.add(indexTemp++, container.get(indexLeft++));
            //temp[indexTemp++] = container.get(indexLeft++);
         }
         else
         {
            temp.add(indexTemp++, container.get(indexRight++));
            //temp[indexTemp++] = container.get(indexRight++);
         }
      }

      //copy elements from unexhausted half to temporary array
      while(indexLeft <= lastLeft)
      {
            temp.add(indexTemp++,container.get(indexLeft++));
            //temp[indexTemp++] = container.get(indexLeft++);
      }
      while(indexRight <= lastRight)
      {
          temp.add(indexTemp++,container.get(indexRight++));
            //temp[indexTemp++] = container.get(indexRight++);
      }

      //copy sorted elements back into original array
      for(int i = 0; i <= temp.size()-1; i++)
      {
         container.set(i+ firstLeft,temp.get(i));
         //container.set(i,temp[i]);
      }
   }

   public static <T extends Comparable<T> > void ShellSort (AbstractList<T> container, int left, int right, int[] GAPS)
   {
      for(int i = 0; i < GAPS.length; i++)
      {
         int h =  GAPS[ i ];
         hSort(container, left, right, h);
      }
   }
   private static <T extends Comparable<T> > void hSort(AbstractList<T> container,int left, int right, int h)
   {
      for(int i = left; i < (left + h); i++)
      {
         sortGappedSubarray(container, i, right, h);
      }
   }

   private static <T extends Comparable<T> > void sortGappedSubarray(AbstractList<T> container, int left, int right, int h)
   {
      for(int i = (left + h); i <= right; i = (i+h))
      {
         T value = container.get(i);
         int j = i;
         while ( j > left && (container.get(j-h).compareTo(value) > 0))
         {
            container.set(j,container.get(j-h));
            j=j-h;
         }
         container.set(j,value);
      }
   }

   public static <T extends Comparable<T> > void insertionSort(AbstractList<T> container)
   {
      for(int i = 1; i < container.size(); i++)
      {
         T value = container.get(i);
         int j = i;
         while( j > 0 && (container.get(j-1).compareTo(value) > 0))
         {
            container.set(j,container.get(j-1));
            j--;
         }
         container.set(j,value);
      }
   }

   public static <T extends Comparable<T> > void bubbleSort(AbstractList<T> container)
   {
      for(int i = (container.size() - 1); i > 0; --i)
      {
         for(int j = 0; j < i; ++j)
         {
            if(container.get(j).compareTo(container.get(j+1)) > 0)
            {
               swap(container,j,j+1);
            }
         }
      }
   }

   public static <T extends Comparable<T> > void earlyStoppingBubbleSort(AbstractList<T> container)
   {
      boolean flag = false;
      for(int i = (container.size() - 1); i > 0; --i)
      {
         flag = false;
         for(int j = 0; j < i; ++j)
         {
            if(container.get(j).compareTo(container.get(j+1)) > 0)
            {
               swap(container,j,j+1);
               flag = true;
            }
         }
         if(flag == false)
         {
            i = 0;
         }
      }
   }


   public static <T extends Comparable<T> > void selectionSort(AbstractList<T> container)
   {
      int maxIndex = 0;
      for(int i = container.size()-1; i > 0; --i)
      {
         maxIndex = 0;
         for(int j = 1; j <=i; ++j)
         {
            if(container.get(j).compareTo(container.get(maxIndex)) > 0)
            {
               maxIndex = j;
            }
         }
         swap(container,i,maxIndex);
      }
   }


   public static <T extends Comparable<T> > void selectionSortAlt(AbstractList<T> container)
   {
      for(int i = container.size()-1; i > 0; --i)
      {
         int maxIndex = 0;
         for(int j = 1; j <=i; ++j)
         {
            if(container.get(j).compareTo(container.get(maxIndex)) > 0)
            {
               maxIndex = j;
            }
         }
         swap(container,i,maxIndex);
      }
   }
}

