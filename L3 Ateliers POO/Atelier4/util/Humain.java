package util;

public class Humain extends Personnage {
	private int nbDeplacements; //Nombre de déplacements effectués
	private int niveau; //Niveau (entre 1 et 3)
	
	public Humain(String nom, int age) {
		super(nom, age);
		nbDeplacements = 0;
		niveau = 1;
	}
	
	@Override
	public void deplacer(int destination, int gain) {
		setPosition(destination);
		getProprietaire().modifierPoints(gain);
		nbDeplacements++;
		if (nbDeplacements == 4 || nbDeplacements == 6) //Niv. 2 à 4 déplacements, et Niv. 3 à 6
			niveau++;
	}
	
	/**
	 * Renvoie la position souhaitée de l'humain
	 * @return Entier représentant la position souhaitée
	 */
	public int positionSouhaitee() {
		int pos = getPosition();
		pos += niveau*nbDeplacements;
		return pos;
	}
	
	@Override
	public String toString() {
		return "Humain " + super.toString();
	}
}
