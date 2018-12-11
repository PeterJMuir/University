public class CTTester
{
	public static void main(String[] args)
	{
		ChangeTracker<Integer> a = new ChangeTracker<Integer>(11);
		System.out.printf("current %d, original %d, changes %d\n", a.current, a.original, a.changes);
		a.update(new Integer(30));
		System.out.printf("current %d, original %d, changes %d\n", a.current, a.original, a.changes);
		a.update(30);
		System.out.printf("current %d, original %d, changes %d\n", a.current, a.original, a.changes);
	}
}