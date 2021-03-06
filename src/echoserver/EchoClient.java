package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {

public static final int portNumber = 6013;
	
public static void main(String[] args) throws IOException {
	
	String server;

	if (args.length == 0) {
		server = "127.0.0.1";
	} else {
		server = args[0];
	}

	try {
		Socket socket = new Socket(server, portNumber);

		InputStream input = socket.getInputStream();
		OutputStream reader = socket.getOutputStream();

		int incByte;
		
		while ((incByte = System.in.read()) != -1) {
			reader.write(incByte);
			reader.flush();
			System.out.write(input.read());
			System.out.flush();
		}
		
		socket.close();
	}	
	
	
	catch (ConnectException ce) {
		System.out.println("We were unable to connect to " + server);
		System.out.println("You should make sure the server is running.");
	}
	catch (IOException ioe) {
		System.out.println("We caught an unexpected exception.");
		System.err.println(ioe);
	}
   }
}
