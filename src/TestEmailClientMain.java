
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class TestEmailClientMain {

	public static void main(String[] args) {
		String receiver = "muss bei aktuellem stand eine gmail/googlemail adresse sein";
		
		//Daten für den Account den ich zum testen erstellt habe
		String sender = "gariath246@gmail.com";
		final String username = "gariath246";
		final String password = "TestTest";
		
		String host = "aspmx.l.google.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username,password);
			}
		});
		
		try{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
			message.setSubject("Hello Housekeeping");
			message.setText("Neuer Test mit start tls auskommentiert");
			Transport.send(message);
			
			System.out.println("Sent message successfully...");
			
			
		}catch (MessagingException e){
			throw new RuntimeException(e);
		}
		
		
		
		
	}
}
