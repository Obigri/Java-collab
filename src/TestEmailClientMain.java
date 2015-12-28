import java.util.Properties;

import javax.mail.Session;

public class TestEmailClientMain {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props);
		LoginFrame loginframe = new LoginFrame(session);
		TestEmailClientFrame frame = new TestEmailClientFrame(session);

	}

}
