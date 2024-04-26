package assistant;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class assistantGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public assistantGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
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
				addItemGUI addItem = new addItemGUI();
				addItem.setVisible(true);
				setVisible(false);
				dispose();
			}
		};
		addBtn.addActionListener(add);
		
		getContentPane().setLayout(null);
		getContentPane().add(question); getContentPane().add(addBtn); getContentPane().add(removeBtn); getContentPane().add(viewRequestsBtn); getContentPane().add(signOutBtn);
	}

}
