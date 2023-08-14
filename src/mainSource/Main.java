package mainSource;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {			
			@Override
			public void run() {
				try {
					StartPage frame = new StartPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

				
			}
		});

	}

}
