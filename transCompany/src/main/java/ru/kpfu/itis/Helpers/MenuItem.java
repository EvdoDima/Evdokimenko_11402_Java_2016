package ru.kpfu.itis.Helpers;

/**
 * Created by evdodima on 11/04/16.
 * 11-402
 */
public class MenuItem {
    private String name;
    private String icon;

    public MenuItem( String name, String icon) {
        this.icon = icon;
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}
