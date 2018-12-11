public class PhysicsCalc
{
   public static void main(String[] args)
   {
      double time = 3.0;
      double initialVelocity = 4.5;
      double acceleration = 9.5;
      double finalVelocity = 0;
      double displacement = 0;

      //Equation 1
      displacement = initialVelocity*time;
      System.out.println("Equation 1: " + displacement);
      //Equation 2
      displacement = initialVelocity*time + (acceleration*time*time)/2;
      System.out.println("Equation 2: " + displacement);
      //Equation 3
      finalVelocity = initialVelocity + acceleration*time;
      System.out.println("Equation 3: " + finalVelocity);
      //Equation 4
      finalVelocity = Math.sqrt(initialVelocity*initialVelocity + 2*acceleration*displacement);
      System.out.println("Equation 4: " + finalVelocity);
   }
}
