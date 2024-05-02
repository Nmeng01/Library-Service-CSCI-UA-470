package login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assistant.assistantGUI;
import classes.*;
import javax.swing.*;
import userGUIs.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import classes.Assistant;

public class newUserGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public newUserGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JLabel askName, askType; JTextField name; JButton registerNewUser, registerNewAssistant;
		askType = new JLabel("Would you like to register as an assistant or a user?");
		registerNewUser = new JButton("User");
		registerNewAssistant = new JButton("Assistant");
		askType.setBounds(89, 42, 353, 20);
		registerNewUser.setBounds(292, 84, 150, 20);
		registerNewAssistant.setBounds(89, 84, 150, 20);
		
		
		
		askName = new JLabel("Enter your name to make an account:");
		name = new JTextField();
		askName.setBounds(137, 76, 250, 20);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(159, 108, 150, 20);
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(0, 0, 89, 23);

		ActionListener saveUser = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<People> people;
			    try {
			      FileInputStream f = new FileInputStream("ppl.bin");
			      ObjectInputStream o = new ObjectInputStream(f);
			      people = (ArrayList<People>) o.readObject();
			      o.close();
			    } catch (IOException n) {
			        people = new ArrayList<People>();
			    } catch (ClassNotFoundException n) {
			        people = new ArrayList<People>();
			    }
				String username = name.getText();
				boolean flag = true;
				for(People p : people) {
					if(p.getName().equalsIgnoreCase(username)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					User user = new User(username);
					userGUI userGui = new userGUI(user, people);
					userGui.setVisible(true);
					setVisible(false);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Username is already taken. Please choose a different username.");
				}
			}
		};
		
		ActionListener saveAssistant = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<People> people;
			    try {
			      FileInputStream f = new FileInputStream("ppl.bin");
			      ObjectInputStream o = new ObjectInputStream(f);
			      people = (ArrayList<People>) o.readObject();
			      o.close();
			    } catch (IOException n) {
			        people = new ArrayList<People>();
			    } catch (ClassNotFoundException n) {
			        people = new ArrayList<People>();
			    }
				String assistantName = name.getText();
				boolean flag = true;
				for(People p : people) {
					if(p.getName().equalsIgnoreCase(assistantName)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					Assistant assistant = new Assistant(assistantName);
					assistantGUI assistantGui = new assistantGUI();
					assistantGui.setVisible(true);
					setVisible(false);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Assistant name is already taken. Please choose a different one.");
				}
			}
		};
		
		ActionListener typeUser =  (new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		name.addActionListener(saveUser);
		 		getContentPane().remove(askType);  getContentPane().remove(registerNewUser);  getContentPane().remove(registerNewAssistant);
		 		getContentPane().add(askName); getContentPane().add(name);
		 		revalidate();
		 		repaint();
		 	}
		 });
		
		ActionListener typeAssistant =  (new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		name.addActionListener(saveAssistant);
		 		getContentPane().remove(askType);  getContentPane().remove(registerNewUser);  getContentPane().remove(registerNewAssistant);
		 		getContentPane().add(askName); getContentPane().add(name);
		 		revalidate();
		 		repaint();
		 	}
		 });
				
		ActionListener backBtnAction = (new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		signInGUI signIn = new signInGUI();
		 		signIn.setSize(500,500);
				signIn.setVisible(true);
				setVisible(false);
				dispose();
		 	}
		 });
		
		
		registerNewUser.addActionListener(typeUser);
		registerNewAssistant.addActionListener(typeAssistant);
		backBtn.addActionListener(backBtnAction);
		getContentPane().setLayout(null);
		getContentPane().add(backBtn); getContentPane().add(askType);  getContentPane().add(registerNewUser);  getContentPane().add(registerNewAssistant);
		
	}

}
