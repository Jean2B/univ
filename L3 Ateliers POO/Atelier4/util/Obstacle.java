package util;

public class Obstacle {
	private int penalite;
	
	/**
	 * Constructeur d'obstacle
	 * @param penalite Nombre de points de pénalité
	 */
	public Obstacle(int penalite) {
		this.penalite = penalite;
	}
	
	/**
	 * Accesseur
	 * @return Nombre de points de pénalité de l'obstacle
	 */
	public int getPenalite() {
		return penalite;
	}
}
