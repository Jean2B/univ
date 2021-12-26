//Félicien & Jean BERTRAND - L3 Info
package tp2;

public class Ex1<Type1, Type2> {
	private Type1 e1;
	private Type2 e2;
	
	public Ex1(Type1 e1, Type2 e2) {
	     this.e1 = e1;
	     this.e2 = e2;
	}
	
	public Type1 getE1() {
		return e1;
	}
	
	public Type2 getE2() {
		return e2;
	}
	
	public void setE1(Type1 e1) {
		this.e1 = e1;
	}
	
	public void setE2(Type2 e2) {
		this.e2 = e2;
	}
}
