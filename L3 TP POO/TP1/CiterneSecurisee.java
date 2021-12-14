//Félicien & Jean BERTRAND - L3 Info
package tp1;

public class CiterneSecurisee extends Citerne implements Cloneable{
	private int capaciteTropPlein;
	private double quantiteTropPlein;
	
	/**
	 * Constructeur de CiterneSecurisee
	 * @param capacite Capacité de la cuve principale
	 * @param capaciteTropPlein Capacité de la cuve de trop plein
	 * @param typeLiquide Type de liquide de la cuve
	 * @param j Jour de la date de mise en service
	 * @param m Mois de la date de mise en service
	 * @param a Année de la date de mise en service
	 */
	public CiterneSecurisee(int capacite, int capaciteTropPlein, String typeLiquide, int j, int m, int a) {
		super(capacite, typeLiquide, j, m, a);
		if (capaciteTropPlein <= 0 || capaciteTropPlein > capacite) {
			capaciteTropPlein = capacite/10;
			System.err.println("La capacité de la cuve de trop plein est incorrecte, enregistrée à 10% de la capacité");
		}
		this.capaciteTropPlein = capaciteTropPlein;
		this.quantiteTropPlein = 0;
	}
	
	/**
	 * Accesseur
	 * @return Retourne la quantité de liquide de la cuve de trop plein
	 */
	public double getQuantiteTropPlein() {
		return quantiteTropPlein;
	}

	
	@Override
	public void nettoyage() {
		super.nettoyage();
		quantiteTropPlein = 0;
	}
	
	@Override
	public void ajouterLiquide(double quantite) {
		double qteEnTrop = this.quantite + quantite - 1;
		try {
			super.ajouterLiquide(quantite);
		}
		catch (UnsupportedOperationException e) {};
		if (qteEnTrop > 0) {
			System.err.println("La cuve principale est pleine.");
			if (qteEnTrop > ((double)capaciteTropPlein/(double)capacite)+quantiteTropPlein) {
				quantiteTropPlein = 1;
				throw new IllegalArgumentException("La cuve de trop plein est pleine.");
			}
			else {
				quantiteTropPlein += qteEnTrop*(double)capacite/(double)capaciteTropPlein;
				quantiteTropPlein = Math.floor(quantiteTropPlein*1000)/1000;
				if (quantiteTropPlein >= 0.5)
					System.err.println("La cuve de trop plein est à moitié pleine.");
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj == null)
			throw new NullPointerException("L'objet ne doit pas être null");
		else if (!(obj instanceof CiterneSecurisee))
			throw new IllegalArgumentException("L'objet n'est pas une citerne sécurisée");
		else {
			CiterneSecurisee citerne = (CiterneSecurisee)obj;
			if (super.equals(citerne)
					&& this.capaciteTropPlein == citerne.capaciteTropPlein
					&& this.quantiteTropPlein == citerne.quantiteTropPlein)
				res = true;
		}
		return res;
	}
	
	@Override
	public String toString() {
		String str = super.toString()
				+ "\nCapacité cuve trop plein : " + capaciteTropPlein
				+ ", volume occupé : " + quantiteTropPlein;
		return str;
	}
	
	@Override
	public int compareA(Object o) {
		int res = 0;
		if (o == null)
			throw new NullPointerException("L'objet ne doit pas être null");
		else if (!(o instanceof CiterneSecurisee))
			throw new IllegalArgumentException("L'objet n'est pas une citerne sécurisée");
		else {
			CiterneSecurisee citerne = (CiterneSecurisee)o;
			double volume1 = this.quantite*this.capacite + this.quantiteTropPlein*this.capaciteTropPlein;
			double volume2 = citerne.quantite*citerne.capacite + citerne.quantiteTropPlein*citerne.capaciteTropPlein;
			if (volume1 < volume2)
				res = -1;
			else if (volume1 > volume2)
				res = 1;
			else if (this.capacite + this.capaciteTropPlein < citerne.capacite + citerne.capaciteTropPlein)
				res = -1;
			else if (this.capacite + this.capaciteTropPlein > citerne.capacite + citerne.capaciteTropPlein)
				res = 1;
		}
		return res;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		CiterneSecurisee citerne;
		try {
			citerne = (CiterneSecurisee)super.clone();
			citerne.capaciteTropPlein = capaciteTropPlein;
			citerne.quantiteTropPlein = quantiteTropPlein;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
		return citerne;
	}
}
