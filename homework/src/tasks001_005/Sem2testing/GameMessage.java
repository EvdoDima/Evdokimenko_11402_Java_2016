package tasks001_005.Sem2testing;

import java.io.Serializable;

/**
 * Created by evdodima on 23/11/15.
 * 11-402
 */
public class GameMessage implements Serializable {

    public final static int MESSAGE = 0;
    public final static int START_STOP_GAME = 1;
    public final static int YOURULE = 2;
    public final static int WORD = 3;
    public final static int CONTACT = 4;
    public static final int CHECK_CONTACT = 5 ;
    public static final int RULER_WORD = 6;
    public static final int END_GAME = 7;
    public static final int NAME_CHOOSE = 8;
    public static final int NAME_CONFIRM = 9;
    public static final int CONTACT_FAILED = 9;





    String senderName;
    String message;
    int messageType;

    public GameMessage(String message, String senderName) {
        this(message,senderName,MESSAGE);

    }

    public GameMessage(int messageType) {
        this(null,null,messageType);

    }

    public GameMessage(String toGuess) {
        this(toGuess,null,WORD);

    }

    public GameMessage(String message, int messageType) {
        this(message,null,messageType);
    }

    public GameMessage(String m, String uname, int messageType)
    {
        this.message = m;
        this.messageType = messageType;
        this.senderName=uname;

    }

    public String getMessage() {
        return message;
    }

    public int getMessageType() {
        return messageType;
    }

    public String getSenderName() {
        return senderName;
    }
}
