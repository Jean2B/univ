//Félicien & Jean BERTRAND - L3 Info
package tp1;

import java.time.LocalDate;

public class TestCiterne {
	
	public static void main(String[] args) {
		Citerne c1 = new Citerne(200, "eau", 4, 12, 2021);
		Citerne c2 = new Citerne(300, "vin", 14, 12, 2021);
		Citerne c3 = new Citerne(200, "eau", 4, 12, 2021);
		assert(Citerne.plusAncienne(c1, c2) == 1):"1 doit être plus ancien";
		c1.ajouterLiquide(0.3);
		String err = "";
		try {
			c1.enleverLiquide(0.4);
		}
		catch (IllegalArgumentException e) {
			err = e.getMessage();
		}
		assert(err == "La cuve est vide, impossible d'enlever plus de liquide."):
			"enleverLiquide doit lever une erreur car on ne peut pas enlever plus de liquide";
		c1.ajouterLiquide(150);
		assert(c1.getQuantite() == 0.75):"La quantité de c1 doit être égale à 0.75";
		assert(c1.getTypeLiquide() == "eau"):"Le type de liquide de c1 doit être l'eau";
		assert(c1.getDateService().equals(LocalDate.of(2021, 12, 4))):"La date de mise en service doit être 2021-12-04";
		assert(Citerne.getNbCiternes() == 3):"Il doit y avoir 3 citernes";
		assert(!(c1.equals(c3))):"c1 ne doit pas être égal à c3";
		c3.ajouterLiquide(150);
		assert(c1.equals(c3)):"c1 doit être égal à c3";
		System.out.println(c1);
		assert(c1.compareA(c2) == 1):"Doit retourner 1 car la quantité de c1 est supérieure à celle de c2";
		c1.nettoyage();
		assert(c1.getTypeLiquide() == null):"Le type de liquide de c1 doit être null";
		c1.setTypeLiquide("huile");
		assert(c1.getTypeLiquide() == "huile"):"Le type de liquide de c1 doit être l'huile";
		
		CiterneSecurisee c4 = new CiterneSecurisee(1000, 100, "huile", 24, 12, 2021);
		c4.ajouterLiquide(0.5); //Pourcentage
		assert(c4.getQuantite() == 0.5):"La cuve principale doit être à moitié pleine (0.5)";
		c4.ajouterLiquide(540); //Volume (m3)
		assert(c4.getQuantite() == 1):"La cuve principale doit être pleine (1)";
		assert(c4.getQuantiteTropPlein() == 0.4):"La cuve de trop plein doit être remplie à 40/100 (0.4)";
		CiterneSecurisee c5 = new CiterneSecurisee(1000, 100, "huile", 24, 12, 2021);
		assert(!(c4.equals(c5))):"c4 ne doit pas être égal à c5";
		c5.ajouterLiquide(1000);
		c5.ajouterLiquide(40);
		assert(c4.equals(c5)):"c4 doit être égal à c5";
		c5.ajouterLiquide(20);
		assert(c5.getQuantiteTropPlein() == 0.6):"La cuve de trop plein doit être remplie à 60/100 (0.6)";
		System.out.println(c5);
		assert(c4.compareA(c5) == -1):"Doit retourner -1 car la quantité de trop plein de c4 est inférieur à celle de c5";
		CiterneSecurisee c6 = null;
		try {
			c6 = (CiterneSecurisee)c5.clone();
		}
		catch(CloneNotSupportedException e) {
			System.err.println("Clonage impossible");
		}
		System.out.println(c6);
		c6.nettoyage();
		assert(c5 != c6 && c5.getTypeLiquide() != c6.getTypeLiquide()):"c5 doit être différent de c6";
	}

}
