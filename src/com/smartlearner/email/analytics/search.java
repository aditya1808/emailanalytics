/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.email.analytics;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
/**
 *
 * @author siva
 */
public class search {
    
     public boolean isValidDate(String inDate,String df) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(df);
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  }
     
     
     public void formatstr(String str1,String dfrmt)
     {
         
          SimpleDateFormat formatter = new SimpleDateFormat(dfrmt);
	try {
 		d = formatter.parse(str1);
		//System.out.println(d);
		
	} catch (ParseException e) {
		e.printStackTrace();
	}
 
     }
     
     
    public static void main(String[] args){
        search srch=new search();
        srch.assignsearch("asd qwe 21 tst"); //not working for "asd qwe 21"
    }
    
    String srchstr1;
    String srchstr2,srchstr3,srchstr4;
    Date d;
    String result;
        public void assignsearch(String str)
        {
            srchstr1=null;
            srchstr2=null;
            srchstr3=null;
            d=null;
            
//PATTERNS
Pattern p3=Pattern.compile("^([0-9]{1,2})(/|-|\\s|)([0-9]{1,2}|[a-zA-Z]{3})(/|-|\\s|)([0-9]{4})*$");
Pattern p6=Pattern.compile("^([0-9]{2}|[a-zA-z]*)(\\s|,|-|)([a-zA-Z]*|[0-9]{2})$");
Pattern p9=Pattern.compile("(^[a-zA-Z\\d.]*)(\\s|,)([0-9]*)(\\s|,)(.*)"); // [string](" " or ,)[number] [string]
Pattern p10=Pattern.compile("^([a-zA-Z\\d.]*|[\\da-zA-z.]*)(\\s|,|-)([a-zA-Z\\d.]*|[\\da-zA-z.]*)(\\s|,)([0-9]*)(\\s|,)(.*)$");
Pattern p11=Pattern.compile("^([0-9]{4}|[a-zA-z]*)(\\s|,|-|)([a-zA-Z]*|[0-9]{4})$");


//Matchers
Matcher m3=p3.matcher(str);
Matcher m6=p6.matcher(str);
Matcher m9=p9.matcher(str);
Matcher m10=p10.matcher(str);
Matcher m11=p11.matcher(str);



if (m3.find()) {
 //  System.out.println("m3.group(3)");
// System.out.println(m3.group(2));
 // System.out.println(m3.group(3));
 //System.out.println(m3.group(4));
  //System.out.println(m3.group(5));
 if(isValidDate(str,"dd/MMM/yyyy")==true)
 {
 formatstr(str,"dd/MMM/yyyy");
 }
 if(isValidDate(str,"dd/MM/yyyy")==true)
 {
     formatstr(str,"dd/MM/yyyy");
 }   
if(isValidDate(str,"dd-MM-yyyy")==true)
 {
     formatstr(str,"dd-MM-yyyy");
 }   
if(isValidDate(str,"dd-MMM-yyyy")==true)
 {
     formatstr(str,"dd-MMM-yyyy");
 }   
if(isValidDate(str,"ddMMMyyyy")==true)
 {
     formatstr(str,"ddMMMyyyy");
 }
if(isValidDate(str,"ddMMyyyy")==true)
 {
     formatstr(str,"ddMMyyyy");
 }
if(isValidDate(str,"dd MMM yyyy")==true)
 {
     formatstr(str,"dd MMM yyyy");
 }
if(isValidDate(str,"dd MM yyyy")==true)
 {
     formatstr(str,"dd MM yyyy");
 }
 //System.out.println(new SimpleDateFormat("MMM-dd-yyyy").format(d));
         
result="m3";
}



if (m6.find()) {
  //System.out.println(m6.group(1););// The matched substring
//  System.out.println(m6.group(2));
 //System.out.println(m6.group(3));
  //System.out.println(m6.group(5));
System.out.println("string 6"); 

 if(isValidDate(str,"dd/MMM")==true)
 {
 formatstr(str,"dd/MMM");
 }
 if(isValidDate(str,"dd/MM")==true)
 {
     formatstr(str,"dd/MM");
 }   
if(isValidDate(str,"dd-MM")==true)
 {
     formatstr(str,"dd-MM");
 }   
if(isValidDate(str,"dd-MMM")==true)
 {
     formatstr(str,"dd-MMM");
 }   
if(isValidDate(str,"ddMMM")==true)
 {
     formatstr(str,"ddMMM");
 }
if(isValidDate(str,"ddMM")==true)
 {
     formatstr(str,"ddMM");
 }
if(isValidDate(str,"dd MMM")==true)
 {
     formatstr(str,"dd MMM");
 }
if(isValidDate(str,"dd MM")==true)
 {
     formatstr(str,"dd MM");
 }   
result="m6";
}

if (m11.find()) {
    System.out.println("string 11");
if(isValidDate(str,"yyyy/MMM")==true)
 {
 formatstr(str,"yyyy/MMM");
 }
 if(isValidDate(str,"yyyy/MM")==true)
 {
     formatstr(str,"yyyy/MM");
 }   
if(isValidDate(str,"yyyy-MM")==true)
 {
     formatstr(str,"yyyy-MM");
 }   
if(isValidDate(str,"yyyy-MMM")==true)
 {
     formatstr(str,"yyyy-MMM");
 }   
if(isValidDate(str,"yyyyMMM")==true)
 {
     formatstr(str,"yyyyMMM");
 }
if(isValidDate(str,"yyyyMM")==true)
 {
     formatstr(str,"yyyyMM");
 }
if(isValidDate(str,"yyyy MMM")==true)
 {
     formatstr(str,"yyyy MMM");
 }
if(isValidDate(str,"yyyy MM")==true)
 {
     formatstr(str,"yyyy MM");
 }   
result="m11";
    
}




if (m9.find()) {
    System.out.println("String 9");
  String ss=m9.group(1);
  System.out.println(ss);// The matched substring
  System.out.println(m9.group(2));
  System.out.println(m9.group(3));
  System.out.println(m9.group(4));
  System.out.println(m9.group(5));
  
srchstr2=m9.group(1);
srchstr3=m9.group(5);

if(isValidDate(m9.group(5),"dd")==true)
 {
     formatstr(m9.group(5),"dd");
 }
if(isValidDate(m9.group(5),"yyyy")==true)
 {
     formatstr(m9.group(5),"yyyy");
 }

result="m9";
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
  
    
srchstr2=m10.group(1);
srchstr3=m10.group(3);
srchstr4=m10.group(7);
if(isValidDate(m10.group(5),"dd")==true)
 {
     formatstr(m10.group(5),"dd");
 }
if(isValidDate(m10.group(5),"yyyy")==true)
 {
     formatstr(m10.group(5),"yyyy");
 }
//group 5 could be date
result="m10";
}
                             
        }
        

}
