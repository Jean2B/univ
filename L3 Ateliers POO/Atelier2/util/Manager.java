package util;

import java.util.*;

public class Manager extends Employe{
	private Secretaire secretaire;
	
	/**
     * Constructeur de Manager
     * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
     * @param salaire le salaire de l'employé
     * @param dateEmbauche la date d'embauche de l'employé
     * @param secretaire Secrétaire
     */
	protected Manager(String leNom, String lePrenom, GregorianCalendar laDate,
					  Adresse lAdresse, float salaire, GregorianCalendar dateEmbauche, Secretaire secretaire) {
		super(leNom, lePrenom, laDate, lAdresse, salaire, dateEmbauche);
		this.secretaire = secretaire;
	}
	
	/**
     * Constructeur de Manager
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
	 * @param secretaire Secrétaire
     */
	protected Manager(String leNom,String lePrenom, int jNaissance, int mNaissance, int aNaissance,
					  int numero, String rue, String code_postal, String ville,
					  float salaire, int jEmbauche, int mEmbauche, int aEmbauche, Secretaire secretaire) {
		this(leNom, lePrenom, new GregorianCalendar(aNaissance,mNaissance,jNaissance),
			 new Adresse(numero,rue,code_postal,ville),
			 salaire, new GregorianCalendar(aEmbauche,mEmbauche,jEmbauche), secretaire);
	}
	
	/**Méthode createManager
     * Vérifie les caractéristiques d'un manager avant de le créer
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
	 * @param secretaire Secrétaire
	 * @return Retourne le manager créé
     */
	public Manager createManager(String leNom,String lePrenom, int jNaissance, int mNaissance, int aNaissance,
			  					 int numero, String rue, String code_postal, String ville,
			  					 float salaire, int jEmbauche, int mEmbauche, int aEmbauche,
			  					 Secretaire secretaire) {
		Manager ma = null;
		if (salaire > 0) {
			ma = new Manager(leNom, lePrenom, jNaissance, mNaissance, aNaissance,
							 numero, rue, code_postal, ville, salaire, jEmbauche, mEmbauche, aEmbauche,
							 secretaire);
			float pourcentage = ma.calculAnnuite()/2;
			ma.augmenterLeSalaire(pourcentage);
		}
		return ma;
	}
	
	/**Méthode modifierSecretaire
	 * Modifie le/la secrétaire associé(e) à un manager
	 * @param secretaire Nouveau secrétaire
	 */
	public void modifierSecretaire(Secretaire secretaire) {
		this.secretaire = secretaire;
	}
}
