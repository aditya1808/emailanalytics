/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.email.analytics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author siva
 */
public class search {
    public static void main(String[] args){
        search srch=new search();
        srch.assignsearch("adit7 ravi 65 tst");
    }
        public void assignsearch(String str)
        {

//DATE PATTERNS
Pattern p3=Pattern.compile("(^[0-9]{2})(/|-)([0-9]{2})(/|-)([0-9]{4})$");
Pattern p4=Pattern.compile("(^[0-9]{2})(/|-|\\s)([a-zA-Z]{3})(/|-|\\s)([0-9]{4})$");

Pattern p6=Pattern.compile("(^[0-9]{2})(\\s|,|-|)([a-z]{3})$");
Pattern p7=Pattern.compile("(^[a-zA-Z]*)(\\s|,|-|)([0-9]{2})$");

// [string](" " or ,)[number] [string]
Pattern p9=Pattern.compile("(^[a-zA-Z\\d.]*)(\\s|,)([0-9]*)(\\s|,)(.*)"); // [string](" " or ,)[number] [string]
Pattern p10=Pattern.compile("(^[a-zA-Z\\d.]*)(\\s|,|-)([a-zA-Z\\d.]*)(\\s|,)([0-9]*)(\\s|,)(.*)");

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
