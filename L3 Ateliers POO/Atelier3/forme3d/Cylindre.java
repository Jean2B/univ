package forme3d;

public class Cylindre extends Forme3D {
	private double rayon;
	private double hauteur;
	
	public Cylindre(double rayon, double hauteur) {
		super("cylindre");
		this.rayon = rayon;
		this.hauteur = hauteur;
	}
	
	public double calculSurface() {
		return 2*Math.PI * rayon * hauteur + 2*Math.PI * Math.pow(rayon,2);
	}
	
	public double calculVolume() {
		return Math.PI * Math.pow(rayon,2) * hauteur;
	}
	
	public boolean equals(Object obj) {
		return (obj instanceof Cylindre && obj != null)
				&& (rayon == ((Cylindre)obj).rayon)
				&& (hauteur == ((Cylindre)obj).hauteur);
	}
	
	public String toString() {
		return super.toString() + "Cylindre de rayon " + rayon + " et de hauteur " + hauteur;
	}
}
