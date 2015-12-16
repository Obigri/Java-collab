import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestEmailClientFrame {

	private JFrame frame;
	private JPanel topBorderElements = new JPanel();
	private JButton newMailButton = new JButton("New E-Mail");
	private JButton logOutButton = new JButton("Log out");
	private JButton answerMailButton = new JButton("Re");
	private JLabel ownEmailAddress = new JLabel("Grab E-mail address and put it here");

	public TestEmailClientFrame() {
		this("No title", 800, 600);
	}

	public TestEmailClientFrame(String title, int width, int height) {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showDefault();
		
	}

	private void showDefault() {
		frame.setLayout(new BorderLayout());
		topBorderElements.setLayout(new BoxLayout(topBorderElements,BoxLayout.X_AXIS));
		topBorderElements.add(newMailButton);
		topBorderElements.add(Box.createRigidArea(new Dimension(10,0)));
		topBorderElements.add(answerMailButton);
		topBorderElements.add(Box.createHorizontalGlue());
		topBorderElements.add(logOutButton);
		topBorderElements.add(Box.createRigidArea(new Dimension(10,0)));
		topBorderElements.add(ownEmailAddress);
		frame.getContentPane().add(topBorderElements, BorderLayout.PAGE_START);
		

	}

}
