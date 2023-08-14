package mainSource;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Container;

import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class StartPage extends JFrame implements ActionListener{
	//Instances
	private JPanel contentPane;
	private JLabel ProjectLabel;
	private JButton letterPracticeButton;
	private JButton wordPracticeButton;
	private JLabel lblNewLabel_1;
	private JButton fullCodePracticeButton;
	private Image img = new ImageIcon("/images/TextBackground.jpg").getImage();
	private JLabel lblNewLabel_2;
	private JPanel letterModePanel;
	private JLabel LetterModeTitle;
	private JButton basicKeysButton;
	private JButton leftTopKeysButton;
	private JButton leftBottomKeysButton;
	private JButton rightTopKeysButton;
	private JButton rightBottomKeysButton;
	private JLabel letterModeBackground;
	private JButton middleKeysButton;	
	private JPanel fullCodeModePanel;
	private JLabel LetterModeTitle_1;
	private JButton hardCodeButton;
	private JButton easyCodeButton;
	private JButton normalCodeButton;
	private JLabel fullCodeModeBackground;
	private JButton scoreBoardButton;
	
	/**
	 * Create the frame.
	 */
	public StartPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartPage.class.getResource("/images/FrameIcon.png")));
		setResizable(false);					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\uD55C\uCEF4 \uD0C0\uC790\uC5F0\uC2B5");
		setBounds(100, 100, 928, 668);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fullCodeModePanel = new JPanel();
		fullCodeModePanel.setOpaque(false);
		fullCodeModePanel.setBounds(558, 213, 222, 363);
		contentPane.add(fullCodeModePanel);
		fullCodeModePanel.setLayout(new GridLayout(0, 1, 0, 0));
		fullCodeModePanel.setVisible(false);
		
		LetterModeTitle_1 = new JLabel("Select Difficulty");
		LetterModeTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		LetterModeTitle_1.setForeground(Color.WHITE);
		LetterModeTitle_1.setFont(new Font("Arial", Font.BOLD, 23));
		fullCodeModePanel.add(LetterModeTitle_1);
		
		easyCodeButton = new JButton("Easy");
		easyCodeButton.setBorderPainted(false);
		easyCodeButton.setOpaque(false);
		easyCodeButton.setContentAreaFilled(false);
		easyCodeButton.setForeground(Color.WHITE);
		easyCodeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		easyCodeButton.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		fullCodeModePanel.add(easyCodeButton);
		
		normalCodeButton = new JButton("Normal");
		normalCodeButton.setBorderPainted(false);
		normalCodeButton.setOpaque(false);
		normalCodeButton.setContentAreaFilled(false);
		normalCodeButton.setForeground(Color.WHITE);
		normalCodeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		normalCodeButton.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		fullCodeModePanel.add(normalCodeButton);
		
		hardCodeButton = new JButton("Hard");
		hardCodeButton.setBorderPainted(false);
		hardCodeButton.setOpaque(false);
		hardCodeButton.setContentAreaFilled(false);
		hardCodeButton.setForeground(Color.WHITE);
		hardCodeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hardCodeButton.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		fullCodeModePanel.add(hardCodeButton);
		
		fullCodeModeBackground = new JLabel("");
		fullCodeModeBackground.setIcon(new ImageIcon(StartPage.class.getResource("/images/SelectBackground.jpg")));
		fullCodeModeBackground.setBounds(558, 213, 222, 363);
		contentPane.add(fullCodeModeBackground);
		fullCodeModeBackground.setVisible(false);
		
		ProjectLabel = new JLabel("\uD0C0 \uC790 \uC5F0 \uC2B5");
		ProjectLabel.setForeground(new Color(255, 255, 255));
		ProjectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ProjectLabel.setFont(new Font("HY목각파임B", Font.PLAIN, 81));
		ProjectLabel.setBounds(226, 82, 450, 100);
		contentPane.add(ProjectLabel);
		
		letterPracticeButton = new JButton(" Letter Practice");
		letterPracticeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		letterPracticeButton.setContentAreaFilled(false);
		letterPracticeButton.setBorderPainted(false);
		letterPracticeButton.setBorder(null);
		letterPracticeButton.setHorizontalAlignment(SwingConstants.LEFT);
		letterPracticeButton.setIcon(new ImageIcon(StartPage.class.getResource("/images/\uC790\uB9AC\uC5F0\uC2B5.png")));
		letterPracticeButton.setBackground(new Color(245, 222, 179));
		letterPracticeButton.setForeground(new Color(0, 0, 0));
		letterPracticeButton.setFont(new Font("한컴 훈민정음 가로쓰기", Font.BOLD, 34));
		letterPracticeButton.setBounds(68, 213, 346, 88);		
		contentPane.add(letterPracticeButton);
		
		wordPracticeButton = new JButton(" Word Practice");
		wordPracticeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wordPracticeButton.setContentAreaFilled(false);
		wordPracticeButton.setIcon(new ImageIcon(StartPage.class.getResource("/images/\uB0B1\uB9D0\uC5F0\uC2B5.png")));
		wordPracticeButton.setHorizontalAlignment(SwingConstants.LEFT);
		wordPracticeButton.setForeground(Color.BLACK);
		wordPracticeButton.setFont(new Font("한컴 훈민정음 가로쓰기", Font.BOLD, 34));
		wordPracticeButton.setBorderPainted(false);
		wordPracticeButton.setBorder(null);
		wordPracticeButton.setBackground(new Color(245, 222, 179));
		wordPracticeButton.setBounds(68, 345, 315, 88);
		contentPane.add(wordPracticeButton);
		
		lblNewLabel_1 = new JLabel("\uD55C\uAE00\uACFC\uCEF4\uD4E8\uD130");
		lblNewLabel_1.setFont(new Font("한컴 훈민정음 가로쓰기", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(248, 38, 166, 51);
		contentPane.add(lblNewLabel_1);
		
		fullCodePracticeButton = new JButton(" Full Code Practice");
		fullCodePracticeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		fullCodePracticeButton.setIcon(new ImageIcon(StartPage.class.getResource("/images/\uC7A5\uBB38\uC5F0\uC2B5.png")));
		fullCodePracticeButton.setHorizontalAlignment(SwingConstants.LEFT);
		fullCodePracticeButton.setForeground(Color.BLACK);
		fullCodePracticeButton.setFont(new Font("한컴 훈민정음 가로쓰기", Font.BOLD, 34));
		fullCodePracticeButton.setContentAreaFilled(false);
		fullCodePracticeButton.setBorderPainted(false);
		fullCodePracticeButton.setBorder(null);
		fullCodePracticeButton.setBackground(new Color(245, 222, 179));
		fullCodePracticeButton.setBounds(68, 488, 382, 88);
		contentPane.add(fullCodePracticeButton);
		
		letterModePanel = new JPanel();
		letterModePanel.setOpaque(false);
		letterModePanel.setBounds(558, 213, 222, 363);
		contentPane.add(letterModePanel);
		letterModePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		LetterModeTitle = new JLabel("Select Mode");
		LetterModeTitle.setForeground(new Color(255, 255, 255));
		LetterModeTitle.setFont(new Font("Arial", Font.BOLD, 23));
		LetterModeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		letterModePanel.add(LetterModeTitle);
		
		basicKeysButton = new JButton("Basic Keys");
		basicKeysButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		basicKeysButton.setContentAreaFilled(false);
		basicKeysButton.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		basicKeysButton.setForeground(new Color(255, 255, 255));
		basicKeysButton.setOpaque(false);
		basicKeysButton.setBorder(null);
		letterModePanel.add(basicKeysButton);
		
		leftTopKeysButton = new JButton("Left Top Keys");
		leftTopKeysButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		leftTopKeysButton.setContentAreaFilled(false);
		leftTopKeysButton.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		leftTopKeysButton.setForeground(new Color(255, 255, 255));
		leftTopKeysButton.setOpaque(false);
		leftTopKeysButton.setBorderPainted(false);
		letterModePanel.add(leftTopKeysButton);
		
		leftBottomKeysButton = new JButton("Left Bottom Keys\r\n");
		leftBottomKeysButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		leftBottomKeysButton.setContentAreaFilled(false);
		leftBottomKeysButton.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		leftBottomKeysButton.setForeground(new Color(255, 255, 255));
		leftBottomKeysButton.setOpaque(false);
		leftBottomKeysButton.setBorderPainted(false);
		letterModePanel.add(leftBottomKeysButton);
		
		rightTopKeysButton = new JButton("Right Top Keys");
		rightTopKeysButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rightTopKeysButton.setContentAreaFilled(false);
		rightTopKeysButton.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		rightTopKeysButton.setForeground(new Color(255, 255, 255));
		rightTopKeysButton.setOpaque(false);
		rightTopKeysButton.setBorderPainted(false);
		letterModePanel.add(rightTopKeysButton);
		
		rightBottomKeysButton = new JButton("Right Bottom Keys");
		rightBottomKeysButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rightBottomKeysButton.setContentAreaFilled(false);
		rightBottomKeysButton.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		rightBottomKeysButton.setForeground(new Color(255, 255, 255));
		rightBottomKeysButton.setOpaque(false);
		rightBottomKeysButton.setBorderPainted(false);
		letterModePanel.add(rightBottomKeysButton);
		
		middleKeysButton = new JButton("Middle Keys");
		middleKeysButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		middleKeysButton.setContentAreaFilled(false);
		middleKeysButton.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		middleKeysButton.setForeground(new Color(255, 255, 255));
		middleKeysButton.setBorder(null);
		middleKeysButton.setBorderPainted(false);
		middleKeysButton.setOpaque(false);
		letterModePanel.add(middleKeysButton);
		letterModePanel.setVisible(false);		
		
		letterModeBackground = new JLabel("");
		letterModeBackground.setIcon(new ImageIcon(StartPage.class.getResource("/images/SelectBackground.jpg")));
		letterModeBackground.setBounds(558, 213, 222, 363);
		contentPane.add(letterModeBackground);
		letterModeBackground.setVisible(false);
		
		scoreBoardButton = new JButton("ScoreBoard");
		scoreBoardButton.setBorder(null);
		scoreBoardButton.setRequestFocusEnabled(false);
		scoreBoardButton.setForeground(Color.WHITE);
		scoreBoardButton.setContentAreaFilled(false);
		scoreBoardButton.setIcon(null);
		scoreBoardButton.setBorderPainted(false);
		scoreBoardButton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		scoreBoardButton.setBounds(0, 0, 142, 51);
		contentPane.add(scoreBoardButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(StartPage.class.getResource("/images/IntroBackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 912, 629);
		contentPane.add(lblNewLabel_2);
		
		setVisible(true);
		
		//ActionListeners used
		basicKeysButton.addActionListener(this);
		leftTopKeysButton.addActionListener(this);
		leftBottomKeysButton.addActionListener(this);
		rightTopKeysButton.addActionListener(this);
		rightBottomKeysButton.addActionListener(this);
		middleKeysButton.addActionListener(this);		
		letterPracticeButton.addActionListener(this);
		wordPracticeButton.addActionListener(this);
		fullCodePracticeButton.addActionListener(this);
		easyCodeButton.addActionListener(this);
		normalCodeButton.addActionListener(this);
		hardCodeButton.addActionListener(this);
		scoreBoardButton.addActionListener(this);
	}		
	
	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//#1. Popup Select mode buttons of Letter Practice
		if(e.getSource() == letterPracticeButton) {
			fullCodeModePanel.setVisible(false);
			fullCodeModeBackground.setVisible(false);
			letterModeBackground.setVisible(true);
			letterModePanel.setVisible(true);
		}
		//Open LetterPractice Frame with specific mode selected
		//1-1. basicKeys
		else if(e.getSource() == basicKeysButton)  		{
			LetterPractice convertframe = new LetterPractice(0);
			convertframe.setVisible(true);
			dispose();
		}
		
		//1-1. leftTopKeys
		else if(e.getSource() == leftTopKeysButton)  		{
			LetterPractice convertframe = new LetterPractice(1);
			convertframe.setVisible(true);
			dispose();
		}
		
		//1-2. leftBottomKeys
		else if(e.getSource() == leftBottomKeysButton)  		{
			LetterPractice convertframe = new LetterPractice(2);
			convertframe.setVisible(true);
			dispose();
		}
		
		//1-3. rightTopKeys
		else if(e.getSource() == rightTopKeysButton)  		{
			LetterPractice convertframe = new LetterPractice(3);
			convertframe.setVisible(true);
			dispose();
		}
		
		//1-4. rightBottomKeys
		else if(e.getSource() == rightBottomKeysButton)  		{
			LetterPractice convertframe = new LetterPractice(4);
			convertframe.setVisible(true);
			dispose();
		}
		
		//1-5. middleKeys
		else if(e.getSource() == middleKeysButton)  		{
			LetterPractice convertframe = new LetterPractice(5);
			convertframe.setVisible(true);
			dispose();
		}
		
		//#2. Open WordPractice Frame
		else if(e.getSource() == wordPracticeButton) {
			WordPractice convertframe = new WordPractice();
			convertframe.setVisible(true);
			dispose();
		}
		
		//#3. Popup Select difficulty buttons of FullCodePractice
		else if(e.getSource() == fullCodePracticeButton) {
			letterModePanel.setVisible(false);
			letterModeBackground.setVisible(true);
			
			fullCodeModePanel.setVisible(true);
		}
		
		//Open fullCodePractice Frame with specific difficulty selected
		//3-1. Easy Code
		else if(e.getSource() == easyCodeButton) {
			FullCodePractice converframe = new FullCodePractice(0);
			converframe.setVisible(true);
			dispose();			
		}
		
		//3-2. Normal Code
		else if(e.getSource() == normalCodeButton) {
			FullCodePractice converframe = new FullCodePractice(1);
			converframe.setVisible(true);
			dispose();			
		}
		
		//3-3. Hard Code
		else if(e.getSource() == hardCodeButton) {
			FullCodePractice converframe = new FullCodePractice(2);
			converframe.setVisible(true);
			dispose();			
		}
		
		//#4. Open ScoreBoard Frame
		else if(e.getSource() == scoreBoardButton) {
			ScoreBoard frame = new ScoreBoard();
			frame.setVisible(true);			
		}
		
	}
}


