package forme3d;

public class Sphere extends Forme3D {
	private double rayon;
	
	public Sphere(double rayon) {
		super("sphere");
		this.rayon = rayon;
	}
	
	public double calculSurface() {
		return 4*Math.PI * Math.pow(rayon, 2);
	}
	
	public double calculVolume() {
		return (4*Math.PI * Math.pow(rayon, 3)) / 3;
	}
	
	public boolean equals(Object obj) {
		return (obj instanceof Sphere && obj != null)
				&& (rayon == ((Sphere)obj).rayon);
	}
	
	public String toString() {
		return super.toString() + "Sphère de rayon " + rayon;
	}
}
