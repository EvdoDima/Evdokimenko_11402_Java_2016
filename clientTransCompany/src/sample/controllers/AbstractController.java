package sample.controllers;

import sample.Main;

/**
 * Created by evdodima on 25/05/16.
 * 11-402
 */
public abstract class AbstractController {

    public void setApp(Main app) {
        this.app = app;
    }

    protected Main app;
}
