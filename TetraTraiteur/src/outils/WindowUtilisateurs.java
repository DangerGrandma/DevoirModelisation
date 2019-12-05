package outils;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class WindowUtilisateurs {

	public static void main(String[] args) {
		afficherUtil();
	}
	
	public static void afficherUtil() {
		JFrame frameUtil = new JFrame("Choisir un Utilisateur");
		frameUtil.setBounds(100,100,151,153);
		frameUtil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameUtil.getContentPane().setLayout(null);
		
		JButton btnSarah = new JButton("Sarah");
		btnSarah.setBounds(10, 11, 115, 23);
		frameUtil.getContentPane().add(btnSarah);
		btnSarah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.boxUtilisateur.setText("Sarah");
				frameUtil.dispose();
			}
		});
		
		JButton btnSimonpierre = new JButton("Simon-Pierre");
		btnSimonpierre.setBounds(10, 45, 115, 23);
		frameUtil.getContentPane().add(btnSimonpierre);
		btnSimonpierre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.boxUtilisateur.setText("Simon-Pierre");
				frameUtil.dispose();
			}
		});
		
		JButton btnAlexandre = new JButton("Alexandre");
		btnAlexandre.setBounds(10, 79, 115, 23);
		frameUtil.getContentPane().add(btnAlexandre);
		btnAlexandre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.boxUtilisateur.setText("Alexandre");
				frameUtil.dispose();
			}
		});
		
		frameUtil.setVisible(true);
	}
}
