package forme2d;

import util.FormeGeometrique;

public abstract class Forme2D extends FormeGeometrique {
	public Forme2D(String nom) {
		super(nom);
	}
	
	abstract public double calculPerimetre();
	
	public String toString() {
		return super.toString() + "(Forme 2D)\n";
	}
}
