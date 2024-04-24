package login;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import classes.User;
import userGUIs.userGUI;

import javax.swing.*;
import java.awt.BorderLayout;

public class oldUserGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					oldUserGUI frame = new oldUserGUI();
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
	public oldUserGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JLabel askName; JTextField name;
		askName = new JLabel("Enter your name to login");
		name = new JTextField();
		askName.setBounds(175, 79, 250, 20);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(171, 110, 150, 20);
		
		ActionListener saveName = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = name.getText();
				/*
				 *compare this against text file to verify
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
