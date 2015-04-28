/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.email.analytics;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ListIterator;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author kriti
 */
public class dbmanage {
    
    public static void prnt(Pattern nr,DBCollection col)
    {
    
         BasicDBObject query = new BasicDBObject("date", nr);
        
        DBCursor cursor = col.find(query); 
            System.out.println("***** Output *****");
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
    
    }
public static void main(String args[]) throws UnknownHostException {

    
    
      Mongo mongoClient = new Mongo( "localhost" , 27017 );
             
         
         DB db = mongoClient.getDB( "header" );
         System.out.println("Conn succesful");
         
         DBCollection coll3 = db.getCollection("head_coll");
         System.out.println("Collection created successfully ...");
        
         /* BasicDBObject document = new BasicDBObject();
            document.put("subject", "sub");
            document.put("from","frm");
            document.put("date","dt");
            coll3.insert(document);
         */
         //Scanner in=new Scanner(System.in);
         //String tst;
         //System.out.println("Enter serach query:");
         //tst=in.nextLine();
         
         Pattern namesRegex;
        srchtest srch=new srchtest();
        srch.assignsearch("19/jan/2015");
        
        if(srch.result=="m3")
        {
         
         String tt=srch.month;
         
        // String tst = Character.toUpperCase(tt.charAt(0)) + tt.substring(1);
        
         String tst="Aditya";
         //String tst1 = Character.toUpperCase(tst.charAt(0)) + tst.substring(1);
          namesRegex = Pattern.compile("^(.*)job(.*)you(.*)" );
          
          prnt(namesRegex,coll3);
        
         BasicDBObject query = new BasicDBObject("subject", namesRegex);
        
        DBCursor cursor = coll3.find(); 
            System.out.println("***** Output *****");
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        }
       
        
        /*
         BasicDBObject abc=new BasicDBObject();
         abc.put("from","Myntra");
         
         DBCursor cursor = coll3.find(abc);
        
         while (cursor.hasNext())
        { 
          
        System.out.println(cursor.next()); 
           
        }
          */  
            
         /*coll3.ensureIndex(new BasicDBObject("from", 1),new BasicDBObject("date", 1));
         List <DBObject> list = coll3.getIndexInfo();

  for (DBObject o : list) {
       System.out.println(o);
    }
                 */
         //BasicDBObject abc=new BasicDBObject();
         //abc.put("subject","Internshala Campus Ambassador 3.0");
         //"2015-01-21T23:41:40.000Z"
         
         
        
                 
        //DBCursor cursor = coll3.find(abc);
        //DBCursor.explain(BasicDB);
	//while(cursor.hasNext()) {
	 //System.out.println(cursor.next());
	//}
         
         
         
}

   
    
}

