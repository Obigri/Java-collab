import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.sun.glass.events.KeyEvent;

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
	private Profile userProfile;

	public Loginframe() {
		initializeFrame();
	}

	private void initializeFrame() {
		frame.setLayout(paneLayout);
		frame.setSize(350, 160);
		frame.setLocationRelativeTo(null);
		lineStartPanel.setLayout(new GridLayout(3, 1));
		lineEndPanel.setLayout(new GridLayout(3, 1));

		emailEntryPanel.setLayout(new BorderLayout());
		emailEntryPanel.add(emailTextField, BorderLayout.LINE_START);
		emailTextField.setPreferredSize(new Dimension(180, 70));
		emailEntryPanel.add(emailProviderLabel, BorderLayout.LINE_END);
		lineStartPanel.add(usernameLabel);
		lineEndPanel.add(usernameTextField);
		lineStartPanel.add(emailLabel);
		emailLabel.setPreferredSize(new Dimension(80, 70));
		lineEndPanel.add(emailEntryPanel);
		lineStartPanel.add(passwordLabel);
		lineEndPanel.add(passwordField);
		loginButton.setMnemonic(KeyEvent.VK_L);

		usernameTextField.getDocument().addDocumentListener(usernameListener);

		frame.getContentPane().add(lineStartPanel, BorderLayout.LINE_START);
		frame.getContentPane().add(lineEndPanel, BorderLayout.LINE_END);
		frame.getContentPane().add(loginButton, BorderLayout.PAGE_END);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(passwordField.getPassword());
			}
		});

	}

	private DocumentListener usernameListener = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent e) {
			userProfile.changeSavedUsername(usernameTextField.getText());
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			userProfile.changeSavedUsername(usernameTextField.getText());
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			userProfile.changeSavedUsername(usernameTextField.getText());
		}
	};

}
