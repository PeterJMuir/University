/*
 * Class Name:    ReceiptSorter
 *
 * Author:        Peter Muir
 * Creation Date: Tuesday, January 10 2017, 16:00
 * Last Modified: Sunday, January 15 2017, 18:39
 *
 * Class Description:
 * Loads a file of Receipts in and stores them in a Receipt vector.
 * User calls sorting algorithms to sort the Receipt data and output to a
 * user specified output file every time it is sorted.
 * Receipt numbers sorted first and then Customer numbers are allowed to be sorted (stable).
 */

import java.io.*;
import java.util.*;


public class ReceiptSorter
{

   public static void main(String[] args) throws Exception
   {
      Vector<Receipt> receipts = new Vector<Receipt>();
      Vector<ReceiptByC> receiptsByC = new Vector<ReceiptByC>();  //This duplicate will sort using Customer Numbers instead of Receipt Numbers

      boolean receiptSorted = false;   //to stop customers being sorted before receipts
      boolean custSorted = false;   //to flag if going from sorting by customer to sorting by receipt
      System.out.println("Enter an input file: ");
      Scanner kb = new Scanner(System.in);
      String fileName = kb.nextLine();
      // System.out.println(fileName);
      loadData(fileName, receipts);
      boolean exit = false;   //flag for the main menu
      do{
         System.out.print("\n\t---BEGIN---" + 
               "\n(1) Sort by receipt number" +
               "\n(2) Sort by customer number" +
               "\n(3) Exit" +
               "\nEnter your option: ");
         long startTime = 0;  //Timers for working out the duration of a sort
         long endTime = 0;
         long duration = 0;

         int option = kb.nextInt();
         kb.nextLine();
         if(option == 1)
         {
            if(custSorted)
            {
               receipts = transferToByR(receiptsByC);
            }
            receiptSorted = true;   //flag at the start to save space
            Receipt.resetCounter(); //resets the comparison counter
            System.out.print("\n\t--CHOOSE RECEIPT SORTING ALGORITHM--" +
                  "\n(1) Sort with Bubble sort" +
                  "\n(2) Sort with Merge sort" +
                  "\n(3) Sort with Shell sort" +
                  "\n(4) Sort with Collections.sort()" +
                  "\nEnter your option: ");
            option = kb.nextInt();
            kb.nextLine();
            System.out.println("Enter an output file name:");  //Ask for the output before sorting
            String outFileName = kb.nextLine();
            switch (option)
            {
               case 1:
                  startTime = System.nanoTime();
                  Sorter.earlyStoppingBubbleSort(receipts); //Bubble Sort
                  endTime = System.nanoTime();
                  break;
               case 2:
                  startTime = System.nanoTime();
                  Sorter.mergeSort(receipts,0,receipts.size()-1); //Merge Sort
                  endTime = System.nanoTime();
                  break;
               case 3:
                  startTime = System.nanoTime();
                  Sorter.ShellSort(receipts,0,receipts.size()-1,getKnuthIntervals(receipts.size()));  //Shell Sort using Knuth's gap sequence
                  endTime = System.nanoTime();
                  break;
               case 4: 
                  startTime = System.nanoTime();
                  Collections.sort(receipts);   //Collections.sort()
                  endTime = System.nanoTime();
                  break;
               default:
                  System.out.println("Please enter a valid option (1,2,3, or 4). Returning to main menu.");
                  receiptSorted = false;  //so that the program doesn't think that the list has been sorted
            }
            if(receiptSorted) //printing done at the end to save space
            {
               duration = (endTime - startTime)/1000; //change into micro seconds
               System.out.print("There were " + receipts.size() + " lines processed and " + Receipt.getCounter() +
                     " comparisons which took ");   //Results printout
               if(duration < 10000)  //if within ten thousand microseconds
               {
                     System.out.println(duration + " microseconds");
               }else if(duration < 10000000)  //if within ten thousand milliseconds
               {
                  duration = duration/1000;  //change to milli
                  System.out.println(duration + " milliseconds");
               }else
               {
                  duration = duration/1000000;  //change to seconds
                  System.out.println(duration + " seconds");
               } 

               writeData(outFileName,receipts);
            }
         }else if(option == 2)
         {
            if(receiptSorted)
            {
               if(!custSorted)   //change sorting priority if coming from sorting by Receipts
               {
                  receiptsByC = transferToByC(receipts);
               }
               custSorted = true;
               ReceiptByC.resetCounter(); //resets the comparison counter
               System.out.print("\n\t--CHOOSE CUSTOMER SORTING ALGORITHM--" +
                     "\n(1) Sort with Bubble sort" +
                     "\n(2) Sort with Merge sort" +
                     "\n(3) Sort with Insertion sort" +
                     "\n(4) Sort with Collections.sort()" +
                     "\nEnter your option: ");
               option = kb.nextInt();
               kb.nextLine();
               System.out.println("Enter an output file name:");  //Ask for the output before sorting
               String outFileName = kb.nextLine();
               switch (option)
               {
                  case 1:
                     startTime = System.nanoTime();
                     Sorter.earlyStoppingBubbleSort(receiptsByC); //Bubble Sort
                     endTime = System.nanoTime();
                     break;
                  case 2:
                     startTime = System.nanoTime();
                     Sorter.mergeSort(receiptsByC,0,receiptsByC.size()-1); //Merge Sort
                     endTime = System.nanoTime();
                     break;
                  case 3:
                     startTime = System.nanoTime();
                     Sorter.insertionSort(receiptsByC);  //Insertion Sort
                     endTime = System.nanoTime();
                     break;
                  case 4:  
                     startTime = System.nanoTime();
                     Collections.sort(receiptsByC);   //Collections.sort()
                     endTime = System.nanoTime();
                     break;
                  default:
                     System.out.println("Please enter a valid option (1,2,3, or 4). Returning to main menu."); //exits to main menu if a non-valid input is submitted
                     custSorted = false;  //flag disabled to negate the "custSorted = true" before the switch
               }
               if(custSorted)
               {
                  duration = (endTime - startTime)/1000; //Changed timing to micro seconds
                  System.out.print("There were " + receiptsByC.size() + " lines processed and " + ReceiptByC.getCounter() +
                        " comparisons which took ");  //results printout
                  if(duration < 10000)  //if within ten thousand microseconds
                  {
                     System.out.println(duration + " microseconds");
                  }else if(duration < 10000000)  //if within ten thousand milliseconds
                  {
                     duration = duration/1000;  //change to milli
                     System.out.println(duration + " milliseconds");
                  }else
                  {
                     duration = duration/1000000;  //change to seconds
                     System.out.println(duration + " seconds");
                  }

                  writeDataByC(outFileName,receiptsByC); //need separate writeData to avoid conflicts
               }


            }else
            {
               System.out.println("You must sort by receipt number first.");  //Receipts need to be sorted first for the program to work properly
            }
         }else if(option == 3)   //exits the program safely
         {
            exit = true;
         }else
         {
            System.out.println("Please enter a valid option"); //A non-valid submission will loop back to the main menu
         }

      }while(!exit); //menu loops until safe exit
   }

   public static void loadData(String fileName, Vector<Receipt> receipts) throws IOException
   {
      File inStream = new File( fileName );
      Scanner reader = new Scanner( inStream );

      String receiptLine = "";
      String custNum = "";
      String cost = "";
      String receiptNum = "";

      boolean more = false;
      if( !(reader.hasNext()) )
      {
         System.out.println("The file was empty. Please exit and re-open the program with a different file.");
      }

      while( reader.hasNext() )
      {
         receiptLine = reader.nextLine();
         String [ ] tokens = receiptLine.split(",");

         receiptNum = tokens[0];
         custNum = tokens[1];
         cost = tokens[2].substring(1); //eliminated '$' sign

         receipts.addElement(new Receipt(receiptNum, custNum, cost));
      }

      reader.close();
   }

   public static void writeData(String fileName, Vector<Receipt> receipts)
      throws IOException
      {
         PrintWriter outFile = new PrintWriter(new File(fileName));

         for (Receipt p: receipts)
         {
            outFile.println(p);  //toString method handled in Receipt.java
         }

         outFile.close();
      }

   public static void writeDataByC(String fileName, Vector<ReceiptByC> receiptsByC)
      throws IOException
      {
         PrintWriter outFile = new PrintWriter(new File(fileName));

         for (ReceiptByC r: receiptsByC)
         {
            outFile.println(r);  //toString method handled in ReceiptByC.java
         }

         outFile.close();
      }


   public static int[] getKnuthIntervals(int n) //for Shell Sort
   {
      //determine start value of h and count number of elements
      //in the sequence
      int h = 1;
      int count = 1;
      while((3*h + 1) < n)
      {
         h = 3*h + 1;
         count++;
      }

      //h is now the start value of the sequence
      //and count is the sequence's length

      int[] gaps = new int[count];
      for(int i = 0; i < gaps.length; i++)
      {
         gaps[i] = h;
         h = (h-1)/3;
      }
      return gaps;
   }

   public static Vector<ReceiptByC> transferToByC(Vector<Receipt> receipts)   //changes a list of Receipt to ReceiptByC to change between sorting methods
   {
      Vector<ReceiptByC> newList = new Vector<ReceiptByC>();
      for(Receipt r: receipts)
      {
         newList.addElement(new ReceiptByC(r));
      }
      return newList;
   }

   public static Vector<Receipt> transferToByR(Vector<ReceiptByC> receiptsByC)   //opposite of above
   {
      Vector<Receipt> newList = new Vector<Receipt>();
      for(ReceiptByC r: receiptsByC)
      {
         newList.addElement(new Receipt(r));
      }
      return newList;
   }
}

