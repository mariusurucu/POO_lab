package seriaf.poo.client;

import java.net.Socket;
import java.util.Scanner;

public class TextClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String user;
        //try {
        user = scanner.nextLine();
        // } catch (IOException ex) {
        //   Logger.getLogger(TextClient.class.getName()).log(Level.SEVERE, null, ex);
        //}
        Socket socket;
        ClientPeer clientpeer;
        try {
            socket = new Socket("127.0.0.1", 9000);
            clientpeer = new ClientPeer(user, socket);
            String buffer;
            while (true) {
                buffer = scanner.nextLine();
                if (buffer.startsWith("/q")) {
                    break;
                } else if (buffer.startsWith("/w")) {
                    String tmpDestinatar = buffer.split(" ")[1];
                    buffer = buffer.replaceAll("/w (\\w+) ", "");
                    clientpeer.sendMessage(buffer, tmpDestinatar);
                } else {
                    clientpeer.sendMessage(buffer);
                }
            }
        } catch (Exception e) {
            System.err.println("Exceptie :" + e);
        }
    }
}
