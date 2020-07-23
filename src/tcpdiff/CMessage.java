package tcpdiff;

import java.io.Serializable;

/**
 * Created by user on 1/13/2018.
 */
public class CMessage implements Serializable{
    private String from;
    private String password;
    private String to;
    private String text;

    public void setFrom(String from) {
        this.from = from;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTo(String to) {
        this.to = to;
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

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    public CMessage(String from, String password, String to, String text) {
        this.from = from;
        this.password = password;
        this.to = to;
        this.text = text;
    }
}
