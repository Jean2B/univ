package forme3d;

import util.FormeGeometrique;

public abstract class Forme3D extends FormeGeometrique {
	public Forme3D(String nom) {
		super(nom);
	}
	
	abstract public double calculVolume();
	
	public String toString() {
		return super.toString() + "(Forme 3D)\n";
	}
}
