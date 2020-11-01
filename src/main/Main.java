package main;

import java.awt.EventQueue;

import view.MainScreen;

/**
 * The main class
 * @author Lucas Alkimim Chaves
 *
 */
public class Main {
	/**
	 * @author Lucas Alkimim Chaves
	 * @param args
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			/**
			 * @author Lucas Alkimim Chaves
			 */
			public void run() {
				
				try {
					
					MainScreen frame = new MainScreen();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			}
		});
	}

}
