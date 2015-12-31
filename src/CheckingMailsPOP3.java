import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class CheckingMailsPOP3 {

	public static void check(String host, String storeType, String user, String password) {

		try {
			Properties properties = new Properties();

			properties.put("mail.pop3.starttls.enable", "true");
			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			Session emailSession = Session.getDefaultInstance(properties);

			Store store = emailSession.getStore("pop3s");

			store.connect(host, user, password);

			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				System.out.println("--------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
			}

			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String host = "pop.gmail.com";
		String mailStoreType = "pop3";
		String username = "gmail";
		String password = "password";

		check(host, mailStoreType, username, password);

	}
}
