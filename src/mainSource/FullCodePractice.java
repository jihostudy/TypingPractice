package mainSource;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import mainSource.*;
import subSource.EmptyInputException;
import subSource.IncompleteAnswerException;
import subSource.Timer;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.lang.model.element.NestingKind;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JProgressBar;
import java.awt.Toolkit;

public class FullCodePractice extends JFrame implements ActionListener, Timer{
	//Instances
	private JPanel contentPane;
	private JButton btnFullcodePractice;
	private JButton backButton;
	private JScrollPane answerCode;
	private JTextArea answerCodeText;
	private JScrollPane userInputCode;
	private JTextArea userInputCodeText;
	private JButton submitButton;
	private JButton HelpButton;
	private JLabel lblNewLabel;
	private JPanel InformationPanel;
	private JLabel TimeLabel;
	private JLabel timeText;
	private JButton clearButton;
	
	/*
	'practiceMode' : depends on what difficulty user selected
     0 : easy 
     1 : normal
     2 : hard    
	 */
	private static int practiceMode;
	private String filePath;    //depending on the mode selected .txt file name will be changed
	private String showMessage; //popup Message for exception handling
	private int wrongNumber;    //Number of wrong inputs
	
	//For the Timer
	private SwingWorker<Boolean, Integer> timer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullCodePractice frame = new FullCodePractice(practiceMode);
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
	public FullCodePractice(int mode) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FullCodePractice.class.getResource("/images/\uC7A5\uBB38\uC5F0\uC2B5.png")));
		setTitle("FullCode Practice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1149, 1038);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnFullcodePractice = new JButton(" FullCode Practice");
		btnFullcodePractice.setIcon(new ImageIcon(FullCodePractice.class.getResource("/images/\uC7A5\uBB38\uC5F0\uC2B5.png")));
		btnFullcodePractice.setHorizontalAlignment(SwingConstants.LEFT);
		btnFullcodePractice.setForeground(Color.BLACK);
		btnFullcodePractice.setFont(new Font("ÇÑÄÄ ÈÆ¹ÎÁ¤À½ °¡·Î¾²±â", Font.BOLD, 50));
		btnFullcodePractice.setFocusable(false);
		btnFullcodePractice.setContentAreaFilled(false);
		btnFullcodePractice.setBorderPainted(false);
		btnFullcodePractice.setBorder(null);
		btnFullcodePractice.setBackground(new Color(245, 222, 179));
		btnFullcodePractice.setBounds(347, 10, 487, 88);
		contentPane.add(btnFullcodePractice);
		
		backButton = new JButton("Back");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		backButton.setFocusable(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(12, 10, 95, 23);
		contentPane.add(backButton);
		
		answerCodeText = new JTextArea();
		answerCodeText.setEditable(false);
		answerCodeText.setFont(new Font("Consolas", Font.PLAIN, 13));
		answerCodeText.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		answerCodeText.setBackground(Color.WHITE);
		answerCode = new JScrollPane(answerCodeText);
		answerCode.setFont(new Font("Consolas", Font.PLAIN, 14));
		answerCode.setBorder(null);
		answerCode.setBounds(12, 108, 550, 881);
		contentPane.add(answerCode);
		
		userInputCodeText = new JTextArea();
		userInputCodeText.setFont(new Font("Consolas", Font.PLAIN, 13));
		userInputCodeText.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		userInputCodeText.setBackground(Color.WHITE);	
		userInputCode = new JScrollPane(userInputCodeText);
		userInputCode.setBorder(null);
		userInputCode.setBounds(574, 108, 550, 881);		
		contentPane.add(userInputCode);
		
		submitButton = new JButton("Submit");
		submitButton.setBorderPainted(false);
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitButton.setBackground(Color.WHITE);
		submitButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		submitButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		submitButton.setBounds(1018, 73, 106, 30);
		contentPane.add(submitButton);
		
		HelpButton = new JButton("Help");
		HelpButton.setBorderPainted(false);
		HelpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		HelpButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		HelpButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		HelpButton.setBackground(Color.WHITE);
		HelpButton.setBounds(12, 73, 106, 30);
		contentPane.add(HelpButton);
		
		InformationPanel = new JPanel();
		InformationPanel.setBounds(945, 10, 176, 30);
		contentPane.add(InformationPanel);
		InformationPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		TimeLabel = new JLabel("Time : ");
		TimeLabel.setOpaque(true);
		TimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		TimeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		TimeLabel.setBackground(Color.WHITE);
		InformationPanel.add(TimeLabel);
		
		timeText = new JLabel("");
		timeText.setOpaque(true);
		timeText.setHorizontalAlignment(SwingConstants.CENTER);
		timeText.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		timeText.setBackground(Color.WHITE);
		InformationPanel.add(timeText);
		
		clearButton = new JButton("Clear");
		clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		clearButton.setBorderPainted(false);
		clearButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		clearButton.setBackground(Color.WHITE);
		clearButton.setBounds(912, 73, 106, 30);
		contentPane.add(clearButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FullCodePractice.class.getResource("/images/IntroBackground.jpg")));
		lblNewLabel.setBounds(0, 0, 1133, 999);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
		
		//'showMessage' : used for exception handling
		showMessage = "Write exactly the same code given.\n" + "space bar, indentation is also treated\n"
					   + "Clear button will clear all your codes written\n" + "After writing all codes, click submit button";
		
		//ActionListeners
		submitButton.addActionListener(this);
		HelpButton.addActionListener(this);
		backButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		//Depending on the difficulty mode user selected the text file that has codes will be selected.
		this.practiceMode = mode; 
		switch (practiceMode){
		case 0: {
			filePath = "EasyFullCode.txt";
			break;
		}
		case 1: {
			filePath = "NormalFullCode.txt";
			break;
		}
		case 2: {
			filePath = "HardFullCode.txt";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value of practiceMode: " + practiceMode);
		}	
		
		readFile();  //Get the codes written in the text file in 'filePath'
		
		startTimer(); //Start timer		
	}
	
	//"readFile" : reads the text file in the filePath chosen above
	private void readFile() {
		try {
			FileInputStream fileobject = new FileInputStream(filePath);
			Scanner scanner = new Scanner(fileobject);			
			
			while(scanner.hasNextLine()) {
				answerCodeText.append(scanner.nextLine() + "\n");
			}			
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	//"compareCode" : compares the differences between two codes and highlight the differences
	private void compareCode(JTextArea originalTextArea, JTextArea userTextArea) {
	        // Get the original code from file
		 	String answerCode = answerCodeText.getText();
	        String userCode = userInputCodeText.getText();

	        Highlighter highlighter = userTextArea.getHighlighter();
	        highlighter.removeAllHighlights();
	        
	        int originalPos = 0;
	        int userPos = 0;
	        wrongNumber = 0;
	        while (originalPos < answerCode.length() && userPos < userCode.length()) {
	            if (answerCode.charAt(originalPos) != userCode.charAt(userPos)) {
	            	wrongNumber++;
	                try {
	                    highlighter.addHighlight(userPos, userPos + 1, new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
	                } 
	                catch (BadLocationException e) {
	                    e.printStackTrace();
	                }	         
	            }
	            originalPos++;
	            userPos++;
	        }	        
	    }

	//ActionListeners
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//#1. SubmitButton
		if(e.getSource() == submitButton) {
			//1.1 Exception Handling
			try {
				compareCode(answerCodeText, userInputCodeText);
				
				//1.1.1 : Empty input
				if(userInputCodeText.getText().length() == 0) {
					throw new EmptyInputException("Input is Empty");
				}
				
				//1.1.2. : Not enough Length of input
				else if(answerCodeText.getText().length() != userInputCodeText.getText().length()) {
					throw new IncompleteAnswerException("Fill in all the answers!");
				}
				
				//2. Open the "checkScoreDialog" frame to check if the user wants to submit
				CheckScoreDialog frame = new CheckScoreDialog(practiceMode, wrongNumber);
				frame.setVisible(true);
				dispose();
			} 
			catch (EmptyInputException error) {
				JOptionPane.showMessageDialog(FullCodePractice.this, "Please write codes before submitting!","No Input",JOptionPane.WARNING_MESSAGE);
			}
			catch(IncompleteAnswerException error) {
				JOptionPane.showMessageDialog(FullCodePractice.this, "Please write all the codes before submitting!","Insufficient Answer",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else if(e.getSource() == HelpButton) {
			JOptionPane.showMessageDialog(FullCodePractice.this, showMessage, "Instructions", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == backButton) {
			StartPage covertFrame = new StartPage();
			covertFrame.setVisible(true);
			dispose();			
		}
		else if(e.getSource() == clearButton) {
			userInputCodeText.setText("");
		}
	}
	
	public void startTimer() {
		timer = new SwingWorker<Boolean, Integer>() {
			
			@Override
			protected Boolean doInBackground() throws Exception {
				try {
					int seconds = 0;
					while(true) {
						int minutes = seconds / 60;
						int remainingSeconds = seconds % 60;
						seconds++;
						String timeString = String.format("%02d:%02d", minutes, remainingSeconds);
						timeText.setText(timeString);
						Thread.sleep(1000);
					}
										 
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
		};
		timer.execute();
	}
}
