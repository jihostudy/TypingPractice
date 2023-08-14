package mainSource;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import subSource.Timer;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Implements Timer for all the Practice Codes
public class LetterPractice extends JFrame implements ActionListener, Timer{
	//Instances
	private JPanel contentPane;
	private JButton letterButton;
	private JTextArea ButtonQ;
	private JTextArea ButtonW;
	private JTextArea ButtonR;
	private JTextArea ButtonE;
	private JTextArea ButtonT;
	private JTextArea ButtonO;
	private JTextArea ButtonP;
	private JTextArea LeftParenthesisButton;
	private JTextArea RightParenthesisButton;
	private JTextArea OrButton;
	private JLabel BackspaceButton;
	private JLabel TabButton;
	private JLabel CapsLockButton;
	private JTextArea SemicolonButton;
	private JTextArea QuotationMarkButton;
	private JLabel EnterButton;
	private JLabel LeftShiftButton;
	private JTextArea CommaButton;
	private JTextArea PeriodButton;
	private JTextArea QuestionmarkButton;
	private JLabel RightShiftButton;
	private JLabel LeftCtrlButton;
	private JLabel SpaceButton;
	private JTextArea WaveButton;
	
	private JTextArea Button1;
	private JTextArea Button2;
	private JTextArea Button3;
	private JTextArea Button4;
	private JTextArea Button5;
	private JTextArea Button6;
	private JTextArea Button7;	
	private JTextArea Button8;
	private JTextArea Button9;
	private JTextArea Button10;
	private JTextArea PlusButton;
	private JTextArea Hyphenbutton;
	
	private JLabel LeftAltButton;
	private JLabel RightAltButton;
	private JLabel RightCtrlButton;
	private JButton backButton;
	private JTextArea textArea_28;
	private JLabel lblNewLabel_20;
	private JTextField ThirdLetterInput;
	private JTextField FourthLetterInput;
	private JTextField SecondLetterInput;
	private JTextField FirstLetterInput;
	private JTextField FifthLetterInput;
	private JTextField UserInput;
	
	private JTextArea ButtonY;
	private JTextArea ButtonU;
	private JTextArea ButtonI;
	private JTextArea ButtonS;
	private JTextArea ButtonA;
	private JTextArea ButtonD;
	private JTextArea ButtonF;
	private JTextArea ButtonG;
	private JTextArea ButtonH;
	private JTextArea ButtonJ;
	private JTextArea ButtonK;
	private JTextArea ButtonL;
	private JTextArea ButtonZ;
	private JTextArea ButtonX;
	private JTextArea ButtonC;
	private JTextArea ButtonV;
	private JTextArea ButtonB;
	private JTextArea ButtonN;
	private JTextArea ButtonM;
	
	private JPanel InformationPanel;
	private JLabel TimeLabel;
	private JLabel AccurancyLabel;
	private JLabel MistakeLabel;
	private JProgressBar accurancyProgrssBar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel timeText;
	private JLabel mistakeText;
	
	/*
		'letterPracticeMode' : depends on what mode user selected
	    0 : basicKeys
	    1 : leftTopKeys
	    2 : leftBottomKeys
	    3 : rightTopKeys
	    4 : rightBottomKeys
	    5 : middleKeys
	 */
	private static int letterPracticeMode = 0; //mode selected
	
	//Used Keys for each modes
	private char[] basicKeys        = {'a','A','s','S','d','D','f','F','j','J','k','K','l','L',';','"'};
	private char[] leftTopKeys      = {'q','Q','w','W','e','E','r','R'};
	private char[] leftBottomKeys   = {'z','Z','x','X','c','C','v','V'};
	private char[] rightTopKeys     = {'u','U','i','I','o','O','p','P'};
	private char[] rightBottomKeys  = {'n','N','m','M',',','<','.','>'};
	private char[] middleKeys       = {'t','T','y','Y','g','G','h','H','b','B','n','N'};	
	private int[] randomNumberRange = {16,8,8,8,8,12}; //Index range of keys above.
	
	//Color that will used to paint keyboards
	private Color keyboardDefaultColor = new Color(255,228,196);  //Color for the keys used in specific mode
	private Color keyboardInputColor = new Color(255,160,122);    //Color that User needs to click at present
	
	//Answer Keys User needs to write
	private char inputKey;
	private char[] userInputKey = new char[5];    //5 answer keys that will be displayed
	private int[] userInputKeyColor = new int[5]; //colors of each 5 keys (0 : black, 1 : blue, 2 : red)
	
	//progress bar
	private SwingWorker<Boolean, Integer> timer;	
	private int inputNumber; //counting the solutions solved
	private int mistakes;    //number of mistakes user made
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					LetterPractice frame = new LetterPractice(letterPracticeMode);
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
	
	//Constructor : needs mode as parameter based on user selection. 
	public LetterPractice(int mode) {
		//GUI Components
		setIconImage(Toolkit.getDefaultToolkit().getImage(LetterPractice.class.getResource("/images/\uC790\uB9AC\uC5F0\uC2B5.png")));
		setTitle("Letter Practice");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		letterButton = new JButton(" Letter Practice");
		letterButton.setFocusable(false);
		letterButton.setIcon(new ImageIcon(LetterPractice.class.getResource("/images/\uC790\uB9AC\uC5F0\uC2B5.png")));
		letterButton.setHorizontalAlignment(SwingConstants.LEFT);
		letterButton.setForeground(Color.BLACK);
		letterButton.setFont(new Font("ÇÑÄÄ ÈÆ¹ÎÁ¤À½ °¡·Î¾²±â", Font.BOLD, 50));
		letterButton.setContentAreaFilled(false);
		letterButton.setBorderPainted(false);
		letterButton.setBorder(null);
		letterButton.setBackground(new Color(245, 222, 179));
		letterButton.setBounds(225, 10, 451, 88);
		contentPane.add(letterButton);
		
		ButtonQ = new JTextArea();		
		ButtonQ.setBackground(new Color(255, 255, 255));
		ButtonQ.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonQ.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonQ.setText("    Q\r\n    q");
		ButtonQ.setBounds(210, 404, 43, 43);
		contentPane.add(ButtonQ);
		
		ButtonW = new JTextArea();
		ButtonW.setBackground(new Color(255, 255, 255));
		ButtonW.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonW.setText("    W\r\n    w");
		ButtonW.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonW.setBounds(257, 404, 43, 43);
		contentPane.add(ButtonW);
		
		ButtonR = new JTextArea();
		ButtonR.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonR.setText("    R\r\n    r");
		ButtonR.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonR.setBounds(351, 404, 43, 43);
		contentPane.add(ButtonR);
		
		ButtonE = new JTextArea();
		ButtonE.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonE.setText("    E\r\n    e");
		ButtonE.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonE.setBounds(304, 404, 43, 43);
		contentPane.add(ButtonE);
		
		ButtonT = new JTextArea();
		ButtonT.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonT.setText("    T\r\n    t");
		ButtonT.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonT.setBounds(398, 404, 43, 43);
		contentPane.add(ButtonT);
		
		ButtonO = new JTextArea();
		ButtonO.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonO.setText("    O\r\n    o");
		ButtonO.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonO.setBounds(586, 404, 43, 43);
		contentPane.add(ButtonO);
		
		ButtonP = new JTextArea();
		ButtonP.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonP.setText("    P\r\n    p");
		ButtonP.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonP.setBounds(633, 404, 43, 43);
		contentPane.add(ButtonP);
		
		LeftParenthesisButton = new JTextArea();
		LeftParenthesisButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		LeftParenthesisButton.setText("    {\r\n    [");
		LeftParenthesisButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		LeftParenthesisButton.setBounds(680, 404, 43, 43);
		contentPane.add(LeftParenthesisButton);
		
		RightParenthesisButton = new JTextArea();
		RightParenthesisButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		RightParenthesisButton.setText("    }\r\n    ]");
		RightParenthesisButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		RightParenthesisButton.setBounds(727, 404, 43, 43);
		contentPane.add(RightParenthesisButton);
		
		OrButton = new JTextArea();
		OrButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		OrButton.setText("    |\r\n    \\");
		OrButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		OrButton.setBounds(774, 404, 43, 43);
		contentPane.add(OrButton);
		
		BackspaceButton = new JLabel("Backspace");
		BackspaceButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		BackspaceButton.setVerticalAlignment(SwingConstants.BOTTOM);
		BackspaceButton.setOpaque(true);
		BackspaceButton.setHorizontalAlignment(SwingConstants.RIGHT);
		BackspaceButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		BackspaceButton.setBackground(Color.WHITE);
		BackspaceButton.setBounds(730, 356, 86, 43);
		contentPane.add(BackspaceButton);
		
		TabButton = new JLabel("Tab");
		TabButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		TabButton.setVerticalAlignment(SwingConstants.BOTTOM);
		TabButton.setOpaque(true);
		TabButton.setHorizontalAlignment(SwingConstants.LEFT);
		TabButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		TabButton.setBackground(Color.WHITE);
		TabButton.setBounds(119, 404, 86, 43);
		contentPane.add(TabButton);
		
		CapsLockButton = new JLabel("Caps Lock");
		CapsLockButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		CapsLockButton.setVerticalAlignment(SwingConstants.BOTTOM);
		CapsLockButton.setOpaque(true);
		CapsLockButton.setHorizontalAlignment(SwingConstants.LEFT);
		CapsLockButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		CapsLockButton.setBackground(Color.WHITE);
		CapsLockButton.setBounds(119, 452, 95, 43);
		contentPane.add(CapsLockButton);
		
		SemicolonButton = new JTextArea();
		SemicolonButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		SemicolonButton.setText("    :\r\n    ;");
		SemicolonButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		SemicolonButton.setBounds(642, 452, 43, 43);
		contentPane.add(SemicolonButton);
		
		QuotationMarkButton = new JTextArea();
		QuotationMarkButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		QuotationMarkButton.setText("    \"\r\n    '");
		QuotationMarkButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		QuotationMarkButton.setBounds(689, 452, 43, 43);
		contentPane.add(QuotationMarkButton);
		
		EnterButton = new JLabel("Enter");
		EnterButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		EnterButton.setVerticalAlignment(SwingConstants.BOTTOM);
		EnterButton.setOpaque(true);
		EnterButton.setHorizontalAlignment(SwingConstants.RIGHT);
		EnterButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		EnterButton.setBackground(Color.WHITE);
		EnterButton.setBounds(736, 452, 81, 43);
		contentPane.add(EnterButton);
		
		LeftShiftButton = new JLabel("Shift");
		LeftShiftButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		LeftShiftButton.setVerticalAlignment(SwingConstants.BOTTOM);
		LeftShiftButton.setOpaque(true);
		LeftShiftButton.setHorizontalAlignment(SwingConstants.LEFT);
		LeftShiftButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		LeftShiftButton.setBackground(Color.WHITE);
		LeftShiftButton.setBounds(119, 500, 122, 43);
		contentPane.add(LeftShiftButton);
		
		CommaButton = new JTextArea();
		CommaButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		CommaButton.setText("    <\r\n    ,");
		CommaButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		CommaButton.setBounds(576, 500, 43, 43);
		contentPane.add(CommaButton);
		
		PeriodButton = new JTextArea();
		PeriodButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		PeriodButton.setText("    >\r\n    .");
		PeriodButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		PeriodButton.setBounds(624, 500, 43, 43);
		contentPane.add(PeriodButton);
		
		QuestionmarkButton = new JTextArea();
		QuestionmarkButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		QuestionmarkButton.setText("    ?\r\n    /");
		QuestionmarkButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		QuestionmarkButton.setBounds(671, 500, 43, 43);
		contentPane.add(QuestionmarkButton);
		
		RightShiftButton = new JLabel("Shift");
		RightShiftButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		RightShiftButton.setVerticalAlignment(SwingConstants.BOTTOM);
		RightShiftButton.setOpaque(true);
		RightShiftButton.setHorizontalAlignment(SwingConstants.RIGHT);
		RightShiftButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		RightShiftButton.setBackground(Color.WHITE);
		RightShiftButton.setBounds(718, 500, 99, 43);
		contentPane.add(RightShiftButton);
		
		LeftCtrlButton = new JLabel("Ctrl");
		LeftCtrlButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		LeftCtrlButton.setVerticalAlignment(SwingConstants.BOTTOM);
		LeftCtrlButton.setOpaque(true);
		LeftCtrlButton.setHorizontalAlignment(SwingConstants.LEFT);
		LeftCtrlButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		LeftCtrlButton.setBackground(Color.WHITE);
		LeftCtrlButton.setBounds(119, 548, 57, 43);
		contentPane.add(LeftCtrlButton);
		
		SpaceButton = new JLabel("");
		SpaceButton.setVerticalAlignment(SwingConstants.BOTTOM);
		SpaceButton.setOpaque(true);
		SpaceButton.setHorizontalAlignment(SwingConstants.LEFT);
		SpaceButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		SpaceButton.setBackground(Color.WHITE);
		SpaceButton.setBounds(243, 548, 451, 43);
		contentPane.add(SpaceButton);
		
		WaveButton = new JTextArea();
		WaveButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		WaveButton.setText("    ~\r\n    `");
		WaveButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		WaveButton.setBounds(119, 356, 43, 43);
		contentPane.add(WaveButton);
		
		Button1 = new JTextArea();
		Button1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button1.setText("    !\r\n    1");
		Button1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Button1.setBounds(166, 356, 43, 43);
		contentPane.add(Button1);
		
		Button2 = new JTextArea();
		Button2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button2.setText("    @\r\n    2");
		Button2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button2.setBounds(213, 356, 43, 43);
		contentPane.add(Button2);
		
		Button3 = new JTextArea();
		Button3.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button3.setText("    #\r\n    3");
		Button3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button3.setBounds(260, 356, 43, 43);
		contentPane.add(Button3);
		
		Button4 = new JTextArea();
		Button4.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button4.setText("    $\r\n    4");
		Button4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button4.setBounds(307, 356, 43, 43);
		contentPane.add(Button4);
		
		Button5 = new JTextArea();
		Button5.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button5.setText("    %\r\n    5");
		Button5.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button5.setBounds(354, 356, 43, 43);
		contentPane.add(Button5);
		
		Button6 = new JTextArea();
		Button6.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button6.setText("    ^\r\n    6");
		Button6.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button6.setBounds(401, 356, 43, 43);
		contentPane.add(Button6);
		
		Button7 = new JTextArea();
		Button7.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button7.setText("    &\r\n    7");
		Button7.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button7.setBounds(448, 356, 43, 43);
		contentPane.add(Button7);
		
		PlusButton = new JTextArea();
		PlusButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		PlusButton.setText("    +\r\n    =");
		PlusButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		PlusButton.setBounds(683, 356, 43, 43);
		contentPane.add(PlusButton);
		
		Button8 = new JTextArea();
		Button8.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button8.setText("    *\r\n    8");
		Button8.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button8.setBounds(495, 356, 43, 43);
		contentPane.add(Button8);
		
		Button9 = new JTextArea();
		Button9.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button9.setText("    (\r\n    9");
		Button9.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button9.setBounds(542, 356, 43, 43);
		contentPane.add(Button9);
		
		Button10 = new JTextArea();
		Button10.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button10.setText("    )\r\n    0");
		Button10.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button10.setBounds(589, 356, 43, 43);
		contentPane.add(Button10);
		
		Hyphenbutton = new JTextArea();
		Hyphenbutton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Hyphenbutton.setText("    _\r\n    -");
		Hyphenbutton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Hyphenbutton.setBounds(636, 356, 43, 43);
		contentPane.add(Hyphenbutton);
		
		LeftAltButton = new JLabel("Alt");
		LeftAltButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		LeftAltButton.setVerticalAlignment(SwingConstants.BOTTOM);
		LeftAltButton.setOpaque(true);
		LeftAltButton.setHorizontalAlignment(SwingConstants.LEFT);
		LeftAltButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		LeftAltButton.setBackground(Color.WHITE);
		LeftAltButton.setBounds(181, 548, 57, 43);
		contentPane.add(LeftAltButton);
		
		RightCtrlButton = new JLabel("Ctrl");
		RightCtrlButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		RightCtrlButton.setVerticalAlignment(SwingConstants.BOTTOM);
		RightCtrlButton.setOpaque(true);
		RightCtrlButton.setHorizontalAlignment(SwingConstants.LEFT);
		RightCtrlButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		RightCtrlButton.setBackground(Color.WHITE);
		RightCtrlButton.setBounds(698, 548, 57, 43);
		contentPane.add(RightCtrlButton);
		
		RightAltButton = new JLabel("Alt");
		RightAltButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		RightAltButton.setVerticalAlignment(SwingConstants.BOTTOM);
		RightAltButton.setOpaque(true);
		RightAltButton.setHorizontalAlignment(SwingConstants.LEFT);
		RightAltButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		RightAltButton.setBackground(Color.WHITE);
		RightAltButton.setBounds(760, 548, 57, 43);
		contentPane.add(RightAltButton);
		
		backButton = new JButton("Back");
		
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setBorderPainted(false);
		backButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		backButton.setFocusable(false);
		backButton.setBounds(12, 10, 95, 23);
		contentPane.add(backButton);
		
		lblNewLabel_20 = new JLabel("Letter");
		lblNewLabel_20.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBounds(413, 103, 95, 15);
		contentPane.add(lblNewLabel_20);
		
		ThirdLetterInput = new JTextField();
		ThirdLetterInput.setFocusable(false);
		ThirdLetterInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		ThirdLetterInput.setFont(new Font("±¼¸²", Font.BOLD, 34));
		ThirdLetterInput.setHorizontalAlignment(SwingConstants.CENTER);
		ThirdLetterInput.setBounds(413, 128, 93, 81);
		contentPane.add(ThirdLetterInput);
		ThirdLetterInput.setColumns(10);
		
		FourthLetterInput = new JTextField();
		FourthLetterInput.setFocusable(false);
		FourthLetterInput.setHorizontalAlignment(SwingConstants.CENTER);
		FourthLetterInput.setFont(new Font("±¼¸²", Font.BOLD, 34));
		FourthLetterInput.setColumns(10);
		FourthLetterInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		FourthLetterInput.setBounds(523, 128, 93, 81);
		contentPane.add(FourthLetterInput);
		
		SecondLetterInput = new JTextField();
		SecondLetterInput.setFocusable(false);
		SecondLetterInput.setHorizontalAlignment(SwingConstants.CENTER);
		SecondLetterInput.setFont(new Font("±¼¸²", Font.BOLD, 34));
		SecondLetterInput.setColumns(10);
		SecondLetterInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		SecondLetterInput.setBounds(302, 128, 93, 81);
		contentPane.add(SecondLetterInput);
		
		FirstLetterInput = new JTextField();
		FirstLetterInput.setFocusable(false);
		FirstLetterInput.setHorizontalAlignment(SwingConstants.CENTER);
		FirstLetterInput.setFont(new Font("±¼¸²", Font.BOLD, 34));
		FirstLetterInput.setColumns(10);
		FirstLetterInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		FirstLetterInput.setBounds(190, 128, 93, 81);
		contentPane.add(FirstLetterInput);
		
		FifthLetterInput = new JTextField();
		FifthLetterInput.setFocusable(false);
		FifthLetterInput.setHorizontalAlignment(SwingConstants.CENTER);
		FifthLetterInput.setFont(new Font("±¼¸²", Font.BOLD, 34));
		FifthLetterInput.setColumns(10);
		FifthLetterInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		FifthLetterInput.setBounds(631, 128, 93, 81);
		contentPane.add(FifthLetterInput);
		
		textArea_28 = new JTextArea();
		textArea_28.setFocusable(false);
		textArea_28.setBounds(139, 94, 653, 132);
		contentPane.add(textArea_28);
		
		UserInput = new JTextField();
		UserInput.setHorizontalAlignment(SwingConstants.CENTER);
		UserInput.setFont(new Font("±¼¸²", Font.BOLD, 34));
		UserInput.setColumns(10);
		UserInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		UserInput.setBounds(413, 248, 93, 81);
		contentPane.add(UserInput);
		
		ButtonY = new JTextArea();
		ButtonY.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonY.setText("    Y\r\n    y");
		ButtonY.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonY.setBounds(445, 404, 43, 43);
		contentPane.add(ButtonY);
		
		ButtonU = new JTextArea();
		ButtonU.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonU.setText("    U\r\n    u");
		ButtonU.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonU.setBounds(492, 404, 43, 43);
		contentPane.add(ButtonU);
		
		ButtonI = new JTextArea();
		ButtonI.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonI.setText("     I\r\n     i");
		ButtonI.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonI.setBounds(539, 404, 43, 43);
		contentPane.add(ButtonI);
		
		ButtonS = new JTextArea();
		ButtonS.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonS.setText("    S\r\n    s");
		ButtonS.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonS.setBounds(266, 452, 43, 43);
		contentPane.add(ButtonS);
		
		ButtonA = new JTextArea();
		ButtonA.setText("    A\r\n    a");
		ButtonA.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonA.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonA.setBounds(219, 452, 43, 43);
		contentPane.add(ButtonA);
		
		ButtonD = new JTextArea();
		ButtonD.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonD.setText("    D\r\n    d");
		ButtonD.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonD.setBounds(313, 452, 43, 43);
		contentPane.add(ButtonD);
		
		ButtonF = new JTextArea();
		ButtonF.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonF.setText("    F\r\n    f");
		ButtonF.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonF.setBounds(360, 452, 43, 43);
		contentPane.add(ButtonF);
		
		ButtonG = new JTextArea();
		ButtonG.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonG.setText("    G\r\n    g");
		ButtonG.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonG.setBounds(407, 452, 43, 43);
		contentPane.add(ButtonG);
		
		ButtonH = new JTextArea();
		ButtonH.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonH.setText("    H\r\n    h");
		ButtonH.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonH.setBounds(455, 452, 43, 43);
		contentPane.add(ButtonH);
		
		ButtonJ = new JTextArea();
		ButtonJ.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonJ.setText("    J\r\n    j");
		ButtonJ.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonJ.setBounds(501, 452, 43, 43);
		contentPane.add(ButtonJ);
		
		ButtonK = new JTextArea();
		ButtonK.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonK.setText("    K\r\n    k");
		ButtonK.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonK.setBounds(548, 452, 43, 43);
		contentPane.add(ButtonK);
		
		ButtonL = new JTextArea();
		ButtonL.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonL.setText("    L\r\n    l");
		ButtonL.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonL.setBounds(595, 452, 43, 43);
		contentPane.add(ButtonL);
		
		ButtonZ = new JTextArea();
		ButtonZ.setText("    Z\r\n    z");
		ButtonZ.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		ButtonZ.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonZ.setBounds(246, 500, 43, 43);
		contentPane.add(ButtonZ);
		 
		ButtonX = new JTextArea();
		ButtonX.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonX.setText("    X\r\n    x");
		ButtonX.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonX.setBounds(293, 500, 43, 43);
		contentPane.add(ButtonX);
		
		ButtonC = new JTextArea();
		ButtonC.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonC.setText("    C\r\n    c");
		ButtonC.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonC.setBounds(340, 500, 43, 43);
		contentPane.add(ButtonC);
		
		ButtonV = new JTextArea();
		ButtonV.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonV.setText("    V\r\n    v");
		ButtonV.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonV.setBounds(387, 500, 43, 43);
		contentPane.add(ButtonV);
		
		ButtonB = new JTextArea();
		ButtonB.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonB.setText("    B\r\n    b");
		ButtonB.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonB.setBounds(434, 500, 43, 43);
		contentPane.add(ButtonB);
		
		ButtonN = new JTextArea();
		ButtonN.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonN.setText("    N\r\n    n");
		ButtonN.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonN.setBounds(481, 500, 43, 43);
		contentPane.add(ButtonN);
		
		ButtonM = new JTextArea();
		ButtonM.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonM.setText("    M\r\n    m");
		ButtonM.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonM.setBounds(528, 500, 43, 43);
		contentPane.add(ButtonM);
		
		InformationPanel = new JPanel();
		InformationPanel.setBounds(26, 236, 176, 99);
		contentPane.add(InformationPanel);
		InformationPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		TimeLabel = new JLabel("Time : ");
		TimeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		TimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		TimeLabel.setBackground(Color.WHITE);
		TimeLabel.setOpaque(true);
		InformationPanel.add(TimeLabel);
		
		timeText = new JLabel("");
		timeText.setOpaque(true);
		timeText.setBackground(Color.WHITE);
		timeText.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		timeText.setHorizontalAlignment(SwingConstants.CENTER);
		InformationPanel.add(timeText);
		
		AccurancyLabel = new JLabel("Accurancy : ");
		AccurancyLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		AccurancyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AccurancyLabel.setOpaque(true);
		AccurancyLabel.setBackground(Color.WHITE);
		InformationPanel.add(AccurancyLabel);
		
		accurancyProgrssBar = new JProgressBar();
		accurancyProgrssBar.setForeground(new Color(255, 153, 0));
		accurancyProgrssBar.setBorderPainted(false);
		accurancyProgrssBar.setBorder(null);
		accurancyProgrssBar.setOpaque(true);
		accurancyProgrssBar.setBackground(Color.WHITE);
		accurancyProgrssBar.setStringPainted(true);
		InformationPanel.add(accurancyProgrssBar);
		
		MistakeLabel = new JLabel("Mistakes : ");
		MistakeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		MistakeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		MistakeLabel.setOpaque(true);
		MistakeLabel.setBackground(Color.WHITE);
		InformationPanel.add(MistakeLabel);
		
		mistakeText = new JLabel("");
		mistakeText.setOpaque(true);
		mistakeText.setBackground(Color.WHITE);
		mistakeText.setHorizontalAlignment(SwingConstants.CENTER);
		mistakeText.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		InformationPanel.add(mistakeText);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(111, 348, 715, 252);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LetterPractice.class.getResource("/images/IntroBackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 912, 629);
		contentPane.add(lblNewLabel_2);
		
		//KeyListener to Listen input immediately
		MyKeyListener keyListener = new MyKeyListener();
		UserInput.addKeyListener(keyListener);		
		UserInput.requestFocus();
		
		backButton.addActionListener(this);
		
		//Save the mode User Selected (letterPracticeMode is static to use in main Function above)
		this.letterPracticeMode = mode;
		
		//Depending on the mode change the Color of keys used
		changeKeyboardDeafultColor();
		
		//Initialize the Answer keys
		for(int i = 2; i < 5; i++) {			
			userInputKey[i] = randomCharacterGenerator(); //get random char in range of selected mode
		}
		String tmp;
		tmp = String.valueOf(userInputKey[2]);
		ThirdLetterInput.setText(tmp);	
		tmp = String.valueOf(userInputKey[3]);
		FourthLetterInput.setText(tmp);
		tmp = String.valueOf(userInputKey[4]);
		FifthLetterInput.setText(tmp);
		
		//Change Color that needs to be written first
		changeKeyboardColor(userInputKey[2], keyboardInputColor);
		
		//Start timer by using Another Thread
		startTimer();
	}
	
	public class MyKeyListener implements KeyListener{		
		@Override
		public void keyPressed(KeyEvent e) {
			//Empty (Prevent Error)
		}
		@Override
		public void keyTyped(KeyEvent e) {		
			inputKey = e.getKeyChar();			
			
			//Correct answer from user
			if(inputKey == userInputKey[2])  
			{
				userInputKeyColor[2] = 1;	//1 : Blue			
			}
			
			//Wrong answer from user
			else  
			{
				userInputKeyColor[2] = 2;  //2 : Red
				mistakes++;
			}
			shiftLeft();	   			  //shift answers left		
			changeInputColor();			  //color previous answers (correct: blue(1), wrong: red(2))
			changeKeyboardDeafultColor(); //change the Color used again to deafultColor
			
			//Making the ProgressBars 
			inputNumber++;
			accurancyProgrssBar.setValue((int)(100*(double)(inputNumber - mistakes) / inputNumber));
			mistakeText.setText(mistakes + "");			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			//Change KeyboardColor by new Answer to write
			changeKeyboardColor(userInputKey[2], keyboardInputColor);
			UserInput.setText("");			
		}	
	}
	
	//"randomCharacterGenerator" Generates random char depending on the mode user selected. 
	public char randomCharacterGenerator() {
		Random random = new Random();
		int randomIndex = random.nextInt(randomNumberRange[letterPracticeMode]);
		char randomCharacter = '.';		// '.' : Initial value(no meaning) 
		switch (letterPracticeMode) 
		{			
			case 0: {				
				randomCharacter = basicKeys[randomIndex];
				break;
			}
			case 1: {				
				randomCharacter = leftTopKeys[randomIndex];
				break;
			}
			case 2: {				
				randomCharacter = leftBottomKeys[randomIndex];
				break;
			}
			case 3: {				
				randomCharacter = rightTopKeys[randomIndex];
				break;
			}
			case 4: {				
				randomCharacter = rightBottomKeys[randomIndex];
				break;
			}
			case 5: {				
				randomCharacter = middleKeys[randomIndex];
				break;
			}
		}
		return randomCharacter;
	}
	
	//"shiftLeft" will shift the answers left and random generate last answer to be written
	public void shiftLeft() {
		//shift array elements Left
		for(int i = 0; i < 4; i++) {
			userInputKey[i] = userInputKey[i+1];
			userInputKeyColor[i] = userInputKeyColor[i+1];
		}
		userInputKeyColor[4] = 0;
		//make random character for the last element
		userInputKey[4] = randomCharacterGenerator();
		
		//display
		String tmp;
		tmp = String.valueOf(userInputKey[0]);
		FirstLetterInput.setText(tmp);		
		tmp = String.valueOf(userInputKey[1]);
		SecondLetterInput.setText(tmp);
		tmp = String.valueOf(userInputKey[2]);
		ThirdLetterInput.setText(tmp);
		tmp = String.valueOf(userInputKey[3]);
		FourthLetterInput.setText(tmp);
		tmp = String.valueOf(userInputKey[4]);
		FifthLetterInput.setText(tmp);	
	}
	
	//"changeInputColor" changes previous answer's color
	public void changeInputColor() {
		//FirstLetter Change color		
		if(userInputKeyColor[0] == 1) {FirstLetterInput.setForeground(Color.BLUE);}
		else                          {FirstLetterInput.setForeground(Color.RED);}
		//SecondLetter Change color		
		if(userInputKeyColor[1] == 1) {SecondLetterInput.setForeground(Color.BLUE);}
		else                          {SecondLetterInput.setForeground(Color.RED);}		
	}
	
	//"changeKeyboardDeafultColor" changes used keys depending on mode selected.
	public void changeKeyboardDeafultColor() {
		switch (letterPracticeMode) {
			case 0: {
				ButtonA.setBackground(keyboardDefaultColor);
				ButtonS.setBackground(keyboardDefaultColor);
				ButtonD.setBackground(keyboardDefaultColor);
				ButtonF.setBackground(keyboardDefaultColor);
				ButtonJ.setBackground(keyboardDefaultColor);
				ButtonK.setBackground(keyboardDefaultColor);
				ButtonL.setBackground(keyboardDefaultColor);
				SemicolonButton.setBackground(keyboardDefaultColor);
				QuotationMarkButton.setBackground(keyboardDefaultColor);
				break;
			}
			case 1: {
				ButtonQ.setBackground(keyboardDefaultColor);
				ButtonW.setBackground(keyboardDefaultColor);
				ButtonE.setBackground(keyboardDefaultColor);
				ButtonR.setBackground(keyboardDefaultColor);		
				break;
			}
			case 2: {
				ButtonZ.setBackground(keyboardDefaultColor);
				ButtonX.setBackground(keyboardDefaultColor);
				ButtonC.setBackground(keyboardDefaultColor);
				ButtonV.setBackground(keyboardDefaultColor);	
				break;
			}
			case 3: {
				ButtonU.setBackground(keyboardDefaultColor);
				ButtonI.setBackground(keyboardDefaultColor);
				ButtonO.setBackground(keyboardDefaultColor);
				ButtonP.setBackground(keyboardDefaultColor);	
				break;
			}
			case 4: {
				ButtonN.setBackground(keyboardDefaultColor);
				ButtonM.setBackground(keyboardDefaultColor);
				CommaButton.setBackground(keyboardDefaultColor);
				PeriodButton.setBackground(keyboardDefaultColor);	
				break;
			}
			case 5: {
				ButtonT.setBackground(keyboardDefaultColor);
				ButtonY.setBackground(keyboardDefaultColor);
				ButtonG.setBackground(keyboardDefaultColor);
				ButtonH.setBackground(keyboardDefaultColor);			
				ButtonB.setBackground(keyboardDefaultColor);
				ButtonN.setBackground(keyboardDefaultColor);
				break;
			}
		}
	}
	
	//"changeKeyboardColor" are used to change color that needs to be written
	public void changeKeyboardColor(char input, Color color) {
		if((input == 'q') || (input == 'Q'))      {ButtonQ.setBackground(color);}
		else if((input == 'w') || (input == 'W')) {ButtonW.setBackground(color);}
		else if((input == 'e') || (input == 'E')) {ButtonE.setBackground(color);}
		else if((input == 'r') || (input == 'R')) {ButtonR.setBackground(color);}
		else if((input == 't') || (input == 'T')) {ButtonT.setBackground(color);}
		else if((input == 'y') || (input == 'Y')) {ButtonY.setBackground(color);}
		else if((input == 'u') || (input == 'U')) {ButtonU.setBackground(color);}
		else if((input == 'i') || (input == 'I')) {ButtonI.setBackground(color);}
		else if((input == 'o') || (input == 'O')) {ButtonO.setBackground(color);}
		else if((input == 'p') || (input == 'P')) {ButtonP.setBackground(color);}
		else if((input == 'a') || (input == 'A')) {ButtonA.setBackground(color);}
		else if((input == 's') || (input == 'S')) {ButtonS.setBackground(color);}
		else if((input == 'd') || (input == 'D')) {ButtonD.setBackground(color);}
		else if((input == 'f') || (input == 'F')) {ButtonF.setBackground(color);}
		else if((input == 'g') || (input == 'G')) {ButtonG.setBackground(color);}
		else if((input == 'h') || (input == 'H')) {ButtonH.setBackground(color);}
		else if((input == 'j') || (input == 'J')) {ButtonJ.setBackground(color);}
		else if((input == 'k') || (input == 'K')) {ButtonK.setBackground(color);}
		else if((input == 'l') || (input == 'L')) {ButtonL.setBackground(color);}
		else if(input == ';') 					  {SemicolonButton.setBackground(color);}
		else if(input == '"') 					  {QuotationMarkButton.setBackground(color);}
		else if((input == 'z') || (input == 'Z')) {ButtonZ.setBackground(color);}
		else if((input == 'x') || (input == 'X')) {ButtonX.setBackground(color);}
		else if((input == 'c') || (input == 'C')) {ButtonC.setBackground(color);}
		else if((input == 'v') || (input == 'V')) {ButtonV.setBackground(color);}
		else if((input == 'b') || (input == 'B')) {ButtonB.setBackground(color);}
		else if((input == 'n') || (input == 'N')) {ButtonN.setBackground(color);}
		else if((input == 'm') || (input == 'M')) {ButtonM.setBackground(color);}
		else if((input == ',') || (input == '<')) {CommaButton.setBackground(color);}
		else if((input == '.') || (input == '>')) {PeriodButton.setBackground(color);}		
	}
	
	//ActionListener
	//Go to StartPage if backButton is clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			StartPage convertFrame = new StartPage();
			convertFrame.setVisible(true);
			dispose(); 
		}		
	}		
	
	//To make progress bars and Timer(abstract method of Timer interface)
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
