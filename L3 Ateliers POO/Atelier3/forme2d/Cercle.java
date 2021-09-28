package forme2d;

public class Cercle extends Forme2D {
	private double rayon;
	
	public Cercle(double rayon) {
		super("cercle");
		this.rayon = rayon;
	}
	
	public double calculSurface() {
		return Math.PI * Math.pow(rayon,2);
	}
	
	public double calculPerimetre() {
		return 2*Math.PI * rayon;
	}
	
	public boolean equals(Object obj) {
		return (obj instanceof Cercle && obj != null)
				&& (rayon == ((Cercle)obj).rayon);
	}
	
	public String toString() {
		return super.toString() + "Cercle de rayon " + rayon;
	}
}
