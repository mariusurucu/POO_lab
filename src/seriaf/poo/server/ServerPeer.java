package seriaf.poo.server;

import java.net.Socket;
import java.io.ObjectInputStream;

public class ServerPeer {

    private Socket mSocket;

    public ServerPeer(Socket socket) {
        mSocket = socket;
    }

    public void run() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(mSocket.getInputStream());
            while (true) {
                System.out.println("" + (String) ois.readObject());
            }
        } catch (Exception e) {
        }

    }
}
