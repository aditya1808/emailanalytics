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
import java.util.List;
/**
 *
 * @author kriti
 */
public class test {
public static void main(String args[]) throws UnknownHostException {

    
    
      Mongo mongoClient = new Mongo( "localhost" , 27017 );
             
         
         DB db = mongoClient.getDB( "email3" );
         System.out.println("Conn succesful");
         
         DBCollection coll3 = db.getCollection("email3");
         System.out.println("Collection created successfully ...");
         
         
        
        //  DBCursor cursor = coll3.find();
        
       //  while (cursor.hasNext())
        //{ 
          
         //System.out.println(cursor.next()); 
           
        //}
         coll3.ensureIndex(new BasicDBObject("from", 1),new BasicDBObject("date", 1));
         List <DBObject> list = coll3.getIndexInfo();

  for (DBObject o : list) {
       System.out.println(o);
    }
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
