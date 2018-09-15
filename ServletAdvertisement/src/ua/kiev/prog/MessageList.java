package ua.kiev.prog;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by admin on 26.03.2017.
 */
public class MessageList implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Message> list = new ArrayList<>();

    public MessageList() {
        super();
    }

    public void addMessage(Message message) {
        list.add(message);
    }

    public ArrayList<Message> getMessageList() {
        return new ArrayList<>(this.list);
    }
}
