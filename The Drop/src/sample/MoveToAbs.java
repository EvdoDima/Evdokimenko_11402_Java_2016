package sample;

import javafx.scene.Node;
import javafx.scene.shape.MoveTo;

/**
 * Created by evdodima on 17/05/16.
 * 11-402
 */
public class MoveToAbs extends MoveTo {
    public MoveToAbs(Node node) {
        super(node.getLayoutBounds().getWidth() / 2,node.getLayoutBounds().getHeight() / 2);
    }

    public MoveToAbs(Node node, double x, double y) {
        super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2,
                y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
    }

}
