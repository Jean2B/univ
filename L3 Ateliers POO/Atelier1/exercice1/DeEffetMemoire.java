package exercice1;

public class DeEffetMemoire extends De {
	private int dernierLancer;
	
	/**
	 * Constructeur du dé à effet mémoire
	 * @param nom le nom du dé
	 * @param nbFaces le nombre de faces du dé
	 */
	public DeEffetMemoire(String nom, int nbFaces) {
		super(nom, nbFaces);
		this.dernierLancer = 0;
	}
	
	/**
	 * Constructeur du dé à effet mémoire sans paramètre
	 */
	public DeEffetMemoire() {
		this("", 6);
	}
	
	/**Lancer le dé à effet mémoire
	 * @return Retourne la valeur du dé
	 */
	public int lancer() {
		int numero = dernierLancer;
		while (numero == dernierLancer) {
			numero = super.lancer();
		}
		dernierLancer = numero;
		return numero;
	}
}
