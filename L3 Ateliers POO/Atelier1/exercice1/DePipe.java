package exercice1;

public class DePipe extends De {
	private final int borneMin;
	
	/**
	 * Constructeur du dé pipé
	 * @param nom le nom du dé
	 * @param nbFaces le nombre de faces du dé
	 * @param borneMin la valeur min du dé pipé
	 */
	public DePipe(String nom, int nbFaces, int borneMin) {
		super(nom, nbFaces);
		if (borneMin < 1 || borneMin > nbFaces) {
			System.err.println("La borne minimale est incorrecte");
			this.borneMin = nbFaces - 1; //Borne minimale par défaut
		}		
		else {
			this.borneMin = borneMin;
		}
	}
	
	/**
	 * Constructeur du dé pipé avec seulement borneMin en paramètre
	 * @param borneMin la valeur min du dé pipé
	 */
	public DePipe(int borneMin) {
		this("", 6, borneMin);
	}
	
	/**Lancer le dé pipé
	 * @return Retourne la valeur du dé
	 */
	public int lancer() {
		int numero = 0;
		while (numero < borneMin) {
			numero = super.lancer();
		}
		return numero;
	}
}
