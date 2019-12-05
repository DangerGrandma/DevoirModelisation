package outils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class InterfaceB extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceB frame = new InterfaceB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static boolean btnsAjout = false; // Variable qui permet d'ajouter des clients
	private static boolean btnsSupp = false; // Variable qui permet de supprimer des clients

	public InterfaceB() {

		// Création de la fenêtre de l'application.

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
		DiviseurHaut.setBackground(new Color(128, 128, 128));
		contentPane.add(DiviseurHaut);
		DiviseurHaut.setLayout(null);

		// Création de la banière de droite

		JPanel DiviseurDroite = new JPanel();
		DiviseurDroite.setBounds(727, 0, 119, 483);
		DiviseurDroite.setBackground(new Color(128, 128, 128));
		contentPane.add(DiviseurDroite);
		DiviseurDroite.setLayout(null);

		// Création d'un paneau qui contient des données relatives à l'utilisateur
		// actuel

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

		// Création d'un objet qui prend en compte les données relatives au temps actuel
		// (synchronisation à l'ordinateur).

		LocalDateTime dateHeure = LocalDateTime.now();

		// Création d'un Label qui afficher le temps actuel selon un format mois, jour
		// et année.

		DateTimeFormatter dtfJour = DateTimeFormatter.ofPattern("MMM dd, 2019");
		JLabel boxTempsJour = new JLabel("" + dtfJour.format(dateHeure));
		boxTempsJour.setFont(new Font("Tahoma", Font.BOLD, 13));
		boxTempsJour.setBounds(12, 11, 99, 29);
		PaneauTemps.add(boxTempsJour);

		// Création d'une metion de la table choisie pour les modification à apporter.

		JButton btnTableSaisie = new JButton("Table#");
		btnTableSaisie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTableSaisie.setBounds(637, 12, 81, 30);
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);
		DiviseurHaut.add(btnTableSaisie);

		// Création d'une Label qui affiche le temps actuel selon un format heure et
		// minutes.

		DateTimeFormatter dtfHeure = DateTimeFormatter.ofPattern("hh:mm");
		JLabel lblNewLabel = new JLabel("" + dtfHeure.format(dateHeure));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(37, 35, 46, 14);
		PaneauTemps.add(lblNewLabel);

		// Image utilisée pour la banière du temps.

		JLabel imgTemps = new JLabel("");
		imgTemps.setBounds(0, 0, 119, 71);
		PaneauTemps.add(imgTemps);
		imgTemps.setIcon(new ImageIcon(Interface.class.getResource("/imgs/bane3.PNG")));

		// Création d'un bouton pour joindre les factures de plusieurs clients
		JButton btnJoindre = new JButton("Joindre");
		btnJoindre.setForeground(Color.BLACK);
		btnJoindre.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnJoindre.setBackground(new Color(50, 205, 50));
		btnJoindre.setBounds(0, 263, 119, 71);
		DiviseurDroite.add(btnJoindre);

		// Création d'un bouton pour faire le paiement/imprimer une facture
		JButton BtnPayement = new JButton("Paiement");
		BtnPayement.setForeground(Color.BLACK);
		BtnPayement.setFont(new Font("Tahoma", Font.BOLD, 11));
		BtnPayement.setBackground(new Color(50, 205, 50));
		BtnPayement.setBounds(0, 379, 119, 71);
		DiviseurDroite.add(BtnPayement);

		// Création du bouton Retour qui amène l'utlisateur à l'interface A.

		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRetour.setBackground(new Color(0, 0, 128));
		btnRetour.setBounds(7, 11, 94, 29);
		DiviseurHaut.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (cmd.equals("RETOUR")) {
					dispose();

					new Interface().setVisible(true);
				}

			}
		});

		/*
		 * Création des six boutons des clients possible à la table sélectionnée à coté
		 * de chaque client, il y a une option de supprimer le client ou de l'ajouter à
		 * la liste d'une table
		 */

		// Client 1

		JCheckBox Client1 = new JCheckBox("Client 1");
		Client1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client1.setBounds(78, 96, 99, 38);
		Client1.setVisible(true);
		contentPane.add(Client1);
		// Client1.setSelected(false);

		// Bouton qui permet d'ajouter le client 1
		JButton Ajouter1 = new JButton("+");
		Ajouter1.setForeground(Color.RED);
		Ajouter1.setVerticalAlignment(SwingConstants.TOP);
		Ajouter1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter1.setBounds(183, 96, 52, 35);
		Ajouter1.setVisible(false);
		contentPane.add(Ajouter1);

		// Bouton qui permet de soustraire le client 1
		JButton Soustraire1 = new JButton("-");
		Soustraire1.setVerticalAlignment(SwingConstants.TOP);
		Soustraire1.setForeground(Color.RED);
		Soustraire1.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire1.setBounds(245, 96, 52, 35);
		contentPane.add(Soustraire1);
		Soustraire1.setVisible(true);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsAjout) {
					btnsAjout = false;
					Client1.setVisible(false);
				} else {
					btnsAjout = true;
					Client1.setVisible(true);
					Ajouter1.setVisible(false);
					Soustraire1.setVisible(true);
				}

			}
		});
		Soustraire1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsSupp) {
					btnsSupp = false;
					Client1.setVisible(true);

				} else {
					btnsSupp = true;
					Client1.setVisible(false);
					Ajouter1.setVisible(true);
					Soustraire1.setVisible(false);

				}
			}

		});

		// Client 2
		JCheckBox Client2 = new JCheckBox("Client 2");
		Client2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client2.setBounds(78, 156, 95, 38);
		contentPane.add(Client2);

		// Bouton qui permet d'ajouter le client 2
		JButton Ajouter2 = new JButton("+");
		Ajouter2.setVerticalAlignment(SwingConstants.TOP);
		Ajouter2.setForeground(Color.RED);
		Ajouter2.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter2.setBounds(183, 156, 52, 35);
		contentPane.add(Ajouter2);
		Ajouter2.setVisible(false);

		// Bouton qui permet de soustraire le client 2
		JButton Soustraire2 = new JButton("-");
		Soustraire2.setVerticalAlignment(SwingConstants.TOP);
		Soustraire2.setForeground(Color.RED);
		Soustraire2.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire2.setBounds(245, 156, 52, 35);
		contentPane.add(Soustraire2);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsAjout) {
					btnsAjout = false;
					Client2.setVisible(false);
				} else {
					btnsAjout = true;
					Client2.setVisible(true);
					Ajouter2.setVisible(false);
					Soustraire2.setVisible(true);
				}

			}
		});
		Soustraire2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsSupp) {
					btnsSupp = false;
					Client2.setVisible(true);

				} else {
					btnsSupp = true;
					Client2.setVisible(false);
					Ajouter2.setVisible(true);
					Soustraire2.setVisible(false);

				}
			}

		});

		// Client 3
		JCheckBox Client3 = new JCheckBox("Client 3");
		Client3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client3.setBounds(78, 216, 95, 38);
		contentPane.add(Client3);

		// Bouton qui permet d'ajouter le client 3
		JButton Ajouter3 = new JButton("+");
		Ajouter3.setVerticalAlignment(SwingConstants.TOP);
		Ajouter3.setForeground(Color.RED);
		Ajouter3.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter3.setBounds(183, 216, 52, 35);
		contentPane.add(Ajouter3);
		Ajouter3.setVisible(false);

		// Bouton qui permet de soustraire le client 3
		JButton Soustraire3 = new JButton("-");
		Soustraire3.setVerticalAlignment(SwingConstants.TOP);
		Soustraire3.setForeground(Color.RED);
		Soustraire3.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire3.setBounds(245, 216, 52, 35);
		contentPane.add(Soustraire3);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsAjout) {
					btnsAjout = false;
					Client3.setVisible(false);
				} else {
					btnsAjout = true;
					Client3.setVisible(true);
					Ajouter3.setVisible(false);
					Soustraire3.setVisible(true);
				}

			}
		});
		Soustraire3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsSupp) {
					btnsSupp = false;
					Client3.setVisible(true);

				} else {
					btnsSupp = true;
					Client3.setVisible(false);
					Ajouter3.setVisible(true);
					Soustraire3.setVisible(false);

				}
			}

		});

		// Client 4
		JCheckBox Client4 = new JCheckBox("Client 4");
		Client4.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client4.setBounds(78, 276, 95, 38);
		contentPane.add(Client4);

		// Bouton qui permet d'ajouter le client 4
		JButton Ajouter4 = new JButton("+");
		Ajouter4.setVerticalAlignment(SwingConstants.TOP);
		Ajouter4.setForeground(Color.RED);
		Ajouter4.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter4.setBounds(183, 276, 52, 35);
		contentPane.add(Ajouter4);
		Ajouter4.setVisible(false);

		// Bouton qui permet de soustraire le client 4
		JButton Soustraire4 = new JButton("-");
		Soustraire4.setVerticalAlignment(SwingConstants.TOP);
		Soustraire4.setForeground(Color.RED);
		Soustraire4.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire4.setBounds(245, 276, 52, 35);
		contentPane.add(Soustraire4);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsAjout) {
					btnsAjout = false;
					Client4.setVisible(false);
				} else {
					btnsAjout = true;
					Client4.setVisible(true);
					Ajouter4.setVisible(false);
					Soustraire4.setVisible(true);
				}

			}
		});
		Soustraire4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsSupp) {
					btnsSupp = false;
					Client4.setVisible(true);

				} else {
					btnsSupp = true;
					Client4.setVisible(false);
					Ajouter4.setVisible(true);
					Soustraire4.setVisible(false);

				}
			}

		});

		// Client 5
		JCheckBox Client5 = new JCheckBox("Client 5");
		Client5.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client5.setBounds(78, 336, 95, 38);
		contentPane.add(Client5);

		// Bouton qui permet d'ajouter le client 5
		JButton Ajouter5 = new JButton("+");
		Ajouter5.setVerticalAlignment(SwingConstants.TOP);
		Ajouter5.setForeground(Color.RED);
		Ajouter5.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter5.setBounds(183, 336, 52, 35);
		contentPane.add(Ajouter5);
		Ajouter5.setVisible(false);

		// Bouton qui permet de soustraire le client 5
		JButton Soustraire5 = new JButton("-");
		Soustraire5.setVerticalAlignment(SwingConstants.TOP);
		Soustraire5.setForeground(Color.RED);
		Soustraire5.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire5.setBounds(245, 336, 52, 35);
		contentPane.add(Soustraire5);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsAjout) {
					btnsAjout = false;
					Client5.setVisible(false);
				} else {
					btnsAjout = true;
					Client5.setVisible(true);
					Ajouter5.setVisible(false);
					Soustraire5.setVisible(true);
				}

			}
		});
		Soustraire5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsSupp) {
					btnsSupp = false;
					Client5.setVisible(true);

				} else {
					btnsSupp = true;
					Client5.setVisible(false);
					Ajouter5.setVisible(true);
					Soustraire5.setVisible(false);

				}
			}

		});

		// Client 6
		JCheckBox Client6 = new JCheckBox("Client 6");
		Client6.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client6.setBounds(78, 396, 95, 38);
		contentPane.add(Client6);

		// Bouton qui permet d'ajouter le client 6
		JButton Ajouter6 = new JButton("+");
		Ajouter6.setVerticalAlignment(SwingConstants.TOP);
		Ajouter6.setForeground(Color.RED);
		Ajouter6.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter6.setBounds(183, 396, 52, 35);
		contentPane.add(Ajouter6);
		Ajouter6.setVisible(false);

		// Bouton qui permet de soustraire le client 6
		JButton Soustraire6 = new JButton("-");
		Soustraire6.setVerticalAlignment(SwingConstants.TOP);
		Soustraire6.setForeground(Color.RED);
		Soustraire6.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire6.setBounds(245, 396, 52, 35);
		contentPane.add(Soustraire6);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsAjout) {
					btnsAjout = false;
					Client6.setVisible(false);
				} else {
					btnsAjout = true;
					Client6.setVisible(true);
					Ajouter6.setVisible(false);
					Soustraire6.setVisible(true);
				}

			}
		});
		Soustraire6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnsSupp) {
					btnsSupp = false;
					Client6.setVisible(true);

				} else {
					btnsSupp = true;
					Client6.setVisible(false);
					Ajouter6.setVisible(true);
					Soustraire6.setVisible(false);

				}
			}

		});

		// Création d'un bouton permettant de modifier la commande d'un client
		JButton btnModClients = new JButton("Commande client");
		btnModClients.setForeground(Color.BLACK);
		btnModClients.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnModClients.setBackground(new Color(50, 205, 50));
		btnModClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Client1.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client2.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client3.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client4.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client5.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client6.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				}
			}
		});
		btnModClients.setBounds(0, 151, 119, 71);
		DiviseurDroite.add(btnModClients);

		// Création d'un background général
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(Interface.class.getResource("/imgs/FondClients.png")));
		Background.setBackground(new Color(220, 220, 220));
		Background.setBounds(0, 47, 728, 436);
		contentPane.add(Background);
		Background.setVisible(false);

	}
}
