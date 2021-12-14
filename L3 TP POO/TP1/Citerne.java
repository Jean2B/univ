//F�licien & Jean BERTRAND - L3 Info
package tp1;
import java.time.*;
import tp1.EstComparable.*;

public class Citerne implements EstComparable{
	private static final int CAPACITEMAX = 20000;
	private static int nbCiternes = 0;
	private final int numCuve;
	protected final int capacite;
	private Liquide typeLiquide;
	private LocalDate dateService;
	protected double quantite;
	protected enum Liquide {eau (10), vin (15), huile (9);
		private final int temperature;
		private Liquide(int temperature) {
			this.temperature = temperature;
		}
	}
	
	/**
	 * Constructeur de Citerne
	 * @param capacite Capacit� d'une cuve
	 * @param typeLiquide Type de liquide
	 * @param dateService Date de mise en service
	 */
	public Citerne(int capacite, Liquide typeLiquide, LocalDate dateService) {
		try {
			if (capacite <= 0 || capacite > CAPACITEMAX)
				throw new IllegalArgumentException("La capacit� de la citerne est incorrecte. (" + capacite + ")");
			else
				this.capacite = capacite; // 0 < capacite <= 20000
			this.setTypeLiquide(typeLiquide); // Peut �tre modifi� apr�s nettoyage
			this.dateService = dateService; // choisir classe Date
			this.quantite = 0;
			nbCiternes++;
			this.numCuve = nbCiternes;
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Le type de liquide n'existe pas.\n" + e);
		}
		catch (DateTimeException e) {
			throw new DateTimeException("La date est invalide.\n" + e);
		}
	}
	
	public Citerne(int capacite, String typeLiquide, int j, int m, int a) {
		this(capacite, Liquide.valueOf(typeLiquide), LocalDate.of(a, m, j));
	}
	
	/**
	 * Accesseur
	 * @return Retourne la quantit� de liquide stock�e
	 */
	public double getQuantite() {
		return quantite;
	}

	/**
	 * Accesseur
	 * @return Retourne le type de liquide stock�
	 */
	public String getTypeLiquide() {
		String str = null;
		if (typeLiquide != null)
			str = typeLiquide.toString();
		return str;
	}
	
	public void setTypeLiquide(Liquide typeLiquide) {
		if (this.typeLiquide != null)
			throw new IllegalArgumentException("La citerne n'a pas �t� nettoy�e.");
		else
			this.typeLiquide = typeLiquide;
	}
	
	public void setTypeLiquide(String typeLiquide) {
		try {
			setTypeLiquide(Liquide.valueOf(typeLiquide));
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Le type de liquide n'existe pas.\n" + e);
		}
	}

	/**
	 * Accesseur
	 * @return Retourne la date de mise en service de la citerne
	 */
	public LocalDate getDateService() {
		return dateService;
	}
	
	/**Comparaison de deux citernes
	 * @param ref1 R�f�rence de la premi�re citerne
	 * @param ref2 R�f�rence de la seconde citerne
	 * @return refAncienne R�f�rence de la plus ancienne des deux citernes
	 */
	public static int plusAncienne(Citerne ref1, Citerne ref2) {
		int refAncienne;
		if (ref1.dateService.isAfter(ref2.dateService))
			refAncienne = ref2.numCuve;
		else
			refAncienne = ref1.numCuve;
		return refAncienne;
	}

	public void nettoyage() {
		quantite = 0;
		typeLiquide = null;
	}
	
	/**
	 * Accesseur
	 * @return Retourne le nombre de citernes
	 */
	public static int getNbCiternes() {
		return nbCiternes;
	}

	/**
	 * Ajouter du liquide dans la cuve
	 * @param quantite Pourcentage � ajouter
	 */
	public void ajouterLiquide(double quantite) {
		if (typeLiquide == null)
			throw new NullPointerException("Le type de liquide de la cuve n'est pas sp�cifi�.");
		else if (quantite <= 0 || quantite > 1) 
			throw new IllegalArgumentException("La quantit� est incorrecte.");
		else if (this.quantite + quantite > 1) {
			this.quantite = 1;
			throw new UnsupportedOperationException("La quantit� d�passe la capacit� maximale de la cuve. La cuve est pleine.");
		}
		else
			this.quantite += Math.floor(quantite*1000)/1000;
	}
	
	/**
	 * Ajouter du liquide dans la cuve
	 * @param quantite Volume (m3) � ajouter
	 */
	public void ajouterLiquide(int quantite) {
		double pourcentage = (double)quantite/(double)capacite;
		this.ajouterLiquide(pourcentage);
	}
	
	/**
	 * Enlever du liquide de la cuve
	 * @param quantite Pourcentage � enlever
	 */
	public void enleverLiquide(double quantite) {
		if (quantite <= 0 || quantite > 1) 
			throw new IllegalArgumentException("La quantit� est incorrecte.");
		else if (this.quantite - quantite < 0) {
			this.quantite = 0;
			throw new IllegalArgumentException("La cuve est vide, impossible d'enlever plus de liquide.");
		}
		else
			this.quantite -= Math.floor(quantite*1000)/1000;
	}
	
	/**
	 * Enlever du liquide de la cuve
	 * @param quantite Volume (m3) � enlever
	 */
	public void enleverLiquide(int quantite) {
		double pourcentage = (double)quantite/(double)capacite;
		this.enleverLiquide(pourcentage);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj == null)
			throw new NullPointerException("L'objet ne doit pas �tre null");
		else if (!(obj instanceof Citerne))
			throw new IllegalArgumentException("L'objet n'est pas une citerne");
		else {
			Citerne citerne = (Citerne)obj;
			if (this.capacite == citerne.capacite
					&& this.dateService.equals(citerne.dateService)
					&& this.typeLiquide == citerne.typeLiquide
					&& this.quantite == citerne.quantite)
				res = true;
		}
		return res;
	}

	@Override
	public String toString() {
		String str = "Citerne n�" + numCuve + ", " + typeLiquide
				+ ", capacit� : " + capacite
				+ " m3, mise en service : " + dateService
				+ ", volume occup� : " + quantite*100 + "%";
		return str;
	}
	
	/**
	 * Comparaison de citernes
	 * @param o Citerne � comparer
	 * @return -1 si la quantit� de l'objet courant est inf�rieure � o, 1 si elle est sup�rieure.
	 * <br>Si elles sont �gales, -1 si la capacit� de l'objet courant est inf�rieure � o, 1 si elle est sup�rieure,
	 * <br>0 si les capacit�s sont aussi �gales.
	 */
	public int compareA(Object o) {
		int res = 0;
		if (o == null)
			throw new NullPointerException("L'objet ne doit pas �tre null");
		else if (!(o instanceof Citerne))
			throw new IllegalArgumentException("L'objet n'est pas une citerne");
		else {
			Citerne citerne = (Citerne)o;
			double volume1 = this.quantite*this.capacite;
			double volume2 = citerne.quantite*citerne.capacite;
			if (volume1 < volume2)
				res = -1;
			else if (volume1 > volume2)
				res = 1;
			else if (this.capacite < citerne.capacite)
				res = -1;
			else if (this.capacite > citerne.capacite)
				res = 1;
		}
		return res;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Citerne citerne;
		try {
			citerne = (Citerne)super.clone();
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
		return citerne;
	}

}
