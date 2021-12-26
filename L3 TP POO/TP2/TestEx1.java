//Félicien & Jean BERTRAND - L3 Info
package tp2;
import java.util.*;
import java.time.*;

public class TestEx1 {

	public static void main(String[] args) {
		ArrayList<Ex1> paires = new ArrayList<Ex1>();
		
		Ex1<Integer, LocalDate> p1 = new Ex1<>(2021, LocalDate.of(2021,12,25));
		Ex1<String, Double> p2 = new Ex1<>("Noël", 100.0);
		Ex1<Integer, Double> p3 = new Ex1<>(3, 2.5);
		
		paires.add(p1);
		paires.add(p2);
		paires.add(p3);
		
		for (Ex1 p:paires) {
			System.out.println(p.getE1());
			System.out.println(p.getE2());
			p.setE1(2022);
			p.setE2(LocalDate.of(2022,1,1));
			System.out.println(p.getE1());
			System.out.println(p.getE2());
		}
	}

}
