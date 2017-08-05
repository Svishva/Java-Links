/**
 * 
 */
package com.example.sendmail;

/**
 * @author system18
 *
 */

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailExample2 {

	public static void main(String[] args) {
		
		
		sendEmail("from@gmail.com", "xxx","to@outlook.com");

	
	}

	public static void sendEmail(String from,String pwd, String to ) {

		

	
		
		final String user = from;
		final String password = pwd;
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("YaHOOOOOOoo");
			message.setText("Sending  email using JavaMail API Part 2"+ new Date());

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		}

		catch (com.sun.mail.smtp.SMTPSendFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
