package ru.kpfu.itis.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface MySampleApplicationServiceAsync {

    void getRequest(String text, AsyncCallback<List<String[]>> async);

    void greet(String name, AsyncCallback<String> async);
}
