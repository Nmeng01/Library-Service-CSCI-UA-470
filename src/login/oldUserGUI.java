package login;

import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;

import assistant.assistantGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import classes.*;
import userGUIs.userGUI;
import javax.swing.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class oldUserGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public oldUserGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JLabel askName, askType; JTextField name; JButton loginUser, loginAssistant;
		askName = new JLabel("Enter your name to login");
		name = new JTextField();
		askName.setBounds(175, 79, 250, 20);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(171, 110, 150, 20);
		
		askType = new JLabel("Would you like to login as an assistant or a user?");
		loginUser = new JButton("User");
		loginAssistant = new JButton("Assistant");
		askType.setBounds(89, 42, 353, 20);
		loginUser.setBounds(292, 84, 150, 20);
		loginAssistant.setBounds(89, 84, 150, 20);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(0, 0, 89, 23);

		ActionListener backBtnAction = (new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		signInGUI signIn = new signInGUI();
		 		signIn.setSize(500,500);
				signIn.setVisible(true);
				setVisible(false);
				dispose();
		 	}
		 });
		
		
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
				boolean flag = false;
				People person = new User("temp"); //changed to username from temp
				for(People p : people) {
					if(p.getName().equalsIgnoreCase(username)) {
						people.remove(p);
						flag = true;
						person = p;
						break;
					}
				}
				if(flag) {
					userGUI userGui = new userGUI((User)person, people);
					userGui.setVisible(true);
					setVisible(false);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Username not found. Please try again or create a new account.");
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
				boolean flag = false;
				People person = new User("temp"); //changed to assistant name from temp
				for(People p : people) {
					if(p.getName().equalsIgnoreCase(assistantName)) {
						people.remove(p);
						flag = true;
						person = p;
						break;
					}
				}
				if(flag) {
					assistantGUI assistantGui = new assistantGUI();
					assistantGui.setVisible(true);
					setVisible(false);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Assistant not found. Please try again or create a new account.");
				}
			}
		};
		
		ActionListener typeUser =  (new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		name.addActionListener(saveUser);
		 		getContentPane().remove(askType);  getContentPane().remove(loginUser);  getContentPane().remove(loginAssistant);
		 		getContentPane().add(askName); getContentPane().add(name);
		 		revalidate();
		 		repaint();
		 	}
		 });
		
		ActionListener typeAssistant =  (new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		name.addActionListener(saveAssistant);
		 		getContentPane().remove(askType);  getContentPane().remove(loginUser);  getContentPane().remove(loginAssistant);
		 		getContentPane().add(askName); getContentPane().add(name);
		 		revalidate();
		 		repaint();
		 	}
		 });
		
		loginUser.addActionListener(typeUser);
		loginAssistant.addActionListener(typeAssistant);
		backBtn.addActionListener(backBtnAction);
		getContentPane().setLayout(null);
		getContentPane().add(backBtn); getContentPane().add(askType);  getContentPane().add(loginUser);  getContentPane().add(loginAssistant);
		
	}

}
