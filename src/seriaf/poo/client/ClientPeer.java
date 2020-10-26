package seriaf.poo.client;

import java.net.Socket;
import java.io.IOException;
import java.io.ObjectOutputStream;
import seriaf.poo.structs.Message;
import seriaf.poo.structs.PrivateMessage;

public class ClientPeer {

    private String mUser;
    private Socket mSocket;
    private ObjectOutputStream mObjectOutputStream;

    public ClientPeer(String user, Socket socket) throws IOException {
        mUser = user;
        mSocket = socket;
        mObjectOutputStream = new ObjectOutputStream(mSocket.getOutputStream());
    }

    public void sendMessage(String message) throws IOException {
        Message m = new Message(mUser, message);
        mObjectOutputStream.writeObject(m);
    }

    public void sendMessage(String message, String recipient) throws IOException {
        PrivateMessage pMsg = new PrivateMessage(recipient, mUser, message);
        mObjectOutputStream.writeObject(pMsg);
    }
}
