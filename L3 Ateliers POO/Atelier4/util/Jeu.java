package util;

import java.util.*;

public class Jeu {
	private static final int NBJOUEURMAX = 6; //Nombre max de joueurs
	private static final int NBCASES = 50; //Nombre de cases
	private String titre;
	private ArrayList<Joueur> listeJoueurs; //Liste des joueurs
	private Case[] cases; //Cases du jeu
	private int nbEtapes;
	private int nbObstacles;
	private static int scoreMax; //Record
	private static Random r = new Random();
	
	/**
	 * Constructeur de jeu
	 * @param titre Titre du jeu
	 * @param nbEtapes Nombre d'étapes du jeu
	 * @param nbObstacles Nombre maximum d'obstacles du jeu
	 */
	public Jeu(String titre, int nbEtapes, int nbObstacles) {
		this.titre = titre;
		this.nbEtapes = nbEtapes;
		this.nbObstacles = nbObstacles;
		listeJoueurs = new ArrayList<Joueur>();
		cases = new Case[NBCASES];
	}
	
	/**
	 * Ajoute un joueur à la liste des joueurs
	 * @param j Joueur à ajouter
	 */
	public void ajouterJoueur(Joueur j) {
		if (listeJoueurs.size() < NBJOUEURMAX)
			listeJoueurs.add(j);
		else
			System.err.println("Le nombre max de joueurs a été atteint");
	}
	
	/**
	 * Crée et renvoie la liste des personnages
	 * @return Liste de tous les personnages de tous les joueurs
	 */
	public ArrayList<Personnage> tousLesPersos() {
		ArrayList<Personnage> listePersos = new ArrayList<Personnage>();
		for (Joueur j:listeJoueurs) {
			if (j.peutJouer())
				listePersos.addAll(j.getListePersos());
			else
				System.err.println(j.getNom() + " ne peut pas jouer");
		}
		return listePersos;
	}
	
	/**
	 * Initialisation des cases du jeu
	 */
	public void initialiserCases() {
		int nbObs = 0; //Nombre d'obstacles créés
		for(int i=0; i<NBCASES; i++) {
			int gain = r.nextInt(NBCASES) + 1;
			cases[i] = new Case(gain);
			if (gain%5 == 0 && nbObs < nbObstacles
					&& i != NBCASES-1) { //Pas d'obstacle sur la dernière case
				Obstacle obs = new Obstacle(gain*2);
				cases[i].placerObstacle(obs);
				nbObs++;
			}
		}
	}
	
	/**
	 * Démarrage du jeu
	 */
	public void lancerJeu() {
		initialiserCases();
		ArrayList<Personnage> listePersos = tousLesPersos();
		for (Personnage perso:listePersos) {
			int i = 0;
			while (!cases[i].estLibre() && i < NBCASES)
				i++;
			cases[i].placerPersonnage(perso);
			perso.setPosition(i);
		}
		System.out.println("Le jeu commence");
		int posSouhaitee = 0;
		for (int nEtape=0; nEtape < nbEtapes; nEtape++) {
			for (Personnage perso:listePersos) {
				posSouhaitee = perso.positionSouhaitee();
				if (posSouhaitee > NBCASES-1)
					posSouhaitee = NBCASES-1;
				Case caseSouhaitee = cases[posSouhaitee];
				if (caseSouhaitee.estLibre()) {
					cases[perso.getPosition()].enleverPersonnage(); //On enlève le perso de l'ancienne case
					caseSouhaitee.placerPersonnage(perso); //On le place dans la nouvelle case
					perso.deplacer(posSouhaitee, caseSouhaitee.getGain());
					//Le perso enregistre sa nouvelle position et le joueur obtient le gain de la case
				}
				else {
					int penalite = caseSouhaitee.getPenalite();
					perso.penaliser(penalite);
				}
			}
		}
		afficherCases();
		afficherResultats();
	}
	
	/**
	 * Affichage des cases
	 */
	public void afficherCases() {
		for (int i=0; i < NBCASES; i++)
			System.out.println("Case " + i + " : " + cases[i]);
	}
	
	/**
	 * Affichage des participants
	 */
	public void afficherParticipants() {
		System.out.println("LISTE DES PARTICIPANTS");
		for (Joueur j:listeJoueurs)
			System.out.println("-------------------------\n" + j);
	}
	
	/**
	 * Renvoie le joueur gagnant
	 * @return Joueur qui a le plus de points
	 */
	public Joueur getGagnant() {
		int nbPointsMax = -1;
		Joueur gagnant = null;
		for (Joueur j:listeJoueurs) {
			int nbPoints = j.getPoints();
			if (nbPoints > nbPointsMax) {
				nbPointsMax = nbPoints;
				gagnant = j;
			}
		}
		return gagnant;
	}
	
	/**
	 * Affichage des résultats
	 */
	public void afficherResultats() {
		System.out.println("JEU " + titre + "\n***********************************************\n");
		afficherParticipants();
		System.out.println("***********************************************\n"
							+ "RESULTATS");
		Joueur gagnant = getGagnant();
		int pointsGagnant = gagnant.getPoints();
		System.out.println("Le gagnant est " + gagnant.getNom() + " avec " + pointsGagnant);
		if (pointsGagnant > scoreMax) {
			System.out.println("Record battu : Ancien score maximum " + scoreMax);
			scoreMax = pointsGagnant;
		}
		else
			System.out.println("Record : " + scoreMax);
	}
}
