import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class test3_socket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			final Socket socket = new Socket("127.0.0.1",8088);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while (true) {
						try {
							DataInputStream in = new DataInputStream(socket.getInputStream());
							System.out.println(in.readUTF());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}).start();
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (true) {
				Scanner sc = new Scanner(System.in);
				out.writeUTF(sc.next());
				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
