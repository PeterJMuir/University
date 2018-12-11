//	Lab 3
//	Question 4: Used to test class ManiSpeciesTank

public class MSTankTester
{
   public static void main(String[] args)
   {
		test1();		// test canAddFish
		test2();		// test addFish
		test3();		// test canRemoveFish and removeFish
	}

	// test canAddFish
	private static void test1()
	{
      Fish n = new Fish("clownfish", 'T', 'S');
      Fish b = new Fish("barracuda", 'T', 'S');
      Fish t = new Fish("trout", 'C', 'F');
      Fish g = new Fish("guppy", 'T', 'F');
      Fish s = new Fish("snapper", 'C', 'S');

      ManySpeciesTank myTank = new ManySpeciesTank("tank1", 'T', 'S', 'S');

      System.out.println("Can add clownfish? " + myTank.canAddFish(n));
      System.out.println("Can add barracuda? " + myTank.canAddFish(b));
      System.out.println("Can add trout? " + myTank.canAddFish(t));
      System.out.println("Can add guppy? " + myTank.canAddFish(g));
      System.out.println("Can add snapper? " + myTank.canAddFish(s));
   }

	// test addFish
	public static void test2()
	{
      Fish nemo1 = new Fish("clownfish", 'T', 'S');
      Fish nemo2 = new Fish("clownfish", 'T', 'S');
      Fish b1 = new Fish("barracuda", 'T', 'S');
		Fish b2 = new Fish("barracuda", 'T', 'S');
		Fish t = new Fish("trout", 'C', 'F');

      ManySpeciesTank myTank = new ManySpeciesTank("tank1", 'T', 'S', 'S');

      System.out.println("Add clownfish? " + myTank.addFish(nemo1));
      System.out.println("Add barracuda? " + myTank.addFish(b1));
      System.out.println("Add trout? " + myTank.addFish(t));
      System.out.println("Add clownfish? " + myTank.addFish(nemo2));
      System.out.println("Add barracuda? " + myTank.addFish(b2));

      System.out.println("\nDisplay tank");
      myTank.display();
   }

	// test canRemoveFish and removeFish
	public static void test3()
	{
   	Fish nemo1 = new Fish("clownfish", 'T', 'S');
		Fish nemo2 = new Fish("clownfish", 'T', 'S');
		Fish b = new Fish("barracuda", 'T', 'S');

      ManySpeciesTank myTank = new ManySpeciesTank("tank1", 'T', 'S', 'S');
      myTank.addFish(nemo1);
      myTank.addFish(nemo2);
      myTank.addFish(b);

      System.out.println("\nDisplay tank");
      myTank.display();

		System.out.println("\nCan remove clown fish? " +
                                  myTank.canRemoveFish("clownfish"));
      System.out.println("Can remove barracuda? " +
                                  myTank.canRemoveFish("barracuda"));

      System.out.println("\nRemove clownfish? " + myTank.removeFish("clownfish"));
      System.out.println("Remove barracuda? " + myTank.removeFish("barracuda"));

    	System.out.println("\nCan remove barracuda? " +
                                  myTank.canRemoveFish("barracuda"));
      System.out.println("Remove barracuda? " + myTank.removeFish("barracuda"));

      System.out.println("\nDisplay tank");
      myTank.display();
   }

}
/*
Result for Test1:
----------------

Can add clownfish? true
Can add barracuda? true
Can add trout? false
Can add guppy? false
Can add snapper? false

Result for Test2:
----------------

Add clownfish? true
Add barracuda? true
Add trout? false
Add clownfish? true
Add barracuda? false

Display tank
ManySpeciesTank: tank id tank1
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: barracuda, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]

Result for Test3:
----------------

Display tank
ManySpeciesTank: tank id tank1
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: barracuda, temperature: T, salinity: S ]

Can remove clown fish? true
Can remove barracuda? true

Remove clownfish? Fish[ species: clownfish, temperature: T, salinity: S ]
Remove barracuda? Fish[ species: barracuda, temperature: T, salinity: S ]

Can remove barracuda? false
Remove barracuda? null

Display tank
ManySpeciesTank: tank id tank1
Fish[ species: clownfish, temperature: T, salinity: S ]
*/
