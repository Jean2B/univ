package util;

import java.util.*;
import util.Adresse;


public class Personne{
    private static final Adresse ADRESSE_INCONNUE = null;
    private String nom;
    private String prenom;
    private final GregorianCalendar dateNaissance;
    private Adresse adresse=ADRESSE_INCONNUE;
    private static int nbPersonnes = 0;
	
	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 */
	public Personne(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse){
		nom = leNom.toUpperCase();
		prenom=lePrenom;
		dateNaissance=laDate;
		adresse=lAdresse;
		nbPersonnes++;
	}
	
	/** 
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'année de naissance
	 * @param numero le n° de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
	 */
	public Personne(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville){
		this(leNom, lePrenom, new GregorianCalendar(a,m,j),new Adresse(numero,rue,code_postal,ville));
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
	 * @return retourne le prénom
	 */
	public String getPrenom(){
		return prenom;
	}
	/**
	 * Accesseur
	 * @return retourne la date de naissance	 
	 */
	public GregorianCalendar getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * Accesseur
	 * @return retourne l'adresse	 
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * Modificateur
	 * @param retourne l'adresse	 
	 */
	public void setAdresse(Adresse a) {
		adresse=a;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String result="\nNom : "+nom+"\n"
		+"Prénom : "+prenom+"\n"+
		"Né(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
		"-"+dateNaissance.get(Calendar.MONTH)+
		"-"+dateNaissance.get(Calendar.YEAR)+"\n"+
		"Adresse : "+
		adresse.toString();
		return result;
	}
	
	/** Méthode plusAgee
	 * @param p1 Première personne
	 * @param p2 Deuxième personne
	 * @return Retourne true si la première personne est strictement plus âgée que la deuxième, false sinon
	 */
	public static boolean plusAgee(Personne p1, Personne p2) {
		return (p1.dateNaissance.compareTo(p2.dateNaissance) < 0);
	}
	
	/** Méthode plusAgeeQue
	 * @param p2 Deuxième personne dont la date de naissance sera comparée à la personne courante
	 * @return Retourne true si la personne courante est strictement plus âgée que la deuxième, false sinon
	 */
	public boolean plusAgeeQue(Personne p2) {
		return (this.dateNaissance.compareTo(p2.dateNaissance) < 0);
	}
	
	//Comparaison de deux personnes (nom, prénom et date de naissance)
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Personne) {
			Personne objPersonne = (Personne)obj;
			res = objPersonne.nom.equals(this.nom) && objPersonne.prenom.equals(this.prenom)
					&& objPersonne.dateNaissance.equals(this.dateNaissance);
		}
		return res;
	}
}
