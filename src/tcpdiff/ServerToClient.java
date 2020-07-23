package tcpdiff;

import java.io.Serializable;

/**
 * Created by user on 1/13/2018.
 */
public class ServerToClient implements Serializable{
    private String username;
    private String text;

    public ServerToClient(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }
}
