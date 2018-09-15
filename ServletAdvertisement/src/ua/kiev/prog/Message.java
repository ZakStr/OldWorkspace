package ua.kiev.prog;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 26.03.2017.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date date;
    private String text;

    public Message(String text) {
        this.date = new Date();
        this.text = text;
    }

    public Message() {
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");
        return sdf.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");
        return sdf.format(date) + text;
    }
}
