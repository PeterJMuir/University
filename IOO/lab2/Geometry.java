public class Geometry
{
	public static String triangleType(int a, int b, int c)
	{
		if(a <= 0 || b <= 0 || c <= 0)
      {
			return "invalid";
		}
		else if(a == b && b == c)
      {
			return "equilateral";
		}
		else if(a == b || a == c || b == c)
      {
			return "isosceles";
		}
		else
      {
			return "scalene";
		}
	}
}
