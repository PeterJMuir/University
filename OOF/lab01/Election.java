public class Election
{
   public static void main(String[] args)
   {
      long LibCoVotes = 6_908_710;
      long AusLabVotes = 6_006_217;
      long totalvotes;
      double LibCopercent;
      double AusLabpercent;
      totalvotes = LibCoVotes + AusLabVotes;
      LibCopercent = (LibCoVotes/(double)totalvotes) * 100;
      AusLabpercent = (AusLabVotes/(double)totalvotes) * 100;
      System.out.println("The total number of formal votes is: "+totalvotes);
      System.out.println("The percentage of votes that are for Liberal/National Coalition is: "+LibCopercent);
      System.out.println("The percentage of votes that are for Australian Labor Party is: "+AusLabpercent);
   }
}
