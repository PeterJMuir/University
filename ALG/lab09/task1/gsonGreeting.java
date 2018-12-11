import java.util.*;
import java.io.*;
import com.google.gson.Gson;

public class gsonGreeting
{

   public static void main(String args[])
   {
      BufferedReader r = null;
      try
      {
         r = new BufferedReader (new FileReader("./greeting.txt"));
      }
      catch (IOException e)
      {
         System.out.println("" + e);
      }

      if (r!=null)
      {
         String line = "";
         String JsonString = "";
         try
         {
            while ((line = r.readLine()) != null)
            {
               System.out.println(line);
               JsonString += line;
            }
            Gson gsonOb = new Gson();
            greet myGreet = gsonOb.fromJson(JsonString, greet.class);
            System.out.println(myGreet.greeting);
            r.close();
         } 
         catch(IOException e)
         {
            System.out.println(""+e);
         }
      }
   }
}
