package de.uulm.in.vs.grn.u1.buffer;

import java.nio.BufferOverflowException;
import java.util.Random;

public class BufferStringWriter implements Runnable {

	public ConcurrentBoundedBuffer cbb = null;
	private String count = new String();

	public BufferStringWriter(ConcurrentBoundedBuffer cbb) {
		this.cbb = cbb;
	}

	// Die zufällig generierte Zahl wird auf den Puffer geschrieben. Falls
	// Puffer voll ist wird die Zahl übersprungen.
	@Override
	public void run() {
		while (true) {
			Random rand = new Random();
			// Ascii Buchstabe
			int randomNum = rand.nextInt((127 - 34) + 1) + 34;
			char randomChar = (char) randomNum;
			try {
				// schreib das Element auf den Puffer, anonsten häng noch ein
				// char an den String
				count = count + randomChar;
				cbb.putElement(count);
				count = "";
			} catch (BufferOverflowException e) {
				continue;
			}
		}
	}

}
