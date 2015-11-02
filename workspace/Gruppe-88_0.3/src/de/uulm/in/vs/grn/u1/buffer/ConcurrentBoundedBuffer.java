package de.uulm.in.vs.grn.u1.buffer;

import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

public class ConcurrentBoundedBuffer {
	protected List<Object> puffer = null;
	protected int size;

	// Standardwert 32
	public ConcurrentBoundedBuffer() {
		this.puffer = new ArrayList<Object>();
		this.size = 32;
	}

	// Falls Puffer nicht zu klein initialisiert Puffer
	public ConcurrentBoundedBuffer(int size) {
		if (size < 1) {
			throw new IllegalArgumentException();
		} else {
			this.size = size;
			this.puffer = new ArrayList<Object>();
		}
	}

	// Element wird angefügt. Läuft Puffer über wird BufferOverflowException
	// geworfen
	public synchronized void putElement(Object o) {
		if (o.equals(null)) {
			throw new NullPointerException();
		}
		if (puffer.size() < size) {
			puffer.add(o);
		} else {
			throw new BufferOverflowException();
		}
	}

	public synchronized Object getNextEntry() {
		//kein leeres Objekt anfügen
		if (puffer.isEmpty()) {
			return null;
		} else {
			//lese und lösche ältestes Element
			Object temp = puffer.get(0);
			puffer.remove(0);
			return temp;
		}
	}
}
