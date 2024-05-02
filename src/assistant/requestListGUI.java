package assistant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Inventory;
import classes.LibraryItem;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class requestListGUI extends JFrame {

	private JPanel contentPane;
	private JList<String> list;
	private JButton backButton;
	private JButton resolveButton;
	private DefaultListModel<String> data;


	/**
	 * Create the frame.
	 */
	public requestListGUI(Inventory inv, assistantGUI a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 33, 350, 115);
		contentPane.add(scrollPane);
		data = requestListDisplay(inv);
		this.list = new JList<String>(data);
		scrollPane.setViewportView(list);
		
		this.backButton = new JButton("Back");
		this.backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		this.backButton.setBounds(241, 195, 85, 21);
		contentPane.add(this.backButton);
		
		this.resolveButton = new JButton("Resolved");
		this.resolveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String request = list.getSelectedValue();
				inv.removeRequest(request);
				data = requestListDisplay(inv);
				list.setModel(data);
			}
		});
		
		this.resolveButton.setBounds(97, 195, 85, 21);
		contentPane.add(this.resolveButton);
	}
	
	// Take Inventory Object and return an Array of Strings
	private DefaultListModel<String> requestListDisplay(Inventory inv) {
		ArrayList<String> data = inv.getRequestList();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = 0; i < data.size(); i++) {
			listModel.addElement(data.get(i));
		}
		return listModel;
		
	}
	
}
