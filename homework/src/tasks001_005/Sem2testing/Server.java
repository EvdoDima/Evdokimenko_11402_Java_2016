package tasks001_005.Sem2testing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by evdodima on 23/11/15.
 * 11-402
 */
public class Server {

    final int PORT = 3456;

    private List<Connection> connections;
    private List<GameMessage> messages;


    private String word;
    private List<String> wordstoCheck;
    private String rulerword;
    private int wordlength;
    private String potentialRuler;

    public List<GameMessage> getMessages() {
        return messages;
    }

    public int getPORT() {
        return PORT;
    }

    public String getPotentialRuler() {
        return potentialRuler;
    }

    public String getRulerword() {
        return rulerword;
    }

    public String getWord() {
        return word;
    }

    public int getWordlength() {
        return wordlength;
    }

    public List<String> getWordstoCheck() {
        return wordstoCheck;
    }

    public void addMessage(GameMessage message) {
        messages.add(message);
    }


    public ArrayList<GameMessage> getMessages(int first) {
        ArrayList<GameMessage> res = new ArrayList<>();
        for (int i = first; i < messages.size(); i++) {
            res.add(messages.get(i));
        }
        return res;
    }


    public List<Connection> getConnections() {
        return connections;
    }

    public Server() throws IOException {

        wordstoCheck = Collections.synchronizedList(new ArrayList<String>());
        word = null;
        rulerword = null;
        potentialRuler = null;
        connections = Collections.synchronizedList(new ArrayList<Connection>());
        messages = Collections.synchronizedList(new ArrayList<GameMessage>());

        go();
    }

    public void go() throws IOException {
        ServerSocket s1 = new ServerSocket(PORT);
        while (true) {
            Socket client = s1.accept();
            connections.add(new Connection(this, client));
            if (connections.size() == 3) {
                startNewGame();
                break;
            }
        }
        while (true) {
            Socket client = s1.accept();
            connections.add(new Connection(this, client));
        }
    }

    private void startNewGame() throws IOException {
        if (this.word != null) {
            sendToAll(new GameMessage(word, GameMessage.END_GAME));
            word = null;
        }
        int i = 0;
        if (potentialRuler != null) {
            for (Connection c : getConnections()) {
                if (c.getUserName().equals(potentialRuler)) {
                    break;
                }
                i++;
            }
        } else {
            Random r = new Random();
            i = r.nextInt(connections.size()-1);
        }
        int ruler1 = i;
        boolean ready = false;
        while (!ready) {
            ready=true;
            for (Connection c : getConnections()) {
                if(c.getUserName()==null){
                    ready=false;
                    break;
                }
            }
        }

        Connection ruler = connections.get(i);
        ruler.writeMessage(new GameMessage(GameMessage.YOURULE));
        potentialRuler = null;
    }

    private void startgame() throws IOException {
        addMessage(new GameMessage(GameMessage.START_STOP_GAME));
        System.out.println("game started");
    }


    public static void main(String[] args) throws IOException {
        Server server = new Server();

    }

    public void setWord(GameMessage mes) throws IOException {
        System.out.println("word setted");
        word = mes.getMessage();
        wordlength = 1;
        System.out.println("the word is :" + word);
        addMessage(new GameMessage(word.substring(0, wordlength)));
        startgame();
    }

    public void sendToAll(GameMessage mes) {
        for (Connection c : connections) {
            try {
                c.writeMessage(mes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkContact(String word) throws IOException {
        wordstoCheck.add(word.trim());
        System.out.println(wordstoCheck.size()+ " "+ countAliveConnections());
        if (wordstoCheck.size() > countAliveConnections() - 2) {
            checkWords();
        }
    }

    public void rulerWord(String word) throws IOException {
        System.out.println("ruler word is " + word);
        if (word.equals(this.word)) {
            wordstoCheck.clear();
            startNewGame();
        } else {
            rulerword = word;
        }
    }

    private void checkWords() throws IOException {
        HashMap<String, Integer> wordsmap = new HashMap<>();
        for (String s : wordstoCheck) {
            if (s.equals(""))continue;

            if (s.equals(this.word)) {
                wordstoCheck.clear();
                startNewGame();
                return;
            }
            if (!wordsmap.containsKey(s)) {
                wordsmap.put(s, 1);
            } else {
                int c = wordsmap.get(s);
                wordsmap.put(s, c + 1);
            }
        }

        for (Map.Entry entry : wordsmap.entrySet()) {
            System.out.println((String) entry.getKey() + "" + (Integer) (entry.getValue()));
            if ((Integer) entry.getValue() > 1) {
                if (checkword((String) entry.getKey())) {
                    return;
                }
            }
        }
        wordstoCheck.clear();
        addMessage(new GameMessage(GameMessage.CONTACT_FAILED));
    }

    private boolean checkword(String word) {
        if ((rulerword==null||!rulerword.equals(word)) &&
                this.word.substring(0, wordlength).equals(word.substring(0, wordlength))) {
            wordlength++;
            addMessage(new GameMessage(this.word.substring(0, wordlength)));
            wordstoCheck.clear();
            return true;
        }
        return false;
    }

    private int countAliveConnections() {

        int res = 0;
        for (Connection c : connections) {
            if (c.thread.isAlive()) {
                res++;
            }
        }
        return res;
    }

    public void contact(GameMessage mes) {
        addMessage(mes);
        potentialRuler = mes.getSenderName();
    }
}
