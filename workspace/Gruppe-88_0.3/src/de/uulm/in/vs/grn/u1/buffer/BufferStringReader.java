package de.uulm.in.vs.grn.u1.buffer;

public class BufferStringReader implements Runnable{
	
	ConcurrentBoundedBuffer cbb = null;
	
	public BufferStringReader(ConcurrentBoundedBuffer cbb){
		this.cbb=cbb;
	}
	//�ltestes Objekt wird ausgegeben. Wird �bersprungen falls null.
	@Override
	public void run() {
		while(true){
			Object temp = cbb.getNextEntry();
			if(temp != null){
				System.out.println(temp);
			}
		}
	}
}
