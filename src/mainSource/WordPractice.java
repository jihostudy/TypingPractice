package mainSource;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import subSource.Timer;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class WordPractice extends JFrame implements ActionListener, Timer{
	//Instances
	private JPanel contentPane;
	private JButton btnWordPractice;
	private JButton backButton;
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
	private JTextArea Hyphenbutton;
	private JTextArea PlusButton;
	private JLabel BackspaceButton;
	private JTextArea OrButton;
	private JTextArea RightParenthesisButton;
	private JTextArea LeftParenthesisButton;
	private JTextArea ButtonP;
	private JTextArea ButtonI;
	private JTextArea ButtonO;
	private JTextArea ButtonU;
	private JTextArea ButtonY;
	private JTextArea ButtonT;
	private JTextArea ButtonR;
	private JTextArea ButtonE;
	private JTextArea ButtonW;
	private JTextArea ButtonQ;	
	private JTextArea ButtonZ;
	private JTextArea ButtonA;
	private JTextArea ButtonS;
	private JTextArea ButtonX;
	private JTextArea ButtonD;
	private JTextArea ButtonC;
	private JTextArea ButtonF;
	private JTextArea ButtonV;
	private JTextArea ButtonG;
	private JTextArea ButtonB;
	private JTextArea ButtonH;
	private JTextArea ButtonN;
	private JTextArea ButtonJ;
	private JTextArea ButtonM;
	private JTextArea ButtonK;
	private JTextArea ButtonL;
	private JLabel TabButton;
	private JLabel CapsLockButton;
	private JLabel LeftShiftButton;
	private JLabel LeftCtrlButton;
	private JLabel LeftAltButton;
	private JTextArea CommaButton;	
	private JTextArea PeriodButton;
	private JTextArea SemicolonButton;
	private JTextArea QuestionmarkButton;
	private JTextArea QuotationMarkButton;
	private JLabel RightShiftButton;
	private JLabel RightAltButton;
	private JLabel RightCtrlButton;
	private JLabel SpacebarButton;
	private JLabel lblNewLabel;
	private JPanel InformationPanel;
	private JLabel TimeLabel;
	private JLabel timeText;
	private JLabel AccurancyLabel;
	private JProgressBar accurancyProgrssBar;
	private JLabel MistakeLabel;
	private JLabel mistakeText;
	private JLabel lblNewLabel_1;
	private JTextArea textArea;
	private JTextField FirstWordInput;
	private JTextField SecondWordInput;
	private JTextField ThirdWordInput;
	private JTextField UserInput;	
	private JButton EnterButton;
	private JLabel lblNewLabel_2;
	
	//Create Answer Words that will be displayed
	private CreateWordInput createInput = new CreateWordInput();
	
	//Answer Words User needs to write
	private String inputString;
	private String[] userInputString = new String[3];
	private int firstInputcolor;
	
	private int index; //Current index that needs to be pressed	
	private Color keyboardInputColor = new Color(255,160,122); //Color that will used to paint keyboards
	
	//progress bar
	private SwingWorker<Boolean, Integer> timer;
	private int inputNumber;
	private int mistakes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordPractice frame = new WordPractice();
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
	public WordPractice() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WordPractice.class.getResource("/images/\uB0B1\uB9D0\uC5F0\uC2B5.png")));
		setResizable(false);
		setTitle("Word Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnWordPractice = new JButton(" Word Practice");
		btnWordPractice.setIcon(new ImageIcon(WordPractice.class.getResource("/images/\uB0B1\uB9D0\uC5F0\uC2B5.png")));
		btnWordPractice.setHorizontalAlignment(SwingConstants.LEFT);
		btnWordPractice.setForeground(Color.BLACK);
		btnWordPractice.setFont(new Font("ÇÑÄÄ ÈÆ¹ÎÁ¤À½ °¡·Î¾²±â", Font.BOLD, 50));
		btnWordPractice.setFocusable(false);
		btnWordPractice.setContentAreaFilled(false);
		btnWordPractice.setBorderPainted(false);
		btnWordPractice.setBorder(null);
		btnWordPractice.setBackground(new Color(245, 222, 179));
		btnWordPractice.setBounds(255, 10, 451, 88);
		contentPane.add(btnWordPractice);
		
		backButton = new JButton("Back");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		backButton.setFocusable(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(12, 10, 95, 23);
		contentPane.add(backButton);
		
		WaveButton = new JTextArea();
		WaveButton.setText("    ~\r\n    `");
		WaveButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		WaveButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		WaveButton.setBounds(120, 356, 43, 43);
		contentPane.add(WaveButton);
		
		Button1 = new JTextArea();
		Button1.setText("    !\r\n    1");
		Button1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Button1.setBounds(167, 356, 43, 43);
		contentPane.add(Button1);
		
		Button2 = new JTextArea();
		Button2.setText("    @\r\n    2");
		Button2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button2.setBounds(214, 356, 43, 43);
		contentPane.add(Button2);
		
		Button3 = new JTextArea();
		Button3.setText("    #\r\n    3");
		Button3.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button3.setBounds(261, 356, 43, 43);
		contentPane.add(Button3);
		
		Button4 = new JTextArea();
		Button4.setText("    $\r\n    4");
		Button4.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button4.setBounds(308, 356, 43, 43);
		contentPane.add(Button4);
		
		Button5 = new JTextArea();
		Button5.setText("    %\r\n    5");
		Button5.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button5.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button5.setBounds(355, 356, 43, 43);
		contentPane.add(Button5);
		
		Button6 = new JTextArea();
		Button6.setText("    ^\r\n    6");
		Button6.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button6.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button6.setBounds(402, 356, 43, 43);
		contentPane.add(Button6);
		
		Button7 = new JTextArea();
		Button7.setText("    &\r\n    7");
		Button7.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button7.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button7.setBounds(449, 356, 43, 43);
		contentPane.add(Button7);
		
		Button8 = new JTextArea();
		Button8.setText("    *\r\n    8");
		Button8.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button8.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button8.setBounds(496, 356, 43, 43);
		contentPane.add(Button8);
		
		Button9 = new JTextArea();
		Button9.setText("    (\r\n    9");
		Button9.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button9.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button9.setBounds(543, 356, 43, 43);
		contentPane.add(Button9);
		
		Button10 = new JTextArea();
		Button10.setText("    )\r\n    0");
		Button10.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Button10.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Button10.setBounds(590, 356, 43, 43);
		contentPane.add(Button10);
		
		Hyphenbutton = new JTextArea();
		Hyphenbutton.setText("    _\r\n    -");
		Hyphenbutton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		Hyphenbutton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		Hyphenbutton.setBounds(637, 356, 43, 43);
		contentPane.add(Hyphenbutton);
		
		PlusButton = new JTextArea();
		PlusButton.setText("    +\r\n    =");
		PlusButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		PlusButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		PlusButton.setBounds(684, 356, 43, 43);
		contentPane.add(PlusButton);
		
		BackspaceButton = new JLabel("Backspace");
		BackspaceButton.setVerticalAlignment(SwingConstants.BOTTOM);
		BackspaceButton.setOpaque(true);
		BackspaceButton.setHorizontalAlignment(SwingConstants.RIGHT);
		BackspaceButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		BackspaceButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		BackspaceButton.setBackground(Color.WHITE);
		BackspaceButton.setBounds(731, 356, 86, 43);
		contentPane.add(BackspaceButton);
		
		OrButton = new JTextArea();
		OrButton.setText("    |\r\n    \\");
		OrButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		OrButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		OrButton.setBounds(775, 404, 43, 43);
		contentPane.add(OrButton);
		
		RightParenthesisButton = new JTextArea();
		RightParenthesisButton.setText("    }\r\n    ]");
		RightParenthesisButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		RightParenthesisButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		RightParenthesisButton.setBounds(728, 404, 43, 43);
		contentPane.add(RightParenthesisButton);
		
		LeftParenthesisButton = new JTextArea();
		LeftParenthesisButton.setText("    {\r\n    [");
		LeftParenthesisButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		LeftParenthesisButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		LeftParenthesisButton.setBounds(681, 404, 43, 43);
		contentPane.add(LeftParenthesisButton);
		
		ButtonP = new JTextArea();
		ButtonP.setText("    P\r\n    p");
		ButtonP.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonP.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonP.setBounds(634, 404, 43, 43);
		contentPane.add(ButtonP);
		
		ButtonI = new JTextArea();
		ButtonI.setText("     I\r\n     i");
		ButtonI.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonI.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonI.setBounds(540, 404, 43, 43);
		contentPane.add(ButtonI);
		
		ButtonO = new JTextArea();
		ButtonO.setText("    O\r\n    o");
		ButtonO.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonO.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonO.setBounds(587, 404, 43, 43);
		contentPane.add(ButtonO);
		
		ButtonU = new JTextArea();
		ButtonU.setText("    U\r\n    u");
		ButtonU.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonU.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonU.setBounds(493, 404, 43, 43);
		contentPane.add(ButtonU);
		
		ButtonY = new JTextArea();
		ButtonY.setText("    Y\r\n    y");
		ButtonY.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonY.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonY.setBounds(446, 404, 43, 43);
		contentPane.add(ButtonY);
		
		ButtonT = new JTextArea();
		ButtonT.setText("    T\r\n    t");
		ButtonT.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonT.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonT.setBounds(399, 404, 43, 43);
		contentPane.add(ButtonT);
		
		ButtonR = new JTextArea();
		ButtonR.setText("    R\r\n    r");
		ButtonR.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonR.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonR.setBounds(352, 404, 43, 43);
		contentPane.add(ButtonR);
		
		ButtonE = new JTextArea();
		ButtonE.setText("    E\r\n    e");
		ButtonE.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonE.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonE.setBounds(305, 404, 43, 43);
		contentPane.add(ButtonE);
		
		ButtonW = new JTextArea();
		ButtonW.setText("    W\r\n    w");
		ButtonW.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonW.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonW.setBackground(Color.WHITE);
		ButtonW.setBounds(258, 404, 43, 43);
		contentPane.add(ButtonW);
		
		ButtonQ = new JTextArea();
		ButtonQ.setText("    Q\r\n    q");
		ButtonQ.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonQ.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonQ.setBackground(Color.WHITE);
		ButtonQ.setBounds(211, 404, 43, 43);
		contentPane.add(ButtonQ);
		
		TabButton = new JLabel("Tab");
		TabButton.setVerticalAlignment(SwingConstants.BOTTOM);
		TabButton.setOpaque(true);
		TabButton.setHorizontalAlignment(SwingConstants.LEFT);
		TabButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		TabButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		TabButton.setBackground(Color.WHITE);
		TabButton.setBounds(120, 404, 86, 43);
		contentPane.add(TabButton);
		
		CapsLockButton = new JLabel("Caps Lock");
		CapsLockButton.setVerticalAlignment(SwingConstants.BOTTOM);
		CapsLockButton.setOpaque(true);
		CapsLockButton.setHorizontalAlignment(SwingConstants.LEFT);
		CapsLockButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		CapsLockButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		CapsLockButton.setBackground(Color.WHITE);
		CapsLockButton.setBounds(120, 452, 95, 43);
		contentPane.add(CapsLockButton);
		
		LeftShiftButton = new JLabel("Shift");
		LeftShiftButton.setVerticalAlignment(SwingConstants.BOTTOM);
		LeftShiftButton.setOpaque(true);
		LeftShiftButton.setHorizontalAlignment(SwingConstants.LEFT);
		LeftShiftButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		LeftShiftButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		LeftShiftButton.setBackground(Color.WHITE);
		LeftShiftButton.setBounds(120, 500, 122, 43);
		contentPane.add(LeftShiftButton);
		
		LeftCtrlButton = new JLabel("Ctrl");
		LeftCtrlButton.setVerticalAlignment(SwingConstants.BOTTOM);
		LeftCtrlButton.setOpaque(true);
		LeftCtrlButton.setHorizontalAlignment(SwingConstants.LEFT);
		LeftCtrlButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		LeftCtrlButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		LeftCtrlButton.setBackground(Color.WHITE);
		LeftCtrlButton.setBounds(120, 548, 57, 43);
		contentPane.add(LeftCtrlButton);
		
		LeftAltButton = new JLabel("Alt");
		LeftAltButton.setVerticalAlignment(SwingConstants.BOTTOM);
		LeftAltButton.setOpaque(true);
		LeftAltButton.setHorizontalAlignment(SwingConstants.LEFT);
		LeftAltButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		LeftAltButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		LeftAltButton.setBackground(Color.WHITE);
		LeftAltButton.setBounds(182, 548, 57, 43);
		contentPane.add(LeftAltButton);
		
		ButtonZ = new JTextArea();
		ButtonZ.setText("    Z\r\n    z");
		ButtonZ.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		ButtonZ.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonZ.setBounds(247, 500, 43, 43);
		contentPane.add(ButtonZ);
		
		ButtonA = new JTextArea();
		ButtonA.setText("    A\r\n    a");
		ButtonA.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonA.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonA.setBounds(220, 452, 43, 43);
		contentPane.add(ButtonA);
		
		ButtonS = new JTextArea();
		ButtonS.setText("    S\r\n    s");
		ButtonS.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonS.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonS.setBounds(267, 452, 43, 43);
		contentPane.add(ButtonS);
		
		ButtonX = new JTextArea();
		ButtonX.setText("    X\r\n    x");
		ButtonX.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonX.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonX.setBounds(294, 500, 43, 43);
		contentPane.add(ButtonX);
		
		ButtonD = new JTextArea();
		ButtonD.setText("    D\r\n    d");
		ButtonD.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonD.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonD.setBounds(314, 452, 43, 43);
		contentPane.add(ButtonD);
		
		ButtonC = new JTextArea();
		ButtonC.setText("    C\r\n    c");
		ButtonC.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonC.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonC.setBounds(341, 500, 43, 43);
		contentPane.add(ButtonC);
		
		ButtonF = new JTextArea();
		ButtonF.setText("    F\r\n    f");
		ButtonF.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonF.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonF.setBounds(361, 452, 43, 43);
		contentPane.add(ButtonF);
		
		ButtonV = new JTextArea();
		ButtonV.setText("    V\r\n    v");
		ButtonV.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonV.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonV.setBounds(388, 500, 43, 43);
		contentPane.add(ButtonV);
		
		ButtonG = new JTextArea();
		ButtonG.setText("    G\r\n    g");
		ButtonG.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonG.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonG.setBounds(408, 452, 43, 43);
		contentPane.add(ButtonG);
		
		ButtonB = new JTextArea();
		ButtonB.setText("    B\r\n    b");
		ButtonB.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonB.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonB.setBounds(435, 500, 43, 43);
		contentPane.add(ButtonB);
		
		ButtonH = new JTextArea();
		ButtonH.setText("    H\r\n    h");
		ButtonH.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonH.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonH.setBounds(456, 452, 43, 43);
		contentPane.add(ButtonH);
		
		ButtonN = new JTextArea();
		ButtonN.setText("    N\r\n    n");
		ButtonN.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonN.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonN.setBounds(482, 500, 43, 43);
		contentPane.add(ButtonN);
		
		ButtonJ = new JTextArea();
		ButtonJ.setText("    J\r\n    j");
		ButtonJ.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonJ.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonJ.setBounds(502, 452, 43, 43);
		contentPane.add(ButtonJ);
		
		ButtonM = new JTextArea();
		ButtonM.setText("    M\r\n    m");
		ButtonM.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonM.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonM.setBounds(529, 500, 43, 43);
		contentPane.add(ButtonM);
		
		ButtonK = new JTextArea();
		ButtonK.setText("    K\r\n    k");
		ButtonK.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonK.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonK.setBounds(549, 452, 43, 43);
		contentPane.add(ButtonK);
		
		CommaButton = new JTextArea();
		CommaButton.setText("    <\r\n    ,");
		CommaButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		CommaButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		CommaButton.setBounds(577, 500, 43, 43);
		contentPane.add(CommaButton);
		
		ButtonL = new JTextArea();
		ButtonL.setText("    L\r\n    l");
		ButtonL.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ButtonL.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		ButtonL.setBounds(596, 452, 43, 43);
		contentPane.add(ButtonL);
		
		PeriodButton = new JTextArea();
		PeriodButton.setText("    >\r\n    .");
		PeriodButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		PeriodButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		PeriodButton.setBounds(625, 500, 43, 43);
		contentPane.add(PeriodButton);
		
		SemicolonButton = new JTextArea();
		SemicolonButton.setText("    :\r\n    ;");
		SemicolonButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		SemicolonButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		SemicolonButton.setBounds(643, 452, 43, 43);
		contentPane.add(SemicolonButton);
		
		QuestionmarkButton = new JTextArea();
		QuestionmarkButton.setText("    ?\r\n    /");
		QuestionmarkButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		QuestionmarkButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		QuestionmarkButton.setBounds(672, 500, 43, 43);
		contentPane.add(QuestionmarkButton);
		
		QuotationMarkButton = new JTextArea();
		QuotationMarkButton.setText("    \"\r\n    '");
		QuotationMarkButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		QuotationMarkButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		QuotationMarkButton.setBounds(690, 452, 43, 43);
		contentPane.add(QuotationMarkButton);
		
		RightShiftButton = new JLabel("Shift");
		RightShiftButton.setVerticalAlignment(SwingConstants.BOTTOM);
		RightShiftButton.setOpaque(true);
		RightShiftButton.setHorizontalAlignment(SwingConstants.RIGHT);
		RightShiftButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		RightShiftButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		RightShiftButton.setBackground(Color.WHITE);
		RightShiftButton.setBounds(719, 500, 99, 43);
		contentPane.add(RightShiftButton);
		
		RightAltButton = new JLabel("Alt");
		RightAltButton.setVerticalAlignment(SwingConstants.BOTTOM);
		RightAltButton.setOpaque(true);
		RightAltButton.setHorizontalAlignment(SwingConstants.LEFT);
		RightAltButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		RightAltButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		RightAltButton.setBackground(Color.WHITE);
		RightAltButton.setBounds(761, 548, 57, 43);
		contentPane.add(RightAltButton);
		
		RightCtrlButton = new JLabel("Ctrl");
		RightCtrlButton.setVerticalAlignment(SwingConstants.BOTTOM);
		RightCtrlButton.setOpaque(true);
		RightCtrlButton.setHorizontalAlignment(SwingConstants.LEFT);
		RightCtrlButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		RightCtrlButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		RightCtrlButton.setBackground(Color.WHITE);
		RightCtrlButton.setBounds(699, 548, 57, 43);
		contentPane.add(RightCtrlButton);
		
		SpacebarButton = new JLabel("");
		SpacebarButton.setVerticalAlignment(SwingConstants.BOTTOM);
		SpacebarButton.setOpaque(true);
		SpacebarButton.setHorizontalAlignment(SwingConstants.LEFT);
		SpacebarButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		SpacebarButton.setBackground(Color.WHITE);
		SpacebarButton.setBounds(244, 548, 451, 43);
		contentPane.add(SpacebarButton);
		
		InformationPanel = new JPanel();
		InformationPanel.setBounds(26, 236, 176, 99);
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
		
		AccurancyLabel = new JLabel("Accurancy : ");
		AccurancyLabel.setOpaque(true);
		AccurancyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AccurancyLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		AccurancyLabel.setBackground(Color.WHITE);
		InformationPanel.add(AccurancyLabel);
		
		accurancyProgrssBar = new JProgressBar();
		accurancyProgrssBar.setStringPainted(true);
		accurancyProgrssBar.setOpaque(true);
		accurancyProgrssBar.setForeground(new Color(255, 153, 0));
		accurancyProgrssBar.setBorderPainted(false);
		accurancyProgrssBar.setBorder(null);
		accurancyProgrssBar.setBackground(Color.WHITE);
		InformationPanel.add(accurancyProgrssBar);
		
		MistakeLabel = new JLabel("Mistakes : ");
		MistakeLabel.setOpaque(true);
		MistakeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		MistakeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		MistakeLabel.setBackground(Color.WHITE);
		InformationPanel.add(MistakeLabel);
		
		mistakeText = new JLabel("");
		mistakeText.setOpaque(true);
		mistakeText.setHorizontalAlignment(SwingConstants.CENTER);
		mistakeText.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		mistakeText.setBackground(Color.WHITE);
		InformationPanel.add(mistakeText);
		
		lblNewLabel_1 = new JLabel("Word to Type");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblNewLabel_1.setBounds(402, 103, 123, 15);
		contentPane.add(lblNewLabel_1);
		
		FirstWordInput = new JTextField();
		FirstWordInput.setHorizontalAlignment(SwingConstants.CENTER);
		FirstWordInput.setFont(new Font("Consolas", Font.BOLD, 25));
		FirstWordInput.setFocusable(false);
		FirstWordInput.setColumns(10);
		FirstWordInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		FirstWordInput.setBounds(80, 128, 240, 81);
		contentPane.add(FirstWordInput);
		
		SecondWordInput = new JTextField();
		SecondWordInput.setHorizontalAlignment(SwingConstants.CENTER);
		SecondWordInput.setFont(new Font("Consolas", Font.BOLD, 25));
		SecondWordInput.setFocusable(false);
		SecondWordInput.setColumns(10);
		SecondWordInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		SecondWordInput.setBounds(332, 128, 240, 81);
		contentPane.add(SecondWordInput);
		
		ThirdWordInput = new JTextField();
		ThirdWordInput.setText("\u0000");
		ThirdWordInput.setHorizontalAlignment(SwingConstants.CENTER);
		ThirdWordInput.setFont(new Font("Consolas", Font.BOLD, 25));
		ThirdWordInput.setFocusable(false);
		ThirdWordInput.setColumns(10);
		ThirdWordInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		ThirdWordInput.setBounds(584, 128, 240, 81);
		contentPane.add(ThirdWordInput);
		
		UserInput = new JTextField();
		UserInput.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		UserInput.setHorizontalAlignment(SwingConstants.CENTER);
		UserInput.setFont(new Font("Consolas", Font.BOLD, 25));
		UserInput.setColumns(10);
		UserInput.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		UserInput.setBounds(332, 250, 240, 81);
		contentPane.add(UserInput);
		
		textArea = new JTextArea();
		textArea.setFocusable(false);
		textArea.setBounds(65, 94, 791, 132);
		contentPane.add(textArea);
		
		EnterButton = new JButton("Enter");
		EnterButton.setHorizontalAlignment(SwingConstants.RIGHT);
		EnterButton.setVerticalAlignment(SwingConstants.BOTTOM);
		EnterButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		EnterButton.setContentAreaFilled(false);
		EnterButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		EnterButton.setBounds(737, 452, 81, 43);
		contentPane.add(EnterButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(111, 348, 715, 252);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(WordPractice.class.getResource("/images/IntroBackground.jpg")));
		lblNewLabel_2.setBounds(0, 0, 912, 629);
		contentPane.add(lblNewLabel_2);
		
		setVisible(true);
		
		//ActionListeners and KeyListeners		
		backButton.addActionListener(this);
		EnterButton.addActionListener(this);
		MyKeyListener keyListener = new MyKeyListener();
		UserInput.addKeyListener(keyListener);		
		
		//Initialize the Answer keys
		userInputString[1] = randomStringGenerator();
		SecondWordInput.setText(userInputString[1]);
		userInputString[2] = randomStringGenerator();
		ThirdWordInput.setText(userInputString[2]);		
		
		//Change Color that needs to be pressed first
		changeColorByInput(keyboardInputColor);
		
		//Start timer by using Another Thread
		startTimer();
	}
	
	//"randomStringGenerator" gets random answer from existing Collection of CreateWordInput class
	public String randomStringGenerator(){	
		String randomString = createInput.getRandomInput();
		return randomString;
	}	
	
	public class MyKeyListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			//User presses backspace button
			if(e.getKeyChar() == '\b') {
				if(index != 0) { //If index == 0 erase nothing
					changeColorByInput(Color.white);								
					index--;				
					changeColorByInput(keyboardInputColor);
				}				
			}
			
			//User presses key (alphabet)
			else if(e.getKeyChar() != '\n'){	
				
				//If the input is already done, ignore the input
				if(index == userInputString[1].length()) { 
					e.consume();
				}
				else {
					changeColorByInput(Color.white);					
					index++;					
					changeColorByInput(keyboardInputColor);	
				}												
			}			
		}

		@Override
		public void keyPressed(KeyEvent e) {	
			//If user press Enter Button
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				
				//Similar with letterPracticeMode (shift(random generate word) -> change color)
				String userInput = UserInput.getText();				
				if(userInput.equals(userInputString[1])) {
					firstInputcolor = 1; //1 : Blue
				}
				else {				
					firstInputcolor = 0; //0 : Red
					mistakes++;
				}
				shiftLeft();
				changeInputColor();
				
				//If User press Enter before the required length of answer
				if(index < userInputString[0].length()) {
					char currentString = userInputString[0].charAt(index);					
					changeKeyboardColor(currentString, Color.white);
				}				
				
				index = 0; //initialize the current index
				changeColorByInput(keyboardInputColor);
				UserInput.setText("");
				
				//progress bar update
				inputNumber++;
				accurancyProgrssBar.setValue((int)(100*(double)(inputNumber - mistakes) / inputNumber));
				mistakeText.setText(mistakes + "");
			}
		}		
		@Override
		public void keyReleased(KeyEvent e) {
			//Empty (Prevent Error)			
		}
	}
	
	//"shiftLeft": shift answers left and generate a random word
	public void shiftLeft() {		
		userInputString[0] = userInputString[1];		
		userInputString[1] = userInputString[2];
		userInputString[2] = randomStringGenerator();
		FirstWordInput.setText(userInputString[0]);
		SecondWordInput.setText(userInputString[1]);
		ThirdWordInput.setText(userInputString[2]);
	}
	
	//"changeInputColor": changes previous answer's color
	public void changeInputColor() {
		if(firstInputcolor == 1) FirstWordInput.setForeground(Color.BLUE);
		else FirstWordInput.setForeground(Color.RED);
	}
	
	//"changeColorByInput": changes color of keyboard that needs to be pressed at present
	public void changeColorByInput(Color color) {
		int length = userInputString[1].length();
		if(length == index){
			char currentString = userInputString[1].charAt(index-1);
			changeKeyboardColor(currentString, Color.white);			
		}
		else {
			char currentString = userInputString[1].charAt(index);
			changeKeyboardColor(currentString, color);			
		}
	}
	
	//"changeKeyboardColor": changes specific color of key.
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
		else if((input == ' ')) {SpacebarButton.setBackground(color);}
	}
	
	//ActionListener for back button(same with different classes)
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == backButton) {
			StartPage convertFrame = new StartPage();
			convertFrame.setVisible(true);
			dispose();
		}		
	}	
	
	//To make progress bars
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
