//Félicien & Jean BERTRAND - L3 Info
package tp2;
import java.util.*;

public class Comparaisons {
	//Comparaison selon l'ordre militaire
	static final Comparator<String> ORDRE_MILITAIRE = new Comparator<String>() {
		/**
		 * Retourne un nombre négatif si le premier mot précède le second selon l'ordre militaire,<br>
		 * un nombre positif si le premier suit le second,<br>
		 * et 0 s'ils sont égaux.
		 * @param s1 Premier mot
		 * @param s2 Second mot
		 * @return Le nombre (int)
		 */
		public int compare(String s1, String s2) {
			int res = 0;
			if (s1.length() < s2.length())
				res = -1;
			else if (s1.length() > s2.length())
				res = 1;
			else
				res = s1.compareTo(s2);
			return res;
		}
	};
	
	//Comparaison selon l'ordre inverse de l'ordre lexicographique
	static final Comparator<String> ORDRE_INVERSE = new Comparator<String>() {
		/**
		 * Retourne un nombre négatif si le premier mot précède le second<br>
		 * un nombre positif si le premier suit le second,<br>
		 * et 0 s'ils sont égaux,<br>
		 * selon l'ordre inverse de l'ordre lexicographique.
		 * @param s1 Premier mot
		 * @param s2 Second mot
		 * @return Le nombre (int)
		 */
		public int compare(String s1, String s2) {
			return s2.compareTo(s1);
		}
	};
	
	/**
	 * 
	 * @param args Ordre des mots, mots à trier
	 */
	public static void main(String[] args) {
		String ordre = args[0];
		ArrayList<String> mots = new ArrayList<>();
		for (int i=1; i<args.length; i++) {
			mots.add(args[i]);
		}
		switch(ordre) {
		case "lexico":
			Collections.sort(mots); break;
		case "militaire":
			Collections.sort(mots, ORDRE_MILITAIRE); break;
		case "inverse":
			Collections.sort(mots, ORDRE_INVERSE); break;
		default:
			System.err.println("L'ordre des mots choisi n'existe pas");
		}
		System.out.println(mots);
	}

}
