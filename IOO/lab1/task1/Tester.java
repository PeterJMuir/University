public class Tester
{
	public static void main(String [] args) throws Exception
	{
		Pet p1 = new Pet("P10", "Snoopy", "Charlie");
		System.out.println(p1);

		Pet p2 = new Dog("P20", "Pluto", "Mickey", "large");
		System.out.println(p2);

		Pet p3 = new Cat("P30", "Garfield", "Odie", "SH");
		System.out.println(p3);

		Pet p4 = new DangerousDog("P40", "Fang", "Joe", "large", 2);
		System.out.println(p4);

		Pet p5 = new DangerousDog("P50", "Crusher", "Luca", "large");
		System.out.println(p5);

		((DangerousDog)p5).setReportedIncidents(3);
		System.out.println(p5);

		System.out.println(".................");

		Pet[] pets = {p1, p2, p3, p4, p5};
		for(Pet p: pets)
		{
			System.out.println(p);
		}

      //Display all Dogs:
      for(Pet p: pets)
      {
         if(p instanceof Dog)
         {
            System.out.println(p);
         }
      }

      //Display Dogs, not DangerousDogs
      for(Pet p: pets)
      {
         if(p.getClass() == Class.forName("Dog"))
         {
            System.out.println(p);
         }
      }

      //Display total number of reported incidents
      int totalIncidents = 0;
      for(Pet p: pets)
      {
         if(p instanceof DangerousDog)
         {
            totalIncidents += ((DangerousDog) p).getReportedIncidents();
         }
      }
      System.out.println("totalIncidents: " + totalIncidents);
	}
}
