package login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class newUserGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		ActionListener saveName = new ActionListener() {
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
		
		name.addActionListener(saveName);
		backBtn.addActionListener(backBtnAction);
		getContentPane().setLayout(null);
		getContentPane().add(askName); getContentPane().add(name);getContentPane().add(backBtn);
		
	}

}
