package tasks001_005.Sem2testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by evdodima on 20/11/15.
 * 11-402
 */
public class ContactPlayer extends JFrame {
    private boolean isRuler;

    String username;
    Socket socket;
    JTextField word;
    JPanel messages;
    JPanel yourMessage;
    ObjectOutputStream writer;
    InputStream is;
    ObjectInputStream ois;
    JPanel waitPanel;
    JPanel endPanel;
    JPanel mainPanel;
    boolean started;
    JScrollBar jb;
    JScrollPane chatbox;

    public ContactPlayer() throws IOException {
        super();

        isRuler = false;
        started = false;
        username = null;
        waitPanel = new JPanel();
        JTextField waitText = new JTextField();
        waitText.setText("     Please wait...     ");
        waitText.setEditable(false);
        waitPanel.add(waitText, BorderLayout.CENTER);
        waitPanel.setBackground(Color.blue);


        endPanel = new JPanel();
        JTextField endText = new JTextField();
        endText.setEditable(false);
        endPanel.add(endText, BorderLayout.CENTER);
        endPanel.setBackground(Color.GREEN);


        JPanel gameWord = new JPanel();
        yourMessage = new JPanel();
        yourMessage.setLayout(new FlowLayout());


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);

        this.setVisible(true);

        // Word that beeing guessed
        word = new JTextField();
        word.setEditable(false);
        gameWord.setLayout(new GridLayout(1, 0));
        gameWord.add(word);
        gameWord.setSize(300, 300);


        final Random r = new Random();
        messages = new JPanel();
        messages.setLayout(new BoxLayout(messages, BoxLayout.PAGE_AXIS));

        chatbox = new JScrollPane(messages);
        jb = chatbox.getVerticalScrollBar();


        final JButton send = new JButton("Send");
        final JTextArea yourM = new JTextArea(1, 30);

        yourM.setLineWrap(true);


        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toSend = yourM.getText();
                GameMessage ms = new GameMessage(toSend, username);
                sendMessage(ms);
                yourM.setText("");
            }
        });
        yourMessage.add(yourM);
        yourMessage.add(send);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(gameWord, BorderLayout.NORTH);
        mainPanel.add(chatbox, BorderLayout.CENTER);
        mainPanel.add(yourMessage, BorderLayout.SOUTH);
        mainPanel.setVisible(true);

        socket = showServerChoose(this);
        writer = new ObjectOutputStream(socket.getOutputStream());
        is = socket.getInputStream();
        ois = new ObjectInputStream(is);


        waitPanel.setVisible(true);
        this.setVisible(true);
        changeGameState(waitPanel);
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ContactPlayer game = new ContactPlayer();
        Socket s = game.socket;
        game.handleMessages();


    }


    public void handleMessages() throws IOException, ClassNotFoundException {
        String potentialName = showUnameChoose(this, null);
        String message = "This name is busy. Choose another: ";
        while (true) {
            if (this.is.available() != 0) {
                GameMessage m;
                while (true) {
                    try {
                        m = (GameMessage) this.ois.readObject();
                    } catch (Exception e) {
                        continue;
                    }
                    break;
                }
                switch (m.getMessageType()) {
                    case GameMessage.WORD:
                        System.out.println("got word");
                        this.messages.removeAll();
                        this.messages.repaint();
                        this.word.setText(m.getMessage());
                        break;

                    case GameMessage.MESSAGE:
                        this.addMessage(m);
                        break;

                    case GameMessage.START_STOP_GAME:
                        System.out.println("Started");
                        if (this.username != null) {
                            this.changeGameState(this.mainPanel);
                        }
                        started = true;
                        break;

                    case GameMessage.YOURULE:
                        this.isRuler = true;
                        String newword = this.wordForGame(this);
                        this.writer.writeObject(new GameMessage(newword));
                        this.yourMessage.setVisible(false);
                        break;

                    case GameMessage.CONTACT:
                        if (this.is.available() == 0) {
                            this.contactWord(m.getMessage());
                        }
                        break;

                    case GameMessage.END_GAME:
                        JTextField word = (JTextField) this.endPanel.getComponent(0);
                        word.setText("Game ended . The word was : " + m.getMessage());
                        this.changeGameState(this.endPanel);
                        this.yourMessage.setVisible(true);
                        this.isRuler = false;
                        break;

                    case GameMessage.NAME_CONFIRM:
                        if (started) {
                            changeGameState(mainPanel);
                        }
                        username = potentialName;
                        break;

                    case GameMessage.NAME_CHOOSE:
                        System.out.println("n choose");
                        potentialName = showUnameChoose(this, message);
                        break;
                }
            }
        }

    }


    public void addMessage(GameMessage m) {
        JPanel newM = newMessage(m.getMessage(), m.getSenderName());
        newM.setVisible(true);
        messages.add(newM, BorderLayout.CENTER);
        messages.validate();
        chatbox.validate();
        jb.validate();
        jb.setValue(jb.getMaximum());


    }

    private JPanel newMessage(String message, String uname) {
        JTextArea m = new JTextArea(2, 30);
        m.setLineWrap(true);
        m.setEditable(false);
        m.setText(message);

        JPanel oneM = new JPanel();
        //    oneM.setLayout(new BorderLayout());
        if (uname != null && uname.equals(username)) uname = null;
        JTextField uName = new JTextField(uname == null ? this.username : uname);
        uName.setPreferredSize(new Dimension(80, 40));
        uName.setEditable(false);
        oneM.add(uName, BorderLayout.CENTER);
        oneM.add(m, BorderLayout.CENTER);
        JButton contact = new JButton("Contact");
        JFrame main = this;
        contact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel message = (JPanel) ((JButton) e.getSource()).getParent();
                String m = ((JTextArea) message.getComponent(1)).getText();
                String uname = ((JTextField) message.getComponent(0)).getText();
                GameMessage ms = new GameMessage(m, uname, GameMessage.CONTACT);
                sendMessage(ms);
            }
        });
        if (uname != null && yourMessage.isVisible()) {
            oneM.add(contact, BorderLayout.CENTER);
        }
        oneM.setBorder(BorderFactory.createLineBorder(Color.blue));
        if (uname == null) {
            oneM.setBackground(Color.lightGray);
        }
        return oneM;
    }

    private String wordForGame(JFrame frame) throws IOException {
        String s;
        String message = "You are ruler. Enter the word :";
        do {
            s = JOptionPane.showInputDialog(
                    frame,
                    message, "Word",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (!wordCheck(s)) {
                message = "This word doesn't exist";
            }
        } while ((s == null || s.equals("") || !wordCheck(s)));
        return s;
    }


    public static boolean wordCheck(String word) throws IOException {
        URL mainpage = new URL("https://ru.wiktionary.org/wiki/" + word);
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new InputStreamReader(mainpage.openStream()));
        } catch (IOException e) {
            return false;
        }
        Pattern pattern = Pattern.compile("<a href=\".+\" title=\"существительное\">Существительное</a>");
        Pattern pattern1 = Pattern.compile("<p>Существительное.</p>");
        String s = bfr.readLine();
        do {
            Matcher m = pattern.matcher(s);
            Matcher m1 = pattern1.matcher(s);
            if (m.find() || m1.find()) {
                return true;
            }
            s = bfr.readLine();
        } while (s != null);
        return false;
    }

    private void contactWord(String message) {
        JDialog dialog = new JDialog(this, "Test", true);
        dialog.setLayout(new BorderLayout());
        //        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JTextField timertext = new JTextField();
        timertext.setEditable(false);

        JTextField text = new JTextField();
        dialog.add(timertext, BorderLayout.NORTH);
        JTextArea mess = new JTextArea(message);
        mess.setLineWrap(true);
        mess.setEditable(false);
        dialog.add(mess, BorderLayout.CENTER);
        dialog.add(text, BorderLayout.SOUTH);
        dialog.setBounds(this.getX() + this.getWidth() / 2 - 150,
                this.getY() + this.getHeight() / 2 - 50, 300, 100 + mess.getLineCount() * 12);
        dialog.setPreferredSize(new Dimension(300, 200));
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                dialog.setVisible(true);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    timertext.setText("                                 " + (15 - i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                String word = text.getText();
                if (isRuler) {
                    sendMessage(new GameMessage(word, GameMessage.RULER_WORD));
                } else
                    sendMessage(new GameMessage(word, GameMessage.CHECK_CONTACT));

                dialog.setVisible(false);
                dialog.dispose();
                System.out.println("closed");
            }
        }).start();
    }

    private void sendMessage(GameMessage gm) {
        while (true) {
            try {
                writer.writeObject(gm);
            } catch (IOException e1) {
                continue;
            }
            break;
        }
    }

    private String showUnameChoose(JFrame frame, String message) {
        String s;
        if (message == null) {
            message = "Enter your name :";
        }
        //  return String.valueOf(Math.random());
        do {
            s = JOptionPane.showInputDialog(
                    frame,
                    message, "Username",
                    JOptionPane.QUESTION_MESSAGE
            );
        } while (s == null || s.equals(""));
        sendMessage(new GameMessage(s, GameMessage.NAME_CHOOSE));
        return s;
    }

//    private boolean checkName(String s) {
//

//        GameMessage answer;
//        try {
//            answer = getAnswer();
//        } catch (IOException e) {
//            return false;
//        }
//        return answer != null && answer.getMessageType() == GameMessage.NAME_CONFIRM;
//    }

    private GameMessage getAnswer() throws IOException {
        while (true) {
            if (is.available() != 0) {
                try {
                    return (GameMessage) ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Socket showServerChoose(JFrame frame) throws IOException {
        String s;
        //   return new Socket("localhost", 3456);
        do {
            s = JOptionPane.showInputDialog(
                    frame,
                    "Enter server adress with port:", "Server adress",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (s == null || s.equals("")) continue;
            String[] addresWithPort = s.split(":");
            try {
                socket = new Socket(addresWithPort[0], Integer.parseInt(addresWithPort[1]));
            } catch (Exception e) {
                continue;
            }
            return socket;
        } while (true);
    }

    public void changeGameState(JPanel newP) {
        getContentPane().removeAll();
        getContentPane().add(newP, BorderLayout.CENTER);
        getContentPane().doLayout();
        update(getGraphics());
        this.setVisible(true);
    }


}