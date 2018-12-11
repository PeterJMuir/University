import java.util.*;
public class Two
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in); 

      // get temperature
      System.out.print("Enter a Fahrenheit temperature: ");
      double fahrenheit = keyboard.nextDouble();
                        
      // convert
      double celsius = 5 * (fahrenheit - 32) / 9;
      
      // display
      System.out.print(fahrenheit);
      System.out.printf(" Farenheit is equivalent to %.2f Celsius\n",
                        celsius);
   } 
}
