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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author krishnac
 */

public class EmailAnalytics {

    public static void main(String args[]) {

        try {
            
             Mongo mongoClient = new Mongo( "localhost" , 27017 );
             
         
         //DB db = mongoClient.getDB( "email" );
             DB db=mongoClient.getDB("email3");
         System.out.println("Conn succesful");
         
         DBCollection coll3 = db.getCollection("email3");
         System.out.println("Collection created successfully");

            FileOutputStream out=new FileOutputStream("EmailText.txt");
            PrintStream print=new PrintStream(out);

            Properties props = new Properties(System.getProperties());
            props.setProperty("mail.store.protocol", "imaps");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            //store.connect("imap.gmail.com", "techkrishacadquery@gmail.com", "Phoenix81#");
            store.connect("imap.gmail.com", "adityaravi65@gmail.com", "m@vr1ck2009");
            System.out.println(store);
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message msg[] = inbox.search(ft);
            System.out.println("MAILS: " + msg.length);
            int countMail = 0;
            for (Message message : msg) {
                //if (countMail < 10) {
                    if (!message.getFrom()[0].toString().contains("google.com")) 
                    {
                        countMail++;
                                       
                        if(message.getFrom()[0].toString().contains("Internshala"))
                     {
                        //String date=message.getSentDate().toString();
                         Date dt=new Date();
                         dt=message.getSentDate();
                         System.out.println("HELOO!!!! DATE: " + dt);
                        
                         //print.println(message.getSentDate().toString());
                       
                         System.out.println("Hello!!! FROM: " +message.getFrom()[0].toString());
                         String frm=message.getFrom()[0].toString();  
                        
                       
                        //print.println(message.getFrom()[0].toString());
                         String sbj=message.getSubject();
                        System.out.println("SUBJECT: " + sbj);
                        
                        
        BasicDBObject document = new BasicDBObject();
            document.put("subject", sbj);
            document.put("from",frm);
            document.put("date",dt);
            coll3.insert(document);
            
             //BasicDBObject newDocument = new BasicDBObject();
             //List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
             //obj.add(new BasicDBObject("subject",sbj));
             //obj.add(new BasicDBObject("from",frm));
             //newDocument.put("$and", obj);
             //newDocument.append("$set", new BasicDBObject().append("date", date));
             //coll.insert(newDocument);
              
	      
                        
                        //print.println(message.getSubject());
                        System.out.println("CONTENT: " + message.getContent().toString());
                        //print.println(message.getContent().toString());
                        System.out.println(message.getContentType());
                        //print.println(message.getContentType());

                        //Object content = message.getContent();
                        //if(content instanceof String)
                        //{
                        //    String str=(String) content;
                         //   print.println(str);
                        //} else if(content instanceof Multipart)
                        //{
                          //  Multipart mp=(Multipart) content;
                            //int count = mp.getCount();
                            //System.out.println("-----------");
                            //for (int i = 0; i < count; i++)
                            //{
                             //   BodyPart bp = mp.getBodyPart(i);
                                //System.out.println(bp.getContent().toString());
                            //    print.println(bp.getContent().toString());
                            //}
                        //}
                        
                        //DBCursor cursor = coll2.find();
        
         //while (cursor.hasNext())
         //{ 
          
           // System.out.println(cursor.next()); 
            
         //}
                        
                        System.out.println("*******");
                     }
                    }    
                    
                    //System.out.println(countMail++);
                //}

            }
        } catch (MessagingException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
