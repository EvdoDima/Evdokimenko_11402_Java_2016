package models;


import java.util.ArrayList;

/**
 * Created by evdodima on 11/04/16.
 * 11-402
 */
public class Menu {
    public static ArrayList<MenuItem> menuItems = new ArrayList<>();

    static {
        menuItems.add(new MenuItem("dashboard",
                "<svg class=\"glyph stroked dashboard-dial\"><use xlink:href=\"#stroked-dashboard-dial\"></use></svg>"));

        menuItems.add(new MenuItem("widgets",
                "<svg class=\"glyph stroked calendar\"><use xlink:href=\"#stroked-calendar\"></use></svg>"));

        menuItems.add(new MenuItem("charts",
                "<svg class=\"glyph stroked line-graph\"><use xlink:href=\"#stroked-line-graph\"></use></svg>"));

        menuItems.add(new MenuItem("tables",
                "<svg class=\"glyph stroked table\"><use xlink:href=\"#stroked-table\"></use></svg>"));


        menuItems.add(new MenuItem("forms",
                "<svg class=\"glyph stroked pencil\"><use xlink:href=\"#stroked-pencil\"></use></svg>"));


        menuItems.add(new MenuItem("panels",
                "<svg class=\"glyph stroked app-window\"><use xlink:href=\"#stroked-app-window\"></use></svg>"));

        menuItems.add(new MenuItem("icons",
                "<svg class=\"glyph stroked star\"><use xlink:href=\"#stroked-star\"></use></svg>"));
    }
}
