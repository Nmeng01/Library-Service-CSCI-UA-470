package userGUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class userGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userGUI frame = new userGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public userGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JButton borrowBtn, returnBtn, allItemsBtn;
		JLabel question;
		question = new JLabel("How can we help you?");
		question.setBounds(185, 82, 150, 20);
		borrowBtn = new JButton("Borrow Item");
		returnBtn = new JButton("Return Item");
		allItemsBtn = new JButton("View All My Items");
		borrowBtn.setBounds(169, 177, 150, 20);
		returnBtn.setBounds(169, 144, 150, 20);
		allItemsBtn.setBounds(169, 113, 150, 20);
		getContentPane().setLayout(null);
		getContentPane().add(borrowBtn, BorderLayout.SOUTH); getContentPane().add(returnBtn); getContentPane().add(allItemsBtn, BorderLayout.WEST);
		getContentPane().add(question, BorderLayout.NORTH);
	}

}
