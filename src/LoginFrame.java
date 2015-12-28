import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Session;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.sun.glass.events.KeyEvent;

public class LoginFrame {
	private JFrame frame = new JFrame("Login");
	private BorderLayout paneLayout = new BorderLayout();
	private JLabel usernameLabel = new JLabel("Username");
	private JLabel emailLabel = new JLabel("E-Mail");
	private JLabel passwordLabel = new JLabel("Password");
	private JTextField usernameTextField = new JTextField();
	private JTextField emailTextField = new JTextField("gmail.com/googlemail.com");
	private JPasswordField passwordTextField = new JPasswordField();
	private JPanel lineStartPanel = new JPanel();
	private JPanel lineEndPanel = new JPanel();
	private JButton loginButton = new JButton("Login");
	private Properties props;

	public LoginFrame() {
		initializeFrame();
	}

	public LoginFrame(Session session) {
		this();
		this.props = session.getProperties();
		props.put("email", emailTextField.getText());
	}

	private void initializeFrame() {
		frame.setLayout(paneLayout);
		frame.setSize(350, 160);
		frame.setLocationRelativeTo(null);
		lineStartPanel.setLayout(new GridLayout(3, 1));
		lineEndPanel.setLayout(new GridLayout(3, 1));

		lineStartPanel.add(usernameLabel);
		lineEndPanel.add(usernameTextField);
		lineStartPanel.add(emailLabel);
		emailLabel.setPreferredSize(new Dimension(80, 70));
		lineEndPanel.add(emailTextField);
		emailTextField.setPreferredSize(new Dimension(260, 70));
		lineStartPanel.add(passwordLabel);
		lineEndPanel.add(passwordTextField);
		loginButton.setMnemonic(KeyEvent.VK_L);

		emailTextField.getDocument().addDocumentListener(emailListener);
		passwordTextField.getDocument().addDocumentListener(passwordListener);

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
				System.out.println(passwordTextField.getPassword());
			}
		});

	}

	private DocumentListener emailListener = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent e) {
			props.put("email", emailTextField.getText());
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			props.put("email", emailTextField.getText());
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			props.put("email", emailTextField.getText());
		}
	};

	private DocumentListener passwordListener = new DocumentListener() {

		@Override
		public void insertUpdate(DocumentEvent e) {
			props.put("password", new String(passwordTextField.getPassword()));
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			props.put("password", new String(passwordTextField.getPassword()));
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			props.put("password", new String(passwordTextField.getPassword()));
		}

	};

}
