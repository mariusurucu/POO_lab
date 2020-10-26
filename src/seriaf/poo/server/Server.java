package seriaf.poo.server;

import seriaf.poo.server.config.ServerConfig;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        ServerConfig sConfiguration;
        ServerSocket sSocket;
        ServerPeer serverpeer;
        try {
            sConfiguration = new ServerConfig();
            sSocket = new ServerSocket(sConfiguration.getTcpPort());
            serverpeer = new ServerPeer(sSocket.accept());
            serverpeer.run();
        } catch (Exception exc) {
            System.err.println("exceptie " + exc);
        }
    }
}
