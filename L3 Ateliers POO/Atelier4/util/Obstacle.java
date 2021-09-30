package util;

public class Obstacle {
	private int penalite;
	
	/**
	 * Constructeur d'obstacle
	 * @param penalite Nombre de points de p�nalit�
	 */
	public Obstacle(int penalite) {
		this.penalite = penalite;
	}
	
	/**
	 * Accesseur
	 * @return Nombre de points de p�nalit� de l'obstacle
	 */
	public int getPenalite() {
		return penalite;
	}
}
