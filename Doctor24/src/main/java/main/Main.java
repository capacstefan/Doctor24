package main;

import javax.swing.SwingUtilities;

import view.LoginPage;

public class Main {
/**
 * Functie main start
 * @param args
 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			try {
				new LoginPage();
			} catch (Exception e){
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		});
	}
}
