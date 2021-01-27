import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 7777;
        try {
            ServerSocket ss = new ServerSocket(port);

            System.out.println("Waiting for a client...");

            Socket socket = ss.accept();

            System.out.println("Connected!");
            System.out.println();

            Support.iin = socket.getInputStream();
            Support.oout = socket.getOutputStream();

            Support.in = new DataInputStream(Support.iin);
            Support.out = new DataOutputStream(Support.oout);

            String line = null;

            while (true) {
                line = Support.in.readUTF();
                System.out.println("Client: " + line);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                line = bufferedReader.readLine();
                Support.out.writeUTF(line);
                Support.out.flush();
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
