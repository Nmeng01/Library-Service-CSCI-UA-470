package assistant;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import classes.Inventory;
import classes.LibraryItem;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractListModel;

import java.util.Comparator;

public class deleteItemGUI extends JFrame {

	private JPanel contentPane;
	private JButton deleteButton;
	private JButton backButton;
	private JList<LibraryItem> list;
	private DefaultListModel<LibraryItem> data;

	/**
	 * Create the frame.
	 */
	public deleteItemGUI(Inventory inv, assistantGUI a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		this.data = inventoryDisplay(inv);

		this.deleteButton = new JButton("Delete Item");
		deleteButton.setBounds(164, 165, 85, 21);
		contentPane.add(deleteButton);
		
		this.backButton = new JButton("Back");
		this.backButton.setBounds(164, 207, 85, 21);
		contentPane.add(this.backButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 10, 350, 145);
		contentPane.add(scrollPane);
		
		list = new JList<LibraryItem>(data);
		scrollPane.setViewportView(list);
		
		ActionListener delete = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryItem item = list.getSelectedValue();
				inv.removeItem(item);
				data = inventoryDisplay(inv);
				list.setModel(data);
			}
		};
		deleteButton.addActionListener(delete);

		ActionListener back = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.setVisible(true);
				setVisible(false);
				dispose();
			}
		};
		backButton.addActionListener(back);
	}
	
	// Take Inventory Object and return an Array of Library Items
	private DefaultListModel<LibraryItem> inventoryDisplay(Inventory inv) {
		ArrayList<LibraryItem> data = inv.displayAll();
		DefaultListModel<LibraryItem> listModel = new DefaultListModel<>();
		ArrayList<LibraryItem> temp = new ArrayList<>();
		for (LibraryItem item : data) {
		    if (!(item.isBorrowed())) {
		        temp.add(item);
		    }
		}
		temp.sort(new Comparator<LibraryItem>() {
		    @Override
		    public int compare(LibraryItem item1, LibraryItem item2) {
		        return item1.getName().compareTo(item2.getName());
		    }
		});
		
		for (LibraryItem item : temp) {
		    listModel.addElement(item);
		}
		return listModel;
		
	}
}
