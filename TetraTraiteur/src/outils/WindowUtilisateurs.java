package outils;

import javax.swing.JFrame;
import javax.swing.JButton;

public class WindowUtilisateurs {

	public static void main(String[] args) {
		afficherUtil();
	}
	
	public static void afficherUtil() {
		JFrame frameUtil = new JFrame("Choisir un Utilisateur");
		frameUtil.setBounds(100,100,151,153);
		frameUtil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUtil.getContentPane().setLayout(null);
		
		JButton btnSarah = new JButton("Sarah");
		btnSarah.setBounds(10, 11, 115, 23);
		frameUtil.getContentPane().add(btnSarah);
		
		JButton btnSimonpierre = new JButton("Simon-Pierre");
		btnSimonpierre.setBounds(10, 45, 115, 23);
		frameUtil.getContentPane().add(btnSimonpierre);
		
		JButton btnAlexandre = new JButton("Alexandre");
		btnAlexandre.setBounds(10, 79, 115, 23);
		frameUtil.getContentPane().add(btnAlexandre);
		
		frameUtil.setVisible(true);
	}
}
