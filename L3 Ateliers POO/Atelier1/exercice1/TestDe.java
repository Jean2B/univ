package exercice1;

public class TestDe {

	public static void main(String[] args) {
		//Création de 2 dés
		De d1 = new De("Number One", 8);
		System.out.println("Nom : " + d1.getNom());
		System.out.println("Nombre de faces : " + d1.getNbFaces());
		d1.setNbFaces(120); //Changement du nombre de faces du dé d1
		System.out.println("Nouveau nombre de faces : " + d1.getNbFaces());
		De d2 = new De();
		System.out.println("Nom : " + d2.getNom());
		System.out.println("Nombre de faces : " + d2.getNbFaces());
		
		//Test de la fonction lancer
		System.out.println("\nOn lance les dés");
		System.out.println(d1.getNom() + " : " + d1.lancer());
		System.out.println(d2.getNom() + " : " + d2.lancer());
		
		System.out.println("On lance les dés 10 fois (meilleur nombre)");
		System.out.println(d1.getNom() + " : " + d1.lancer(10));
		System.out.println(d2.getNom() + " : " + d2.lancer(10));
		
		//Test toString
		System.out.println("\nTEST toString");
		System.out.println(d1 + "\n" + d2);
		
		//Test equals avec un troisième dé
		De d3 = new De("Number One", 6); //Nombre de faces différent de d1
		System.out.println("\n" + d3);
		System.out.println("\nTEST equals (même nom et même nombre de faces)");
		System.out.println("Equals avec nombre de faces différents : " + d1.equals(d3));
		d3.setNbFaces(120); //Nombre de faces identique à d1
		System.out.println("Equals avec nombre de faces identique : " + d1.equals(d3));
		
		//Test du dé pipé
		De d4 = new DePipe("", 80, 70);
		System.out.println("\nDé pipé\n" + d4);
		System.out.println("\nTEST Dé pipé");
		System.out.println(d4.getNom() + " : " + d4.lancer());
		
		//Test du dé à effet mémoire
		De d5 = new DeEffetMemoire("", 3);
		System.out.println("\nDé à effet mémoire\n" + d5);
		System.out.println("\nTEST Dé à effet mémoire");
		int lancerPrecedent = 0;
		System.out.print("Lancer le dé 10 fois :");
		for(int i=0; i<10; i++) {
			int lancerSuivant = d5.lancer();
			//Vérification des répétitions : les nombres se répétant s'affichent en rouge
			if (lancerPrecedent == lancerSuivant) {
				System.err.print(" " + lancerSuivant);
			}
			else {System.out.print(" " + lancerSuivant);}
			lancerPrecedent = lancerSuivant;
		}
	}

}
