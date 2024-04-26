package assistant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import classes.*;

public class addItemGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public addItemGUI(Inventory i, assistantGUI a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,550);
		JLabel question;
		JButton bookBtn, gameBtn, movieBtn, backBtn;
		question = new JLabel("What item are you adding?");
		bookBtn = new JButton("Book");
		gameBtn = new JButton("Game");
		movieBtn = new JButton("Movie");
		
		question.setBounds(190, 60, 350, 20);
		bookBtn.setBounds(20, 108, 150, 20);
		gameBtn.setBounds(196, 108, 150, 20);
		movieBtn.setBounds(372, 108, 150, 20);
		
		ActionListener book = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookGUI addBook = new addBookGUI(i, a);
				addBook.setVisible(true);
				setVisible(false);
				dispose();
			}
		};
		bookBtn.addActionListener(book);
		
		ActionListener game = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGameGUI addGame = new addGameGUI(i, a);
				addGame.setVisible(true);
				setVisible(false);
				dispose();
			}
		};
		gameBtn.addActionListener(game);
		
		ActionListener movie = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMovieGUI addMovie = new addMovieGUI(i, a);
				addMovie.setVisible(true);
				setVisible(false);
				dispose();
			}
		};
		movieBtn.addActionListener(movie);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(196, 148, 150, 20);
		ActionListener back = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.setVisible(true);
				setVisible(false);
				dispose();
			}
		};
		backBtn.addActionListener(back);
		
		getContentPane().setLayout(null);
		getContentPane().add(question); getContentPane().add(bookBtn); getContentPane().add(gameBtn); getContentPane().add(movieBtn); getContentPane().add(backBtn);
	}
}