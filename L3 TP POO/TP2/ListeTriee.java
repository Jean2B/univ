//Félicien & Jean BERTRAND - L3 Info
package tp2;
import java.util.*;

public class ListeTriee {
	/**
	 * Affiche une collection triée de nombres aléatoires entre 0 et 1000 (deux versions)
	 * @param args Taille de la collection
	 */
	public static void main(String[] args) {
		//Version 1
		int taille = Integer.parseInt(args[0]);
		int NBMAX = 1000;
		ArrayList<Integer> nombres = new ArrayList<Integer>();
		Random r = new Random();
		for (int i=0; i<taille; i++) {
			nombres.add(r.nextInt(NBMAX + 1));
		}
		Collections.sort(nombres);
		System.out.println(nombres);
		
		//Version 2
		Set<Integer> nombres2 = new TreeSet<Integer>();
		for (int i=0; i<taille; i++) {
			nombres2.add(r.nextInt(NBMAX + 1));
		}
		System.out.println(nombres2);
	}
}
