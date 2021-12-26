//Félicien & Jean BERTRAND - L3 Info
package tp2;

import java.util.Collections;
import tp2.Personne;

public class TestPersonne {

	public static void main(String[] args) {
		//Création de personnes
		Personne p1 = new Personne("Toto", "Personne", 6, 7, 2000);
		Personne p2 = new Personne("Test", "Personne", 3, 4, 2002);
		Personne p3 = new Personne("Titi", "Personne", 6, 7, 2000);
		Personne p4 = new Personne("Test", "Dupont", 3, 4, 2002);
		
		//On trie la liste des personnes selon leur âge, puis nom et prénom)
		Collections.sort(Personne.personnes, Personne.ORDRE_PERSONNE);
		
		//Affichage de la liste des personnes
		System.out.println(Personne.personnes);
		
		//Assertions
		assert(Personne.personnes.get(0).equals(p3)):
			"La première personne doit être TITI Personne";
		assert(Personne.personnes.get(1).equals(p1)):
			"La deuxième personne doit être TOTO Personne";
		assert(Personne.personnes.get(2).equals(p4)):
			"La troisième personne doit être TEST Dupont";
		assert(Personne.personnes.get(3).equals(p2)):
			"La quatrième personne doit être TEST Personne";
	}

}
