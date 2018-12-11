import java.io.FileNotFoundException;

/*
 * Class Name:    Tester
 *
 * Author:        Your Name
 * Creation Date: Thursday, April 27 2017, 22:31 
 * Last Modified: Friday, April 28 2017, 02:39
 * 
 * Class Description:
 *
 */

public class Tester
{
   public static void main(String[] args) throws FileNotFoundException
   {
	   Window s = Window.readSpecFromFile("HouseFile.txt");
      //Window s = new Window(40,40,'*');
      //s.display();
      /*Shape l = new Line(1,1,19,1,1,'1');s.addShape(l);
      Shape r = new Rectangle(5,5,3,6,'9');s.addShape(r);
      Shape t = new Triangle(9,10,3,-1,0,'3');s.addShape(t);
      Shape c = new Circle(15,11,5,'+');s.addShape(c);
      Shape txt = new Text(15,15,"HELLO MORTALS",1,0);s.addShape(txt);*/
      s.display();
      s.writeSpecToFile("T1Drawing.txt");
   }
}

