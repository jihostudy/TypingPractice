package mainSource;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mainSource.FullCodePractice;
import mainSource.SubmitFormDialog;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Toolkit;

public class CheckScoreDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton submitButton;
	private JButton tryAgainButton;
	private JLabel lblNewLabel;
	private JTextField scoreText;
	private JLabel lblNewLabel_1;
	
	private static int score; 		 //score given by the FullCodePractice
	private static int practiceMode; //Difficulty mode Selected by user
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CheckScoreDialog dialog = new CheckScoreDialog(practiceMode, score);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CheckScoreDialog(int praicticeMode, int wrongNumber) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CheckScoreDialog.class.getResource("/images/FrameIcon.png")));
		setTitle("Submit Check");
		setBounds(100, 100, 426, 146);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 410, 74);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("Score(Wrong Number) : ");
			lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(73, 10, 190, 37);
			contentPanel.add(lblNewLabel);
		}
		{
			scoreText = new JTextField();
			scoreText.setEditable(false);
			scoreText.setBorder(null);
			scoreText.setOpaque(false);
			scoreText.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			scoreText.setBounds(275, 10, 106, 37);
			contentPanel.add(scoreText);
			scoreText.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Do you want to Submit?");
			lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(58, 45, 234, 25);
			contentPanel.add(lblNewLabel_1);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setBounds(0, 74, 410, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				submitButton = new JButton("Submit");
				submitButton.setActionCommand("OK");
				buttonPane.add(submitButton);
				getRootPane().setDefaultButton(submitButton);
			}
			{
				tryAgainButton = new JButton("Try Again");
				tryAgainButton.setActionCommand("Cancel");
				buttonPane.add(tryAgainButton);
			}
		}
		submitButton.addActionListener(this);
		tryAgainButton.addActionListener(this);
		
		score = wrongNumber;

		scoreText.setText(wrongNumber + "");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//If user choose to submit, Open SubmitForm
		if(e.getSource() == submitButton) {
			SubmitFormDialog frame = new SubmitFormDialog(practiceMode, score);
			frame.setVisible(true);
			dispose();
		}
		
		//If user doesn't want to submit, open FullCodePractice again.
		else if(e.getSource() == tryAgainButton) {
			FullCodePractice frame = new FullCodePractice(practiceMode);
			frame.setVisible(true);
			dispose();
		}
		
	}

}
