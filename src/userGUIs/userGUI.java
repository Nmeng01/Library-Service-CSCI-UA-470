package userGUIs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
		JButton borrowBtn, returnBtn, allItemsBtn, requestItemBtn, signOutBtn;
		JLabel question;
		question = new JLabel("How can we help you?");
		question.setBounds(185, 82, 150, 20);
		borrowBtn = new JButton("Borrow Item");
		returnBtn = new JButton("Return Item");
		allItemsBtn = new JButton("View All My Items");
		requestItemBtn = new JButton("Request an Item To Be Added");
		signOutBtn = new JButton("Sign out");
		
		allItemsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//only the users checked out items
            	JTable availableInventory;
            	ArrayList<LibraryItem> items = u.viewItems();
            	List<String[]> tableData = new ArrayList<>();
				for(LibraryItem item: items) {
					String[] rowData = {item.getName(), item.getGenre()};	
					tableData.add(rowData);
				}
				String[][] tableData2 = new String[tableData.size()][];
				tableData.toArray(tableData2);
				String[] columnNames = { "Name", "Genre" };
				availableInventory = new JTable(tableData2, columnNames);
				availableInventory.setDefaultEditor(Object.class, null);  //to make sure users can't edit the table values bc or else they can double click and modify it :(
				availableInventory.setBounds(0,23,500,500);
				JButton backBtn = new JButton("Back");
				backBtn.setBounds(0, 0, 89, 23);
				 ActionListener backBtnAction = (new ActionListener() {
				 	 public void actionPerformed(ActionEvent e) {
				 		getContentPane().add(borrowBtn); getContentPane().add(returnBtn); getContentPane().add(allItemsBtn); getContentPane().add(signOutBtn); getContentPane().add(question);
						getContentPane().remove(availableInventory);
						getContentPane().remove(backBtn);
						revalidate();
				 		repaint();
				 	}
				  });
				 
				 backBtn.addActionListener(backBtnAction);
				 
				getContentPane().remove(borrowBtn); getContentPane().remove(returnBtn); getContentPane().remove(allItemsBtn); getContentPane().remove(signOutBtn); getContentPane().remove(question);
				getContentPane().add(availableInventory); getContentPane().add(backBtn);
				revalidate();
		 		repaint();
            }
					
        });

		borrowBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable availableInventory;
				Inventory inventory = readInventory();
            	ArrayList<LibraryItem> items = inventory.displayAll();
            	List<String[]> tableData = new ArrayList<>();
				for(LibraryItem item: items) {
					if(item.isBorrowed() == false) {
						String[] rowData = {item.getName(), item.getGenre()};
					    tableData.add(rowData);
					}
            	}
				String[][] tableData2 = new String[tableData.size()][];
				tableData.toArray(tableData2);
				String[] columnNames = { "Name", "Genre" };
				availableInventory = new JTable(tableData2, columnNames);
				availableInventory.setDefaultEditor(Object.class, null);  //to make sure users can't edit the table values bc or else they can double click and modify it :(
				availableInventory.setBounds(0,23,500,500);
				
				JButton backBtn = new JButton("Back");
				backBtn.setBounds(0, 0, 89, 23);

				 ActionListener backBtnAction = (new ActionListener() {
				 	 public void actionPerformed(ActionEvent e) {
				 		getContentPane().add(borrowBtn); getContentPane().add(returnBtn); getContentPane().add(allItemsBtn); getContentPane().add(signOutBtn); getContentPane().add(question);
						getContentPane().remove(availableInventory);
						getContentPane().remove(backBtn);
						revalidate();
				 		repaint();
				 	}
				  });
				 
				 backBtn.addActionListener(backBtnAction);
				 
				availableInventory.getSelectionModel().addListSelectionListener( new ListSelectionListener () {
					  public void valueChanged(ListSelectionEvent event) {
						  if (!event.getValueIsAdjusting()) {  
						  	int selectedRow = availableInventory.getSelectedRow();
						  	if (selectedRow != -1) {	
								  Object itemName = availableInventory.getValueAt(selectedRow, 0); 
								  for(LibraryItem item: items) {
									  if (item.getName().equals(itemName)) {
						                    item.setBorrowed(true);	
						                    u.borrowItem(item);
						                    Inventory inventoryNew = new Inventory();
						                    inventoryNew.setInventory(items);
						                    writeInventory(inventoryNew); 
						                    break;
									  }
					            	}
								  JOptionPane.showMessageDialog(null, "You have checked out: "+itemName);
								  ArrayList<LibraryItem> newItems = readInventory().displayAll();
								  if(!(newItems.isEmpty())) {
									  List<String[]> newTableData = new ArrayList<>();
									  for (LibraryItem item : newItems) {
										  if(item.isBorrowed() == false) {
											  String[] rowData = {item.getName(), item.getGenre()};
											  newTableData.add(rowData);
										  }
									  }
									  String[][] newTableData2 = new String[newTableData.size()][];
									  newTableData.toArray(newTableData2);
									  availableInventory.setModel(new DefaultTableModel(newTableData2, columnNames));
								  }
								  else {
									  availableInventory.setModel(new DefaultTableModel(new String[][]{}, columnNames));
								  }
							      revalidate();
							      repaint();
						  	}
						  }
					  }
				});
				//idea source: https://stackoverflow.com/questions/4795586/determine-which-jtable-cell-is-clicked
				//revalidate();
				getContentPane().remove(borrowBtn); getContentPane().remove(returnBtn); getContentPane().remove(allItemsBtn); getContentPane().remove(signOutBtn); getContentPane().remove(question);
				getContentPane().add(availableInventory); getContentPane().add(backBtn);
				revalidate();
		 		repaint();
				//show the entire available inventory -  done
				//set the item as borrowed - done
				//add it to the users own borrowed list - done
			}
		});
		//idea sources: https://www.digitalocean.com/community/tutorials/java-list-add-addall-methods
		//idea source: https://www.geeksforgeeks.org/java-swing-jtable/

		returnBtn.addActionListener( new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				    JTable availableInventory;
	            	ArrayList<LibraryItem> items = u.viewItems();
	            	List<String[]> tableData = new ArrayList<>();
					for(LibraryItem item: items) {
						String[] rowData = {item.getName(), item.getGenre()};	
						tableData.add(rowData);
					}
					String[][] tableData2 = new String[tableData.size()][];
					tableData.toArray(tableData2);
					String[] columnNames = { "Name", "Genre" };
					availableInventory = new JTable(tableData2, columnNames);
					availableInventory.setDefaultEditor(Object.class, null);  //to make sure users can't edit the table values bc or else they can double click and modify it :(
					availableInventory.setBounds(0,23,500,500);
					
					JButton backBtn = new JButton("Back");
					backBtn.setBounds(0, 0, 89, 23);

					 ActionListener backBtnAction = (new ActionListener() {
					 	 public void actionPerformed(ActionEvent e) {
					 		getContentPane().add(borrowBtn); getContentPane().add(returnBtn); getContentPane().add(allItemsBtn); getContentPane().add(signOutBtn); getContentPane().add(question);
							getContentPane().remove(availableInventory);
							getContentPane().remove(backBtn);
							revalidate();
					 		repaint();
					 	}
					  });
					 
					 backBtn.addActionListener(backBtnAction);
					 
					availableInventory.getSelectionModel().addListSelectionListener( new ListSelectionListener () {
						  public void valueChanged(ListSelectionEvent event) {
							  if (!event.getValueIsAdjusting()) {
								  int selectedRow = availableInventory.getSelectedRow();
								  if (selectedRow != -1) {
									  Object itemName = availableInventory.getValueAt(selectedRow, 0); 
									  Inventory inventory = readInventory();
						              ArrayList<LibraryItem> invItems = inventory.displayAll();
									  for(LibraryItem item: invItems) {
										  if (item.getName().equals(itemName)) {
							                    item.setBorrowed(false);	
							                    u.returnItem(item);
							                    Inventory inventoryNew = new Inventory();
							                    inventoryNew.setInventory(invItems);
							                    writeInventory(inventoryNew); 
							                    break;
										  }
						            	}
									  JOptionPane.showMessageDialog(null, "You have returned: "+itemName);
									  ArrayList<LibraryItem> newItems = u.viewItems();
									  if(!(newItems.isEmpty())) {
										  List<String[]> newTableData = new ArrayList<>();
										  for (LibraryItem item : newItems) {
											  String[] rowData = {item.getName(), item.getGenre()};
											  newTableData.add(rowData);
										  }
										  String[][] newTableData2 = new String[newTableData.size()][];
										  newTableData.toArray(newTableData2);
										  availableInventory.setModel(new DefaultTableModel(newTableData2, columnNames));
									  }
									  else {
										  availableInventory.setModel(new DefaultTableModel(new String[][]{}, columnNames));
									  }
								  }
							      revalidate();
							      repaint();
							  }
						  }
					});
					//idea source: https://stackoverflow.com/questions/4795586/determine-which-jtable-cell-is-clicked
					//revalidate();
					getContentPane().remove(borrowBtn); getContentPane().remove(returnBtn); getContentPane().remove(allItemsBtn); getContentPane().remove(signOutBtn); getContentPane().remove(question);
					getContentPane().add(availableInventory); getContentPane().add(backBtn);
					revalidate();
			 		repaint();
					//show the entire available inventory -  done
					//set the item as borrowed - done
					//add it to the users own borrowed list - done
				}
		 });
		
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
		requestItemBtn.setBounds(142, 209, 200, 20);
		signOutBtn.setBounds(169, 241, 150, 20);
		getContentPane().setLayout(null);
		getContentPane().add(borrowBtn); getContentPane().add(returnBtn); 
		getContentPane().add(allItemsBtn);  getContentPane().add(signOutBtn);
		//getContentPane().add(requestItemBtn);
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
	
	public void writeInventory(Inventory newInv) {
		try {
            FileOutputStream f = new FileOutputStream("data.bin");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(newInv);
            o.close();
          } catch (FileNotFoundException n) {
            System.out.println("Error: File not found");
          } catch (IOException i) {
            System.out.println("Error writing to file:" + i.getMessage());
            i.printStackTrace();
          }
	}	
	
}
