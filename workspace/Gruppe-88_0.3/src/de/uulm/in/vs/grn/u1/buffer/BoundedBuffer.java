package de.uulm.in.vs.grn.u1.buffer;

import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

public class BoundedBuffer {
	protected List<Object> puffer = null;
	protected int size;

	public BoundedBuffer() {
		this.puffer = new ArrayList<Object>();
		this.size = 32;
	}

	public BoundedBuffer(int size) {
		if (size < 1) {
			throw new IllegalArgumentException();
		} else {
			this.size = size;
			this.puffer = new ArrayList<Object>();
		}
	}

	public void putElement(Object o) {
		if (o.equals(null)) {
			throw new NullPointerException();
		}
		if (puffer.size() < size) {
			puffer.add(o);
		} else {
			throw new BufferOverflowException();
		}
	}

	public Object getNextEntry() {
		if (puffer.isEmpty()) {
			return null;
		} else {
			Object temp = puffer.get(0);
			puffer.remove(0);
			return temp;
		}
	}
}
