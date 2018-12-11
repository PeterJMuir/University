import java.util.*;

public class time
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);
      System.out.print("GIMME SOME SECONDS, SON: ");
      int secs = kbd.nextInt();
      int mins = secs/60;
      int hours = mins/60;
      secs = secs%60;
      mins = mins%60;
      System.out.println("DA-YUM, THAT'S " + hours + " HOURS " + mins + " MINUTES AND " + secs + " SECONDS!");
   }
}
