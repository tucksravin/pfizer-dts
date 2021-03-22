import java.util.*;
import java.io.*;

public class ReadOut{

public static void main(String args[])
{
  System.out.println("--------------------------------------------------------------------------------------------------");


try( Scanner sc = new Scanner(new File("inv2.csv"));){
  sc.useDelimiter(",");   //sets the delimiter pattern
  for(int i = 0;i<20;i++)
  {
    sc.next();
  }
  while (sc.hasNext())  //returns a boolean value
  {

    System.out.println("____");
    System.out.println(sc.next());

  }
}catch (FileNotFoundException e){

        e.printStackTrace();
    }

}
}
