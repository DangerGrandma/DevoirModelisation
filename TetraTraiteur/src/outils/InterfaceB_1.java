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
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class InterfaceB_1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtArticlesCommentairesQuantit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceB_1 frame = new InterfaceB_1();
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
	public InterfaceB_1() {
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
		
		JButton btnAjouterArticle = new JButton("Ajouter Article");
		btnAjouterArticle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAjouterArticle.setForeground(new Color(255, 255, 255));
		btnAjouterArticle.setBackground(new Color(50, 205, 50));
		btnAjouterArticle.setBounds(0, 151, 119, 71);
		DiviseurDroite.add(btnAjouterArticle);
		btnAjouterArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (cmd.equals("Ajouter Article")) {
					dispose();

					new InterfaceC().setVisible(true);
				}

			}
		});
		
		JButton btnClient = new JButton("Client#");
		btnClient.setOpaque(true);
		btnClient.setContentAreaFilled(false);
		btnClient.setBackground(Color.LIGHT_GRAY);
		btnClient.setBounds(621, 11, 81, 30);
		DiviseurHaut.add(btnClient);

		// Création du bouton Retour qui amène l'utlisateur à l'interface B.

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

					new InterfaceB().setVisible(true);
				}

			}
		});

		// Création d'une metion de la table choisie pour les modification à apporter.

		JButton btnTableSaisie = new JButton("Table#");
		btnTableSaisie.setBounds(530, 12, 81, 30);
		DiviseurHaut.add(btnTableSaisie);
		btnTableSaisie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);

		// Création d'une metion du client choisie pour les modification à apporter.

		btnTableSaisie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);
		
		txtArticlesCommentairesQuantit = new JTextField();
		txtArticlesCommentairesQuantit.setText("  Articles\t\t\tCommentaires\t \t        Quantit\u00E9\t   \t           Prix");
		txtArticlesCommentairesQuantit.setEditable(false);
		txtArticlesCommentairesQuantit.setBounds(10, 58, 707, 37);
		contentPane.add(txtArticlesCommentairesQuantit);
		txtArticlesCommentairesQuantit.setColumns(10);
		
	}
}
