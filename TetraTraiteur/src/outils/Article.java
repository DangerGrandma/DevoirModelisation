/* @class Article
 * 
 * Cette classe a pour but de représenter des articles alimentaires propres au restaurant. 
 * Il seront placés dans @param commande de @class Client.
 * 
 */

package outils;

public class Article {
	
	protected String nom;
	protected String completion; // État du complétion de l'article en cuisine. Modifiable seulement par les cuisiniers.
	protected int prix;
	protected int quantite;

	
	// Constructeur des articles du menu
	
	public Article(String s, int i) {
		nom = s;
		prix = i;		
	}
	
	static Article Soupe = new Article("Soupe", 4);
	static Article Salade = new Article("Salade", 5);
	static Article Bruschetta = new Article("Bruschetta", 5);
	
	static Article Saumon = new Article("Saumon", 15);
	static Article Poulet = new Article("Poulet", 13);
	static Article BLT = new Article("BLT", 13);
	static Article Tofu = new Article("Tofu", 12);
	static Article Spaghetti = new Article("Spaghetti", 16);
	static Article Risotto = new Article("Risotto", 15);
	static Article Homard = new Article("Homard", 21);
	static Article Burger = new Article("Burger", 14);
	
	static Article Cafe = new Article("Cafe", 3);
	static Article Soda = new Article("Soda", 3);
	static Article Limonade = new Article("Limonade", 4);
	static Article The = new Article("The", 3);
	
}