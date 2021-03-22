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

private String lysate;

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
  cDate = s;
}

public void setCTime(String s)
{
  cTime = s;
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
  lysate = s;
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

public String getLysate()
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
