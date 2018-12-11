/*
 * Class Name:    CarClubMemberTester
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 19 2016, 14:44 
 * Last Modified: Tuesday, April 19 2016, 14:58
 * 
 * Class Description:
 *
 */

public class CarClubMemberTester
{
   public static void main(String[] args)
   {
      CarClubMember Frank = new CarClubMember("Frank","001");
      String FrankName = Frank.getName();
      System.out.println("Category test: name");
      System.out.println("   name should be set to Frank");
      System.out.println("   name is set to " + FrankName);
      System.out.println("   Test: " + (FrankName.equals("Frank") ? "SUCCESSFUL" : "FAILED"));


      String FrankPhone = Frank.getPhone();
      System.out.println("Category test: phone");
      System.out.println("   phone should be set to 001");
      System.out.println("   phone is set to " + FrankPhone);
      System.out.println("   Test: " + (FrankPhone.equals("001") ? "SUCCESSFUL" : "FAILED"));


      String FrankCar1 = Frank.getCar1Details();
      System.out.println("Category test: Car1Details");
      System.out.println("   Car1Details should be set to none");
      System.out.println("   name is set to " + FrankName);
      System.out.println("   Test: " + (FrankName.equals("Frank") ? "SUCCESSFUL" : "FAILED"));
   }
}
