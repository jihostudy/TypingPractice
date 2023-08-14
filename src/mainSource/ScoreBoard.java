package mainSource;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import subSource.Score;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class ScoreBoard extends JDialog {
	private JScrollPane EasyScrollPane;
	private JScrollPane NormalScrollPane;
	private JTextArea easyScoreBoard;
	private JTextArea normalScoreBoard;
	private JScrollPane HardScrollPane;
	private JTextArea hardScoreBoard;	
	private JLabel lblNewLabel;
	private JLabel lblNormalScoreBoard;
	private JLabel lblNewLabel_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ScoreBoard dialog = new ScoreBoard();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ScoreBoard() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ScoreBoard.class.getResource("/images/FrameIcon.png")));
		setTitle("Score Board");
		setBounds(100, 100, 886, 906);
		getContentPane().setLayout(null);
		
		easyScoreBoard = new JTextArea();
		easyScoreBoard.setBorder(null);
		easyScoreBoard.setFont(new Font("Consolas", Font.PLAIN, 16));
		EasyScrollPane = new JScrollPane(easyScoreBoard );
		EasyScrollPane.setBorder(null);
		EasyScrollPane.setBounds(0, 42, 290, 825);
		getContentPane().add(EasyScrollPane);
		
		
		
		normalScoreBoard = new JTextArea();
		normalScoreBoard.setBorder(null);
		normalScoreBoard.setFont(new Font("Consolas", Font.PLAIN, 16));
		NormalScrollPane = new JScrollPane(normalScoreBoard);
		NormalScrollPane.setBorder(null);
		NormalScrollPane.setBounds(290, 42, 290, 825);
		getContentPane().add(NormalScrollPane);
		
		hardScoreBoard = new JTextArea();
		hardScoreBoard.setBorder(null);
		hardScoreBoard.setFont(new Font("Consolas", Font.PLAIN, 16));
		HardScrollPane = new JScrollPane(hardScoreBoard);
		HardScrollPane.setBorder(null);
		HardScrollPane.setBounds(580, 42, 290, 825);
		getContentPane().add(HardScrollPane);		
		
		lblNewLabel = new JLabel("Easy Score Board");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNewLabel.setBounds(50, 10, 190, 28);
		getContentPane().add(lblNewLabel);
		
		lblNormalScoreBoard = new JLabel("Normal Score Board");
		lblNormalScoreBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblNormalScoreBoard.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNormalScoreBoard.setBounds(340, 10, 190, 28);
		getContentPane().add(lblNormalScoreBoard);
		
		lblNewLabel_2 = new JLabel("Hard Score Board");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNewLabel_2.setBounds(630, 10, 190, 28);
		getContentPane().add(lblNewLabel_2);
		
		//Making score board of Easy scores.
		Collection<Score> easyScores = new ArrayList<>();
		
		try {
			FileInputStream inputStream = new FileInputStream("EasyScoreBoard.txt");
            Scanner scanner = new Scanner(inputStream); 
	            while (scanner.hasNextLine()) {
	            	String line = scanner.nextLine();
	            	String[] tokens = line.split(":");
	            	
	                if (tokens.length == 2) {
	                	String name = tokens[0].trim();
	                	int score = Integer.parseInt(tokens[1].trim());
	                	Score temp = new Score(name, score);
	                	easyScores.add(temp);
	                }
	            }
	        inputStream.close();
	        scanner.close();
        }
		catch (IOException error) {
            error.printStackTrace();
        }
        List<Score> sortedEasyScores = new ArrayList<>(easyScores);
        Collections.sort(sortedEasyScores);        
        
        for (Score student : sortedEasyScores) {
		   	easyScoreBoard.append(student.getName() + ": " + student.getScore()+"\n");
	    }
        
      //Making score board of Normal scores.
        Collection<Score> normalScores = new ArrayList<>();
		
		try {
			FileInputStream inputStream = new FileInputStream("NormalScoreBoard.txt");
            Scanner scanner = new Scanner(inputStream); 
	            while (scanner.hasNextLine()) {
	            	String line = scanner.nextLine();
	            	String[] tokens = line.split(":");
	            	
	                if (tokens.length == 2) {
	                	String name = tokens[0].trim();
	                	int score = Integer.parseInt(tokens[1].trim());
	                	Score temp = new Score(name, score);
	                	normalScores.add(temp);
	                }
	            }
	         inputStream.close();
	         scanner.close();
        }
		catch (IOException error) {
            error.printStackTrace();
        }
        List<Score> sortedNormalScores = new ArrayList<>(normalScores);
        Collections.sort(sortedNormalScores);        
        
        for (Score student : sortedNormalScores) {
		   	normalScoreBoard.append(student.getName() + ": " + student.getScore()+"\n");
	    }
        
      //Making score board of Hard scores.
        Collection<Score> hardScores = new ArrayList<>();
		
		try {
			FileInputStream inputStream = new FileInputStream("HardScoreBoard.txt");
            Scanner scanner = new Scanner(inputStream); 
	            while (scanner.hasNextLine()) {
	            	String line = scanner.nextLine();
	            	String[] tokens = line.split(":");
	            	
	                if (tokens.length == 2) {
	                	String name = tokens[0].trim();
	                	int score = Integer.parseInt(tokens[1].trim());
	                	Score temp = new Score(name, score);
	                	hardScores.add(temp);
	                }
	            }
	       inputStream.close();
	       scanner.close();
        }
		catch (IOException error) {
            error.printStackTrace();
        }
        List<Score> sortedHardScores = new ArrayList<>(hardScores);
        Collections.sort(sortedHardScores);        
        
        for (Score student : sortedHardScores) {
		   	hardScoreBoard.append(student.getName() + ": " + student.getScore()+"\n");
	    }			
	}

}
