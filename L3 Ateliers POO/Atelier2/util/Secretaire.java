package util;

import java.util.*;

public class Secretaire extends Employe{
	private static final double BONUSSALAIRE = 0.1;
	private static final int MAXMANAGERS = 5;
	protected Manager[] managers = new Manager[MAXMANAGERS];

    /**Constructeur de Secretaire
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     * @param laDate la date de naissance de la personne
     * @param lAdresse l'adresse de la personne
     * @param salaire le salaire de l'employé
     * @param dateEmbauche la date d'embauche de l'employé
     */
    protected Secretaire(String leNom, String lePrenom, GregorianCalendar laDate,
    					 Adresse lAdresse, double salaire, GregorianCalendar dateEmbauche) {
        super(leNom, lePrenom, laDate, lAdresse, salaire, dateEmbauche);
    }
    
    /**Constructeur de Secretaire
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     * @param j le jour de naissance
     * @param m le mois de naissance
     * @param a l'année de naissance
     * @param numero le n° de la rue
     * @param rue la rue
     * @param code_postal le code postal de l'adresse
     * @param ville la ville ou la personne habite
     * @param salaire le salaire de l'employé
     * @param jEmbauche le jour de la date d'embauche
     * @param mEmbauche le mois de la date d'embauche
     * @param aEmbauche l'année de la date d'embauche
     */
    protected Secretaire(String leNom, String lePrenom, int j, int m, int a,
                      int numero, String rue, String code_postal, String ville,
                      double salaire, int jEmbauche, int mEmbauche, int aEmbauche) {
        this(leNom, lePrenom, new GregorianCalendar(a,m,j), new Adresse(numero,rue,code_postal,ville),
             salaire, new GregorianCalendar(aEmbauche,mEmbauche,jEmbauche));
    }
    
    /** Méthode createSecretaire
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     * @param jNaissance le jour de naissance
     * @param mNaissance le mois de naissance
     * @param aNaissance l'année de naissance
     * @param numero le n° de la rue
     * @param rue la rue
     * @param code_postal le code postal de l'adresse
     * @param ville la ville ou la personne habite
     * @param salaire le salaire de l'employé
     * @param jEmbauche le jour de la date d'embauche
     * @param mEmbauche le mois de la date d'embauche
     * @param aEmbauche l'année de la date d'embauche
     * @return Retourne les informations du nouveau secrétaire si les informations sont correctes
     */
    public static Secretaire createSecretaire(String leNom, String lePrenom,
    										  int jNaissance, int mNaissance, int aNaissance,
    										  int numero, String rue, String code_postal, String ville,
    										  double salaire, int jEmbauche, int mEmbauche, int aEmbauche) {
        Secretaire se = null;
        if(salaire > 0) {
            se = new Secretaire(leNom, lePrenom, jNaissance, mNaissance, aNaissance,
            					numero, rue, code_postal, ville,
                                salaire, jEmbauche, mEmbauche, aEmbauche);
        }
        return se;
    }
    
    /**Méthode getNbManagers
     * Renvoie le nombre de managers gérés par un(e) secrétaire
     * @return Nombre de managers
     */
    public int getNbManagers() {
    	Manager ma = managers[0];
    	int nbManagers = 0;
    	while (ma != null && nbManagers < MAXMANAGERS) {
    		ma = managers[nbManagers];
    		nbManagers++;
    	}
    	return nbManagers;
    }
    
	/**Méthode augmenterLeSalaire
	 * Augmente le salaire d'un(e) secrétaire suivant un pourcentage donné,
	 * avec un bonus pour chaque manager géré
	 * @param pourcentage Pourcentage d'augementation du salaire (sans bonus)
	 */
	public void augmenterLeSalaire(double pourcentage) {
		if (pourcentage > 0) {
			pourcentage += this.getNbManagers() * BONUSSALAIRE;
			double salaire = getSalaire();
			salaire += salaire * (pourcentage/100);
			setSalaire(salaire);
		}
	}
	
	public void ajoutManager(Manager ma) {
		int nbManagers = this.getNbManagers();
		if (nbManagers >= MAXMANAGERS) {
			System.err.println("Le nombre max de managers pour " +
							   getPrenom() + " " + getNom() + " a été atteint.");
		}
		else {
			managers[nbManagers] = ma;
		}
	}
	
	public void retraitManager(Manager ma) {
		
	}
}
