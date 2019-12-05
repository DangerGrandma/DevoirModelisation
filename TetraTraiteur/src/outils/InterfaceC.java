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
import javax.swing.text.Document;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class InterfaceC extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceC frame = new InterfaceC();
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
	public InterfaceC() {
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
				

				
				//Création du bouton qui confirme le "panier" de la commande et qui retourne à l'interface B_1
				
				JButton btnConfirmer = new JButton("Confirmer");
				btnConfirmer.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnConfirmer.setBackground(new Color(50, 205, 50));
				btnConfirmer.setBounds(0, 360, 119, 52);
				DiviseurDroite.add(btnConfirmer);
				btnConfirmer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String cmd = e.getActionCommand();

						if (cmd.equals("Confirmer")) {
							dispose();

							new InterfaceB_1().setVisible(true);
						}

					}
				});
				
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

							new InterfaceB_1().setVisible(true);
						}

					}
				});
				
				// Création de la liste des items sélectionnés
				JTextArea ListeItem = new JTextArea();
				ListeItem.setBounds(10, 362, 705, 113);
				contentPane.add(ListeItem);
				

				// Menu
				
				JCheckBoxMenuItem menuSalade = new JCheckBoxMenuItem("Salade");
				menuSalade.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuSalade.setBounds(10, 89, 133, 24);
				contentPane.add(menuSalade);
				menuSalade.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (menuSalade.isSelected()) {
							ListeItem.append("\nSalade");
						}
						else {
							
						}
					}
				});
				
				JCheckBoxMenuItem menuSoupe = new JCheckBoxMenuItem("Soupe");
				menuSoupe.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuSoupe.setBounds(10, 162, 133, 24);
				contentPane.add(menuSoupe);
			
				menuSoupe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (menuSoupe.isSelected()) {
				
							ListeItem.append("\nSoupe");
						}
						else {
							ListeItem.setText("");
						}
					}
					
				});
				
				JCheckBoxMenuItem menuBruschetta = new JCheckBoxMenuItem("Bruschetta");
				menuBruschetta.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuBruschetta.setBounds(10, 238, 133, 24);
				contentPane.add(menuBruschetta);
				
				JCheckBoxMenuItem MenuSaumon = new JCheckBoxMenuItem("Saumon aux herbes");
				MenuSaumon.setFont(new Font("Tahoma", Font.BOLD, 14));
				MenuSaumon.setBounds(153, 89, 178, 24);
				contentPane.add(MenuSaumon);
				
				JCheckBoxMenuItem menuPoulet = new JCheckBoxMenuItem("Poulet au citon");
				menuPoulet.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuPoulet.setBounds(153, 162, 178, 24);
				contentPane.add(menuPoulet);
				
				JCheckBoxMenuItem menuBLT = new JCheckBoxMenuItem("BLT");
				menuBLT.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuBLT.setBounds(153, 238, 178, 24);
				contentPane.add(menuBLT);
				
				JCheckBoxMenuItem menuTofu = new JCheckBoxMenuItem("Tofu Frit");
				menuTofu.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuTofu.setBounds(153, 316, 178, 24);
				contentPane.add(menuTofu);
				
				JCheckBoxMenuItem menuSpaghetti = new JCheckBoxMenuItem("Spaghetti a l'encre");
				menuSpaghetti.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuSpaghetti.setBounds(341, 89, 189, 24);
				contentPane.add(menuSpaghetti);
				
				JCheckBoxMenuItem menuRisotto = new JCheckBoxMenuItem("Risotto aux Champignons");
				menuRisotto.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuRisotto.setBounds(341, 162, 218, 24);
				contentPane.add(menuRisotto);
				
				JCheckBoxMenuItem menuHomard = new JCheckBoxMenuItem("Assiette Homard");
				menuHomard.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuHomard.setBounds(341, 238, 179, 24);
				contentPane.add(menuHomard);
				
				JCheckBoxMenuItem menuBurger = new JCheckBoxMenuItem("Burger Vege");
				menuBurger.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuBurger.setBounds(341, 316, 179, 24);
				contentPane.add(menuBurger);
				
				JCheckBoxMenuItem Cafe = new JCheckBoxMenuItem("Cafe");
				Cafe.setFont(new Font("Tahoma", Font.BOLD, 14));
				Cafe.setBounds(569, 89, 159, 24);
				contentPane.add(Cafe);
				
				JCheckBoxMenuItem BoissonGazeuse = new JCheckBoxMenuItem("Boisson Gazeuse");
				BoissonGazeuse.setFont(new Font("Tahoma", Font.BOLD, 14));
				BoissonGazeuse.setBounds(569, 162, 159, 24);
				contentPane.add(BoissonGazeuse);
				
				JCheckBoxMenuItem Limonade = new JCheckBoxMenuItem("Limonade");
				Limonade.setFont(new Font("Tahoma", Font.BOLD, 14));
				Limonade.setBounds(569, 238, 159, 24);
				contentPane.add(Limonade);
				
				JCheckBoxMenuItem The = new JCheckBoxMenuItem("The");
				The.setFont(new Font("Tahoma", Font.BOLD, 14));
				The.setBounds(569, 316, 159, 24);
				contentPane.add(The);
				
				//Création du bouton annuler la commande, qui efface tout ce qu'il y a dans la liste de la commande
				
				JButton btnAnnuler = new JButton("Annuler");
				btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnAnnuler.setBackground(new Color(50, 205, 50));
				btnAnnuler.setBounds(0, 271, 119, 52);
				DiviseurDroite.add(btnAnnuler);
				btnAnnuler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String cmd = e.getActionCommand();

						if (cmd.equals("Annuler")) {						
							ListeItem.setText("");
							menuSalade.setSelected(false);
							menuSoupe.setSelected(false);
							
						}
				
						
					}
		
				});
				
				
				
	

	}
}
