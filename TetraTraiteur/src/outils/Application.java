package outils;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Application extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Application() {
		setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel DiviseurHaut = new JPanel();
		DiviseurHaut.setBackground(Color.GREEN);
		DiviseurHaut.setBounds(0, 0, 728, 48);
		contentPane.add(DiviseurHaut);
		DiviseurHaut.setLayout(null);
		
		JLabel imgDiviseurHaut = new JLabel("");
		imgDiviseurHaut.setBounds(0, 0, 728, 48);
		imgDiviseurHaut.setIcon(new ImageIcon("images\\DiviseurHaut(inactif).jpg"));
		DiviseurHaut.add(imgDiviseurHaut);
		
		JPanel DiviseurDroite = new JPanel();
		DiviseurDroite.setBackground(Color.RED);
		DiviseurDroite.setBounds(727, 0, 119, 483);
		contentPane.add(DiviseurDroite);
		DiviseurDroite.setLayout(null);
		
		JPanel PaneauUtilisateur = new JPanel();
		PaneauUtilisateur.setBounds(0, 0, 119, 47);
		DiviseurDroite.add(PaneauUtilisateur);
		PaneauUtilisateur.setBackground(Color.YELLOW);
		
		JPanel PaneauTemps = new JPanel();
		PaneauTemps.setBackground(Color.PINK);
		PaneauTemps.setBounds(0, 47, 119, 71);
		DiviseurDroite.add(PaneauTemps);
		PaneauTemps.setLayout(null);
		
		JPanel PaneauHeure = new JPanel();
		PaneauHeure.setBackground(Color.CYAN);
		PaneauHeure.setBounds(57, 0, 62, 25);
		PaneauTemps.add(PaneauHeure);
		
		JButton BtnChangerUtilisateur = new JButton("Changer \r\nUtilisateur");
		BtnChangerUtilisateur.setEnabled(false);
		BtnChangerUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 8));
		BtnChangerUtilisateur.setBounds(20, 147, 89, 58);
		DiviseurDroite.add(BtnChangerUtilisateur);
		
		JButton btnModifiertatTable = new JButton("Modifier \u00C9tat Table");
		btnModifiertatTable.setBounds(20, 259, 89, 58);
		DiviseurDroite.add(btnModifiertatTable);
		
		JButton btnArchive = new JButton("Archive");
		btnArchive.setBounds(20, 374, 89, 58);
		DiviseurDroite.add(btnArchive);
	}
}