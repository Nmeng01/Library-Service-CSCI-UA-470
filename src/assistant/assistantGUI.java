package assistant;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import classes.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import login.*;

public class assistantGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public assistantGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		// get inventory
		final Inventory inventory;
		Inventory temp = new Inventory();
	    try {
	      FileInputStream f = new FileInputStream("data.bin");
	      ObjectInputStream o = new ObjectInputStream(f);
	      temp = (Inventory) o.readObject();
	      o.close();
	    } catch (IOException n) {
	        temp = new Inventory();
	    } catch (ClassNotFoundException n) {
	        temp = new Inventory();
	    }
	    inventory = temp;
		// Layout
		JButton addBtn, removeBtn, viewRequestsBtn, signOutBtn;
		JLabel question;
		question = new JLabel("What would you like to do?");
		question.setBounds(160, 82, 175, 20);
		addBtn = new JButton("Add Item");
		removeBtn = new JButton("Remove Item");
		viewRequestsBtn = new JButton("View Requested Items");
		signOutBtn = new JButton("Sign out");
		addBtn.setBounds(166, 110, 150, 20);
		removeBtn.setBounds(166, 141, 150, 20);
		viewRequestsBtn.setBounds(166, 172, 150, 20);
		signOutBtn.setBounds(166, 203, 150, 20);
		
		ActionListener add = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemGUI addItem = new addItemGUI(inventory, assistantGUI.this);
				addItem.setVisible(true);
				setVisible(false);
			}
		};
		addBtn.addActionListener(add);
		
		ActionListener delete = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItemGUI deleteItem = new deleteItemGUI(inventory, assistantGUI.this);
				deleteItem.setVisible(true);
				setVisible(false);
			}
		};
		
		removeBtn.addActionListener(delete);
		
		ActionListener openRequestList = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestListGUI reqGUI = new requestListGUI(inventory, assistantGUI.this);
				reqGUI.setVisible(true);
				setVisible(false);
			}
		};
		viewRequestsBtn.addActionListener(openRequestList);
		
		ActionListener signOut = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    FileOutputStream f = new FileOutputStream("data.bin");
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(inventory);
                    o.close();
                  } catch (FileNotFoundException n) {
                    System.out.println("Error: File not found");
                  } catch (IOException i) {
                    System.out.println("Error writing to file:" + i.getMessage());
                    i.printStackTrace();
                  }
				signInGUI sGUI = new signInGUI();
				sGUI.setVisible(true);
				sGUI.setSize(500,500);
				setVisible(false);
				dispose();
			}
		};
		signOutBtn.addActionListener(signOut);
		
		getContentPane().setLayout(null);
		getContentPane().add(question); getContentPane().add(addBtn); getContentPane().add(removeBtn); getContentPane().add(viewRequestsBtn); getContentPane().add(signOutBtn);
	}

}
