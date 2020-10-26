package seriaf.poo.structs;

public class PrivateMessage extends Message {

    private static final long serialVersionUID = 2;
    private String mDestinatar;

    @Override
    public String toString() {
        return "(priv)" + super.toString();
    }

    public String getRecipient() {
        return mDestinatar;
    }

    public PrivateMessage(String destinatar, String name, String content) {
        super(name, content);
        mDestinatar = destinatar;
    }
}
