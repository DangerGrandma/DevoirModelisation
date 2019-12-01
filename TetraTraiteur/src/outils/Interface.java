package outils;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Button;

public class Interface extends JFrame {

	private JPanel contentPane; // Paneau d'affichage principal.
	private static boolean btnsActives = false;  // Variable qui permet d'afficher les boutons d'état de table. 
	private static JButton boutonActuel; // Variable utilisée pour déterminer quel table a été sélectionnée pour modification.
	
	
	public Interface() {
		
		// Création de la  fenêtre de l'application.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 522);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Création de la banière du haut.
		
		JPanel DiviseurHaut = new JPanel();
		DiviseurHaut.setBounds(0, 0, 728, 48);
		DiviseurHaut.setBackground(Color.GREEN);
		contentPane.add(DiviseurHaut);
		DiviseurHaut.setLayout(null);
		
		/*
		 *  Création du bouton de changement d'état de table à "Libre". La table choisie en @param boutonActuel devient Libre,
		 *  puis @param boutonActuel se vide afin de limiter les opérations et requiert une nouvelle sélection pour autres modifications.
		 */
		
		JButton btnLibre = new JButton("");
		btnLibre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boutonActuel != null)
				boutonActuel.setBackground(Color.GREEN);
				boutonActuel = null;
			}
		});
		btnLibre.setIcon(new ImageIcon(Interface.class.getResource("/imgs/button_libre.png")));
		btnLibre.setBounds(312, 11, 94, 29);
		DiviseurHaut.add(btnLibre);
		btnLibre.setVisible(false);
		
		/*
		 *  Création du bouton de changement d'état de table à "Occupée". La table choisie en @param boutonActuel devient Occupée,
		 *  puis @param boutonActuel se vide afin de limiter les opérations et requiert une nouvelle sélection pour autres modifications.
		 */
		
		JButton btnOccupee = new JButton("");
		btnOccupee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boutonActuel != null)
				boutonActuel.setBackground(Color.YELLOW);
				boutonActuel = null;
			}
		});
		btnOccupee.setIcon(new ImageIcon(Interface.class.getResource("/imgs/button_occupee.png")));
		btnOccupee.setBounds(416, 11, 94, 29);
		DiviseurHaut.add(btnOccupee);
		btnOccupee.setVisible(false);
		
		/*
		 *  Création du bouton de changement d'état de table à "À Débarrasser". La table choisie en @param boutonActuel devient À Débarrasser,
		 *  puis @param boutonActuel se vide afin de limiter les opérations et requiert une nouvelle sélection pour autres modifications.
		 */
		
		JButton btnDebarrasser = new JButton("");
		btnDebarrasser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boutonActuel != null)
				boutonActuel.setBackground(Color.RED);
				boutonActuel = null;
			}
		});
		btnDebarrasser.setIcon(new ImageIcon(Interface.class.getResource("/imgs/button_a-debarrasser.png")));
		btnDebarrasser.setBounds(520, 11, 94, 29);
		DiviseurHaut.add(btnDebarrasser);
		btnDebarrasser.setVisible(false);
		
		/*
		 *  Création du bouton de changement d'état de table à "Autre Serveur". La table choisie en @param boutonActuel devient Autre Serveur,
		 *  puis @param boutonActuel se vide afin de limiter les opérations et requiert une nouvelle sélection pour autres modifications.
		 */
		
		JButton btnAutreServeur = new JButton("");
		btnAutreServeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boutonActuel != null)
				boutonActuel.setBackground(Color.LIGHT_GRAY);
				boutonActuel = null;
			}
		});
		btnAutreServeur.setIcon(new ImageIcon(Interface.class.getResource("/imgs/button_autre-serveur.png")));
		btnAutreServeur.setBounds(624, 11, 94, 29);
		DiviseurHaut.add(btnAutreServeur);
		btnAutreServeur.setVisible(false);
		
		// Création d'une metion de la table choisie pour les modification à apporter.
		
		JButton btnTableSaisie = new JButton("Table#");
		btnTableSaisie.setBounds(22, 13, 89, 23);
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);
		DiviseurHaut.add(btnTableSaisie);
		btnTableSaisie.setVisible(false);
		
		// Création d'un Label qui indique à l'utilisateur de choisir une table à modifier, puis son nouvel état.
		
		JLabel lblModTable = new JLabel("Choisir Table + État");
		lblModTable.setFont(new Font("Arial", Font.BOLD, 12));
		lblModTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblModTable.setBounds(121, 18, 125, 14);
		DiviseurHaut.add(lblModTable);
		lblModTable.setVisible(false);
		
		// Image utilisée pour la banière du haut.
		
		JLabel imgDiviseurHaut = new JLabel("");
		imgDiviseurHaut.setBounds(0, 0, 728, 48);
		imgDiviseurHaut.setIcon(new ImageIcon(Interface.class.getResource("/imgs/DiviseurHaut(inactif).jpg")));
		DiviseurHaut.add(imgDiviseurHaut);
		
		// Création de la banière de droite
		
		JPanel DiviseurDroite = new JPanel();
		DiviseurDroite.setBounds(727, 0, 119, 483);
		DiviseurDroite.setBackground(Color.RED);
		contentPane.add(DiviseurDroite);
		DiviseurDroite.setLayout(null);
		
		// Création d'un paneau qui contient des données relatives à l'utilisateur actuel
		
		JPanel PaneauUtilisateur = new JPanel();
		PaneauUtilisateur.setBounds(0, 0, 119, 47);
		DiviseurDroite.add(PaneauUtilisateur);
		PaneauUtilisateur.setBackground(Color.YELLOW);
		PaneauUtilisateur.setLayout(null);
		
		// Création d'un Label qui affiche ces informations
		
		JLabel boxUtilisateur = new JLabel("Utilisateur");
		boxUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		boxUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxUtilisateur.setBounds(10, 11, 99, 25);
		PaneauUtilisateur.add(boxUtilisateur);
		
		// Image utilisée pour le paneau utilisateur.
		
		JLabel imgUtilisateur = new JLabel("");
		imgUtilisateur.setVerticalAlignment(SwingConstants.TOP);
		imgUtilisateur.setBounds(0, 0, 119, 47);
		PaneauUtilisateur.add(imgUtilisateur);
		imgUtilisateur.setIcon(new ImageIcon(Interface.class.getResource("/imgs/Banner2.PNG")));
		
		// Création d'un paneau où sont affichées les informations relatives au temps.
		
		JPanel PaneauTemps = new JPanel();
		PaneauTemps.setBackground(Color.PINK);
		PaneauTemps.setBounds(0, 47, 119, 71);
		DiviseurDroite.add(PaneauTemps);
		PaneauTemps.setLayout(null);
		
		// Création d'un objet qui prend en compte les données relatives au temps actuel (synchronisation à l'ordinateur).
		
		LocalDateTime dateHeure = LocalDateTime.now();
		
		// Création d'un Label qui afficher le temps actuel selon un format mois, jour et année.
		
		DateTimeFormatter dtfJour = DateTimeFormatter.ofPattern("MMM dd, 2019");
		JLabel boxTempsJour = new JLabel("" +dtfJour.format(dateHeure));
		boxTempsJour.setFont(new Font("Tahoma", Font.BOLD, 13));
		boxTempsJour.setBounds(12, 11, 99, 29);
		PaneauTemps.add(boxTempsJour);
		
		// Création d'une Label qui affiche le temps actuel selon un format heure et minutes.
		
		DateTimeFormatter dtfHeure = DateTimeFormatter.ofPattern("hh:mm");
		JLabel lblNewLabel = new JLabel(""+dtfHeure.format(dateHeure));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(37, 35, 46, 14);
		PaneauTemps.add(lblNewLabel);
		
		// Image utilisée pour la banière du temps.
		
		JLabel imgTemps = new JLabel("");
		imgTemps.setBounds(0, 0, 119, 71);
		PaneauTemps.add(imgTemps);
		imgTemps.setIcon(new ImageIcon(Interface.class.getResource("/imgs/bane3.PNG")));
		
		// Création du bouton pour invoquer une fenêtre des archives.
		
		JButton btnArchive = new JButton("");
		btnArchive.setForeground(SystemColor.desktop);
		btnArchive.setBackground(SystemColor.desktop);
		btnArchive.setBounds(0, 363, 119, 74);
		DiviseurDroite.add(btnArchive);
		btnArchive.setIcon(new ImageIcon(Interface.class.getResource("/imgs/btnArchive.png")));
		
		// Création du bouton pour changer d'utilisateur.
		
		JButton btnUtilisateur = new JButton("");
		btnUtilisateur.setForeground(SystemColor.desktop);
		btnUtilisateur.setBackground(SystemColor.desktop);
		btnUtilisateur.setBounds(0, 146, 119, 74);
		DiviseurDroite.add(btnUtilisateur);
		btnUtilisateur.setIcon(new ImageIcon(Interface.class.getResource("/imgs/btnChange.png")));
		
		// Création du bouton pour modifier l'état d'une table.
		
		JButton btnModTable = new JButton("");
		btnModTable.addActionListener(new ActionListener() {
			
			/*
			 * Lorsque ce bouton est activé, on vérifie d'abord si la modification des tables est permise ou non. Son état est alors changé à son inverse,
			 * et l'interface est modifié de façon à respecter cet état; l'image de la banière du haut change en conséquence, tout comme la possibilité 
			 * de modifier l'état des tables.
			 */
			
			public void actionPerformed(ActionEvent e) {
				
				// Si modification permise.
				
				if(btnsActives) {
					btnsActives = false;
					imgDiviseurHaut.setIcon(new ImageIcon(Interface.class.getResource("/imgs/DiviseurHaut(inactif).jpg")));
					btnLibre.setVisible(false);
					btnOccupee.setVisible(false);
					btnDebarrasser.setVisible(false);
					btnAutreServeur.setVisible(false);
					btnTableSaisie.setVisible(false);
					lblModTable.setVisible(false);
				}
				
				// Si modification n'est pas permise.
				
				else {
					btnsActives = true;
					imgDiviseurHaut.setIcon(new ImageIcon(Interface.class.getResource("/imgs/DiviseurHaut(actif).png")));
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
		btnModTable.setIcon(new ImageIcon(Interface.class.getResource("/imgs/btnTable.png")));
		btnModTable.setForeground(SystemColor.desktop);
		btnModTable.setBackground(SystemColor.desktop);
		
		// Image utilisée pour la banière de droite.
		
		JLabel imgDiviseurDroite = new JLabel("New label");
		imgDiviseurDroite.setBounds(0, 118, 119, 365);
		DiviseurDroite.add(imgDiviseurDroite);
		imgDiviseurDroite.setIcon(new ImageIcon(Interface.class.getResource("/imgs/Bannerdroite.PNG")));
	
		
		/* 
		 * Boutons pour les tables de 1 à 24. Lorsque @param btnsActives est True, on peut intéragir avec les tables pour les modifier.
		 * La table sélectionnée en @param boutonActuel peut alors changer d'état ou être consultée et changée. Cette table est d'ailleurs
		 * affichée en haut à gauche comme état sélectionnée et prête à toute modification.
		 */
				
		JButton btnTable1 = new JButton("1");
		btnTable1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table1");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable1;
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
		btnTable2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table2");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable2;
				}
			}
		});
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
		btnTable3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table3");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable3;
				}
			}
		});
		
		JButton btnTable4 = new JButton("4");
		btnTable4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table4");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable4;
				}
			}
		});
		btnTable4.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable4.setMargin(new Insets(0, 0, 0, 0));
		btnTable4.setBackground(Color.LIGHT_GRAY);
		btnTable4.setContentAreaFilled(false);
		btnTable4.setOpaque(true);
		btnTable4.setBounds(290, 315, 20, 20);
		contentPane.add(btnTable4);
		
		JButton btnTable5 = new JButton("5");
		btnTable5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table5");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable5;
				}
			}
		});
		btnTable5.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable5.setMargin(new Insets(0, 0, 0, 0));
		btnTable5.setBackground(Color.LIGHT_GRAY);
		btnTable5.setContentAreaFilled(false);
		btnTable5.setOpaque(true);
		btnTable5.setBounds(290, 275, 20, 20);
		contentPane.add(btnTable5);
		
		JButton btnTable6 = new JButton("6");
		btnTable6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table6");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable6;
				}
			}
		});
		btnTable6.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable6.setMargin(new Insets(0, 0, 0, 0));
		btnTable6.setBackground(Color.LIGHT_GRAY);
		btnTable6.setContentAreaFilled(false);
		btnTable6.setOpaque(true);
		btnTable6.setBounds(290, 235, 20, 20);
		contentPane.add(btnTable6);
		
		JButton btnTable7 = new JButton("7");
		btnTable7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table7");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable7;
				}
			}
		});
		btnTable7.setMargin(new Insets(0, 0, 0, 0));
		btnTable7.setFont(new Font("Arial", Font.PLAIN, 13));
		btnTable7.setBackground(Color.LIGHT_GRAY);
		btnTable7.setContentAreaFilled(false);
		btnTable7.setOpaque(true);
		btnTable7.setBounds(290, 195, 20, 20);
		contentPane.add(btnTable7);
		
		JButton btnTable8 = new JButton("8");
		btnTable8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table8");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable8;
				}
			}
		});
		btnTable8.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable8.setMargin(new Insets(0, 0, 0, 0));
		btnTable8.setBackground(Color.LIGHT_GRAY);
		btnTable8.setContentAreaFilled(false);
		btnTable8.setOpaque(true);
		btnTable8.setBounds(332, 154, 20, 20);
		contentPane.add(btnTable8);
		
		JButton btnTable9 = new JButton("9");
		btnTable9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table9");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable9;
				}
			}
		});
		btnTable9.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable9.setMargin(new Insets(0, 0, 0, 0));
		btnTable9.setBackground(Color.LIGHT_GRAY);
		btnTable9.setContentAreaFilled(false);
		btnTable9.setOpaque(true);
		btnTable9.setBounds(372, 154, 20, 20);
		contentPane.add(btnTable9);
		
		JButton btnTable10 = new JButton("10");
		btnTable10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table100");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable10;
				}
			}
		});
		btnTable10.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable10.setMargin(new Insets(0, 0, 0, 0));;
		btnTable10.setBackground(Color.LIGHT_GRAY);
		btnTable10.setContentAreaFilled(false);
		btnTable10.setOpaque(true);
		btnTable10.setBounds(414, 195, 20, 20);
		contentPane.add(btnTable10);
		
		JButton btnTable11 = new JButton("11");
		btnTable11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table11");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable11;
				}
			}
		});
		btnTable11.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable11.setMargin(new Insets(0, 0, 0, 0));
		btnTable11.setBackground(Color.LIGHT_GRAY);
		btnTable11.setContentAreaFilled(false);
		btnTable11.setOpaque(true);
		btnTable11.setBounds(414, 235, 20, 20);
		contentPane.add(btnTable11);
		
		JButton btnTable12 = new JButton("12");
		btnTable12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table12");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable12;
				}
			}
		});
		btnTable12.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable12.setMargin(new Insets(0, 0, 0, 0));
		btnTable12.setBackground(Color.LIGHT_GRAY);
		btnTable12.setContentAreaFilled(false);
		btnTable12.setOpaque(true);
		btnTable12.setBounds(414, 275, 20, 20);
		contentPane.add(btnTable12);
		
		JButton btnTable13 = new JButton("13");
		btnTable13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table13");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable13;
				}
			}
		});
		btnTable13.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable13.setMargin(new Insets(0, 0, 0, 0));
		btnTable13.setBackground(Color.LIGHT_GRAY);
		btnTable13.setContentAreaFilled(false);
		btnTable13.setOpaque(true);
		btnTable13.setBounds(414, 315, 20, 20);
		contentPane.add(btnTable13);
		
		JButton btnTable14 = new JButton("14");
		btnTable14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table14");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable14;
				}
			}
		});
		btnTable14.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable14.setMargin(new Insets(0, 0, 0, 0));
		btnTable14.setBackground(Color.LIGHT_GRAY);
		btnTable14.setContentAreaFilled(false);
		btnTable14.setOpaque(true);
		btnTable14.setBounds(414, 355, 20, 20);
		contentPane.add(btnTable14);
		
		JButton btnTable15 = new JButton("15");
		btnTable15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table15");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable15;
				}
			}
		});
		btnTable15.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable15.setMargin(new Insets(0, 0, 0, 0));
		btnTable15.setBackground(Color.LIGHT_GRAY);
		btnTable15.setContentAreaFilled(false);
		btnTable15.setOpaque(true);
		btnTable15.setBounds(414, 395, 20, 20);
		contentPane.add(btnTable15);

		JButton btnTable16 = new JButton("16");
		btnTable16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table16");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable16;
				}
			}
		});
		btnTable16.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable16.setMargin(new Insets(0, 0, 0, 0));
		btnTable16.setBackground(Color.LIGHT_GRAY);
		btnTable16.setContentAreaFilled(false);
		btnTable16.setOpaque(true);
		btnTable16.setBounds(414, 435, 20, 20);
		contentPane.add(btnTable16);
		
		JButton btnTable17 = new JButton("17");
		btnTable17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table17");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable17;
				}
			}
		});
		btnTable17.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable17.setBackground(Color.LIGHT_GRAY);
		btnTable17.setContentAreaFilled(false);
		btnTable17.setOpaque(true);
		btnTable17.setBounds(77, 80, 50, 50);
		contentPane.add(btnTable17);
		
		JButton btnTable18 = new JButton("18");
		btnTable18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table18");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable18;
				}
			}
		});
		btnTable18.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable18.setBackground(Color.LIGHT_GRAY);
		btnTable18.setContentAreaFilled(false);
		btnTable18.setOpaque(true);
		btnTable18.setBounds(77, 180, 50, 50);
		contentPane.add(btnTable18);
		
		JButton btnTable19 = new JButton("19");
		btnTable19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table19");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable19;
				}
			}
		});
		btnTable19.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable19.setBackground(Color.LIGHT_GRAY);
		btnTable19.setContentAreaFilled(false);
		btnTable19.setOpaque(true);
		btnTable19.setBounds(77, 280, 50, 50);
		contentPane.add(btnTable19);
		
		JButton btnTable20 = new JButton("20");
		btnTable20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table20");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable20;
				}
			}
		});
		btnTable20.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable20.setBackground(Color.LIGHT_GRAY);
		btnTable20.setContentAreaFilled(false);
		btnTable20.setOpaque(true);
		btnTable20.setBounds(77, 380, 50, 50);
		contentPane.add(btnTable20);
		
		JButton btnTable21 = new JButton("21");
		btnTable21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table21");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable21;
				}
			}
		});
		btnTable21.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable21.setBackground(Color.LIGHT_GRAY);
		btnTable21.setContentAreaFilled(false);
		btnTable21.setOpaque(true);
		btnTable21.setBounds(597, 80, 50, 50);
		contentPane.add(btnTable21);
		
		JButton btnTable22 = new JButton("22");
		btnTable22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table22");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable22;
				}
			}
		});
		btnTable22.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable22.setBackground(Color.LIGHT_GRAY);
		btnTable22.setContentAreaFilled(false);
		btnTable22.setOpaque(true);
		btnTable22.setBounds(597, 180, 50, 50);
		contentPane.add(btnTable22);
		
		JButton btnTable23 = new JButton("23");
		btnTable23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table23");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable23;
				}
			}
		});
		btnTable23.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable23.setBackground(Color.LIGHT_GRAY);
		btnTable23.setContentAreaFilled(false);
		btnTable23.setOpaque(true);
		btnTable23.setBounds(597, 280, 50, 50);
		contentPane.add(btnTable23);

		JButton btnTable24 = new JButton("24");
		btnTable24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnsActives) {
					btnTableSaisie.setText("Table24");
					lblModTable.setText("Choisir Table + État");
					boutonActuel = btnTable24;
				}
			}
		});
		btnTable24.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable24.setBackground(Color.LIGHT_GRAY);
		btnTable24.setContentAreaFilled(false);
		btnTable24.setOpaque(true);
		btnTable24.setBounds(597, 380, 50, 50);
		contentPane.add(btnTable24);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowUtilisateurs WU = new WindowUtilisateurs();
				WU.afficherUtil();
			}
		});
		btnNewButton.setBounds(303, 94, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel imgSalle = new JLabel("");
		imgSalle.setIcon(new ImageIcon(Interface.class.getResource("/imgs/InterfaceSalle.png")));
		imgSalle.setBounds(0, 48, 725, 435);
		contentPane.add(imgSalle);		
	}
	
	
}
