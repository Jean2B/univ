package exercice1;

public class DePipe extends De {
	private int borneMin;
	
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
	
	public DePipe(int borneMin) {
		this("", 6, borneMin);
	}
	
	public int lancer() {
		int numero = 0;
		while (numero < borneMin) {
			numero = super.lancer();
		}
		return numero;
	}
}
