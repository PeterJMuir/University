//	Lab 3
//	Question 3: Used to test class OneSpeciesTank

public class OSTankTester
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

      OneSpeciesTank myTank = new OneSpeciesTank("tank1", 'T', 'S');

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
      Fish nemo3 = new Fish("clownfish", 'T', 'S');
      Fish nemo4 = new Fish("clownfish", 'T', 'S');
      Fish nemo5 = new Fish("clownfish", 'T', 'S');
      Fish nemo6 = new Fish("clownfish", 'T', 'S');
      Fish nemo7 = new Fish("clownfish", 'T', 'S');
      Fish b = new Fish("barracuda", 'T', 'S');

      OneSpeciesTank myTank = new OneSpeciesTank("tank1", 'T', 'S');

      System.out.println("Add clownfish? " + myTank.addFish(nemo1));
      System.out.println("Add barracuda? " + myTank.addFish(b));

      System.out.println("Add clownfish? " + myTank.addFish(nemo2));
      System.out.println("Add clownfish? " + myTank.addFish(nemo3));
      System.out.println("Add clownfish? " + myTank.addFish(nemo4));
      System.out.println("Add clownfish? " + myTank.addFish(nemo5));
      System.out.println("Add clownfish? " + myTank.addFish(nemo6));
      System.out.println("Add clownfish? " + myTank.addFish(nemo7));

      System.out.println("\nDisplay tank");
      myTank.display();
   }

	// test canRemoveFish and removeFish
	public static void test3()
	{
      Fish nemo1 = new Fish("clownfish", 'T', 'S');
      Fish nemo2 = new Fish("clownfish", 'T', 'S');
      Fish nemo3 = new Fish("clownfish", 'T', 'S');

      OneSpeciesTank myTank = new OneSpeciesTank("tank1", 'T', 'S');
      myTank.addFish(nemo1);
      myTank.addFish(nemo2);
      myTank.addFish(nemo3);

      System.out.println("\nDisplay tank");
      myTank.display();

      System.out.println("\nCan remove barracuda? " +
                                  myTank.canRemoveFish("barracuda"));

      System.out.println("Remove clownfish? " + myTank.removeFish("clownfish"));
      System.out.println("Remove clownfish? " + myTank.removeFish("clownfish"));
      System.out.println("Remove clownfish? " + myTank.removeFish("clownfish"));
      System.out.println("Remove clownfish? " + myTank.removeFish("clownfish"));

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
Add barracuda? false
Add clownfish? true
Add clownfish? true
Add clownfish? true
Add clownfish? true
Add clownfish? true
Add clownfish? false

Display tank
OneSpeciesTank: tank id tank1
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]

Result for Test3:
----------------

Display tank
OneSpeciesTank: tank id tank1
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]
Fish[ species: clownfish, temperature: T, salinity: S ]

Can remove barracuda? false
Remove clownfish? Fish[ species: clownfish, temperature: T, salinity: S ]
Remove clownfish? Fish[ species: clownfish, temperature: T, salinity: S ]
Remove clownfish? Fish[ species: clownfish, temperature: T, salinity: S ]
Remove clownfish? null

Display tank
OneSpeciesTank: tank id tank1
*/
