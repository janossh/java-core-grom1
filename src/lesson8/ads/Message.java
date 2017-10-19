package lesson8.ads;

import java.util.Date;

public class Message extends BaseEntity{
    String userFrom;
    String userTo;
    Date dateSent;
    Date dateRead;
    String message;

    public Message(long id, String userFrom, String userTo, String message) {
        super(id);
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.dateSent = new Date();
        this.message = message;
    }


    void setDateRead() {
        dateRead = new Date();
    }

    boolean isRead() {
//        if (dateRead == null)
//            return false;
//        else
//            return true;

        return dateRead == null;
    }
}
