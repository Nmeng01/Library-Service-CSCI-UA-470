package assistant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import classes.*;
import java.util.*;

public class addBookGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public addBookGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JLabel instructions, option, titleLbl, genreLbl, authorLbl, illustratorLbl, awardsLbl, levelOfReadingLbl;
		JTextField titleTxt, genreTxt, authorTxt, illustratorTxt, awardsTxt, levelOfReadingTxt;
		JButton submitBtn;
		
		instructions = new JLabel("Enter the following:");
		titleLbl = new JLabel("Title");
		genreLbl = new JLabel("Genre");
		authorLbl = new JLabel("Author");
		option = new JLabel("Optional inputs");
		illustratorLbl = new JLabel("Illustrator");
		awardsLbl = new JLabel("Awards (Comma separated)");
		levelOfReadingLbl = new JLabel("Level of Reading");
		
		instructions.setBounds(200, 30, 350, 20);
		titleLbl.setBounds(150, 70, 150, 20);
		genreLbl.setBounds(142, 110, 150, 20);
		authorLbl.setBounds(134, 150, 150, 20);
		option.setBounds(200, 190, 350, 20);
		illustratorLbl.setBounds(114, 230, 150, 20);
		awardsLbl.setBounds(5, 270, 175, 20);
		levelOfReadingLbl.setBounds(70, 310, 150, 20);
		
		titleTxt = new JTextField();
		genreTxt = new JTextField();
		authorTxt = new JTextField();
		illustratorTxt = new JTextField();
		awardsTxt = new JTextField();
		levelOfReadingTxt = new JTextField();
		
		titleTxt.setBounds(180, 70, 150, 20);
		genreTxt.setBounds(180, 110, 150, 20);
		authorTxt.setBounds(180, 150, 150, 20);
		illustratorTxt.setBounds(180, 230, 150, 20);
		awardsTxt.setBounds(180, 270, 150, 20);
		levelOfReadingTxt.setBounds(180, 310, 150, 20);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(180, 340, 150, 20);
		ActionListener submit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(titleTxt.getText().isEmpty() || genreTxt.getText().isEmpty() || authorTxt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all required fields.");
				}
				else {
					Book book = new Book(titleTxt.getText(), false, genreTxt.getText(), authorTxt.getText());
					if(!(illustratorTxt.getText().isEmpty())) {
						book.setIllustrator(illustratorTxt.getText());
					}
					if(!(awardsTxt.getText().isEmpty())) {
						String temp[] = awardsTxt.getText().split(",");
						List<String> awards = new ArrayList<String>(Arrays.asList(temp));
						book.setAwards((ArrayList<String>)awards);
					}
					if(!(levelOfReadingTxt.getText().isEmpty())) {
						book.setLevelOfReading(levelOfReadingTxt.getText());
					}
					// add to inventory
					assistantGUI aGUI = new assistantGUI();
					aGUI.setVisible(true);
					setVisible(false);
					dispose();
				}
			}
		};
		submitBtn.addActionListener(submit);
		
		getContentPane().setLayout(null);
		getContentPane().add(instructions); getContentPane().add(titleLbl); getContentPane().add(genreLbl); getContentPane().add(authorLbl); getContentPane().add(option); getContentPane().add(illustratorLbl); getContentPane().add(awardsLbl); getContentPane().add(levelOfReadingLbl);
		getContentPane().add(titleTxt); getContentPane().add(genreTxt); getContentPane().add(authorTxt); getContentPane().add(illustratorTxt); getContentPane().add(awardsTxt); getContentPane().add(levelOfReadingTxt);
		getContentPane().add(submitBtn);
	}
}