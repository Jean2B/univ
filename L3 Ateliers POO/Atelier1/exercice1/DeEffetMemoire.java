package exercice1;

public class DeEffetMemoire extends De {
	private int dernierLancer;
	
	//Constructeur du dé à effet mémoire
	public DeEffetMemoire(String nom, int nbFaces) {
		super(nom, nbFaces);
		this.dernierLancer = 0;
	}
	
	//Constructeur du dé à effet mémoire sans paramètre
	public DeEffetMemoire() {
		this("", 6);
	}
	
	//Lancer le dé à effet mémoire
	public int lancer() {
		int numero = super.lancer();
		while (numero == dernierLancer) {
			numero = super.lancer();
		}
		dernierLancer = numero;
		return numero;
	}
}
