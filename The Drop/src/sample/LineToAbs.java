package sample;

import javafx.scene.Node;
import javafx.scene.shape.LineTo;

/**
 * Created by evdodima on 17/05/16.
 * 11-402
 */
public class LineToAbs extends LineTo {
    public LineToAbs(Node node, double x, double y) {
        super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
    }

}

