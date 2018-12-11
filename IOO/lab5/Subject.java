// Laboratory 05
import java.util.*;
import java.io.*;
public class Subject
{
   private String code;
   private String title;
   private int fieldCount;
   private String fieldWeights; // a string with tokens separated by |
                                // e.g. F|20|10|70
   private int studentCount;
   private Student[] students;
   private int[] finalMarks;

   public Subject(String code, String title, int fieldCount,
                  String fieldWeights, int studentCount, Student[] students)
   {
      this.code = code;
      this.title = title;
      this.fieldCount = fieldCount;
      this.fieldWeights = fieldWeights;
      this.studentCount = studentCount;
      this.students = students;
      finalMarks = new int[studentCount];
   }

   public static Subject loadData(Scanner infile)
   {
      String tempCode,tempTitle,tempFieldWeights;
      int tempFieldCount, tempStudentCount;
      int count = 0;
      String line = infile.nextLine();
      StringTokenizer tkn = new StringTokenizer(line,"|");
      tkn.nextToken();
      tempCode = tkn.nextToken(); 

      line = infile.nextLine();
      tkn = new StringTokenizer(line,"|");
      tkn.nextToken();
      tempTitle = tkn.nextToken();

      line = infile.nextLine();
      tkn = new StringTokenizer(line,"|");
      tkn.nextToken();
      tempFieldCount = Integer.parseInt(tkn.nextToken().trim());

      tempFieldWeights = infile.nextLine().trim();

      line = infile.nextLine();
      tkn = new StringTokenizer(line,"|");
      tkn.nextToken();
      tempStudentCount = Integer.parseInt(tkn.nextToken().trim());
      
      Student[] tempStudents = new Student[tempStudentCount];

      while(infile.hasNext())
      {
         line = infile.nextLine();
         tkn = new StringTokenizer(line, "|");
         tkn.nextToken();
         String sNum = tkn.nextToken();
         String famName = tkn.nextToken().trim();
         String initials = tkn.nextToken().trim();
         double[] marks = new double[tkn.countTokens()];
         for(int i = 0; i < marks.length; ++i)
         {
            marks[i] = Double.parseDouble(tkn.nextToken().trim());
         }
         tempStudents[count++] = new Student(sNum,famName, initials, marks);
      }
      return new Subject(tempCode, tempTitle, tempFieldCount, tempFieldWeights, tempStudentCount, tempStudents);
   }

   public void displayStudents()
   {
      for(Student s: students)
      {
         System.out.println(s);
      }
   }

   public void writeReport(PrintWriter out)
   {
      // Question 2 - to be completed

      // One approach is shown below

      //	Call a private method calculateFinalMarks() to update final marks
      calculateFinalMarks();

      // Define arrays of lower and upper bounds for the frequency table
      int [] lowers = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
      int [] uppers = {9, 19, 29, 39, 49, 59, 69, 79, 89, 99, 100};

      // Define array to hold frequencies, i.e. number of stars
      int[] frequencies = new int[lowers.length];

      // Perform a for loop to find highest and lowest mark indexes,
      // total marks and fill in frequencies array
      int hMark = 0;
      int lMark = 0;
      int sum = 0;
      for(int i = 0; i < studentCount; ++i)
      {
         int tempMark = finalMarks[i];
         if(tempMark > finalMarks[hMark]) hMark = i;
         if(tempMark < finalMarks[lMark]) lMark = i;

         for(int j = 0; j < lowers.length; ++j)
         {
            if((lowers[j] <= tempMark) && (tempMark <= uppers[j]))
            {
               ++frequencies[j];
               break;
            }
         }

         sum += tempMark;
      }
      double average = (double)sum/studentCount;

      // Output the required information followed by the histogram
      System.out.println("The student with the highest mark is: " + students[hMark].getName() + ", " +students[hMark].getInitials());
      System.out.println("The student with the lowest mark is: " + students[lMark].getName() + ", " +students[lMark].getInitials());
      System.out.printf("The average mark is: %2.2f \n",average);

      System.out.println("\nA histogram of the subject " + code + " is:");
      for(int index = 0; index < frequencies.length; ++index)
      {
         if(index == frequencies.length -1)
         {
            System.out.printf("%5d:",lowers[index]);
         }else
         {
            System.out.printf("%2d-%2d:",lowers[index],uppers[index]);
         }
         for(int k = 0; k < frequencies[index]; ++k)
         {
            System.out.print("*");
         }
         System.out.println();
      }
   }

   private void calculateFinalMarks()
   {
      StringTokenizer tempTkn = new StringTokenizer(fieldWeights, "|");
      tempTkn.nextToken();
      int[] weighting = new int[fieldCount];
      for(int k = 0; k < fieldCount; ++k)
      {
         weighting[k] = Integer.parseInt(tempTkn.nextToken().trim());
      }
      for(int i = 0; i < studentCount; ++i)
      {
         double sum = 0;
         for(int j = 1; j <= fieldCount; ++j)
         {
            sum += ( (students[i].getMark(j) * weighting[j-1]) / 100 );
         }
         finalMarks[i] = (int)sum;
      }
   }

   public String toString()
   {
      String desc = getClass().getName() + "[\ncode: " + code
             + "\nTitle: " + title
             + "\nField Count: " + fieldCount
             + "\nField Weights: " + fieldWeights
             + "\nStudent Count: " + studentCount
             + "\nStudents: [";
             for(Student s : students)
             {
                desc += "\n" + s;
             }
             desc += "\n]";
      return desc;
   }
}
