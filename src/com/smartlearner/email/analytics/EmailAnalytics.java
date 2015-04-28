/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.email.analytics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import java.util.Enumeration;
import javax.mail.Header;
/**
 *
 * @author krishnac
 */

public class EmailAnalytics {

    public static void main(String args[]) {

        try {
            
             Mongo mongoClient = new Mongo( "localhost" , 27017 );
             
         
         
             DB db=mongoClient.getDB("header");
         System.out.println("Conn succesful");
         
         //DBCollection coll3 = db.getCollection("temp_col"); has date stored in date format,not as string
         DBCollection coll3 = db.getCollection("head_coll");
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
            
            //HEADERS
            
            /*
            Message[] messages = inbox.getMessages();
      for (int i = 0; i < messages.length; i++) {
        System.out.println((i + 1));
        Enumeration headers = messages[i].getAllHeaders();
        while (headers.hasMoreElements()) {
          Header h = (Header) headers.nextElement();
          
           BasicDBObject document = new BasicDBObject();
           if((!"Subject".equals(h.getName()))&&(!"From".equals(h.getName()))&&(!"Date".equals(h.getName()))&&(!"To".equals(h.getName()))&&(!"Delivered-To".equals(h.getName())))
           {
            System.out.println(h.getName() + ": " + h.getValue());   
            document.put(h.getName(), h.getValue());
           }
            coll3.insert(document);
          System.out.println("=========================================");
        }}
            
            */
            
            
            
             //String[][] data = null;
           
            
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message msg[] = inbox.search(ft);
            System.out.println("MAILS: " + msg.length);
            int countMail = 0;
//            int i=0;
            for (Message message : msg) {
                //if (countMail < 10) {
                    if (!message.getFrom()[0].toString().contains("google.com")) 
                    {
                        countMail++;
                                       
                      //  if(message.getFrom()[0].toString().contains("Internshala"))
                     //{
                        BasicDBObject document = new BasicDBObject();
                        
         Enumeration headers = message.getAllHeaders();
        while (headers.hasMoreElements()) {
          Header h = (Header) headers.nextElement();
          
           
           if((!"Subject".equals(h.getName()))&&(!"From".equals(h.getName()))&&(!"Date".equals(h.getName()))&&(!"To".equals(h.getName()))&&(!"Delivered-To".equals(h.getName())))
           {
            System.out.println(h.getName() + ": " + h.getValue());   
            document.put(h.getName(), h.getValue());
           }
            
          System.out.println("=========================================");
        }               
                        
                        
                        // Date dt=new Date();
                         String dt=message.getSentDate().toString();
                         //System.out.println("HELOO!!!! DATE: " + dt);
                        //print.println(message.getSentDate().toString());
                       
                         //System.out.println("Hello!!! FROM: " +message.getFrom()[0].toString());
                         String frm=message.getFrom()[0].toString();  
                        
                        
    //for (int i = 0; i < data.length; ++i) {}
      //  for (int j = 0; j < data[i].length; ++j){;}
                       
                        //print.println(message.getFrom()[0].toString());
                        String sbj=message.getSubject();
                        //System.out.println("SUBJECT: " + sbj);
                        
            document.put("subject", sbj);
            document.put("from",frm);
            document.put("date",dt);
            coll3.insert(document);
            
                        
         //print.println(message.getSubject());
        /*                System.out.println("CONTENT: " + message.getContent().toString());
                        print.println(message.getContent().toString());
                        System.out.println(message.getContentType());
                        print.println(message.getContentType());
*/
                  /*      
                        Object content = message.getContent();
                        if(content instanceof String)
                        {
                            String str=(String) content;
                            print.println(str);
                        } else if(content instanceof Multipart)
                        {
                            Multipart mp=(Multipart) content;
                            int count = mp.getCount();
                            System.out.println("-----------");
                            for (int x = 0; x < count; x++)
                            {
                                BodyPart bp = mp.getBodyPart(x);
                                System.out.println(bp.getContent().toString());
                             // print.println(bp.getContent().toString());
                            }
                        }
                    */    
                        
                   
       
     
     
             //BasicDBObject newDocument = new BasicDBObject();
             //List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
             //obj.add(new BasicDBObject("subject",sbj));
             //obj.add(new BasicDBObject("from",frm));
             //newDocument.put("$and", obj);
             //newDocument.append("$set", new BasicDBObject().append("date", date));
             //coll.insert(newDocument);
              
	      
                        
                        //DBCursor cursor = coll2.find();
                            //while (cursor.hasNext())
                               //{ 
                               // System.out.println(cursor.next());             
                                     //}
                        
                        /*
                        coll3.ensureIndex(new BasicDBObject("from", 1),new BasicDBObject("date", 1));
                        coll3.ensureIndex(new BasicDBObject("sub", 1),new BasicDBObject("from", 1));
                        coll3.ensureIndex(new BasicDBObject("from", 1));
                                */
                        System.out.println("*******");
                     //}
                    }    
                    

                    //System.out.println(countMail++);
                //}

            }
        } catch (MessagingException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
