package seriaf.poo.server.config;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import seriaf.poo.server.exceptions.InvalidFormatException;
import seriaf.poo.server.exceptions.MissingKeyException;
import seriaf.poo.server.exceptions.UnknownKeyException;

/**
 *
 * @author student
 */
public class ServerConfig {

    private int TCP_PORT;
    private int MAX_CLIENTS;
    private boolean keyfound;
    private boolean clientfound;
    private boolean portfound;

    public int getTcpPort() {
        return TCP_PORT;
    }

    public int getMaxClients() {
        return MAX_CLIENTS;
    }

    public ServerConfig(String filepath) throws IOException, InvalidFormatException, UnknownKeyException, MissingKeyException {

        BufferedReader reader;
        reader = new BufferedReader(new FileReader(filepath));

        String line;

        while ((line = reader.readLine()) != null) {

            String trim = line.trim();
            if (trim.startsWith("#") || trim.isEmpty()) {
                continue;
            }

            if (!trim.matches("[a-zA-Z_][a-zA-Z0-9_]*\\s*=\\s*[0-9]+")) {
                throw new InvalidFormatException();
            }

            String key[] = trim.split("=");

            if (key[0].compareTo("TCP_PORT") == 0) {
                TCP_PORT = Integer.parseInt(key[1]);
                keyfound = true;
                portfound = true;
            }
            if (key[0].compareTo("MAX_CLIENTS") == 0) {
                MAX_CLIENTS = Integer.parseInt(key[1]);
                keyfound = true;
                clientfound = true;

            }

        }
        if (!keyfound) {
            throw new UnknownKeyException();
        }
        if (!(portfound && clientfound)) {
            throw new MissingKeyException();

        }

        reader.close();
    }

    public ServerConfig() throws IOException, InvalidFormatException, UnknownKeyException, MissingKeyException {
        this("server.conf");
    }
}
