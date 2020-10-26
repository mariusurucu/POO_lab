
package seriaf.poo.structs;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 1;

    private String mName;
    private String mContent;

    @Override
    public String toString() {
        return mName + ":" + mContent;
    }

    public Message(String name, String content) {
        mName = name;
        mContent = content;
    }
}
