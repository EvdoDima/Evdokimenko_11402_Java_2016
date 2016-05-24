package sample;


import javafx.animation.PathTransition;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.LinkedList;

import static sample.Block.blockHeight;

public class Main extends Application {

    public static final int borderWidth = 10;
    public static final int windowWidth = 400;
    public static final int windowHeight = 600;

    public static int currentHeight = borderWidth;

    private LinkedList<Block> activeBlocks;
    public static boolean dropping=false;

    public Stage primary;





    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The Drop");
        primaryStage.setScene(createScene());
        primaryStage.setResizable(false);
        primaryStage.show();
        primary=primaryStage;
    }



    public Scene createScene() {
        activeBlocks = new LinkedList<Block>();
        final Group root = new Group();

        final Rectangle horizontalBorder = setBorders(root);

        final Label score = new Label("Score : 0");
        score.setLayoutX(borderWidth+5);
        score.setLayoutY(5);
        score.setStyle("-fx-font-size: 20px");

        root.getChildren().add(score);

        activeBlocks.add(new Block(root));

        final Main app = this;



        final Scene scene = new Scene(root, windowWidth, windowHeight);


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.isAltDown()) {
                    if (!dropping) {
                        dropping = true;
                        activeBlocks.getLast().drop(app,root, activeBlocks,score);
                        changeScope(root, horizontalBorder);
                    }
                }
            }
        });


        return scene;
    }

    private void changeScope(Group root, Rectangle horizontalBorder) {
        if (activeBlocks.size()>5) {
            int i = 0;
            for (final Block block : activeBlocks) {
                if (i==7) {
                    continue;
                }
                block.fixPosition();
                Path path = new Path();
                path.getElements().add(new MoveToAbs(block));
                path.getElements().add(new LineToAbs(block,block.getLayoutX(),block.getLayoutY()+blockHeight));
                PathTransition pathTransition = new PathTransition();
                pathTransition.setDuration(Duration.millis(300*Block.gamespeed));
                pathTransition.setPath(path);
                pathTransition.setNode(block);
                pathTransition.play();
              //  block.relocate(block.getLayoutX(),block.getLayoutY()+blockHeight);
                i++;
            }


            root.getChildren().remove(horizontalBorder);

        }
    }


    public static void main(String[] args) {
        launch(args);
    }


    private Rectangle setBorders(Group root) {
        Rectangle verticalBorderLeft = new Rectangle();
        verticalBorderLeft.setWidth(borderWidth);
        verticalBorderLeft.setHeight(windowHeight);

        verticalBorderLeft.setLayoutX(0);
        verticalBorderLeft.setLayoutY(0);
        verticalBorderLeft.setFill(Color.GRAY);

        Rectangle verticalBorderRight = new Rectangle();
        verticalBorderRight.setWidth(borderWidth);
        verticalBorderRight.setHeight(windowHeight);

        verticalBorderRight.setLayoutX(windowWidth - borderWidth);
        verticalBorderRight.setLayoutY(0);
        verticalBorderRight.setFill(Color.GRAY);

        Rectangle horizontalBorder = new Rectangle();
        horizontalBorder.setWidth(windowWidth);
        horizontalBorder.setHeight(borderWidth);

        horizontalBorder.setLayoutX(0);
        horizontalBorder.setLayoutY(windowHeight - borderWidth);
        horizontalBorder.setFill(Color.GRAY);


        root.getChildren().addAll(verticalBorderLeft, verticalBorderRight, horizontalBorder);
        return horizontalBorder;
    }
}