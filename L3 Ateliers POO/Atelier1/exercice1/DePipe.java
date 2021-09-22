package exercice1;

public class DePipe extends De {
	private int borneMin;
	
	//Constructeur du dé pipé
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
	
	//Constructeur du dé pipé avec seulement borneMin en paramètre
	public DePipe(int borneMin) {
		this("", 6, borneMin);
	}
	
	//Lancer le dé pipé
	public int lancer() {
		int numero = 0;
		while (numero < borneMin) {
			numero = super.lancer();
		}
		return numero;
	}
}
