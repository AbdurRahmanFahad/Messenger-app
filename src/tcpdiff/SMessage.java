package tcpdiff;

import java.io.Serializable;

/**
 * Created by user on 1/13/2018.
 */
public class SMessage implements Serializable{
    private String from;
    private String password;
    private String text;

    public SMessage(String from, String password, String text) {
        this.from = from;
        this.password = password;
        this.text = text;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public String getPassword() {
        return password;
    }

    public String getText() {
        return text;
    }
}
