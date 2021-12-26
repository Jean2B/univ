//F�licien & Jean BERTRAND - L3 Info
package tp2;

import java.time.*;
import java.util.*;


public class Personne{
    private static final int AGE_MAJORITE = 18;
    private String nom;
    private String prenom;
    private final LocalDate dateNaissance;
    private static int nbPersonnes = 0;
    private int ageObtentionDernierDiplome;
    public static ArrayList<Personne> personnes = new ArrayList<>();
	
    static final Comparator<Personne> ORDRE_PERSONNE = new Comparator<Personne>() {
		/**
		 * Retourne un nombre n�gatif si la premi�re personne pr�c�de la seconde,<br>
		 * un nombre positif si la premi�re suit la seconde,<br>
		 * et 0 si elles sont �gales,<br>
		 * selon l'�ge, puis l'ordre alphab�tique du nom et du pr�nom.
		 * @param p1 Premi�re personne
		 * @param p2 Seconde personne
		 * @return Le nombre (int)
		 */
		public int compare(Personne p1, Personne p2) {
			int res = p1.dateNaissance.compareTo(p2.dateNaissance);
			if (res == 0)
				res = p1.nom.compareTo(p2.nom);
			if (res == 0)
				res = p1.prenom.compareTo(p2.prenom);
			return res;
		}
	};
	
	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le pr�nom de la personne
	 * @param laDate la date de naissance de la personne
	 */
	public Personne(String leNom,String lePrenom, LocalDate laDate){
		nom = leNom.toUpperCase();
		prenom=lePrenom;
		dateNaissance=laDate;
		nbPersonnes++;
		personnes.add(this);
	}
	
	/** 
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le pr�nom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'ann�e de naissance
	 */
	public Personne(String leNom,String lePrenom, int j, int m, int a){
		this(leNom, lePrenom, LocalDate.of(a,m,j));
	}
	
	/**
	 * Accesseur
	 * @return Nombre de personnes cr��es
	 */
	public static int getNbPersonnes() {
		return nbPersonnes;
	}
	
	/**
	 * Accesseur
	 * @return �ge de la majorit�
	 */
	public static int getAgeMajorite() {
		return AGE_MAJORITE;
	}
	
	/**
	 * Accesseur
	 * @return �ge lors de l'obtention du dernier dipl�me
	 */
	public int getAgeObtentionDernierDiplome() {
		return ageObtentionDernierDiplome;
	}

	/**
	 * Accesseur
	 * @return retourne le nom
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * Accesseur
	 * @return retourne le pr�nom
	 */
	public String getPrenom(){
		return prenom;
	}
	/**
	 * Accesseur
	 * @return retourne la date de naissance	 
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String result="\nNom : "+nom+"\n"
		+"Pr�nom : "+prenom+"\n"+
		"N�(e) le : "+dateNaissance.getDayOfMonth()+
		"-"+dateNaissance.getMonth()+
		"-"+dateNaissance.getYear()+"\n";
		return result;
	}
	
	/** M�thode plusAgee
	 * @param p1 Premi�re personne
	 * @param p2 Deuxi�me personne
	 * @return Retourne true si la premi�re personne est strictement plus �g�e que la deuxi�me, false sinon
	 */
	public static boolean plusAgee(Personne p1, Personne p2) {
		return (p1.dateNaissance.compareTo(p2.dateNaissance) < 0);
	}
	
	/** Méthode plusAgeeQue
	 * @param p2 Deuxi�me personne dont la date de naissance sera compar�e � la personne courante
	 * @return Retourne true si la personne courante est strictement plus �g�e que la deuxi�me, false sinon
	 */
	public boolean plusAgeeQue(Personne p2) {
		return (this.dateNaissance.compareTo(p2.dateNaissance) < 0);
	}
	
	//Comparaison de deux personnes (nom, pr�nom et date de naissance)
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Personne && obj != null) {
			Personne objPersonne = (Personne)obj;
			res = objPersonne.nom.equals(this.nom) && objPersonne.prenom.equals(this.prenom)
					&& objPersonne.dateNaissance.equals(this.dateNaissance);
		}
		return res;
	}
}
