public class TriangleTypeTester
{
 	private static int testNr = 0;
  	private static int passedTests = 0;
 	private static int failedTests = 0;

   public static void main(String[] args)
   {
      System.out.println("Tests");
      System.out.println("-----");

      // First test (for example)
      String testDescription = "Inputs form 3 sides of a scalene triangle";
      test(4, 2, 3, testDescription, "scalene");

      // Next tests
      testDescription = "Inputs form 3 sides of an equilateral triangle";
      test(2, 2, 2, testDescription, "equilateral");

      testDescription = "Inputs form 3 sides of an isosceles triangle";
      test(2, 2, 3, testDescription, "isosceles");

      testDescription = "Inputs form an invalid triangle (negative length)";
      test((-3), 2, 2, testDescription, "invalid");

      testDescription = "Inputs form an invalid triangle (zero length side)";
      test(2, 0, 3, testDescription, "invalid");

      testDescription = "Inputs form an invalid triangle (zero length all sides)";
      test(0, 0, 0, testDescription, "invalid");

      testDescription = "Inputs form an invalid triangle (negative length all sides)";
      test(-2, -1, -3, testDescription, "invalid");

      // Testing Report
      int totalTests = failedTests + passedTests;
      System.out.println();
      System.out.println("Testing Report");
      System.out.println("--------------");
      System.out.println("PASSED tests: " + passedTests);
      System.out.println("FAILED tests: " + failedTests);
      System.out.println("TOTAL tests: " + totalTests);
   }

   public static void test(int a, int b, int c, String testDescription, String expected)
   {
      System.out.println("\nTest " + (++ testNr) + ":  " + testDescription);

      String result = Geometry.triangleType(a, b, c);

      System.out.println("Expected Result: " + expected);
      System.out.println("Actual Result: " + result);
      if (result.equals(expected))
      {
         System.out.println("SUCCESSFUL");
         ++passedTests;
      }
      else
      {
         System.out.println("FAILED");
         ++failedTests;
      }
	}
}
