package de.uulm.in.vs.grn.u1.buffer;

public class ReadersWritersMain {
	public static void main(String[] args) {
		//initializiere und starte Threads
		ConcurrentBoundedBuffer cbb = new ConcurrentBoundedBuffer();
		Thread t1 = new Thread(new BufferStringWriter(cbb));
		Thread t2 = new Thread(new BufferStringReader(cbb));
		t1.start();
		t2.start();
	}
}
