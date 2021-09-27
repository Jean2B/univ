package util;

import java.util.*;

public class Secretaire extends Employe{
	protected Manager[] managers = new Manager[5];

    /**Constructeur de Secretaire
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     * @param laDate la date de naissance de la personne
     * @param lAdresse l'adresse de la personne
     * @param salaire le salaire de l'employé
     * @param dateEmbauche la date d'embauche de l'employé
     * @param manager Manager
     */
    protected Secretaire(String leNom, String lePrenom, GregorianCalendar laDate,
                      Adresse lAdresse, float salaire, GregorianCalendar dateEmbauche, Manager manager) {
        super(leNom, lePrenom, laDate, lAdresse, salaire, dateEmbauche);
        this.managers[0] = manager;
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
     * @param manager Manager
     */
    protected Secretaire(String leNom, String lePrenom, int j, int m, int a,
                      int numero, String rue, String code_postal, String ville,
                      float salaire, int jEmbauche, int mEmbauche, int aEmbauche, Manager manager) {
        this(leNom, lePrenom, new GregorianCalendar(a,m,j), new Adresse(numero,rue,code_postal,ville),
             salaire, new GregorianCalendar(aEmbauche,mEmbauche,jEmbauche), manager);
    }
    
    /** Méthode createSecretaire
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
     * @param manager Manager
     * @return Retourne les informations du nouveau secrétaire si les informations sont correctes
     */
    public Secretaire createSecretaire(String leNom, String lePrenom, int j, int m, int a,
                                   int numero, String rue, String code_postal, String ville,
                                   float salaire, int jEmbauche, int mEmbauche, int aEmbauche, Manager manager) {
        Secretaire se = null;
        if(salaire > 0) {
            se = new Secretaire(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville,
                                     salaire, jEmbauche, mEmbauche, aEmbauche, manager);
        }
        return se;
    }
}
