package util;

public abstract class FormeGeometrique {
	public final String id;
	private static int nbFormes = 0;
	
	public FormeGeometrique(String nom) {
		nbFormes++;
		id = nom + "_" + nbFormes;
	}
	
	abstract public double calculSurface();	
	
	public boolean compareSurface(Object obj) {
		return (obj instanceof FormeGeometrique && obj != null)
				&& (this.calculSurface() > ((FormeGeometrique)obj).calculSurface());
	}
	
	public String toString() {
		return "ID : " + id + " ";
	}
}
