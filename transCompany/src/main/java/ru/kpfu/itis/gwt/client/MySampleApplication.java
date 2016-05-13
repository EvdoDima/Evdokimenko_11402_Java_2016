package ru.kpfu.itis.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

    private MySampleApplicationServiceAsync greetingService = GWT.create(MySampleApplicationService.class);
    private TextBox nameTextBox = new TextBox();
    private Label greetingLabel = new Label("Hello, GWT!");

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(nameTextBox);
        RootPanel.get().add(greetingLabel);

        final AsyncCallback<String> callback = new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                greetingLabel.setText("ERROR!");
            }

            @Override
            public void onSuccess(String result) {
                greetingLabel.setText(result);
            }
        };

        nameTextBox.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent keyUpEvent) {
                greetingService.greet(nameTextBox.getText(), callback);
            }
        });
    }

//    /**
//     * This is the entry point method.
//     */
//    public void onModuleLoad() {
//
//        final TextBox namefield = new TextBox();
//        final TextBox emailfield = new TextBox();
//        final TextArea messagefiled = new TextArea();
//
//        final Button submitbutton = new Button();
//
//
//
//
//
//        submitbutton.addClickHandler(new ClickHandler() {
//
//            @Override
//            public void onClick(ClickEvent event) {
//
//            }
//        });
//
//        // Assume that the host HTML has elements defined whose
//        // IDs are "slot1", "slot2".  In a real app, you probably would not want
//        // to hard-code IDs.  Instead, you could, for example, search for all
//        // elements with a particular CSS class and replace them with widgets.
//        //
//        RootPanel.get("name").add(namefield);
//        RootPanel.get("email").add(emailfield);
//        RootPanel.get("message").add(messagefiled);
//        RootPanel.get("submitbutton").add(submitbutton);
//
//
//
//    }
//
//    private static class MyAsyncCallback implements AsyncCallback<List<String[]>> {
//        private RootPanel tbody;
//
//
//        public MyAsyncCallback(RootPanel tbody) {
//            this.tbody = tbody;
//        }
//
//        public void onSuccess(List<String[]> result) {
//            System.out.println("success");
//
//            for (String[] strs :result) {
//                String row="";
//                for (String str : strs) {
//                   row+="<td>"+str+"</td>";
//                }
//
//                tbody.add(new HTMLPanel("tablebody","<tr><td>1</td><td>2</td></tr>"));
//            }
//        }
//
//        public void onFailure(Throwable throwable) {
//            tbody.add(new HTML("Failed to receive answer from server!"));
//        }
//    }
}
