
package seriaf.poo.structs;

import java.io.IOException;
import seriaf.poo.server.config.ServerConfig;
import seriaf.poo.server.exceptions.InvalidFormatException;
import seriaf.poo.server.exceptions.MissingKeyException;
import seriaf.poo.server.exceptions.UnknownKeyException;

/**
 *
 * @author student
 */
public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException, UnknownKeyException, MissingKeyException {
        ServerConfig s1 = new ServerConfig();

        System.out.printf("TCP_PORT=%d \n", s1.getTcpPort());
        System.out.printf("MAX_CLIENTS=%d \n", s1.getMaxClients());

    }
}
