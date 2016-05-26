package sample.connection;


import sample.models.enums.UserRole;

import java.io.IOException;
import java.util.Base64;


/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */

public class ServerAuth {
    private static String loginPass;
    public static UserRole role;

    private ServerConnection server = new ServerConnection();

    static String getLoginPass() {
        return loginPass;
    }

    public boolean tryAuth(String login, String pass) {
        save(login, pass);

        try {
            UserRole role = server.getUserRole();
            ServerAuth.role = role;
            System.out.println(role);
            return true;
        } catch (MyCustomException e) {
            System.out.println(e.getStatusCode());
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return false;
    }

    private void save(String login, String pass) {
        byte[] bytes = (login + ":" + pass).getBytes();
        loginPass = "Basic " + Base64.getEncoder().encodeToString(bytes);;
    }
}
