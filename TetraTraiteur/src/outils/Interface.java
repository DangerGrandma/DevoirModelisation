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
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class Interface extends JFrame {

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
	public Interface() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 522);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel DiviseurHaut = new JPanel();
		DiviseurHaut.setBounds(0, 0, 728, 48);
		DiviseurHaut.setBackground(Color.GREEN);
		contentPane.add(DiviseurHaut);
		DiviseurHaut.setLayout(null);
		
		JLabel imgDiviseurHaut = new JLabel("");
		imgDiviseurHaut.setBounds(0, 0, 728, 48);
		imgDiviseurHaut.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\DiviseurHaut(inactif).jpg"));
		DiviseurHaut.add(imgDiviseurHaut);
		
		JPanel DiviseurDroite = new JPanel();
		DiviseurDroite.setBounds(727, 0, 119, 483);
		DiviseurDroite.setBackground(Color.RED);
		contentPane.add(DiviseurDroite);
		DiviseurDroite.setLayout(null);
		
		JPanel PaneauUtilisateur = new JPanel();
		PaneauUtilisateur.setBounds(0, 0, 119, 47);
		DiviseurDroite.add(PaneauUtilisateur);
		PaneauUtilisateur.setBackground(Color.YELLOW);
		PaneauUtilisateur.setLayout(null);
		
		JLabel boxUtilisateur = new JLabel("Utilisateur");
		boxUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		boxUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxUtilisateur.setBounds(10, 11, 99, 25);
		PaneauUtilisateur.add(boxUtilisateur);
		
		JLabel imgUtilisateur = new JLabel("");
		imgUtilisateur.setVerticalAlignment(SwingConstants.TOP);
		imgUtilisateur.setBounds(0, 0, 119, 47);
		PaneauUtilisateur.add(imgUtilisateur);
		imgUtilisateur.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\Banner2.PNG"));
		
		JPanel PaneauTemps = new JPanel();
		PaneauTemps.setBackground(Color.PINK);
		PaneauTemps.setBounds(0, 47, 119, 71);
		DiviseurDroite.add(PaneauTemps);
		PaneauTemps.setLayout(null);
		
		JLabel boxTemps = new JLabel("Temps");
		boxTemps.setBounds(37, 26, 46, 14);
		PaneauTemps.add(boxTemps);
		
		JLabel imgTemps = new JLabel("");
		imgTemps.setBounds(0, 0, 119, 71);
		PaneauTemps.add(imgTemps);
		imgTemps.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\bane3.PNG"));
		
		JButton btnArchive = new JButton("");
		btnArchive.setForeground(SystemColor.desktop);
		btnArchive.setBackground(SystemColor.desktop);
		btnArchive.setBounds(0, 362, 119, 74);
		DiviseurDroite.add(btnArchive);
		btnArchive.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\btnArchive.png"));
		
		JButton btnUtilisateur = new JButton("");
		btnUtilisateur.setForeground(SystemColor.desktop);
		btnUtilisateur.setBackground(SystemColor.desktop);
		btnUtilisateur.setBounds(0, 146, 119, 74);
		DiviseurDroite.add(btnUtilisateur);
		btnUtilisateur.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\btnChange.png"));
		
		JButton btnModTable = new JButton("");
		btnModTable.setBounds(0, 247, 119, 74);
		DiviseurDroite.add(btnModTable);
		btnModTable.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\btnTable.png"));
		btnModTable.setForeground(SystemColor.desktop);
		btnModTable.setBackground(SystemColor.desktop);
		
		JLabel imgDiviseurDroite = new JLabel("New label");
		imgDiviseurDroite.setBounds(0, 118, 119, 365);
		DiviseurDroite.add(imgDiviseurDroite);
		imgDiviseurDroite.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\Bannerdroite.PNG"));
	}
}
