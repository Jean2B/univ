package util;

public abstract class Personnage {
	private String nom;
	private int age;
	private int position;
	private Joueur proprietaire; //Propriétaire du personnage
	
	/**
	 * Constructeur de personnage
	 * @param nom Nom du personnage
	 * @param age Âge du personnage
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
	 * @return Joueur propriétaire du personnage
	 */
	protected Joueur getProprietaire() {
		return proprietaire;
	}
	
	/**
	 * Modificateur
	 * @param proprietaire Propriétaire du personnage
	 */
	protected void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	/**
	 * Modifie la position du personnage et le nombre de points de son propriétaire
	 * @param destination Nouvelle position du personnage
	 * @param gain Points obtenus par le joueur propriétaire
	 */
	public void deplacer(int destination, int gain) {
		position = destination;
		proprietaire.modifierPoints(gain);
	}
	
	/**
	 * Diminue le nombre de points du propriétaire
	 * @param penalite Nombre de points à retirer au joueur propriétaire
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
