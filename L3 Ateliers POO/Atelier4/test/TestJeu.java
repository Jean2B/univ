package test;

import util.*;

public class TestJeu {

	public static void main(String[] args) {
		for (int i=0; i<5; i++) {
			Jeu jeu = new Jeu("AtelierPOO", 4, 10);
			
			Joueur j1 = new Joueur("Paul");
			Tauren t1 = new Tauren("Hector", 15, 10);
			Humain h1 = new Humain("Jean", 10);
			j1.ajouterPersonnage(t1);
			j1.ajouterPersonnage(h1);
			
			Joueur j2 = new Joueur("Lucien");
			Humain h2 = new Humain("Marie", 10);
			Tauren t2 = new Tauren("Hercule", 20, 5);
			j2.ajouterPersonnage(h2);
			j2.ajouterPersonnage(t2);
			
			jeu.ajouterJoueur(j1);
			jeu.ajouterJoueur(j2);
			
			jeu.lancerJeu();
		}
	}

}
