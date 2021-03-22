import java.util.*;
import java.io.*;

public class DTSConverter{

  public static void main(String args[])
  {
    System.out.println("--------------------------------------------------------------------------------------------------");
    LinkedList<Sample> samples = new LinkedList<Sample>();
    Sample curr = new Sample();
    String token;
    int col=0;
    /*
      0  - site number
      1  - subject number
      2  - accession number
      3  - id on sample
      4  - dob
      5  - sex
      6  - specimen collection date
      7  - specimen collection time
      8  - timePoint
      9  - specimen type
      10 - specimen process
      11 - total cell number
      12 - rna
      13 - dna
      14 - protein
      15 - frozen cells
      16 - freezer
      17 - box
      18 - position
      19 - notes

    */


    try( Scanner sc = new Scanner(new File("inv.csv"));){
      sc.useDelimiter(",");   //sets the delimiter pattern

      for(int i = 0;i<20;i++) //skips the header
      {
        sc.next();
      }

      while (sc.hasNext())  //returns a boolean value
      {
        token = sc.next();
          //find and returns the next complete token from this scanner

        if(col==0)
        {
          if(token.substring(2).isEmpty())
          {
            for(int i =0 ; i <60 ; i++)
            {
              token = sc.next();
            }
          }
          curr = new Sample();
          System.out.println();
          curr.setSite(token.substring(2));
        }

        else if(col==1)
          curr.setSub(token);

        else if(col==2)
            curr.setAcc(token);

        else if(col==6)
          curr.setCDate(token);

        else if(col==7)
          curr.setCTime(token);

        else if(col==8)
          curr.setTimePoint(token);

        else if(col==9)
          curr.setMarrow(token);

        else if(col==14)
          curr.setLysate(token);

        col++;

        if(col==19)
        {
          System.out.println(curr.toString());
          samples.add(curr);
          col=-1;
        }
      }
      sc.close();  //closes the scanner
    }catch (FileNotFoundException e){

            e.printStackTrace();
        }

  }



}
