/* @class InterfaceB_1
 * 
 * Il s'agit de l'interface qui affiche les informations relatives au client
 * choisi plus tot sur lequel on travaille a l'instant. Principalement, sert
 * a afficher les articles dans la commande de ce client.
 */

package outils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
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

	static JPanel contentPane;
	
	static int posY = 100; // Attribut utilise pour determiner ou place les articles d'une commande dans la fenetre.
	
	/*
	 * Cette methode sert a afficher les articles d'une commande d'un client. Il s'agit d'une boucle
	 * qui traverse la liste des Articles.
	 */
	
	public static void displayArticles(JPanel jp, int i)
	{
		for(int j = 0; j < i; j++) {
			
		// Ou placer le paneau qui contient l'info de l'article.
			
		JPanel panel = new JPanel();
		panel.setBounds(10, posY, 707, 22);
		jp.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		
		// Label pour le nom d'article.
		
		JLabel articleClient = new JLabel(""+InterfaceB.clientChoisi.commande.get(j).nom);
		articleClient.setHorizontalAlignment(SwingConstants.LEFT);
		articleClient.setBounds(0, 4, 140, 14);
		articleClient.setOpaque(true);
		panel.add(articleClient);
		
		// Quantite de l'article.
		
		JLabel quantArticle = new JLabel("1");
		quantArticle.setHorizontalAlignment(SwingConstants.CENTER);
		quantArticle.setBounds(324, 4, 46, 14);
		panel.add(quantArticle);
		
		// Prix de l'article.
		
		JLabel lblPrix = new JLabel(""+InterfaceB.clientChoisi.commande.get(j).prix);
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setBounds(443, 4, 73, 14);
		lblPrix.setOpaque(true);
		panel.add(lblPrix);
		
		JButton button = new JButton("-");
		button.setBounds(291, 0, 23, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("-");
		button_1.setBounds(380, 0, 23, 23);
		panel.add(button_1);
		
		posY += 24; // Nouvelle position pour le prochain article.
		}
	}

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
		// Creation de la fenetre de l'application.

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 522);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Cretion de la baniere du haut.

		JPanel DiviseurHaut = new JPanel();
		DiviseurHaut.setBounds(0, 0, 728, 48);
		DiviseurHaut.setBackground(new Color(128, 128, 128));
		contentPane.add(DiviseurHaut);
		DiviseurHaut.setLayout(null);

		// Creation de la baniere de droite

		JPanel DiviseurDroite = new JPanel();
		DiviseurDroite.setBounds(727, 0, 119, 483);
		DiviseurDroite.setBackground(new Color(128, 128, 128));
		contentPane.add(DiviseurDroite);
		DiviseurDroite.setLayout(null);

		// Creation d'un paneau qui contient des donnees relatives a l'utilisateur
		// actuel

		JPanel PaneauUtilisateur = new JPanel();
		PaneauUtilisateur.setBounds(0, 0, 119, 47);
		DiviseurDroite.add(PaneauUtilisateur);
		PaneauUtilisateur.setBackground(Color.YELLOW);
		PaneauUtilisateur.setLayout(null);

		// Creation d'un Label qui affiche ces informations

		JLabel boxUtilisateur = new JLabel("Utilisateur");
		boxUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		boxUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxUtilisateur.setBounds(10, 11, 99, 25);
		PaneauUtilisateur.add(boxUtilisateur);

		// Image utilisee pour le paneau utilisateur.

		JLabel imgUtilisateur = new JLabel("");
		imgUtilisateur.setVerticalAlignment(SwingConstants.TOP);
		imgUtilisateur.setBounds(0, 0, 119, 47);
		PaneauUtilisateur.add(imgUtilisateur);
		imgUtilisateur.setIcon(new ImageIcon(Interface.class.getResource("/imgs/Banner2.PNG")));

		// Creation d'un paneau oe sont affichees les informations relatives au temps.

		JPanel PaneauTemps = new JPanel();
		PaneauTemps.setBackground(Color.PINK);
		PaneauTemps.setBounds(0, 47, 119, 71);
		DiviseurDroite.add(PaneauTemps);
		PaneauTemps.setLayout(null);

		// Creation d'un objet qui prend en compte les donnees relatives au temps actuel
		// (synchronisation a l'ordinateur).

		LocalDateTime dateHeure = LocalDateTime.now();

		// Creation d'un Label qui afficher le temps actuel selon un format mois, jour
		// et annee.

		DateTimeFormatter dtfJour = DateTimeFormatter.ofPattern("MMM dd, 2019");
		JLabel boxTempsJour = new JLabel("" + dtfJour.format(dateHeure));
		boxTempsJour.setFont(new Font("Tahoma", Font.BOLD, 13));
		boxTempsJour.setBounds(12, 11, 99, 29);
		PaneauTemps.add(boxTempsJour);

		// Creation d'un Label qui affiche le temps actuel selon un format heure et
		// minutes.

		DateTimeFormatter dtfHeure = DateTimeFormatter.ofPattern("hh:mm");
		JLabel lblNewLabel = new JLabel("" + dtfHeure.format(dateHeure));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(37, 35, 46, 14);
		PaneauTemps.add(lblNewLabel);

		// Image utilisee pour la baniere du temps.

		JLabel imgTemps = new JLabel("");
		imgTemps.setBounds(0, 0, 119, 71);
		PaneauTemps.add(imgTemps);
		imgTemps.setIcon(new ImageIcon(Interface.class.getResource("/imgs/bane3.PNG")));
		
		// Bouton qui sert a ajouter des articles a la commande du client.
		
		JButton btnAjouterArticle = new JButton("Ajouter Article");
		btnAjouterArticle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAjouterArticle.setForeground(new Color(255, 255, 255));
		btnAjouterArticle.setBackground(new Color(50, 205, 50));
		btnAjouterArticle.setBounds(0, 151, 119, 71);
		btnAjouterArticle.setBorder(null);
		DiviseurDroite.add(btnAjouterArticle);
		btnAjouterArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (cmd.equals("Ajouter Article")) {
					dispose();

					new InterfaceC().setVisible(true); // Amene a l'InterfaceC
				}

			}
		});
		
		// Afficher le client sur lequel on travaille
		
		JButton btnClient = new JButton(""+InterfaceB.clientChoisi.nom); 
		btnClient.setOpaque(true);
		btnClient.setContentAreaFilled(false);
		btnClient.setBackground(Color.LIGHT_GRAY);
		btnClient.setBounds(621, 11, 81, 30);
		btnClient.setBorder(null);
		DiviseurHaut.add(btnClient);

		// Creation du bouton Retour qui amene l'utlisateur a l'interface B.

		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRetour.setBackground(new Color(0, 0, 128));
		btnRetour.setBounds(7, 11, 94, 29);
		btnRetour.setBorder(null);
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

		// Creation d'une mention de la table choisie pour les modification a apporter.

		JButton btnTableSaisie = new JButton("Table"+Interface.tableChoisie.numero); 
		btnTableSaisie.setBounds(530, 12, 81, 30);
		DiviseurHaut.add(btnTableSaisie);
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);
		
		// Baniere ou paneau guide pour les articles et leurs infos.
		
		JPanel panelCommande = new JPanel();
		panelCommande.setBackground(new Color(153, 204, 204));
		panelCommande.setBounds(10, 58, 707, 37);
		contentPane.add(panelCommande);
		panelCommande.setLayout(null);
		
		// Nom Article
		
		JLabel lblArticle = new JLabel("Article");
		lblArticle.setBounds(3, 12, 46, 14);
		panelCommande.add(lblArticle);
		
		// Quantite Article
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantite.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantite.setBounds(323, 12, 46, 14);
		panelCommande.add(lblQuantite);
		
		// Prix Article
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setBounds(455, 12, 46, 14);
		panelCommande.add(lblPrix);
		
	
		
	}
}
