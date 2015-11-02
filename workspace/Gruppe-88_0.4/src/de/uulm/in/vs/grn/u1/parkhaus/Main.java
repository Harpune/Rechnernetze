package de.uulm.in.vs.grn.u1.parkhaus;

public class Main {

	public static void main(String[] args) {
		Garage g = new Garage(20);
		for (int i = 0; i < 40; i++) {
			Car c = new Car(g, i);
			Thread t = new Thread(c);
			t.start();
		}
	}
}
