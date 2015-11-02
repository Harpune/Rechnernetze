package de.uulm.in.vs.grn.u1.buffer;

public class RingBuffer extends BoundedBuffer {
	
	public RingBuffer(int size){
		super(size);
	}
	
	public void putElement(Object o) {
		if (o.equals(null)) {
			throw new NullPointerException();
		}
		if (puffer.size() < size) {
			puffer.add(o);
		} else {
			puffer.remove(0);
			puffer.add(o);
		}
	}
}
