public class Pet
{
   private String name;
   private String type;
   private int age;
   
   public Pet(String name, String type, int age)
   {
      this.name = name;
      this.type = type;
      this.age = age;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getType()
   {
      return type;
   }
   
   public int getAge()
   {
      return age;
   }
   
   public void setAge(int age)
   {
      this.age = age;
   }
   
   public void increaseAge()
   {
      age++;
   }
   
   // not required by the question
   public String toString()
   {
      String s = "Pet[" 
                  + "name: " + name 
                  + ", type: " + type
                  + ", age: " + age 
                  + "]";
      return s;
   }
}
