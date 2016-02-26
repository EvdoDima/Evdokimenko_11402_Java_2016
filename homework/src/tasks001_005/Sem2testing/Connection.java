package tasks001_005.Sem2testing;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Created by evdodima on 23/11/15.
 * 11-402
 */
public class Connection implements Runnable {
    Socket socket;
    Thread thread;
    Server server;
    int messageIndex;
    ObjectOutputStream oos;
    private String username;


    public void writeMessage(GameMessage m) throws IOException {
        sendMessage(m);
    }


    public Connection(Server server, Socket socket) throws IOException {
        messageIndex = 0;
        this.socket = socket;
        oos = new ObjectOutputStream(socket.getOutputStream());
        this.server = server;
        username = null;
        thread = new Thread(this);
        thread.start();

    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);


            while (true) {

                for (GameMessage m : server.getMessages(messageIndex)) {

                    sendMessage(m);
                    System.out.println(messageIndex);
                    messageIndex++;

                }

                if (is.available() != 0) {
                    GameMessage mes = (GameMessage) ois.readObject();
                    if (mes != null) {

                        switch (mes.getMessageType()) {
                            case GameMessage.WORD:
                                server.setWord(mes);
                                break;
                            case GameMessage.MESSAGE:
                                server.addMessage(mes);
                                break;
                            case GameMessage.CONTACT:
                                server.contact(mes);
                                break;

                            case GameMessage.CHECK_CONTACT:
                                server.checkContact(mes.getMessage());
                                break;

                            case GameMessage.RULER_WORD:
                                server.rulerWord(mes.getMessage());
                                break;

                            case GameMessage.NAME_CHOOSE:
                                System.out.println("name choose");
                                if (checkName(mes.getMessage())) {
                                    username = mes.getMessage();
                                    System.out.println(username);
                                    sendMessage(new GameMessage(GameMessage.NAME_CONFIRM));
                                } else {
                                    sendMessage(new GameMessage(GameMessage.NAME_CHOOSE));
                                }
                                break;
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void sendMessage(GameMessage gameMessage) {
        while (true) {
            try {
                oos.writeObject(gameMessage);
            } catch (IOException e) {
                continue;
            }
            break;
        }
    }

    private boolean checkName(String message) {
        for (Connection c : server.getConnections()) {
            if (c.getUserName() != null && c.getUserName().equals(message)) {
                return false;
            }
        }
        return true;
    }

    public String getUserName() {
        return username;
    }
}
