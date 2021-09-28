package forme2d;

public class Ellipse extends Forme2D {
	private double rayon1;
	private double rayon2;
	
	public Ellipse(double rayon1, double rayon2) {
		super("ellipse");
		this.rayon1 = rayon1;
		this.rayon2 = rayon2;
	}
	
	public double calculSurface() {
		return Math.PI * rayon1 * rayon2;
	}
	
	public double calculPerimetre() {
		return 2*Math.PI * Math.sqrt(Math.pow(rayon1,2) + Math.pow(rayon2,2) / 2);
	}
	
	public boolean equals(Object obj) {
		return (obj instanceof Ellipse && obj != null)
				&& (rayon1 == ((Ellipse)obj).rayon1)
				&& (rayon2 == ((Ellipse)obj).rayon2);
	}
	
	public String toString() {
		return super.toString() + "Ellipse de rayons " + rayon1 + " et " + rayon2;
	}
}
