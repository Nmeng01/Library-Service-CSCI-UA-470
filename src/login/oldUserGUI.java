package login;

import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
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
		JLabel askName; JTextField name;
		askName = new JLabel("Enter your name to login");
		name = new JTextField();
		askName.setBounds(175, 79, 250, 20);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(171, 110, 150, 20);
		
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
				boolean flag = false;
				People person = new User("temp");
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
		
		name.addActionListener(saveName);

		getContentPane().setLayout(null);
		getContentPane().add(askName); getContentPane().add(name);
		
	}

}
