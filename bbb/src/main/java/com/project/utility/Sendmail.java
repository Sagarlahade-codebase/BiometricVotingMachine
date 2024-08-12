package com.project.utility;
import javax.mail.*;
import javax.mail.internet.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.mail.Message.RecipientType;



/**

 * @author Prashant
 */
public class Sendmail {

	/**
	 * Send mail with specified params
	 * @param from who this is from
	 * @param to who this is for
	 * @param subject subject of the mail
	 * @param text body of the mail
	 */
	private static void send(final Properties props,String mailId,String subject){
		
    	String from = props.getProperty("testmail.from");
    	/*final String from = "prashant.pa1992@gmail.com";
    	final String password="11101992amit";
    	*/
    	System.out.println("from"+from);
    	
		//String to = props.getProperty("testmail.to");
		String to =mailId;
		
		System.out.println("to "+to);
		
		//System.out.println("password is=="+ub);
		
		String data="";
		
		//String subject = props.getProperty("testmail.subject");
		//subject = "Regarding Forget Password";
		
		
		String body = props.getProperty("testmail.body");
		
		Session mailSession = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("mail.user"), props.getProperty("mail.password"));
				
				//return new PasswordAuthentication(props.getProperty(from), props.getProperty(password));
			}
		});
		Message simpleMessage = new MimeMessage(mailSession);
		
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress(from);
			toAddress = new InternetAddress(to);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		
		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject(subject);
			simpleMessage.setText(data);
						
			Transport.send(simpleMessage);	
			
			
			
			
		} catch (MessagingException e) {
			System.err.println("Error sending mail");
			e.printStackTrace();
		}		
	}
	
	
	private static void send(final Properties props,String mailId,String msg,String subject){
		
    	String from = props.getProperty("testmail.from");
    	/*final String from = "prashant.pa1992@gmail.com";
    	final String password="11101992amit";
    	*/
    	System.out.println("from"+from);
    	
		//String to = props.getProperty("testmail.to");
		String to =mailId;
		
		System.out.println("to "+to);
		
		System.out.println("password is=="+msg);
		
		//String data="Welcome to XYZ bank. Your Account No. and password is "+ub.getAccNo()+" "+ub.getPassword()+". And your ATM no is "+ub.getAtmNo()+" having pin "+ub.getAtmPin();
		
		//String subject = props.getProperty("testmail.subject");
		//subject = "Regarding Forget Password";
		
		
		String body = props.getProperty("testmail.body");
		
		Session mailSession = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("mail.user"), props.getProperty("mail.password"));
				
				//return new PasswordAuthentication(props.getProperty(from), props.getProperty(password));
			}
		});
		Message simpleMessage = new MimeMessage(mailSession);
		
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress(from);
			toAddress = new InternetAddress(to);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		
		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject(subject);
			simpleMessage.setText(msg);
						
			Transport.send(simpleMessage);	
			
			
			
			
		} catch (MessagingException e) {
			System.err.println("Error sending mail");
			e.printStackTrace();
		}		
	}
	
	public static void SendOTPEmail(String mailId,String msg,String subject) {
		final Properties props = new Properties();
		
		Properties prop = new Properties();
		InputStream in = Sendmail.class.getClassLoader().getResourceAsStream("com/project/utility/sample_mail.properties");
		
		try {
			//props.load(new FileInputStream("H:\\LCUBE WORK\\Project Related Softwares\\mail jars\\sample_mail.properties"));
			props.load(in);
		} catch (FileNotFoundException e1) {
			System.err.println("Properties file not found");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.err.println("Error loading properties file");
			e1.printStackTrace();
		}
		
		Sendmail.send(props,mailId,msg,subject);		
	}
	
	public static void mainSendEmail(String mailId,ArrayList<String> al,String subject) {
		final Properties props = new Properties();
		
		Properties prop = new Properties();
		InputStream in = Sendmail.class.getClassLoader().getResourceAsStream("mail.config.properties");
		
		try {
		//	props.load(new FileInputStream("H:\\LCUBE WORK\\Project Related Softwares\\mail jars\\sample_mail.properties"));
			props.load(in);
		} catch (FileNotFoundException e1) {
			System.err.println("Properties file not found");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.err.println("Error loading properties file");
			e1.printStackTrace();
		}
		
		Sendmail.send(props,mailId,subject);		
	}
}