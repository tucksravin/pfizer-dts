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

//copies in data into Sample object and builds a list.
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


  try {

        // create a write

        BufferedWriter writer =  new BufferedWriter(new FileWriter("output.csv"));

        // write header record
        writer.write("STUDY,PATIENT,VISIT,EFF_ACCESSION_NUM,MBIO_SAMP_DATE,MBIO_SAMP_TIME,EFF_PLN_TIME,MBIO_SOURCE,MBIO_SAMP_SITE,MBIO_SAMP_SITE_DET,MBIO_SAMP_ORIGIN,MBIO_PROCED,MBIO_COLL_PROC_DATE,MBIO_COLL_PROC_DATE,MBIO_SLIDES_CUT_DATE,MBIO_SENT_LAB_DATE,MBIO_PROCESS,MBIO_PROCESS_DET,MBIO_ANALYTE_2,MBIO_TEST_DESCR,MBIO_ANALYT_METH,MBIO_ANAL_METH_SPEC,MBIO_ANAL_METH_DET,MBIO_ANALYZED_DATE,MBIO_QUAL_RES,MBIO_PARM_2,MBIO_QUANTIT_RES,MBIO_RES_UNIT,MBIO_GENE_ALTER,MBIO_VENDOR,MBIO_COM_VEN");
        writer.newLine();

        Iterator<Sample> it = samples.iterator();
        String s = "";
        String o = "";
        Sample sam;

        while(it.hasNext())
        {
          sam=it.next();

          s = "B1371012, "+sam.getSite()+sam.getSub() + "," + sam.getTimePoint() + "," + sam.getAcc() + "," + sam.getCDate() + "," + sam.getCTime() + ",,";
          if(sam.getMarrow().equals("BM"))
            s=s+"BONE MARROW,,,,BONE MARROW ASPIRATE,,,,,,,";
          else
            s=s+"BLOOD,,,,PERIPHERAL BLOOD,,,,,,,";

          for(int i=0 ; i<7 ; i++)
          {
              switch(i)
              {
                case 0:
                  o=s+"GAPDH,CONTROL FOR GLI1 EXPRESSION,";
                  break;

                case 1:
                  o=s+"GLI1,,";
                  break;

                case 2:
                  o=s+"GAPDH,CONTROL FOR GLI3 EXPRESSION,";
                  break;

                case 3:
                  o=s+"GLI3R,,";
                  break;

                case 4:
                  o=s+"GLI3FL,,";
                  break;

                case 5:
                  o=s+"GAPDH,CONTROL FOR SMO EXPRESSION,";
                  break;

                case 6:
                  o=s+"SMO,,";
                  break;
              }

              o=o+"WESTERN BLOT,";

              if(sam.getLysate())
                o=o+",,20210101,,,100.00,RFU,,CEDARS-SINAI,";
              else
                o=o+",,,,,,RFU,,CEDARS-SINAI,INSUFFICIENT CELL QUANTITY FOR ANALYSIS";

                writer.write(o);
                writer.newLine();
          }


        }
        // write all records


        //close the writer
        writer.close();

    } catch (IOException ex) {
        ex.printStackTrace();
    }

  }



}
