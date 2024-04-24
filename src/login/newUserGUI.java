package login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.User;

import javax.swing.*;
import userGUIs.*;

public class newUserGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newUserGUI frame = new newUserGUI();
					frame.setVisible(true);
					frame.setSize(500,500); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newUserGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JLabel askName; JTextField name;
		askName = new JLabel("Enter your name to make an account:");
		name = new JTextField();
		askName.setBounds(137, 76, 250, 20);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(159, 108, 150, 20);
		
		ActionListener saveName = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = name.getText();
				//User user = new User(username);
				/*
				 * save this to a textfile
				*/
				userGUI userGui = new userGUI();
				userGui.setVisible(true);
			}
		};
		
		name.addActionListener(saveName);

		getContentPane().setLayout(null);
		getContentPane().add(askName); getContentPane().add(name);
		
	}

}
