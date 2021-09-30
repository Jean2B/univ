package util;

public abstract class Personnage {
	private String nom;
	private int age;
	private int position;
	private Joueur proprietaire; //Propri�taire du personnage
	
	/**
	 * Constructeur de personnage
	 * @param nom Nom du personnage
	 * @param age �ge du personnage
	 */
	public Personnage(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}
	
	/**
	 * Accesseur
	 * @return Position du personnage
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * Modificateur
	 * @param pos Nouvelle position du personnage
	 */
	protected void setPosition(int pos) {
		position = pos;
	}
	
	/**
	 * Accesseur
	 * @return Joueur propri�taire du personnage
	 */
	protected Joueur getProprietaire() {
		return proprietaire;
	}
	
	/**
	 * Modificateur
	 * @param proprietaire Propri�taire du personnage
	 */
	protected void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	/**
	 * Modifie la position du personnage et le nombre de points de son propri�taire
	 * @param destination Nouvelle position du personnage
	 * @param gain Points obtenus par le joueur propri�taire
	 */
	public void deplacer(int destination, int gain) {
		position = destination;
		proprietaire.modifierPoints(gain);
	}
	
	/**
	 * Diminue le nombre de points du propri�taire
	 * @param penalite Nombre de points � retirer au joueur propri�taire
	 */
	public void penaliser(int penalite) {
		proprietaire.modifierPoints(-penalite);
	}
	
	@Override
	//Nom du personnage
	public String toString() {
		return nom;
	}
	
	public abstract int positionSouhaitee();
}
