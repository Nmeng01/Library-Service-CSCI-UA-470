package assistant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import classes.*;
import java.util.*;

public class addMovieGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public addMovieGUI(Inventory i, assistantGUI a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JLabel instructions, option, titleLbl, genreLbl, formatLbl, directorLbl, reviewsLbl, actorsLbl;
		JTextField titleTxt, genreTxt, formatTxt, directorTxt, reviewsTxt, actorsTxt;
		JButton submitBtn, backBtn;
		
		instructions = new JLabel("Enter the following:");
		titleLbl = new JLabel("Title");
		genreLbl = new JLabel("Genre");
		formatLbl = new JLabel("Format");
		option = new JLabel("Optional inputs");
		directorLbl = new JLabel("Director");
		reviewsLbl = new JLabel("Reviews (Comma separated)");
		actorsLbl = new JLabel("Actors (Comma separated)");
		
		instructions.setBounds(200, 30, 350, 20);
		titleLbl.setBounds(150, 70, 150, 20);
		genreLbl.setBounds(142, 110, 150, 20);
		formatLbl.setBounds(134, 150, 150, 20);
		option.setBounds(200, 190, 350, 20);
		directorLbl.setBounds(127, 230, 150, 20);
		reviewsLbl.setBounds(4, 270, 175, 20);
		actorsLbl.setBounds(13, 310, 175, 20);
		
		titleTxt = new JTextField();
		genreTxt = new JTextField();
		formatTxt = new JTextField();
		directorTxt = new JTextField();
		reviewsTxt = new JTextField();
		actorsTxt = new JTextField();
		
		titleTxt.setBounds(180, 70, 150, 20);
		genreTxt.setBounds(180, 110, 150, 20);
		formatTxt.setBounds(180, 150, 150, 20);
		directorTxt.setBounds(180, 230, 150, 20);
		reviewsTxt.setBounds(180, 270, 150, 20);
		actorsTxt.setBounds(180, 310, 150, 20);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(180, 350, 150, 20);
		ActionListener submit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(titleTxt.getText().isEmpty() || genreTxt.getText().isEmpty() || formatTxt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all required fields.");
				}
				else {
					Movie movie = new Movie(titleTxt.getText(), false, genreTxt.getText(), formatTxt.getText());
					if(!(directorTxt.getText().isEmpty())) {
						movie.setDirector(directorTxt.getText());
					}
					if(!(reviewsTxt.getText().isEmpty())) {
						String temp[] = reviewsTxt.getText().split(",");
						List<String> reviews = new ArrayList<String>(Arrays.asList(temp));
						movie.setReviews((ArrayList<String>)reviews);
					}
					if(!(actorsTxt.getText().isEmpty())) {
						String temp[] = actorsTxt.getText().split(",");
						List<String> actors = new ArrayList<String>(Arrays.asList(temp));
						movie.setNotableActors((ArrayList<String>)actors);
					}
					i.addItem(movie);
					a.setVisible(true);
					setVisible(false);
					dispose();
				}
			}
		};
		submitBtn.addActionListener(submit);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(180, 390, 150, 20);
		ActionListener back = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemGUI addItem = new addItemGUI(i, a);
				addItem.setVisible(true);
				setVisible(false);
				dispose();
			}
		};
		backBtn.addActionListener(back);
		
		getContentPane().setLayout(null);
		getContentPane().add(instructions); getContentPane().add(titleLbl); getContentPane().add(genreLbl); getContentPane().add(formatLbl); getContentPane().add(option); getContentPane().add(directorLbl); getContentPane().add(reviewsLbl); getContentPane().add(actorsLbl);
		getContentPane().add(titleTxt); getContentPane().add(genreTxt); getContentPane().add(formatTxt); getContentPane().add(directorTxt); getContentPane().add(reviewsTxt); getContentPane().add(actorsTxt);
		getContentPane().add(submitBtn); getContentPane().add(backBtn);
	}
}