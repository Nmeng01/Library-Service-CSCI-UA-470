package userGUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import login.*;
import classes.*;


public class userGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user;
	private ArrayList<People> people;

	/**
	 * Create the frame.
	 */
	public userGUI(User u, ArrayList<People> p) {
		
		
		this.user = u;
		this.people = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JButton borrowBtn, returnBtn, allItemsBtn, signOutBtn;
		JLabel question;
		question = new JLabel("How can we help you?");
		question.setBounds(185, 82, 150, 20);
		borrowBtn = new JButton("Borrow Item");
		returnBtn = new JButton("Return Item");
		allItemsBtn = new JButton("View All My Items");
		signOutBtn = new JButton("Sign out");
		
		allItemsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Inventory inventory = readInventory();
            	ArrayList<LibraryItem> items = inventory.displayAll();
            	for(LibraryItem item: items) {
            		// System.out.println(item);
            	}
            }
        });

		borrowBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable availableInventory;
				Inventory inventory = readInventory();
            	ArrayList<LibraryItem> items = inventory.displayAll();
            	
            	List<String[]> tableData = new ArrayList<>();
				for(LibraryItem item: items) {
					String[] rowData = {item.getName(), item.getGenre()};
				    tableData.add(rowData);
            	}
				String[][] tableData2 = new String[tableData.size()][];
				tableData.toArray(tableData2);
				String[] columnNames = { "Name", "Genre" };
				availableInventory = new JTable(tableData2, columnNames);
				
				
//				availableInventory.getSelectionModel().addListSelectionListener(){
//						public void actionPerformed(ActionEvent e) {
//							System.out.println()
//						}
//				};
				
				
				availableInventory.setDefaultEditor(Object.class, null);  //to make sure users can't edit the table values
				availableInventory.setBounds(0,0,500,500);
				getContentPane().remove(borrowBtn); getContentPane().remove(returnBtn); getContentPane().remove(allItemsBtn); getContentPane().remove(signOutBtn); getContentPane().remove(question);
				getContentPane().add(availableInventory);
				revalidate();
		 		repaint();
				//show the entire available inventory
				//set the item as borrowed
				//add it to the uers own borrowed list
			}
		});
		//sources: https://www.digitalocean.com/community/tutorials/java-list-add-addall-methods
		//source: https://www.geeksforgeeks.org/java-swing-jtable/

		// returnBtn.addActionListener( new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
				//should only show the stuff thats in their borrowed list
		// 	}
		// });
		
		signOutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	userGUI.this.people.add(userGUI.this.user);
            	try {
                    FileOutputStream f = new FileOutputStream("ppl.bin");
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(userGUI.this.people);
                    o.close();
                  } catch (FileNotFoundException n) {
                    System.out.println("Error: File not found");
                  } catch (IOException i) {
                    System.out.println("Error writing to file:" + i.getMessage());
                    i.printStackTrace();
                  }
            	try {
					signInGUI frame = new signInGUI();
					frame.setVisible(true);
					frame.setSize(500,500); 
				} catch (Exception a) {
					a.printStackTrace();
				}
                setVisible(false);
                dispose();
            }
        });
		
		question.setBounds(169, 81, 150, 20);
		borrowBtn.setBounds(169, 113, 150, 20);
		returnBtn.setBounds(169, 145, 150, 20);
		allItemsBtn.setBounds(169, 177, 150, 20);
		signOutBtn.setBounds(169, 209, 150, 20);
		getContentPane().setLayout(null);
		getContentPane().add(borrowBtn); getContentPane().add(returnBtn); 
		getContentPane().add(allItemsBtn); getContentPane().add(signOutBtn);
		getContentPane().add(question);
	}
	
	public Inventory readInventory() {
		 Inventory i = null;
		 try {
		      FileInputStream f = new FileInputStream("data.bin");
		      ObjectInputStream o = new ObjectInputStream(f);
		      i = (Inventory) o.readObject();
		      o.close();
		    } catch (IOException n) {
		        System.out.println("error");
		    } catch (ClassNotFoundException n) {
		    	System.out.println("error_2");
		    }
	   return i;
	}

}
