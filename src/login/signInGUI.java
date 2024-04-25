package login;
import assistant.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import javax.swing.JFrame;
// import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
// import javax.swing.JLabel;
// import javax.swing.JButton;
// import javax.swing.AbstractButton;
import javax.swing.*;


public class signInGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public signInGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel welcome, question;
		JButton userBtn, assistantBtn;
		welcome = new JLabel("Welcome to the Library");
		question = new JLabel("Are you a user or an assistant?");
		userBtn = new JButton("User");
		assistantBtn = new JButton("Assistant");
		
		welcome.setBounds(176, 29, 150, 20);
		question.setBounds(165, 60, 350, 20);
		userBtn.setBounds(84, 108, 150, 20);
		assistantBtn.setBounds(260, 108, 150, 20);

		ActionListener newUser = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newUserGUI newUser = new newUserGUI();
				newUser.setVisible(true);
				setVisible(false);
				dispose();
			}
		};

		ActionListener returningUser = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldUserGUI returningUser = new oldUserGUI();
				returningUser.setVisible(true);
				setVisible(false);
				dispose();
			}
		};
		
		
		ActionListener assistantUser = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assistantGUI assistantGui = new assistantGUI();
				assistantGui.setVisible(true);
				setVisible(false);
				dispose();
			}
		};

		ActionListener user = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton newUserBtn, returningUserBtn;
				remove(welcome); remove(question); remove(userBtn); remove(assistantBtn);
				newUserBtn = new JButton("New User");
				returningUserBtn = new JButton("Returning User");
				newUserBtn.addActionListener(newUser);
				returningUserBtn.addActionListener(returningUser);
				newUserBtn.setBounds(84, 108, 150, 20);
				returningUserBtn.setBounds(260, 108, 150, 20);
				getContentPane().add(newUserBtn); getContentPane().add(returningUserBtn);
				revalidate();
				repaint();
			}
		};

		userBtn.addActionListener(user);
		assistantBtn.addActionListener(assistantUser);
		getContentPane().setLayout(null);
		getContentPane().add(welcome); getContentPane().add(question); getContentPane().add(userBtn); getContentPane().add(assistantBtn);
		


	}

}


/*
 * sources
 * https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/button.html
 * Lecture 03/27
 */