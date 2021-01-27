import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int serverPort = 7777;

        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);

            Socket socket = new Socket(ipAddress, serverPort);

            System.out.println("Connected!");

             Support.iin = socket.getInputStream();
            Support.oout = socket.getOutputStream();

            Support.in = new DataInputStream(Support.iin);
            Support.out = new DataOutputStream(Support.oout);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line;
            System.out.println();

            while (true) {
                line = keyboard.readLine();
                Support.out.writeUTF(line);
                Support.out.flush();
                System.out.println("Server: " + Support.in.readUTF());
                System.out.println();
            }


        } catch (Exception ignored) {

        }
    }
}
