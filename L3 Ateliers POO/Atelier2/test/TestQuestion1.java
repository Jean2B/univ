package test;

import util.Personne;

public class TestQuestion1 {

	public static void main(String[] args) {
		//Création de 3 personnes
		Personne p1 = new Personne("Test", "Personne", 6, 7, 2000, 8, "RueTest", "88888", "TestVille");
		Personne p2 = new Personne("Test", "Personne", 3, 4, 2002, 8, "RueTest", "88888", "TestVille");
		Personne p3 = new Personne("Test", "Personne", 6, 7, 2000, 8, "RueTest", "88888", "TestVille");
		
		System.out.println("Nombre de personnes : " + Personne.getNbPersonnes());

		//Test plusAgee et plusAgeeQue
		System.out.println("Test plusAgee : p1 est plus âgée que p2");
		System.out.println("plusAgee(p1, p2) : " + Personne.plusAgee(p1, p2));
		System.out.println("plusAgee(p2, p1) : " + Personne.plusAgee(p2, p1));
		System.out.println("p1.plusAgeeQue(p2) : " + p1.plusAgeeQue(p2));
		System.out.println("p2.plusAgeeQue(p1) : " + p2.plusAgeeQue(p1));

		//Test equals
		System.out.println("\nTest equals : p1 est identique à p3 (mais pas p2)");
		System.out.println("p1.equals(p3) : " + p1.equals(p3));
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
	}

}
