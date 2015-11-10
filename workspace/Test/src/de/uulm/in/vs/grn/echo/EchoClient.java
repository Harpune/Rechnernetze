package de.uulm.in.vs.grn.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) throws Exception, IOException {
		Socket socket = new Socket("192.168.1.2", 8888);
		
		OutputStream outputStream = socket.getOutputStream();
		InputStream inputStream = socket.getInputStream();
		
		outputStream.write("Test\r\n".getBytes());
		
		int n;
		while((n = inputStream.read()) != -1){
			System.out.print((char) n);
		}
		
		inputStream.close();
		outputStream.close();
		socket.close();
	}
}
