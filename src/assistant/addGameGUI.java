package assistant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import classes.*;
import java.util.*;

public class addGameGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public addGameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JLabel instructions, option, titleLbl, genreLbl, reviewsLbl, playersLbl;
		JTextField titleTxt, genreTxt, reviewsTxt, playersTxt;
		JButton submitBtn;
		
		instructions = new JLabel("Enter the following:");
		titleLbl = new JLabel("Title");
		genreLbl = new JLabel("Genre");
		option = new JLabel("Optional inputs");
		reviewsLbl = new JLabel("Reviews (Comma separated)");
		playersLbl = new JLabel("Number of Players (int)");
		
		instructions.setBounds(200, 30, 350, 20);
		titleLbl.setBounds(150, 70, 150, 20);
		genreLbl.setBounds(142, 110, 150, 20);
		option.setBounds(200, 150, 350, 20);
		reviewsLbl.setBounds(4, 190, 175, 20);
		playersLbl.setBounds(36, 230, 150, 20);
		
		titleTxt = new JTextField();
		genreTxt = new JTextField();
		reviewsTxt = new JTextField();
		playersTxt = new JTextField();
		
		titleTxt.setBounds(180, 70, 150, 20);
		genreTxt.setBounds(180, 110, 150, 20);
		reviewsTxt.setBounds(180, 190, 150, 20);
		playersTxt.setBounds(180, 230, 150, 20);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(180, 270, 150, 20);
		ActionListener submit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(titleTxt.getText().isEmpty() || genreTxt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all required fields.");
				}
				else {
					Game game = new Game(titleTxt.getText(), false, genreTxt.getText());
					if(!(reviewsTxt.getText().isEmpty())) {
						String temp[] = reviewsTxt.getText().split(",");
						List<String> reviews = new ArrayList<String>(Arrays.asList(temp));
						game.setReviews((ArrayList<String>)reviews);
					}
					if(!(playersTxt.getText().isEmpty())) {
						try {
							game.setNumberOfPlayers(Integer.parseInt(playersTxt.getText()));
						}
						catch(NumberFormatException nfe) {
							JOptionPane.showMessageDialog(null, "Could not save number of players because of invalid input.");
						}
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
		getContentPane().add(instructions); getContentPane().add(titleLbl); getContentPane().add(genreLbl); getContentPane().add(option); getContentPane().add(reviewsLbl); getContentPane().add(playersLbl);
		getContentPane().add(titleTxt); getContentPane().add(genreTxt); getContentPane().add(reviewsTxt); getContentPane().add(playersTxt);
		getContentPane().add(submitBtn);
	}
}