/* @class Client
 * Il s'agit d'objets qui seront plac�s en @param clients dans @class Table.
 * Les objets Client poss�dent une attribut @param commande, qui tient compte de tous les articles
 * command�s par celui-ci.
 */

package outils;

import java.util.ArrayList;

public class Client {
	
	protected String nom;
	protected ArrayList<Article> commande = new ArrayList<Article>(); // Liste d'objets Article command�es
	protected int total; // Total des @param prix des objets Article
	
	
	/*
	 *  Cette m�thode sert � d�terminer le total d'une commande d'un client. On parcours la liste enti�re
	 *  en cumulant les @param prix des objets Article.
	 */

	
	public Client(String s)
	{
		this.nom = s;
	}
	
	public int getTotal()
	{
		for(int i = 0; i < commande.size(); i++)
		{
			total+= commande.get(i).prix;
		}
		
		return total;
	}

}