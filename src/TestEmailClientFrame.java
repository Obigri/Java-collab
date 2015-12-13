import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestEmailClientFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton button = new JButton("Increase");

	public TestEmailClientFrame() {
		this("No title", 800, 600);
	}

	public TestEmailClientFrame(String title, int width, int height) {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		button.addActionListener(a1);
	}

	ActionListener a1 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			increaseSize(10);

		}

	};

	
	public void increaseSize(int addition) {
		frame.setSize(frame.getWidth() + addition, frame.getHeight() + addition);
	}
}
