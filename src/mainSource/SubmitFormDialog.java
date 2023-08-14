package mainSource;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.print.event.PrintJobAttributeEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import subSource.wrongStudentIdException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.awt.Toolkit;

public class SubmitFormDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField studentIDText;
	private JTextField nameText;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JPanel buttonPane;
	private JButton submitButton;
	private JButton cancelButton;
	
	private static int practiceMode; //Difficulty mode Selected by user
	private static int score;        //score given by the FullCodePractice	
	private String filePath;		 //Depending on the mode the file used will be different
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SubmitFormDialog dialog = new SubmitFormDialog(practiceMode, score);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SubmitFormDialog(int mode, int wrongNumber) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SubmitFormDialog.class.getResource("/images/FrameIcon.png")));
		setTitle("Submit Form");
		setBounds(100, 100, 448, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("StudentID");
			lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 17));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(47, 34, 141, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			lblName = new JLabel("Name");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setFont(new Font("Bahnschrift", Font.BOLD, 17));
			lblName.setBounds(47, 75, 141, 31);
			contentPanel.add(lblName);
		}
		{
			studentIDText = new JTextField();
			studentIDText.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(studentIDText.getForeground() == Color.LIGHT_GRAY) {
						studentIDText.setText("");
						studentIDText.setForeground(Color.BLACK);
					}
				}
			});
			studentIDText.setForeground(Color.LIGHT_GRAY);
			studentIDText.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			studentIDText.setText("Ex) 2019311945");
			studentIDText.setBounds(200, 34, 171, 31);
			contentPanel.add(studentIDText);
			studentIDText.setColumns(10);
		}
		{
			nameText = new JTextField();
			nameText.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(nameText.getForeground() == Color.LIGHT_GRAY) {
						nameText.setText("");
						nameText.setForeground(Color.BLACK);
					}
				}
			});
			nameText.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			nameText.setForeground(Color.LIGHT_GRAY);
			nameText.setText("Ex) JihoKim");
			nameText.setColumns(10);
			nameText.setBounds(200, 75, 171, 31);
			contentPanel.add(nameText);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				submitButton = new JButton("Submit");
				submitButton.setActionCommand("OK");
				buttonPane.add(submitButton);
				getRootPane().setDefaultButton(submitButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		score = wrongNumber;
		
		/*
		'filePath' : depends on what difficulty user selected
	     0 : easy   -> "EasyScoreBoard.txt"
	     1 : normal -> "NormalScoreBoard.txt"
	     2 : hard   -> "HardScoreBoard.txt"
		 */
		practiceMode = mode;
		switch (practiceMode){
		case 0: {
			filePath = "EasyScoreBoard.txt";
			break;
		}
		case 1: {
			filePath = "NormalScoreBoard.txt";
			break;
		}
		case 2: {
			filePath = "HardScoreBoard.txt";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value of practiceMode: " + practiceMode);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//User want to submit
		if(e.getSource() == submitButton) {
			try {
				//Write on specific filePath
				FileOutputStream fileWrite = new FileOutputStream(filePath,true);
				PrintWriter buffer = new PrintWriter(fileWrite);
				
				//Exception when length is not enough for StudentID
				if(studentIDText.getText().length() != 10) {
					throw new wrongStudentIdException("Improper Student ID! Write 10 numbers!");
				}
				
				//Write
				buffer.println(nameText.getText() + "(" + studentIDText.getText() + "):" + score);
				
				//Close
				buffer.close();
				fileWrite.close();
				
				JOptionPane.showMessageDialog(SubmitFormDialog.this, "Succesfully Submitted!","Success",JOptionPane.PLAIN_MESSAGE);
				
				//Open StartPage and check the ScoreBoard!
				StartPage frame = new StartPage();
				frame.setVisible(true);			
				dispose();				
			} 
			catch (wrongStudentIdException error) {
				JOptionPane.showMessageDialog(SubmitFormDialog.this, "StudentId must be length 10!","Wrong StudentId",JOptionPane.WARNING_MESSAGE);
			}
			catch (Exception error) {
				JOptionPane.showMessageDialog(SubmitFormDialog.this, "File not exist");
			}
		}
		
		//User does not want to submit : Start again from the beginning
		else if(e.getSource() == cancelButton) {
			StartPage frame = new StartPage();
			frame.setVisible(true);		
			dispose();
		}
		
	}

}

