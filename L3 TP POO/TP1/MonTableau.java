//Félicien & Jean BERTRAND - L3 Info
package tp1;

public class MonTableau implements EstComparable {
	private int[] tableau;
	
	/**
	 * Constructeur de MonTableau
	 * @param tableau Tableau d'entiers
	 */
	public MonTableau(int[] tableau) {
		this.tableau = tableau;
	}
	
	/**Comparaison de tableaux d'entiers
	 * @param o Tableau à comparer
	 * @return –1 si l'objet courant est inférieur à o,<br>
	 * 0 s’ils sont égaux,<br>
	 * 1 sinon
	 */
	public int compareA(Object o) {
		int sommeX = 0;
		int sommeY = 0;
		int res = 0;
		if (o == null)
			throw new NullPointerException("L'objet ne doit pas être null");
		else {
			MonTableau tabY;
			try {
				tabY = (MonTableau)o;
				for (int i=0; i<tableau.length; i++) {
					sommeX += tableau[i];
				}
				for (int i=0; i<tabY.tableau.length; i++) {
					sommeY += tabY.tableau[i];
				}
				if (sommeX < sommeY)
					res = -1;
				else if (sommeX > sommeY)
					res = 1;
				//Sinon, res reste à zéro (sommeX == sommeY)
			}
			catch (ClassCastException e) {
				System.err.println("L'objet n'est pas comparable\n" + e);
			}
		}
		return res;
	}
}
