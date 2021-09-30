package util;

import java.util.*;

public class Joueur {
	private String nom;
	private String code; //Code du joueur (J1, J2,...)
	private static int nbJoueurs = 0;
	private int nbPoints;
	private ArrayList<Personnage> listePersos; //Personnages du joueur
	
	/**
	 * Constructeur de joueur
	 * @param nom Nom du joueur
	 */
	public Joueur(String nom) {
		this.nom = nom;
		nbJoueurs++;
		code = "J" + nbJoueurs;
		nbPoints = 0;
		listePersos = new ArrayList<Personnage>();
	}
	
	/**
	 * Accesseur
	 * @return Nom du joueur
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Accesseur
	 * @return Points du joueur
	 */
	public int getPoints() {
		return nbPoints;
	}
	
	/**
	 * Accesseur
	 * @return Liste des personnages du joueur
	 */
	public ArrayList<Personnage> getListePersos() {
		return listePersos;
	}
	
	/**
	 * Ajout d'un personnage à la liste des persos du joueur
	 * @param p Personnage à ajouter
	 */
	public void ajouterPersonnage(Personnage p) {
		listePersos.add(p);
		p.setProprietaire(this);
	}
	
	/**
	 * Modificateur du nombre de points du joueur
	 * @param nb Nombre de points à ajouter (ou retirer si négatif)
	 */
	public void modifierPoints(int nb) {
		if (nbPoints+nb < 0)
			nbPoints = 0; //nbPoints ne doit pas être inférieur à 0
		else
			nbPoints += nb;
	}
	
	/**
	 * Vérifie si le joueur peut jouer (s'il a au moins un personnage)
	 * @return true si le joueur peut jouer, false sinon
	 */
	public boolean peutJouer() {
		return (listePersos.size() >= 1);
	}
	
	@Override
	//Caractéristiques du joueur
	public String toString() {
		String msg = code + " " + nom + " (" + nbPoints + " points) ";
		if (peutJouer())
			msg += "avec " + listePersos.size() + " personnages";
		else
			msg += "aucun personnage";
		return msg;
	}
}
