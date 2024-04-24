package assistant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
public class assistantGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					assistantGUI frame = new assistantGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public assistantGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JButton addBtn, removeBtn, viewRequestsBtn;
		addBtn = new JButton("Add Item");
		removeBtn = new JButton("Remove Item");
		viewRequestsBtn = new JButton("View Requested Items");
		addBtn.setBounds(166, 110, 150, 20);
		removeBtn.setBounds(166, 141, 150, 20);
		viewRequestsBtn.setBounds(166, 172, 150, 20);
		getContentPane().setLayout(null);
		getContentPane().add(addBtn); getContentPane().add(removeBtn); getContentPane().add(viewRequestsBtn);
	}

}
