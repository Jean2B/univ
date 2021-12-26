//Félicien & Jean BERTRAND - L3 Info
package tp2;

import java.util.*;
import java.io.*; 

public class Anagramme {
	
	/**
	 * Retourne les listes d'anagrammes contenant au moins un nombre donné de mots
	 * @param args Chemin du fichier, Nombre min d'anagrammes
	 */
	public static void main(String[] args) {
		int minAnagrammes = Integer.parseInt(args[1]);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		try {
			Scanner scan = new Scanner(new File(args[0]));
			String mot;
			while (scan.hasNext()) {
				String lettres = alphabetize(mot = scan.next());
				List<String> groupe = map.get(lettres);
				if (groupe==null)
					map.put(lettres, groupe=new ArrayList<String>());
				groupe.add(mot);
			}
		}
		catch (FileNotFoundException e) {
			 System.err.println("Le fichier n'a pas été trouvé");
			 System.exit(1);
		}
		for (List<String> l : map.values()) {
			if (l.size() >= minAnagrammes) System.out.println(l.size() + ": " + l);
		}
	} 
	
	/**
	 * Retourne les lettres d'un mot dans l'ordre alphabétique
	 * @param s Mot
	 * @return Lettres du mot
	 */
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
