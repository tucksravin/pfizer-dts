import java.util.*;
import java.io.*;

public class Sample {


private String site;
private String sub;
private String acc;
//private String id;
private String cDate;
private String cTime;
private String timePoint;

//if false, then peripheral blood
private String marrow;

private boolean lysate;

/*
private String gli1Value;
private String gli1Gapdh;
private String gli3FullValue;
private String gli3RepValue;
private String gli3Gapdh;
private String smoValue;
private String smoGapdh;
private String rejectReason;
*/

public void setSite(String s)
{
  site = s;
}

public void setSub(String s)
{
  sub = s;
}

public void setAcc(String s)
{
  acc = s;
}

//public void setId(String s)
//{
  //id = s;
//}

public void setCDate(String s)
{
  String year = "20"+s.substring(s.length()-2);
  String monthName = s.substring(s.length()-8,s.length()-5);
  String month ="??";
  switch(monthName)
  {
    case "Jan":
      month="01";
      break;
    case "Feb":
      month="02";
      break;
    case "Mar":
      month="03";
      break;
    case "Apr":
      month="04";
      break;
    case "May":
      month="05";
      break;
    case "Jun":
      month="06";
      break;
    case "Jul":
      month="07";
      break;
    case "Aug":
      month="08";
      break;
    case "Sep":
      month="09";
      break;
    case "Oct":
      month="10";
      break;
    case "Nov":
      month="11";
      break;
    case "Dec":
      month="12";
      break;


  }
  String day = s.substring(0,s.length()-9);

  if(Integer.parseInt(day)<10)
    day = "0"+day;

  cDate = year + month + day;
}

public void setCTime(String s)
{
  if(s.length()<5)
  s="0"+s;
  String o = s;
  o = s.substring(0, s.length()-3)+ s.substring(s.length()-2)+"00";
  cTime = o;
}

public void setTimePoint(String s)
{
  timePoint = s;
}

public void setMarrow(String s)
{
  marrow = s;
}

public void setLysate(String s)
{

  if(s.equals("-")||s.isEmpty())
    lysate=false;
  else
    lysate=true;
}

// gets

public String getSite()
{
  return site;
}

public String getSub()
{
  return sub;
}

public String getAcc()
{
  return acc;
}

//public String getId()
//{
//  return id;
//}

public String getCDate()
{
  return cDate;
}

public String getCTime()
{
  return cTime;
}

public String getTimePoint()
{
  return timePoint;
}

public String getMarrow()
{
  return marrow;
}

public boolean getLysate()
{
  return lysate;
}

public String toString()
{
  String s =     "site     : " + site;
  s = s + "\n" + "subject  : " + sub;
  s = s + "\n" + "accession: " + acc;
//  s = s + "\n" + "id       : " + id;
  s = s + "\n" + "col date : " + cDate;
  s = s + "\n" + "col time : " + cTime;
  s = s + "\n" + "type     : " + marrow;
  s = s + "\n" + "ptn count: " + lysate;

  return s;
}


}
