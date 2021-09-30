package util;

public class Case {
	private int gain; //Points de la case
	private Personnage perso; //Personnage pr�sent sur la case (aucun = null)
	private Obstacle obs; //Obstacle pr�sent sur la case (aucun = null)
	
	/**
	 * Constructeur de case
	 * @param obs Obstacle de la case
	 * @param gain Points de la case
	 */
	public Case(Obstacle obs, int gain) {
		this.obs = obs;
		this.gain = gain;
	}
	
	/**
	 * Constructeur de case
	 * @param gain Points de la case
	 */
	public Case(int gain) {
		this(null, gain);
	}
	
	/**
	 * Accesseur
	 * @return Points de la case
	 */
	public int getGain() {
		return gain;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPenalite() {
		int penalite = 0;
		if (!sansObstacle())
			penalite = obs.getPenalite(); //P�nalit� si un obstacle est sur la case
		else if (!sansPerso())
			penalite = -gain; //Retire le gain au joueur si la case est d�j� occup�e
		return penalite;
	}
	
	/**
	 * M�thode positionnant le personnage sur la case
	 * @param perso Personnage � placer
	 */
	public void placerPersonnage(Personnage perso) {
		if (estLibre())
			this.perso = perso;
	}
	
	/**
	 * M�thode positionnant l'obstacle sur la case
	 * @param perso Obstacle � placer
	 */
	public void placerObstacle(Obstacle obs) {
		if (estLibre())
			this.obs = obs;
	}
	
	/**
	 * Enl�ve le personnage de la case
	 */
	public void enleverPersonnage() {
		perso = null;
	}
	
	/**
	 * V�rifie si la case est libre
	 * @return true si la case est libre, false sinon
	 */
	public boolean estLibre() {
		return (sansObstacle() && sansPerso());
	}
	
	/**
	 * V�rifie s'il n'y a pas d'obstacle
	 * @return True s'il n'y a pas d'obstacle sur la case, false sinon
	 */
	public boolean sansObstacle() {
		return (obs == null);
	}
	
	/**
	 * V�rifie si la case n'est pas occup�e
	 * @return True s'il n'y a pas de personnage sur la case, false sinon
	 */
	public boolean sansPerso() {
		return (perso == null);
	}
	
	@Override
	public String toString() {
		String msg = "";
		if (!sansObstacle())
			msg = "Obstacle (p�nalit� = " + getPenalite() + ")";
		else if (!sansPerso())
			msg = perso.toString() + " (p�nalit� = " + getPenalite() + ")";
		else
			msg = "Libre (gain = " + gain + ")";
		return msg;
	}
}
