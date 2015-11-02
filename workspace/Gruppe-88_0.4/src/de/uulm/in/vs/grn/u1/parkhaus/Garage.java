package de.uulm.in.vs.grn.u1.parkhaus;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	public int max;
	public List<Car> garage = null;

	public Garage(int max) {
		this.max = max;
		this.garage = new ArrayList<Car>();
	}

	public boolean add(Car c) {
		if (garage.size() < max) {
			System.out.println(garage.size() + " Cars in the Garage");
			garage.add(c);
			System.out.println("Car " + c.nr + " parked and " + garage.size() + " Cars in the Garage");
			return true;
		} else {
			return false;
		}
	}

	public void remove(Car c) {
		if (garage.size() > 0) {
			System.out.println(garage.size() + " Cars in the Garage");
			garage.remove(c);
			System.out.println("Car " + c.nr + " removed and " + garage.size() + " Cars in the Garage");

		}
	}
}
