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
	private static boolean btnsActives = false; // Variable qui permet d'afficher les boutons d'�tat de table.
	private static JButton boutonActuel; // Variable utilis�e pour d�terminer quel table a �t� s�lectionn�e pour
											// modification.
	private static boolean btnsClients = false; // Variable qui permet d'afficher les boutons des clients d'une table.

	public Interface() {

		// Cr�ation de la fen�tre de l'application.

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 522);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Cr�ation de la bani�re du haut.

		JPanel DiviseurHaut = new JPanel();
		DiviseurHaut.setBounds(0, 0, 728, 48);
		DiviseurHaut.setBackground(Color.GREEN);
		contentPane.add(DiviseurHaut);
		DiviseurHaut.setLayout(null);

		/*
		 * Cr�ation du bouton de changement d'�tat de table � "Libre". La table choisie
		 * en @param boutonActuel devient Libre, puis @param boutonActuel se vide afin
		 * de limiter les op�rations et requiert une nouvelle s�lection pour autres
		 * modifications.
		 */

		JButton btnLibre = new JButton("");
		btnLibre.setIcon(new ImageIcon(Interface.class.getResource("/imgs/button_libre.png")));
		btnLibre.setBounds(312, 11, 94, 29);
		DiviseurHaut.add(btnLibre);
		btnLibre.setVisible(false);
		btnLibre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boutonActuel != null)
					boutonActuel.setBackground(Color.GREEN);
				boutonActuel = null;
			}
		});

		/*
		 * Cr�ation du bouton de changement d'�tat de table � "Occup�e". La table
		 * choisie en @param boutonActuel devient Occup�e, puis @param boutonActuel se
		 * vide afin de limiter les op�rations et requiert une nouvelle s�lection pour
		 * autres modifications.
		 */

		JButton btnOccupee = new JButton("");
		btnOccupee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boutonActuel != null)
					boutonActuel.setBackground(Color.YELLOW);
				boutonActuel = null;
			}
		});
		btnOccupee.setIcon(new ImageIcon(Interface.class.getResource("/imgs/button_occupee.png")));
		btnOccupee.setBounds(416, 11, 94, 29);
		DiviseurHaut.add(btnOccupee);
		btnOccupee.setVisible(false);

		/*
		 * Cr�ation du bouton de changement d'�tat de table � "� D�barrasser". La table
		 * choisie en @param boutonActuel devient � D�barrasser, puis @param
		 * boutonActuel se vide afin de limiter les op�rations et requiert une nouvelle
		 * s�lection pour autres modifications.
		 */

		JButton btnDebarrasser = new JButton("");
		btnDebarrasser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boutonActuel != null)
					boutonActuel.setBackground(Color.RED);
				boutonActuel = null;
			}
		});
		btnDebarrasser.setIcon(new ImageIcon(Interface.class.getResource("/imgs/button_a-debarrasser.png")));
		btnDebarrasser.setBounds(520, 11, 94, 29);
		DiviseurHaut.add(btnDebarrasser);
		btnDebarrasser.setVisible(false);

		/*
		 * Cr�ation du bouton de changement d'�tat de table � "Autre Serveur". La table
		 * choisie en @param boutonActuel devient Autre Serveur, puis @param
		 * boutonActuel se vide afin de limiter les op�rations et requiert une nouvelle
		 * s�lection pour autres modifications.
		 */

		JButton btnAutreServeur = new JButton("");
		btnAutreServeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boutonActuel != null)
					boutonActuel.setBackground(Color.LIGHT_GRAY);
				boutonActuel = null;
			}
		});
		btnAutreServeur.setIcon(new ImageIcon(Interface.class.getResource("/imgs/button_autre-serveur.png")));
		btnAutreServeur.setBounds(624, 11, 94, 29);
		DiviseurHaut.add(btnAutreServeur);
		btnAutreServeur.setVisible(false);

		// Cr�ation d'une metion de la table choisie pour les modification � apporter.

		JButton btnTableSaisie = new JButton("Table#");
		btnTableSaisie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTableSaisie.setBounds(10, 11, 81, 30);
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);
		DiviseurHaut.add(btnTableSaisie);
		btnTableSaisie.setVisible(false);

		// Cr�ation d'un Label qui indique � l'utilisateur de choisir une table �
		// modifier, puis son nouvel �tat.

		JLabel lblModTable = new JLabel("Choisir Table + �tat");
		lblModTable.setFont(new Font("Arial", Font.BOLD, 12));
		lblModTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblModTable.setBounds(101, 19, 125, 14);
		DiviseurHaut.add(lblModTable);
		lblModTable.setVisible(false);

		// Cr�ation d'un bouton pour changer l'utilisateur

		JButton btnNewUtilisateur = new JButton("Utilisateur");
		btnNewUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowUtilisateurs WU = new WindowUtilisateurs();
				WU.afficherUtil();
			}
		});
		btnNewUtilisateur.setBounds(290, 107, 144, 23);
		btnNewUtilisateur.setBorder(null);
		contentPane.add(btnNewUtilisateur);

		// Image utilis�e pour la bani�re du haut.

		JLabel imgDiviseurHaut = new JLabel("");
		imgDiviseurHaut.setBounds(0, 0, 728, 48);
		imgDiviseurHaut.setIcon(new ImageIcon(Interface.class.getResource("/imgs/DiviseurHaut(inactif).jpg")));
		DiviseurHaut.add(imgDiviseurHaut);

		// Cr�ation de la bani�re de droite

		JPanel DiviseurDroite = new JPanel();
		DiviseurDroite.setBounds(727, 0, 119, 483);
		DiviseurDroite.setBackground(Color.RED);
		contentPane.add(DiviseurDroite);
		DiviseurDroite.setLayout(null);

		// Cr�ation d'un paneau qui contient des donn�es relatives � l'utilisateur
		// actuel

		JPanel PaneauUtilisateur = new JPanel();
		PaneauUtilisateur.setBounds(0, 0, 119, 47);
		DiviseurDroite.add(PaneauUtilisateur);
		PaneauUtilisateur.setBackground(Color.YELLOW);
		PaneauUtilisateur.setLayout(null);

		// Cr�ation d'un Label qui affiche ces informations

		JLabel boxUtilisateur = new JLabel("Utilisateur");
		boxUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		boxUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxUtilisateur.setBounds(10, 11, 99, 25);
		PaneauUtilisateur.add(boxUtilisateur);

		// Image utilis�e pour le paneau utilisateur.

		JLabel imgUtilisateur = new JLabel("");
		imgUtilisateur.setVerticalAlignment(SwingConstants.TOP);
		imgUtilisateur.setBounds(0, 0, 119, 47);
		PaneauUtilisateur.add(imgUtilisateur);
		imgUtilisateur.setIcon(new ImageIcon(Interface.class.getResource("/imgs/Banner2.PNG")));

		// Cr�ation d'un paneau o� sont affich�es les informations relatives au temps.

		JPanel PaneauTemps = new JPanel();
		PaneauTemps.setBackground(Color.PINK);
		PaneauTemps.setBounds(0, 47, 119, 71);
		PaneauTemps.setBorder(null);
		DiviseurDroite.add(PaneauTemps);
		PaneauTemps.setLayout(null);

		// Cr�ation d'un objet qui prend en compte les donn�es relatives au temps actuel
		// (synchronisation � l'ordinateur).

		LocalDateTime dateHeure = LocalDateTime.now();

		// Cr�ation d'un Label qui afficher le temps actuel selon un format mois, jour
		// et ann�e.

		DateTimeFormatter dtfJour = DateTimeFormatter.ofPattern("MMM dd, 2019");
		JLabel boxTempsJour = new JLabel("" + dtfJour.format(dateHeure));
		boxTempsJour.setFont(new Font("Tahoma", Font.BOLD, 13));
		boxTempsJour.setBounds(12, 11, 99, 29);
		boxTempsJour.setBorder(null);
		PaneauTemps.add(boxTempsJour);

		// Cr�ation d'une Label qui affiche le temps actuel selon un format heure et
		// minutes.

		DateTimeFormatter dtfHeure = DateTimeFormatter.ofPattern("hh:mm");
		JLabel lblNewLabel = new JLabel("" + dtfHeure.format(dateHeure));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(37, 35, 46, 14);
		lblNewLabel.setBorder(null);
		PaneauTemps.add(lblNewLabel);

		// Image utilis�e pour la bani�re du temps.

		JLabel imgTemps = new JLabel("");
		imgTemps.setBounds(0, 0, 119, 71);
		PaneauTemps.add(imgTemps);
		imgTemps.setIcon(new ImageIcon(Interface.class.getResource("/imgs/bane3.PNG")));

		// Cr�ation du bouton pour invoquer une fen�tre des archives.

		JButton btnArchive = new JButton("Archives");
		btnArchive.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnArchive.setForeground(new Color(255, 255, 255));
		btnArchive.setBackground(new Color(50, 205, 50));
		btnArchive.setBounds(0, 363, 119, 85);
		DiviseurDroite.add(btnArchive);

		// Cr�ation du bouton pour changer d'utilisateur.

		JButton btnUtilisateur = new JButton("Utilisateurs");
		btnUtilisateur.setHorizontalAlignment(SwingConstants.LEFT);
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUtilisateur.setForeground(new Color(255, 255, 255));
		btnUtilisateur.setBackground(new Color(50, 205, 50));
		btnUtilisateur.setBounds(0, 146, 119, 85);
		btnUtilisateur.setBorder(null);
		DiviseurDroite.add(btnUtilisateur);

		/*
		 * Boutons pour les tables de 1 � 24. Lorsque @param btnsActives est True, on
		 * peut int�ragir avec les tables pour les modifier. La table s�lectionn�e
		 * en @param boutonActuel peut alors changer d'�tat ou �tre consult�e et
		 * chang�e. Cette table est d'ailleurs affich�e en haut � gauche comme �tat
		 * s�lectionn�e et pr�te � toute modification.
		 */

		JButton btnTable1 = new JButton("1");
		btnTable1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table1");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable1;
				}
			}
		});

		btnTable1.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable1.setMargin(new Insets(0, 0, 0, 0));
		btnTable1.setBorder(null);
		btnTable1.setBackground(Color.LIGHT_GRAY);
		btnTable1.setContentAreaFilled(false);
		btnTable1.setOpaque(true);
		btnTable1.setBounds(290, 435, 20, 20);
		contentPane.add(btnTable1);

		JButton btnTable2 = new JButton("2");
		btnTable2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table2");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable2;
				}
			}
		});
		btnTable2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table2");
					String cmd = e.getActionCommand();

					if (cmd.equals("2")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

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
				if (btnsActives) {
					btnTableSaisie.setText("Table3");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable3;
				}
			}
		});
		btnTable3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table3");
					String cmd = e.getActionCommand();

					if (cmd.equals("3")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		JButton btnTable4 = new JButton("4");
		btnTable4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table4");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable4;
				}
			}
		});
		btnTable4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table4");
					String cmd = e.getActionCommand();

					if (cmd.equals("4")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

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
				if (btnsActives) {
					btnTableSaisie.setText("Table5");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable5;
				}
			}
		});
		btnTable5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table5");
					String cmd = e.getActionCommand();

					if (cmd.equals("5")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

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
				if (btnsActives) {
					btnTableSaisie.setText("Table6");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable6;
				}
			}
		});
		btnTable6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table6");
					String cmd = e.getActionCommand();

					if (cmd.equals("6")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

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
				if (btnsActives) {
					btnTableSaisie.setText("Table7");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable7;
				}
			}
		});
		btnTable7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table7");
					String cmd = e.getActionCommand();

					if (cmd.equals("7")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

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
				if (btnsActives) {
					btnTableSaisie.setText("Table8");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable8;
				}
			}
		});
		btnTable8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table8");
					String cmd = e.getActionCommand();

					if (cmd.equals("8")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

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
				if (btnsActives) {
					btnTableSaisie.setText("Table9");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable9;
				}
			}
		});
		btnTable9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table9");
					String cmd = e.getActionCommand();

					if (cmd.equals("9")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

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
				if (btnsActives) {
					btnTableSaisie.setText("Table100");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable10;
				}
			}
		});
		btnTable10.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table10");
					String cmd = e.getActionCommand();

					if (cmd.equals("10")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable10.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable10.setMargin(new Insets(0, 0, 0, 0));
		btnTable10.setBackground(Color.LIGHT_GRAY);
		btnTable10.setBorder(null);
		btnTable10.setContentAreaFilled(false);
		btnTable10.setOpaque(true);
		btnTable10.setBounds(414, 195, 20, 20);
		contentPane.add(btnTable10);

		JButton btnTable11 = new JButton("11");
		btnTable11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table11");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable11;
				}
			}
		});
		btnTable11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table11");
					String cmd = e.getActionCommand();

					if (cmd.equals("11")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable11.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable11.setMargin(new Insets(0, 0, 0, 0));
		btnTable11.setBackground(Color.LIGHT_GRAY);
		btnTable11.setBorder(null);
		btnTable11.setContentAreaFilled(false);
		btnTable11.setOpaque(true);
		btnTable11.setBounds(414, 235, 20, 20);
		contentPane.add(btnTable11);

		JButton btnTable12 = new JButton("12");
		btnTable12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table12");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable12;
				}
			}
		});
		btnTable12.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table12");
					String cmd = e.getActionCommand();

					if (cmd.equals("12")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable12.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable12.setMargin(new Insets(0, 0, 0, 0));
		btnTable12.setBackground(Color.LIGHT_GRAY);
		btnTable12.setBorder(null);
		btnTable12.setContentAreaFilled(false);
		btnTable12.setOpaque(true);
		btnTable12.setBounds(414, 275, 20, 20);
		contentPane.add(btnTable12);

		JButton btnTable13 = new JButton("13");
		btnTable13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table13");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable13;
				}
			}
		});
		btnTable13.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table13");
					String cmd = e.getActionCommand();

					if (cmd.equals("13")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable13.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable13.setMargin(new Insets(0, 0, 0, 0));
		btnTable13.setBackground(Color.LIGHT_GRAY);
		btnTable13.setBorder(null);
		btnTable13.setContentAreaFilled(false);
		btnTable13.setOpaque(true);
		btnTable13.setBounds(414, 315, 20, 20);
		contentPane.add(btnTable13);

		JButton btnTable14 = new JButton("14");
		btnTable14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table14");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable14;
				}
			}
		});
		btnTable14.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table14");
					String cmd = e.getActionCommand();

					if (cmd.equals("14")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable14.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable14.setMargin(new Insets(0, 0, 0, 0));
		btnTable14.setBackground(Color.LIGHT_GRAY);
		btnTable14.setBorder(null);
		btnTable14.setContentAreaFilled(false);
		btnTable14.setOpaque(true);
		btnTable14.setBounds(414, 355, 20, 20);
		contentPane.add(btnTable14);

		JButton btnTable15 = new JButton("15");
		btnTable15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table15");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable15;
				}
			}
		});
		btnTable15.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table15");
					String cmd = e.getActionCommand();

					if (cmd.equals("15")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable15.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable15.setMargin(new Insets(0, 0, 0, 0));
		btnTable15.setBackground(Color.LIGHT_GRAY);
		btnTable15.setBorder(null);
		btnTable15.setContentAreaFilled(false);
		btnTable15.setOpaque(true);
		btnTable15.setBounds(414, 395, 20, 20);
		contentPane.add(btnTable15);

		JButton btnTable16 = new JButton("16");
		btnTable16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table16");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable16;
				}
			}
		});
		btnTable16.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table16");
					String cmd = e.getActionCommand();

					if (cmd.equals("16")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable16.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable16.setMargin(new Insets(0, 0, 0, 0));
		btnTable16.setBackground(Color.LIGHT_GRAY);
		btnTable16.setBorder(null);
		btnTable16.setContentAreaFilled(false);
		btnTable16.setOpaque(true);
		btnTable16.setBounds(414, 435, 20, 20);
		contentPane.add(btnTable16);

		JButton btnTable17 = new JButton("17");
		btnTable17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table17");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable17;
				}
			}
		});
		btnTable17.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table17");
					String cmd = e.getActionCommand();

					if (cmd.equals("17")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable17.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable17.setBackground(Color.LIGHT_GRAY);
		btnTable17.setContentAreaFilled(false);
		btnTable17.setBorder(null);
		btnTable17.setOpaque(true);
		btnTable17.setBounds(77, 80, 50, 50);
		contentPane.add(btnTable17);

		JButton btnTable18 = new JButton("18");
		btnTable18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table18");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable18;
				}
			}
		});
		btnTable18.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table18");
					String cmd = e.getActionCommand();

					if (cmd.equals("18")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable18.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable18.setBackground(Color.LIGHT_GRAY);
		btnTable18.setContentAreaFilled(false);
		btnTable18.setBorder(null);
		btnTable18.setOpaque(true);
		btnTable18.setBounds(77, 180, 50, 50);
		contentPane.add(btnTable18);

		JButton btnTable19 = new JButton("19");
		btnTable19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table19");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable19;
				}
			}
		});
		btnTable19.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table19");
					String cmd = e.getActionCommand();

					if (cmd.equals("19")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable19.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable19.setBackground(Color.LIGHT_GRAY);
		btnTable19.setContentAreaFilled(false);
		btnTable19.setBorder(null);
		btnTable19.setOpaque(true);
		btnTable19.setBounds(77, 280, 50, 50);
		contentPane.add(btnTable19);

		JButton btnTable20 = new JButton("20");
		btnTable20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table20");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable20;
				}
			}
		});
		btnTable20.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table20");
					String cmd = e.getActionCommand();

					if (cmd.equals("20")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable20.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable20.setBackground(Color.LIGHT_GRAY);
		btnTable20.setContentAreaFilled(false);
		btnTable20.setBorder(null);
		btnTable20.setOpaque(true);
		btnTable20.setBounds(77, 380, 50, 50);
		contentPane.add(btnTable20);

		JButton btnTable21 = new JButton("21");
		btnTable21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table21");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable21;
				}
			}
		});
		btnTable21.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table21");
					String cmd = e.getActionCommand();

					if (cmd.equals("21")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable21.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable21.setBackground(Color.LIGHT_GRAY);
		btnTable21.setContentAreaFilled(false);
		btnTable21.setBorder(null);
		btnTable21.setOpaque(true);
		btnTable21.setBounds(597, 80, 50, 50);
		contentPane.add(btnTable21);

		JButton btnTable22 = new JButton("22");
		btnTable22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table22");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable22;
				}
			}
		});
		btnTable22.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table22");
					String cmd = e.getActionCommand();

					if (cmd.equals("22")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable22.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable22.setBackground(Color.LIGHT_GRAY);
		btnTable22.setContentAreaFilled(false);
		btnTable22.setBorder(null);
		btnTable22.setOpaque(true);
		btnTable22.setBounds(597, 180, 50, 50);
		contentPane.add(btnTable22);

		JButton btnTable23 = new JButton("23");
		btnTable23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table23");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable23;
				}
			}
		});
		btnTable23.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table23");
					String cmd = e.getActionCommand();

					if (cmd.equals("23")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable23.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable23.setBackground(Color.LIGHT_GRAY);
		btnTable23.setContentAreaFilled(false);
		btnTable23.setBorder(null);
		btnTable23.setOpaque(true);
		btnTable23.setBounds(597, 280, 50, 50);
		contentPane.add(btnTable23);

		JButton btnTable24 = new JButton("24");
		btnTable24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsActives) {
					btnTableSaisie.setText("Table24");
					lblModTable.setText("Choisir Table + �tat");
					boutonActuel = btnTable24;
				}
			}
		});
		btnTable24.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnsClients) {
					btnTableSaisie.setText("Table24");
					String cmd = e.getActionCommand();

					if (cmd.equals("24")) {
						dispose();

						new InterfaceB().setVisible(true);
					}

				}

			}
		});

		btnTable24.setFont(new Font("Arial", Font.BOLD, 13));
		btnTable24.setBackground(Color.LIGHT_GRAY);
		btnTable24.setContentAreaFilled(false);
		btnTable24.setBorder(null);
		btnTable24.setOpaque(true);
		btnTable24.setBounds(597, 380, 50, 50);
		contentPane.add(btnTable24);

		
		
		
		
		// Image utilis�e pour l'interface principale, ici la salle.

		JLabel imgSalle = new JLabel("");
		imgSalle.setIcon(new ImageIcon(Interface.class.getResource("/imgs/InterfaceSalle.png")));
		imgSalle.setBounds(0, 48, 725, 435);
		contentPane.add(imgSalle);

		// Cr�ation du bouton pour choisir les clients d'une table

		JButton btnClientsTable = new JButton("Clients");
		btnClientsTable.setForeground(new Color(255, 255, 255));
		btnClientsTable.addActionListener(new ActionListener() {

			/*
			 */

			public void actionPerformed(ActionEvent e) {

				// Si modification permise.

				if (btnsClients) {
					btnsClients = false;
					btnsActives = false;

					imgDiviseurHaut
							.setIcon(new ImageIcon(Interface.class.getResource("/imgs/DiviseurHaut(actif).jpg")));
					btnLibre.setVisible(false);
					btnOccupee.setVisible(false);
					btnDebarrasser.setVisible(false);
					btnAutreServeur.setVisible(false);
					btnTableSaisie.setVisible(false);
					lblModTable.setVisible(false);
					btnClientsTable.setVisible(true);
					btnUtilisateur.setVisible(true);
					// btnRetour.setVisible(false);
					btnTable1.setVisible(true);

				}

				//

				else {
					btnsClients = true;
					imgDiviseurHaut
							.setIcon(new ImageIcon(Interface.class.getResource("/imgs/DiviseurHaut(actif).PNG")));
					btnLibre.setVisible(false);
					btnOccupee.setVisible(false);
					btnDebarrasser.setVisible(false);
					btnAutreServeur.setVisible(false);
					btnTableSaisie.setVisible(true);
					lblModTable.setVisible(false);
					btnClientsTable.setVisible(true);
					btnUtilisateur.setVisible(false);
					btnNewUtilisateur.setVisible(false);

				}
			}

		});
		btnClientsTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClientsTable.setBackground(new Color(50, 205, 50));
		btnClientsTable.setBounds(0, 146, 119, 85);
		DiviseurDroite.add(btnClientsTable);

		// Cr�ation du bouton pour modifier l'�tat d'une table.

		JButton btnModTable = new JButton("\u00C9tat tables");
		btnModTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModTable.setBorder(null);
		btnModTable.addActionListener(new ActionListener() {

			/*
			 * Lorsque ce bouton est activ�, on v�rifie d'abord si la modification des
			 * tables est permise ou non. Son �tat est alors chang� � son inverse, et
			 * l'interface est modifi� de fa�on � respecter cet �tat; l'image de la bani�re
			 * du haut change en cons�quence, tout comme la possibilit� de modifier l'�tat
			 * des tables.
			 */

			public void actionPerformed(ActionEvent e) {

				// Si modification permise.

				if (btnsActives) {
					btnsActives = false;
					imgDiviseurHaut
							.setIcon(new ImageIcon(Interface.class.getResource("/imgs/DiviseurHaut(inactif).jpg")));
					btnLibre.setVisible(false);
					btnOccupee.setVisible(false);
					btnDebarrasser.setVisible(false);
					btnAutreServeur.setVisible(false);
					btnTableSaisie.setVisible(false);
					lblModTable.setVisible(false);
					btnClientsTable.setVisible(false);
					btnUtilisateur.setVisible(true);

				}

				// Si modification n'est pas permise.

				else {
					btnsActives = true;
					imgDiviseurHaut
							.setIcon(new ImageIcon(Interface.class.getResource("/imgs/DiviseurHaut(actif).PNG")));
					btnLibre.setVisible(true);
					btnOccupee.setVisible(true);
					btnDebarrasser.setVisible(true);
					btnAutreServeur.setVisible(true);
					btnTableSaisie.setVisible(true);
					lblModTable.setVisible(true);
					btnClientsTable.setVisible(true);
					btnUtilisateur.setVisible(false);
				}
			}

		});
		btnModTable.setBounds(0, 256, 119, 85);
		DiviseurDroite.add(btnModTable);
		btnModTable.setForeground(new Color(255, 255, 255));
		btnModTable.setBackground(new Color(50, 205, 50));

		// Image utilis�e pour la bani�re de droite.

		JLabel imgDiviseurDroite = new JLabel("New label");
		imgDiviseurDroite.setBounds(0, 118, 119, 365);
		DiviseurDroite.add(imgDiviseurDroite);
		imgDiviseurDroite.setIcon(new ImageIcon(Interface.class.getResource("/imgs/Bannerdroite.PNG")));

		/*
		 * Background.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { if (btnsClients) {
		 * btnTableSaisie.setText("Table1"); Background.setVisible(true);
		 * btnClient1.setVisible(true); btnClient2.setVisible(true);
		 * btnClient3.setVisible(true); btnClient4.setVisible(true);
		 * btnClient5.setVisible(true); btnClient6.setVisible(true);
		 * btnTable1.setVisible(false);
		 * 
		 * } } });
		 */

	}
}
