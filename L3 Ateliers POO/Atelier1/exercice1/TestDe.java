package exercice1;

public class TestDe {

	public static void main(String[] args) {
		De d1 = new De("Number One", 8);
		System.out.println("Nom : " + d1.getNom());
		System.out.println("Nombre de faces : " + d1.getNbFaces());
		d1.setNbFaces(120);
		System.out.println("Nouveau nombre de faces : " + d1.getNbFaces());
		De d2 = new De();
		System.out.println("Nom : " + d2.getNom());
		System.out.println("Nombre de faces : " + d2.getNbFaces());
		
		System.out.println("\nOn lance les dés");
		System.out.println(d1.getNom() + " : " + d1.lancer());
		System.out.println(d2.getNom() + " : " + d2.lancer());
		
		System.out.println("On lance les dés 10 fois (meilleur nombre)");
		System.out.println(d1.getNom() + " : " + d1.lancer(10));
		System.out.println(d2.getNom() + " : " + d2.lancer(10));
		
		System.out.println("\nTEST toString");
		System.out.println(d1 + "\n" + d2);
		
		De d3 = new De("Number One", 6);
		System.out.println("\nTEST equals (même nom et même nombre de faces)");
		System.out.println("Equals avec nombre de faces différents : " + d1.equals(d3));
		d3.setNbFaces(120);
		System.out.println("Equals avec nombre de faces identique : " + d1.equals(d3));
		
		System.out.println("\nTEST Dé pipé");
		De d4 = new DePipe("", 80, 70);
		System.out.println(d4.getNom() + " : " + d4.lancer());
		
		De d5 = new DeEffetMemoire("", 3);
		System.out.println("\nTEST Dé à effet mémoire");
		int lancerPrecedent = d5.lancer();
		System.out.print("Lancer le dé 10 fois : " + lancerPrecedent);
		for(int i=0; i<9; i++) {
			int lancerSuivant = d5.lancer();
			if (lancerPrecedent == lancerSuivant) {
				System.err.print(" " + lancerSuivant);
			}
			else {System.out.print(" " + lancerSuivant);}
			lancerPrecedent = lancerSuivant;
		}
	}

}
