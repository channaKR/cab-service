package com.go.cheeta.service;
<<<<<<< HEAD
import java.util.Properties;
import java.util.Random;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
=======
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Message;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.codec.binary.Base64;



>>>>>>> 915bacf5a6702528a9fb9bbe7ea4cfa5be77a23e
public class EmailService {

	


<<<<<<< HEAD
=======
	  public static Message sendEmail(String fromEmailAddress,
	                                  String toEmailAddress)
	      throws MessagingException, IOException {
		  final String CREDENTIALS_FILE_PATH = "T:/credential.json";
		    InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);
		  /* Load pre-authorized user credentials from the environment.
	           TODO(developer) - See https://developers.google.com/identity for
	            guides on implementing OAuth2 for your application.*/
	    GoogleCredentials Credentials = GoogleCredentials.getApplicationDefault()
	    		
	        .createScoped(GmailScopes.GMAIL_SEND);
	    HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(Credentials);
	
	    // Create the gmail API client
	    Gmail service = new Gmail.Builder(new NetHttpTransport(),
	        GsonFactory.getDefaultInstance(),
	        requestInitializer)
	        .setApplicationName("gocheeta web")
	        .build();

	    // Create the email content
	    String messageSubject = "Test message";
	    String bodyText = "lorem ipsum.";

	    // Encode as MIME message
	    Properties props = new Properties();
	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage email = new MimeMessage(session);
	    email.setFrom(new InternetAddress(fromEmailAddress));
	    email.addRecipient(javax.mail.Message.RecipientType.TO,
	        new InternetAddress(toEmailAddress));
	    email.setSubject(messageSubject);
	    email.setText(bodyText);

	    // Encode and wrap the MIME message into a gmail message
	    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	    email.writeTo(buffer);
	    byte[] rawMessageBytes = buffer.toByteArray();
	    String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
	    Message message = new Message();
	    message.setRaw(encodedEmail);

	    try {
	      // Create send message
	      message = service.users().messages().send("me", message).execute();
	      System.out.println("Message id: " + message.getId());
	      System.out.println(message.toPrettyString());
	      return message;
	    } catch (GoogleJsonResponseException e) {
	      // TODO(developer) - handle error appropriately
	      GoogleJsonError error = e.getDetails();
	      if (error.getCode() == 403) {
	        System.err.println("Unable to send message: " + e.getDetails());
	      } else {
	        throw e;
	      }
	    }
	    return null;
	  }

>>>>>>> 915bacf5a6702528a9fb9bbe7ea4cfa5be77a23e
	
	
	
}
