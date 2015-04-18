/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.email.analytics;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.Date;

/**
 *
 * @author siva
 */
public class user {
    public static String str1,str2,str3,str4;
    Date dt;
    public static String usrname;
    public static void main(String[] args) throws UnknownHostException
    {
        usrname="adityaravi65@gmail.com";
         Mongo mongoClient = new Mongo( "localhost" , 27017 );
             
         
         DB db = mongoClient.getDB( "email3" );
         System.out.println("Conn succesful");
         
                 
         DBCollection coll3 = db.getCollection(usrname);
         System.out.println("Collection created successfully ...");
        
  
         //Search
         search srch=new search();
        srch.assignsearch("29aug1990");
        
        if(srch.result=="m3")
        {
            Date dt=srch.d;
            System.out.println(dt);
        }
        
        if(srch.result=="m6")
        {
            Date dt=srch.d;
        }
        
        if(srch.result=="m9")
        {
            str1=srch.srchstr2;
            str2=srch.srchstr3;
           
            //Use these two strings for searching in mongodb
        }
        
        if(srch.result=="m10")
        {
            //use these two strings for searching in mongodb
         str1=srch.srchstr2;
         str2=srch.srchstr3;
         str3=srch.srchstr4;
         
         System.out.println(str1+str2);
        }
        if(srch.result=="m11")
        {
            
        }
    }
    
}
