package de.uulm.in.vs.grn.u1.parkhaus;

public class Car implements Runnable {
	public int nr;
	public Garage garage = null;
	public boolean parked = false;

	public Car(Garage garage, int nr) {
		this.garage = garage;
		this.nr = nr;
	}

	@Override
	public void run() {
		while (true) {
			if (parked) {
				this.leave();
			} else {
				this.park();
			}
			// Warten
			int zeit = (int) (Math.random() * 2000);
			try {
				Thread.sleep(zeit);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void park() {
		if (garage.add(this)) {
			parked = true;
		}
	}

	private void leave() {
		garage.remove(this);
		parked = false;
	}

}

