
package seriaf.poo.server.exceptions;

public class MissingKeyException extends Exception {

    public MissingKeyException() {
        super("One or more keys are missing from configuration file");
    }
}
