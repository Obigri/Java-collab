import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginframe {
	private JFrame frame = new JFrame("Login");
	private BorderLayout paneLayout = new BorderLayout();
	private JLabel usernameLabel = new JLabel("Username");
	private JLabel emailLabel = new JLabel("E-Mail");
	private JLabel emailProviderLabel = new JLabel("@gmail.com");
	private JLabel passwordLabel = new JLabel("Password");
	private JTextField usernameTextField = new JTextField();
	private JTextField emailTextField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JPanel lineStartPanel = new JPanel();
	private JPanel lineEndPanel = new JPanel();
	private JPanel emailEntryPanel = new JPanel();
	private JButton loginButton = new JButton("Login");
	
	
	public Loginframe() {
		initializeFrame();
	}

	private void initializeFrame() {
		frame.setLayout(paneLayout);
		frame.setSize(350, 160);
		frame.setLocationRelativeTo(null);
		lineStartPanel.setLayout(new GridLayout(3,1));
		lineEndPanel.setLayout(new GridLayout(3, 1));
		
		emailEntryPanel.setLayout(new BorderLayout());
		emailEntryPanel.add(emailTextField, BorderLayout.LINE_START);
		emailTextField.setPreferredSize(new Dimension(180, 70));
		emailEntryPanel.add(emailProviderLabel, BorderLayout.LINE_END);
		lineStartPanel.add(usernameLabel);
		lineEndPanel.add(usernameTextField);
		lineStartPanel.add(emailLabel);
		emailLabel.setPreferredSize(new Dimension(80,70));
		lineEndPanel.add(emailEntryPanel);
		lineStartPanel.add(passwordLabel);
		lineEndPanel.add(passwordField);
		
		frame.getContentPane().add(lineStartPanel, BorderLayout.LINE_START);
		frame.getContentPane().add(lineEndPanel, BorderLayout.LINE_END);
		frame.getContentPane().add(loginButton, BorderLayout.PAGE_END);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
	}

}
