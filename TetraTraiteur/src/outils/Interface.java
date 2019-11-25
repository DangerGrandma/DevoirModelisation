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
	private static boolean btnsActives = false;
	//private static String etatChoisi = "";


	
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
		
		JButton btnLibre = new JButton("");
		btnLibre.setIcon(new ImageIcon("F:\\DevoirModelisation\\TetraTraiteur\\bin\\button_libre.png"));
		btnLibre.setBounds(312, 11, 94, 29);
		DiviseurHaut.add(btnLibre);
		btnLibre.setVisible(false);
		
		JButton btnOccupee = new JButton("");
		btnOccupee.setIcon(new ImageIcon("images\\button_occupee.png"));
		btnOccupee.setBounds(416, 11, 94, 29);
		DiviseurHaut.add(btnOccupee);
		btnOccupee.setVisible(false);
		
		JButton btnDebarrasser = new JButton("");
		btnDebarrasser.setIcon(new ImageIcon("images\\button_a-debarrasser.png"));
		btnDebarrasser.setBounds(520, 11, 94, 29);
		DiviseurHaut.add(btnDebarrasser);
		btnDebarrasser.setVisible(false);
		
		JButton btnAutreServeur = new JButton("");
		btnAutreServeur.setIcon(new ImageIcon("images\\button_autre-serveur.png"));
		btnAutreServeur.setBounds(624, 11, 94, 29);
		DiviseurHaut.add(btnAutreServeur);
		btnAutreServeur.setVisible(false);
		
		JButton btnTableSaisie = new JButton("Table#");
		btnTableSaisie.setBounds(22, 13, 89, 23);
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);
		DiviseurHaut.add(btnTableSaisie);
		btnTableSaisie.setVisible(false);
		
		JLabel lblModTable = new JLabel("Choisir Table");
		lblModTable.setFont(new Font("Arial", Font.BOLD, 12));
		lblModTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblModTable.setBounds(142, 18, 78, 14);
		DiviseurHaut.add(lblModTable);
		lblModTable.setVisible(false);
		
		JLabel imgDiviseurHaut = new JLabel("");
		imgDiviseurHaut.setBounds(0, 0, 728, 48);
		imgDiviseurHaut.setIcon(new ImageIcon("images\\DiviseurHaut(actif).PNG"));
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
		imgUtilisateur.setIcon(new ImageIcon("images\\Banner2.PNG"));
		
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
		imgTemps.setIcon(new ImageIcon("images\\bane3.PNG"));
		
		JButton btnArchive = new JButton("");
		btnArchive.setForeground(SystemColor.desktop);
		btnArchive.setBackground(SystemColor.desktop);
		btnArchive.setBounds(0, 363, 119, 74);
		DiviseurDroite.add(btnArchive);
		btnArchive.setIcon(new ImageIcon("images\\btnArchive.png"));
		
		JButton btnUtilisateur = new JButton("");
		btnUtilisateur.setForeground(SystemColor.desktop);
		btnUtilisateur.setBackground(SystemColor.desktop);
		btnUtilisateur.setBounds(0, 146, 119, 74);
		DiviseurDroite.add(btnUtilisateur);
		btnUtilisateur.setIcon(new ImageIcon("images\\btnChange.png"));
		
		JButton btnModTable = new JButton("");
		btnModTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnsActives) {
					btnsActives = false;
					imgDiviseurHaut.setIcon(new ImageIcon("images\\DiviseurHaut(inactif).jpg"));
					btnLibre.setVisible(false);
					btnOccupee.setVisible(false);
					btnDebarrasser.setVisible(false);
					btnAutreServeur.setVisible(false);
					btnTableSaisie.setVisible(false);
					lblModTable.setVisible(false);
				}
				
				else {
					btnsActives = true;
					imgDiviseurHaut.setIcon(new ImageIcon("images\\DiviseurHaut(actif).png"));
					btnLibre.setVisible(true);
					btnOccupee.setVisible(true);
					btnDebarrasser.setVisible(true);
					btnAutreServeur.setVisible(true);
					btnTableSaisie.setVisible(true);
					lblModTable.setVisible(true);
				}
			}
		
		});
		btnModTable.setBounds(0, 250, 119, 74);
		DiviseurDroite.add(btnModTable);
		btnModTable.setIcon(new ImageIcon("images\\btnTable.png"));
		btnModTable.setForeground(SystemColor.desktop);
		btnModTable.setBackground(SystemColor.desktop);
		
		JLabel imgDiviseurDroite = new JLabel("New label");
		imgDiviseurDroite.setBounds(0, 118, 119, 365);
		DiviseurDroite.add(imgDiviseurDroite);
		imgDiviseurDroite.setIcon(new ImageIcon("images\\Bannerdroite.PNG"));
	
		
		// Boutons pour les tables de 1 à 24
				
		JButton btnTable1 = new JButton("1");
		btnTable1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table1");
					lblModTable.setText("Choisir État");
				}
			}
		});
		btnTable1.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable1.setMargin(new Insets(0, 0, 0, 0));
		btnTable1.setBackground(Color.LIGHT_GRAY);
		btnTable1.setContentAreaFilled(false);
		btnTable1.setOpaque(true);
		btnTable1.setBounds(290, 435, 20, 20);
		contentPane.add(btnTable1);
	
		JButton btnTable2 = new JButton("2");
		btnTable2.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable2.setMargin(new Insets(0, 0, 0, 0));
		btnTable2.setBackground(Color.LIGHT_GRAY);
		btnTable2.setContentAreaFilled(false);
		btnTable2.setOpaque(true);
		btnTable2.setBounds(290, 395, 20, 20);
		contentPane.add(btnTable2);
	
		JButton btnTable3 = new JButton("3");
		btnTable3.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable3.setMargin(new Insets(0, 0, 0, 0));
		btnTable3.setBackground(Color.LIGHT_GRAY);
		btnTable3.setContentAreaFilled(false);
		btnTable3.setOpaque(true);
		btnTable3.setBounds(290, 355, 20, 20);
		contentPane.add(btnTable3);
		
		JButton btnTable4 = new JButton("4");
		btnTable4.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable4.setMargin(new Insets(0, 0, 0, 0));
		btnTable4.setBackground(Color.LIGHT_GRAY);
		btnTable4.setContentAreaFilled(false);
		btnTable4.setOpaque(true);
		btnTable4.setBounds(290, 315, 20, 20);
		contentPane.add(btnTable4);
		
		JButton btnTable5 = new JButton("5");
		btnTable5.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable5.setMargin(new Insets(0, 0, 0, 0));
		btnTable5.setBackground(Color.LIGHT_GRAY);
		btnTable5.setContentAreaFilled(false);
		btnTable5.setOpaque(true);
		btnTable5.setBounds(290, 275, 20, 20);
		contentPane.add(btnTable5);
		
		JButton btnTable6 = new JButton("6");
		btnTable6.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable6.setMargin(new Insets(0, 0, 0, 0));
		btnTable6.setBackground(Color.LIGHT_GRAY);
		btnTable6.setContentAreaFilled(false);
		btnTable6.setOpaque(true);
		btnTable6.setBounds(290, 235, 20, 20);
		contentPane.add(btnTable6);
		
		JButton btnTable7 = new JButton("7");
		btnTable7.setMargin(new Insets(0, 0, 0, 0));
		btnTable7.setFont(new Font("Arial", Font.PLAIN, 13));
		btnTable7.setBackground(Color.LIGHT_GRAY);
		btnTable7.setContentAreaFilled(false);
		btnTable7.setOpaque(true);
		btnTable7.setBounds(290, 195, 20, 20);
		contentPane.add(btnTable7);
		
		JButton btnTable8 = new JButton("8");
		btnTable8.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable8.setMargin(new Insets(0, 0, 0, 0));
		btnTable8.setBackground(Color.LIGHT_GRAY);
		btnTable8.setContentAreaFilled(false);
		btnTable8.setOpaque(true);
		btnTable8.setBounds(332, 154, 20, 20);
		contentPane.add(btnTable8);
		
		JButton btnTable9 = new JButton("9");
		btnTable9.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable9.setMargin(new Insets(0, 0, 0, 0));
		btnTable9.setBackground(Color.LIGHT_GRAY);
		btnTable9.setContentAreaFilled(false);
		btnTable9.setOpaque(true);
		btnTable9.setBounds(372, 154, 20, 20);
		contentPane.add(btnTable9);
		
		JButton btnTable10 = new JButton("10");
		btnTable10.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable10.setMargin(new Insets(0, 0, 0, 0));;
		btnTable10.setBackground(Color.LIGHT_GRAY);
		btnTable10.setContentAreaFilled(false);
		btnTable10.setOpaque(true);
		btnTable10.setBounds(414, 195, 20, 20);
		contentPane.add(btnTable10);
		
		JButton btnTable11 = new JButton("11");
		btnTable11.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable11.setMargin(new Insets(0, 0, 0, 0));
		btnTable11.setBackground(Color.LIGHT_GRAY);
		btnTable11.setContentAreaFilled(false);
		btnTable11.setOpaque(true);
		btnTable11.setBounds(414, 235, 20, 20);
		contentPane.add(btnTable11);
		
		JButton btnTable12 = new JButton("12");
		btnTable12.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable12.setMargin(new Insets(0, 0, 0, 0));
		btnTable12.setBackground(Color.LIGHT_GRAY);
		btnTable12.setContentAreaFilled(false);
		btnTable12.setOpaque(true);
		btnTable12.setBounds(414, 275, 20, 20);
		contentPane.add(btnTable12);
		
		JButton btnTable13 = new JButton("13");
		btnTable13.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable13.setMargin(new Insets(0, 0, 0, 0));
		btnTable13.setBackground(Color.LIGHT_GRAY);
		btnTable13.setContentAreaFilled(false);
		btnTable13.setOpaque(true);
		btnTable13.setBounds(414, 315, 20, 20);
		contentPane.add(btnTable13);
		
		JButton btnTable14 = new JButton("14");
		btnTable14.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable14.setMargin(new Insets(0, 0, 0, 0));
		btnTable14.setBackground(Color.LIGHT_GRAY);
		btnTable14.setContentAreaFilled(false);
		btnTable14.setOpaque(true);
		btnTable14.setBounds(414, 355, 20, 20);
		contentPane.add(btnTable14);
		
		JButton btnTable15 = new JButton("15");
		btnTable15.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable15.setMargin(new Insets(0, 0, 0, 0));
		btnTable15.setBackground(Color.LIGHT_GRAY);
		btnTable15.setContentAreaFilled(false);
		btnTable15.setOpaque(true);
		btnTable15.setBounds(414, 395, 20, 20);
		contentPane.add(btnTable15);

		JButton btnTable16 = new JButton("16");
		btnTable16.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable16.setMargin(new Insets(0, 0, 0, 0));
		btnTable16.setBackground(Color.LIGHT_GRAY);
		btnTable16.setContentAreaFilled(false);
		btnTable16.setOpaque(true);
		btnTable16.setBounds(414, 435, 20, 20);
		contentPane.add(btnTable16);
		
		JButton btnTable17 = new JButton("17");
		btnTable17.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable17.setBackground(Color.LIGHT_GRAY);
		btnTable17.setContentAreaFilled(false);
		btnTable17.setOpaque(true);
		btnTable17.setBounds(77, 80, 50, 50);
		contentPane.add(btnTable17);
		
		JButton btnTable18 = new JButton("18");
		btnTable18.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable18.setBackground(Color.LIGHT_GRAY);
		btnTable18.setContentAreaFilled(false);
		btnTable18.setOpaque(true);
		btnTable18.setBounds(77, 180, 50, 50);
		contentPane.add(btnTable18);
		
		JButton btnTable19 = new JButton("19");
		btnTable19.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable19.setBackground(Color.LIGHT_GRAY);
		btnTable19.setContentAreaFilled(false);
		btnTable19.setOpaque(true);
		btnTable19.setBounds(77, 280, 50, 50);
		contentPane.add(btnTable19);
		
		JButton btnTable20 = new JButton("20");
		btnTable20.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable20.setBackground(Color.LIGHT_GRAY);
		btnTable20.setContentAreaFilled(false);
		btnTable20.setOpaque(true);
		btnTable20.setBounds(77, 380, 50, 50);
		contentPane.add(btnTable20);
		
		JButton btnTable21 = new JButton("21");
		btnTable21.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable21.setBackground(Color.LIGHT_GRAY);
		btnTable21.setContentAreaFilled(false);
		btnTable21.setOpaque(true);
		btnTable21.setBounds(597, 80, 50, 50);
		contentPane.add(btnTable21);
		
		JButton btnTable22 = new JButton("22");
		btnTable22.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable22.setBackground(Color.LIGHT_GRAY);
		btnTable22.setContentAreaFilled(false);
		btnTable22.setOpaque(true);
		btnTable22.setBounds(597, 180, 50, 50);
		contentPane.add(btnTable22);
		
		JButton btnTable23 = new JButton("23");
		btnTable23.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable23.setBackground(Color.LIGHT_GRAY);
		btnTable23.setContentAreaFilled(false);
		btnTable23.setOpaque(true);
		btnTable23.setBounds(597, 280, 50, 50);
		contentPane.add(btnTable23);

		JButton btnTable24 = new JButton("24");
		btnTable24.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable24.setBackground(Color.LIGHT_GRAY);
		btnTable24.setContentAreaFilled(false);
		btnTable24.setOpaque(true);
		btnTable24.setBounds(597, 380, 50, 50);
		contentPane.add(btnTable24);
		
		JLabel imgSalle = new JLabel("");
		imgSalle.setIcon(new ImageIcon("images\\InterfaceSalle.png"));
		imgSalle.setBounds(0, 48, 725, 435);
		contentPane.add(imgSalle);
		
		/*
		class nouvelEtat implements ActionListener{
			public void actionPerformed(ActionEvent etatClique) {
				if (etatClique.getSource() == btnLibre) {
					etatChoisi = "Libre";
					
				}
				
			}
			
		}
		 */
	}
		
	
}
