package ru.kpfu.itis.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("/gwtrequest.rpc")
public interface MySampleApplicationService extends RemoteService {
    // Sample interface method of remote interface

    String greet(String name);

    List<String[]> getRequest(String text);


    /**
     * Utility/Convenience class.
     * Use MySampleApplicationService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
     */
    public static class App {
        private static MySampleApplicationServiceAsync ourInstance = GWT.create(MySampleApplicationService.class);

        public static synchronized MySampleApplicationServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
