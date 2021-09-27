package util;

import java.util.*;

public class Employe extends Personne{
	private float salaire;
    private final GregorianCalendar dateEmbauche;
	
    /**
     * Constructeur d'Employe
     * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
     * @param salaire le salaire de l'employé
     * @param dateEmbauche la date d'embauche de l'employé
     */
	protected Employe(String leNom, String lePrenom, GregorianCalendar laDate,
					  Adresse lAdresse, float salaire, GregorianCalendar dateEmbauche) {
		super(leNom, lePrenom, laDate, lAdresse);
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}
	
	/**
     * Constructeur d'Employe
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
     */
	protected Employe(String leNom,String lePrenom, int jNaissance, int mNaissance, int aNaissance,
					  int numero, String rue, String code_postal, String ville,
					  float salaire, int jEmbauche, int mEmbauche, int aEmbauche) {
		this(leNom, lePrenom, new GregorianCalendar(aNaissance,mNaissance,jNaissance),
			 new Adresse(numero,rue,code_postal,ville),
			 salaire, new GregorianCalendar(aEmbauche,mEmbauche,jEmbauche));
	}

	/**Méthode createEmploye
     * Vérifie les caractéristiques d'un employe avant de le créer
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
	 * @return Retourne l'employé créé
     */
	public Employe createEmploye(String leNom,String lePrenom, int jNaissance, int mNaissance, int aNaissance,
			  					 int numero, String rue, String code_postal, String ville,
			  					 float salaire, int jEmbauche, int mEmbauche, int aEmbauche) {
		Employe em = null;
		if (salaire > 0) {
			em = new Employe(leNom, lePrenom, jNaissance, mNaissance, aNaissance,
							 numero, rue, code_postal, ville, salaire, jEmbauche, mEmbauche, aEmbauche);
		}
		return em;
	}
	
	/**Méthode augmenterLeSalaire
	 * Augmente le salaire d'un employé suivant un pourcentage donné
	 * @param pourcentage Pourcentage d'augementation du salaire
	 */
	public void augmenterLeSalaire(float pourcentage) {
		if (pourcentage > 0) {
			this.salaire += this.salaire * (pourcentage/100);
		}
	}
	
	/**Méthode calculAnnuite
	 * @return Nombre d'années que l'employé a passé dans l'entreprise
	 */
	public int calculAnnuite() {
		Calendar rightNow = Calendar.getInstance();
		return dateEmbauche.get(Calendar.YEAR) - rightNow.get(Calendar.YEAR);
	}
}
