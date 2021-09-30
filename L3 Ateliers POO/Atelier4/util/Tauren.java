package util;

public class Tauren extends Personnage {
	private int taille;
	
	/**
	 * Constructeur de Tauren
	 * @param nom
	 * @param age
	 * @param taille
	 */
	public Tauren(String nom, int age, int taille) {
		super(nom, age);
		this.taille = taille;
	}
	
	/**
	 * Renvoie la position souhaitée du Tauren
	 * @return Entier représentant la position souhaitée
	 */
	public int positionSouhaitee() {
		int pos = getPosition();
		pos += (int)(Math.floor((Math.random() * taille)) + 1);
		//Nombre aléatoire entre 0 et <1, multiplié par la taille du Tauren,
		//arrondi à l'entier inférieur, + 1 pour avoir un nombre entre 1 et la taille
		return pos;
	}
	
	@Override
	//Nom du Tauren
	public String toString() {
		return "Tauren " + super.toString();
	}
}
