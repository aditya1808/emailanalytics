/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.email.analytics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author siva
 */
public class testpurpose {
   
 /*   public static void isNumeric(String string) {
       
   System.out.println(string.matches("^[-+]?\\d+(\\.\\d+)?$"));
      
    }
  */
  
  public static void main(String[] args) {
      
      //isNumeric("123.23");   
/*String regex = "[0-9]+";
String data = "23343453";
String str1="20/12/2013";
String str2="20/feb-2013";
String str3="20feb2013";
String str4="20feb";
String str5="feb20";
String str6="jan";
if(data.matches(regex))
{
    Date date=null;
   try{
    date = new SimpleDateFormat("dd/MM/yyyy").parse("20130925");
    
    } catch (ParseException ex) {
        System.out.println(ex);
    }
    if(date==null)
        System.out.println("date is not valid");
    else
        System.out.println("date valid");
    
   
    
    
    
    boolean checkformat,checkformat2,checkformat3,checkformat4,checkformat5,checkformat6;
    checkformat =str1.matches("([0-9]{2})(/|-)([0-9]{2})(/|-)([0-9]{4})");
    checkformat2=str2.matches("([0-9]{2})(/|-)([a-z]{3})(/|-)([0-9]{4})");
    checkformat3=str3.matches("([0-9]{2})([a-z]{3})([0-9]{4})");
    checkformat4=str4.matches("([0-9]{2})([a-z]{3})");
    checkformat5=str5.matches("([a-z]{3})([0-9]{2})");
    checkformat6=str6.matches("([a-z]{3})"); 
    System.out.println(checkformat+"-"+checkformat2+"-"+checkformat3+"-"+checkformat4+"-"+checkformat5+"-"+checkformat6);
}*/





String s1="Last one: http://abc.imp/Basic2#URPlus1_S2_3,";

String s3="12/20/2013";
String s4="21/feb/2014";
String s5="21feb 2014";
String s6="18 aug";
String s7="nov 18";
String s9 ="aditya,21 feb";

String str="aditya ravi 21 feb";

//Defining patterns for matching to search string
Pattern p1=Pattern.compile("#([^,]*)");
Pattern p2=Pattern.compile("");

//DATE PATTERNS
Pattern p3=Pattern.compile("(^[0-9]{2})(/|-)([0-9]{2})(/|-)([0-9]{4})$");
Pattern p4=Pattern.compile("(^[0-9]{2})(/|-|\\s)([a-zA-Z]{3})(/|-|\\s)([0-9]{4})$");

Pattern p6=Pattern.compile("(^[0-9]{2})(\\s|,|-|)([a-z]{3})$");
Pattern p7=Pattern.compile("(^[a-zA-Z]*)(\\s|,|-|)([0-9]{2})$");

// [string](" " or ,)[number] [string]
Pattern p9=Pattern.compile("(^[a-zA-Z]*)(\\s|,)([0-9]*)(\\s|,)(.*)"); // [string](" " or ,)[number] [string]
Pattern p10=Pattern.compile("(^[a-zA-Z]*)(\\s|,|-)([a-zA-Z]*)(\\s|,)([0-9]*)(\\s|,)(.*)");

Pattern p11=Pattern.compile("(^[0-9]*)(\\s|,)([a-zA-Z]*)(.*)");
//Matchers
Matcher m3=p3.matcher(str);

Matcher m4=p4.matcher(str);
Matcher m6=p6.matcher(str);
Matcher m7=p7.matcher(str);
Matcher m9 = p9.matcher(str);
Matcher m10 = p10.matcher(str);
Matcher m11=p11.matcher(str);


if (m3.find()) {
    System.out.println("String 3");
  String ss=m3.group(1);
  System.out.println(ss);// The matched substring
 // System.out.println(m3.group(2));
  System.out.println(m3.group(3));
  //System.out.println(m3.group(4));
  System.out.println(m3.group(5));
  
}

if (m4.find()) {
    System.out.println("String 4");
  String ss=m4.group(1);
  System.out.println(ss);// The matched substring
 // System.out.println(m4.group(2));
  System.out.println(m4.group(3));
  //System.out.println(m4.group(4));
  System.out.println(m4.group(5));
  
}


if (m6.find()) {
    System.out.println("String 6");
  String ss=m6.group(1);
  System.out.println(ss);// The matched substring
 System.out.println(m6.group(2));
  System.out.println(m6.group(3));
 // System.out.println(m6.group(4));
  //System.out.println(m6.group(5));
  
}
if (m7.find()) {
    System.out.println("String 7");
  String ss=m7.group(1);
  System.out.println(ss);// The matched substring
 System.out.println(m7.group(2));
  System.out.println(m7.group(3));
  //System.out.println(m7.group(4));
  //System.out.println(m7.group(5));
  
}

if (m9.find()) {
    System.out.println("String 9");
  String ss=m9.group(1);
  System.out.println(ss);// The matched substring
  System.out.println(m9.group(2));
  System.out.println(m9.group(3));
  System.out.println(m9.group(4));
  System.out.println(m9.group(5));
  
}

if (m10.find()) {
    System.out.println("String 10");
  String ss=m10.group(1);
  System.out.println(ss);// The matched substring
  System.out.println(m10.group(2));
  System.out.println(m10.group(3));
  System.out.println(m10.group(4));
  System.out.println(m10.group(5));
  System.out.println(m10.group(6));
  System.out.println(m10.group(7));
}

if (m11.find()) {
    System.out.println("String 11");
  String ss=m11.group(1);
  System.out.println(ss);// The matched substring
  System.out.println(m11.group(2));
  System.out.println(m11.group(3));
  System.out.println(m11.group(4));

  
}



  }
}
