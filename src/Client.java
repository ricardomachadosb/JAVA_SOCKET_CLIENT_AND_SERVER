import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		final String host = "localhost";
		final int portNumber = 8088;
		
		Socket socket = new Socket(host, portNumber);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
					try {
						String userInput = userInputBR.readLine();
						out.println(userInput);
						out.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		while (true) {
	        try {
	            String msg = in.readLine();
	            System.out.println(msg);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
		}
	}
}
