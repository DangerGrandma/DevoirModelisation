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
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		contentPane.setForeground(Color.BLACK);
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
		btnArchive.setBounds(0, 363, 119, 74);
		DiviseurDroite.add(btnArchive);
		btnArchive.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\btnArchive.png"));
		
		JButton btnUtilisateur = new JButton("");
		btnUtilisateur.setForeground(SystemColor.desktop);
		btnUtilisateur.setBackground(SystemColor.desktop);
		btnUtilisateur.setBounds(0, 146, 119, 74);
		DiviseurDroite.add(btnUtilisateur);
		btnUtilisateur.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\btnChange.png"));
		
		JButton btnModTable = new JButton("");
		btnModTable.setBounds(0, 250, 119, 74);
		DiviseurDroite.add(btnModTable);
		btnModTable.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\btnTable.png"));
		btnModTable.setForeground(SystemColor.desktop);
		btnModTable.setBackground(SystemColor.desktop);
		
		JLabel imgDiviseurDroite = new JLabel("New label");
		imgDiviseurDroite.setBounds(0, 118, 119, 365);
		DiviseurDroite.add(imgDiviseurDroite);
		imgDiviseurDroite.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\Bannerdroite.PNG"));
	
		
		// Boutons pour les tables de A à F
		
		JButton btnTableA = new JButton("A");
		btnTableA.setFont(new Font("Arial", Font.BOLD, 13));
		btnTableA.setBackground(Color.LIGHT_GRAY);
		btnTableA.setContentAreaFilled(false);
		btnTableA.setOpaque(true);
		btnTableA.setBounds(77, 80, 50, 50);
		contentPane.add(btnTableA);
		btnTableA.setOpaque(true);

		
		JButton btnTableB = new JButton("B");
		btnTableB.setFont(new Font("Arial", Font.BOLD, 13));
		btnTableB.setBackground(Color.LIGHT_GRAY);
		btnTableB.setContentAreaFilled(false);
		btnTableB.setOpaque(true);
		btnTableB.setBounds(77, 180, 50, 50);
		contentPane.add(btnTableB);
		btnTableB.setOpaque(true);

		
		JButton btnTableC = new JButton("C");
		btnTableC.setFont(new Font("Arial", Font.BOLD, 13));
		btnTableC.setBackground(Color.LIGHT_GRAY);
		btnTableC.setContentAreaFilled(false);
		btnTableC.setOpaque(true);
		btnTableC.setBounds(77, 280, 50, 50);
		contentPane.add(btnTableC);
		btnTableC.setOpaque(true);

		
		JButton btnTableD = new JButton("D");
		btnTableD.setFont(new Font("Arial", Font.BOLD, 13));
		btnTableD.setBackground(Color.LIGHT_GRAY);
		btnTableD.setContentAreaFilled(false);
		btnTableD.setOpaque(true);
		btnTableD.setBounds(77, 380, 50, 50);
		contentPane.add(btnTableD);
		btnTableD.setOpaque(true);

		
		JButton btnTableE = new JButton("E");
		btnTableE.setFont(new Font("Arial", Font.BOLD, 13));
		btnTableE.setBackground(Color.LIGHT_GRAY);
		btnTableE.setContentAreaFilled(false);
		btnTableE.setOpaque(true);
		btnTableE.setBounds(597, 80, 50, 50);
		contentPane.add(btnTableE);
		btnTableE.setOpaque(true);

		
		JButton btnTableF = new JButton("F");
		btnTableF.setFont(new Font("Arial", Font.BOLD, 13));
		btnTableF.setBackground(Color.LIGHT_GRAY);
		btnTableF.setContentAreaFilled(false);
		btnTableF.setOpaque(true);
		btnTableF.setBounds(597, 180, 50, 50);
		contentPane.add(btnTableF);
		btnTableF.setOpaque(true);

		
		JButton btnTableG = new JButton("G");
		btnTableG.setFont(new Font("Arial", Font.BOLD, 13));
		btnTableG.setBackground(Color.LIGHT_GRAY);
		btnTableG.setContentAreaFilled(false);
		btnTableG.setOpaque(true);
		btnTableG.setBounds(597, 280, 50, 50);
		contentPane.add(btnTableG);
		btnTableG.setOpaque(true);

		
		JButton btnTableH = new JButton("H");
		btnTableH.setFont(new Font("Arial", Font.BOLD, 13));
		btnTableH.setBackground(Color.LIGHT_GRAY);
		btnTableH.setContentAreaFilled(false);
		btnTableH.setOpaque(true);
		btnTableH.setBounds(597, 380, 50, 50);
		contentPane.add(btnTableH);
		btnTableH.setOpaque(true);

		
		JButton btnTable1 = new JButton("1");
		btnTable1.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable1.setMargin(new Insets(0, 0, 0, 0));
		btnTable1.setBackground(Color.LIGHT_GRAY);
		btnTable1.setContentAreaFilled(false);
		btnTable1.setOpaque(true);
		btnTable1.setBounds(290, 435, 20, 20);
		contentPane.add(btnTable1);
		btnTable1.setOpaque(true);

		
		JButton btnTable2 = new JButton("2");
		btnTable2.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable2.setMargin(new Insets(0, 0, 0, 0));
		btnTable2.setBackground(Color.LIGHT_GRAY);
		btnTable2.setContentAreaFilled(false);
		btnTable2.setOpaque(true);
		btnTable2.setBounds(290, 395, 20, 20);
		contentPane.add(btnTable2);
		btnTable2.setOpaque(true);

		
		JButton btnTable3 = new JButton("3");
		btnTable3.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable3.setMargin(new Insets(0, 0, 0, 0));
		btnTable3.setBackground(Color.LIGHT_GRAY);
		btnTable3.setContentAreaFilled(false);
		btnTable3.setOpaque(true);
		btnTable3.setBounds(290, 355, 20, 20);
		contentPane.add(btnTable3);
		btnTable3.setOpaque(true);

		
		JButton btnTable4 = new JButton("4");
		btnTable4.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable4.setMargin(new Insets(0, 0, 0, 0));
		btnTable4.setBackground(Color.LIGHT_GRAY);
		btnTable4.setContentAreaFilled(false);
		btnTable4.setOpaque(true);
		btnTable4.setBounds(290, 315, 20, 20);
		contentPane.add(btnTable4);
		btnTable4.setOpaque(true);

		
		JButton btnTable5 = new JButton("5");
		btnTable5.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable5.setMargin(new Insets(0, 0, 0, 0));
		btnTable5.setBackground(Color.LIGHT_GRAY);
		btnTable5.setContentAreaFilled(false);
		btnTable5.setOpaque(true);
		btnTable5.setBounds(290, 275, 20, 20);
		contentPane.add(btnTable5);
		btnTable5.setOpaque(true);

		
		JButton btnTable6 = new JButton("6");
		btnTable6.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable6.setMargin(new Insets(0, 0, 0, 0));
		btnTable6.setBackground(Color.LIGHT_GRAY);
		btnTable6.setContentAreaFilled(false);
		btnTable6.setOpaque(true);
		btnTable6.setBounds(290, 235, 20, 20);
		contentPane.add(btnTable6);
		btnTable6.setOpaque(true);

		
		JButton btnTable7 = new JButton("7");
		btnTable7.setMargin(new Insets(0, 0, 0, 0));
		btnTable7.setFont(new Font("Arial", Font.PLAIN, 13));
		btnTable7.setBackground(Color.LIGHT_GRAY);
		btnTable7.setContentAreaFilled(false);
		btnTable7.setOpaque(true);
		btnTable7.setBounds(290, 195, 20, 20);
		contentPane.add(btnTable7);
		btnTable7.setOpaque(true);

		
		JButton btnTable8 = new JButton("8");
		btnTable8.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable8.setMargin(new Insets(0, 0, 0, 0));
		btnTable8.setBackground(Color.LIGHT_GRAY);
		btnTable8.setContentAreaFilled(false);
		btnTable8.setOpaque(true);
		btnTable8.setBounds(332, 154, 20, 20);
		contentPane.add(btnTable8);
		btnTable8.setOpaque(true);

		
		JButton btnTable9 = new JButton("9");
		btnTable9.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable9.setMargin(new Insets(0, 0, 0, 0));
		btnTable9.setBackground(Color.LIGHT_GRAY);
		btnTable9.setContentAreaFilled(false);
		btnTable9.setOpaque(true);
		btnTable9.setBounds(372, 154, 20, 20);
		contentPane.add(btnTable9);
		btnTable9.setOpaque(true);

		
		JButton btnTable10 = new JButton("10");
		btnTable10.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable10.setMargin(new Insets(0, 0, 0, 0));;
		btnTable10.setBackground(Color.LIGHT_GRAY);
		btnTable10.setContentAreaFilled(false);
		btnTable10.setOpaque(true);
		btnTable10.setBounds(414, 195, 20, 20);
		contentPane.add(btnTable10);
		btnTable10.setOpaque(true);

		
		JButton btnTable11 = new JButton("11");
		btnTable11.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable11.setMargin(new Insets(0, 0, 0, 0));
		btnTable11.setBackground(Color.LIGHT_GRAY);
		btnTable11.setContentAreaFilled(false);
		btnTable11.setOpaque(true);
		btnTable11.setBounds(414, 235, 20, 20);
		contentPane.add(btnTable11);
		btnTable11.setOpaque(true);

		
		JButton btnTable12 = new JButton("12");
		btnTable12.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable12.setMargin(new Insets(0, 0, 0, 0));
		btnTable12.setBackground(Color.LIGHT_GRAY);
		btnTable12.setContentAreaFilled(false);
		btnTable12.setOpaque(true);
		btnTable12.setBounds(414, 275, 20, 20);
		contentPane.add(btnTable12);
		btnTable12.setOpaque(true);

		
		JButton btnTable13 = new JButton("13");
		btnTable13.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable13.setMargin(new Insets(0, 0, 0, 0));
		btnTable13.setBackground(Color.LIGHT_GRAY);
		btnTable13.setContentAreaFilled(false);
		btnTable13.setOpaque(true);
		btnTable13.setBounds(414, 315, 20, 20);
		contentPane.add(btnTable13);
		btnTable13.setOpaque(true);

		
		JButton btnTable14 = new JButton("14");
		btnTable14.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable14.setMargin(new Insets(0, 0, 0, 0));
		btnTable14.setBackground(Color.LIGHT_GRAY);
		btnTable14.setContentAreaFilled(false);
		btnTable14.setOpaque(true);
		btnTable14.setBounds(414, 355, 20, 20);
		contentPane.add(btnTable14);
		btnTable14.setOpaque(true);

		
		JButton btnTable15 = new JButton("15");
		btnTable15.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable15.setMargin(new Insets(0, 0, 0, 0));
		btnTable15.setBackground(Color.LIGHT_GRAY);
		btnTable15.setContentAreaFilled(false);
		btnTable15.setOpaque(true);
		btnTable15.setBounds(414, 395, 20, 20);
		contentPane.add(btnTable15);
		btnTable15.setOpaque(true);

		
		JButton btnTable16 = new JButton("16");
		btnTable16.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable16.setMargin(new Insets(0, 0, 0, 0));
		btnTable16.setBackground(Color.LIGHT_GRAY);
		btnTable16.setContentAreaFilled(false);
		btnTable16.setOpaque(true);
		btnTable16.setBounds(414, 435, 20, 20);
		contentPane.add(btnTable16);
		btnTable16.setOpaque(true);
		
		JLabel imgSalle = new JLabel("");
		imgSalle.setIcon(new ImageIcon("D:\\Eclipse-Workspace\\DevoirModelisation\\images\\InterfaceSalle.png"));
		imgSalle.setBounds(0, 48, 725, 435);
		contentPane.add(imgSalle);
	}
}
