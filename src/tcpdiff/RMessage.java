package tcpdiff;

import java.io.Serializable;

/**
 * Created by user on 1/13/2018.
 */
public class RMessage implements Serializable{
    private String username;
    private String password;

    public RMessage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
