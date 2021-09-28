package forme2d;

public class Rectangle extends Forme2D {
	private double longueur;
	private double largeur;
	
	public Rectangle(double longueur, double largeur) {
		super("rectangle");
		this.longueur = longueur;
		this.largeur = largeur;
	}
	
	public double calculSurface() {
		return longueur*largeur;
	}
	
	public double calculPerimetre() {
		return 2*(longueur+largeur);
	}
	
	public boolean equals(Object obj) {
		return (obj instanceof Rectangle && obj != null)
				&& (longueur == ((Rectangle)obj).longueur)
				&& (largeur == ((Rectangle)obj).largeur);
	}
	
	public String toString() {
		return super.toString() + "Rectangle de longueur " + longueur + " et de largeur " + largeur;
	}
}
