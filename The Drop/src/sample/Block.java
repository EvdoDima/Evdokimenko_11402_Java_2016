package sample;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import static sample.Main.*;


/**
 * Created by evdodima on 16/05/16.
 * 11-402
 */
public class Block extends Rectangle {

    public static int blockscount = 0;

    public static final int blockHeight = 60;
    public static final int blockWidth = 100;
    public static double gamespeed;

    PathTransition pathTransition;


    public Block(final Group root) {
        blockscount++;
        gamespeed = 0.1 + 1.0/(blockscount+1);


        Random random = new Random();

        this.setFill(Color.rgb(random.nextInt(254), random.nextInt(254), random.nextInt(254)));

        this.setHeight(blockHeight);
        this.setWidth(blockWidth);

        boolean side = random.nextBoolean();

        this.setLayoutX(side ? borderWidth + 5 : windowWidth - (borderWidth + 5) - blockWidth);
        int interval = 200 + (currentHeight > blockHeight * 4 ? blockHeight : 0);
        this.setLayoutY(windowHeight - (currentHeight + interval));


        Path path = new Path();
        path.getElements().add(new MoveToAbs(this));
        path.getElements().add(new LineToAbs(this, windowWidth - (borderWidth + 5) - blockWidth, this.getLayoutY()));

        Path pathReversed = new Path();
        pathReversed.getElements().add(new MoveToAbs(this));
        pathReversed.getElements().add(new LineToAbs(this, borderWidth + 5, this.getLayoutY()));

        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1700 * gamespeed));
        pathTransition.setPath(side ? path : pathReversed);
        pathTransition.setNode(this);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        root.getChildren().add(this);

    }

    public void drop(final Main app, final Group root, final LinkedList<Block> activeBlocks, final Label score) {
        pathTransition.stop();
        fixPosition();
        Block prevBlock = null;
        if (activeBlocks.size() > 1) {
            prevBlock = activeBlocks.get(activeBlocks.size() - 2);
        }
        if (prevBlock != null && !(getLayoutX() > prevBlock.getLayoutX() - blockWidth &&
                getLayoutX() < prevBlock.getLayoutX() + blockWidth)) {

            int i = 0;

//            Path path = new Path();
//            path.getElements().add(new MoveToAbs(root));
//            path.getElements().add(new LineToAbs(root, 0, windowHeight + blockHeight));
//            PathTransition pathTransition = new PathTransition();
//            pathTransition.setDuration(Duration.millis(500));
//            pathTransition.setPath(path);
//            pathTransition.setNode(root);
//            pathTransition.play();
//            root.minWidth(windowWidth);
//            root.minHeight(windowHeight);
//
//            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    System.out.println(root.getLayoutX()+" "+root.getLayoutY());
//                   // root.getChildren().clear();
//                    root.minWidth(windowWidth);
//                    root.minHeight(windowHeight);
//                    Path path = new Path();
//                    path.getElements().add(new MoveToAbs(root));
//                    path.getElements().add(new LineToAbs(root, 0, 0));
//                    PathTransition pathTransition = new PathTransition();
//                    pathTransition.setDuration(Duration.millis(500));
//                    pathTransition.setPath(path);
//                    pathTransition.setNode(root);
//                    pathTransition.play();
//
//                    root.setLayoutX(0);
//                    root.setLayoutY(0);
//                    Label label = new Label("Your score : " + blockscount);
//                    label.setStyle("-fx-font-size: 20px");
//                    label.setLayoutY(windowHeight / 2 - 10);
//                    label.setLayoutX(15);
//
//                    Label lostlabel = new Label("You lost");
//                    lostlabel.setStyle("-fx-font-size: 20px");
//                    lostlabel.setLayoutY(windowHeight / 2 - 35);
//                    lostlabel.setLayoutX(15);
//
//                    Button newGame = new Button("New game");
//
//                    newGame.setMinHeight(45);
//                    newGame.setLayoutY(windowHeight / 2 - 30);
//                    newGame.setLayoutX(windowWidth - 200);
//
//                    Main.dropping = false;
//                    blockscount = 0;
//                    currentHeight = borderWidth;
//
//                    app.primary.getScene().setOnKeyPressed(null);
//
//                    newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent event) {
//                            app.primary.setScene(app.createScene());
//                        }
//                    });
//
//                    root.getChildren().add(label);
//                    root.getChildren().add(lostlabel);
//                    root.getChildren().add(newGame);
//                }
//            });


            for (final Node node : root.getChildren()) {

                Path path = new Path();
                path.getElements().add(new MoveToAbs(node));
                path.getElements().add(new LineToAbs(node, node.getLayoutX(), windowHeight + blockHeight));
                PathTransition pathTransition = new PathTransition();
                double speed = windowHeight / 700.0;
                pathTransition.setDuration(Duration.millis((windowHeight - node.getLayoutY()) / speed));
                pathTransition.setPath(path);
                pathTransition.setNode(node);
                pathTransition.play();
                pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        node.relocate(node.getLayoutX(),windowHeight+blockHeight);
                    }
                });
                if (i == 0) {
                    pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            node.relocate(node.getLayoutX(),windowHeight+blockHeight);

                            Label label = new Label("Your score : " + blockscount);
                            label.setStyle("-fx-font-size: 20px;");
                            label.setLayoutY(windowHeight / 3);
                            label.setLayoutX(windowWidth/2-60);

                            Label lostlabel = new Label("You lost");
                            lostlabel.setStyle("-fx-font-size: 20px; ");

                            lostlabel.setLayoutY(windowHeight /4);
                            lostlabel.setLayoutX(windowWidth/2 - 40);

                            Label infoLabel = new Label();

                            try {
                                 infoLabel= (Label)((Pane)new FXMLLoader(getClass().
                                        getResource("StartPAge.fxml")).load()).getChildren().get(4);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                            Main.dropping = false;
                            blockscount = 0;
                            currentHeight = borderWidth;

                            app.primary.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
                                @Override
                                public void handle(KeyEvent event) {
                                    if (event.getCode()== KeyCode.SPACE){
                                        app.changeSceneToGame();
                                    }
                                }
                            });


                            root.getChildren().add(label);
                            root.getChildren().add(lostlabel);
                            root.getChildren().add(infoLabel);
                           // root.getChildren().add(newGame);

                        }
                    });
                    i++;
                }
            }


            return;

        }
        Path path = new Path();
        path.getElements().add(new MoveToAbs(this));
        path.getElements().add(new LineToAbs(this, this.getLayoutX(),
                windowHeight - currentHeight - blockHeight));

        if (currentHeight < blockHeight * 4)
            currentHeight += blockHeight;

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(700 * gamespeed));
        pathTransition.setPath(path);
        pathTransition.setNode(this);
        pathTransition.play();
        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                score.setText("Score : " + blockscount);
                Main.dropping = false;
                addNewBlock(root, activeBlocks);

            }
        });
    }


    public void fixPosition() {
        double x = this.getLayoutX() + this.getTranslateX();
        double y = this.getLayoutY() + this.getTranslateY();
        this.relocate(x, y);
//        this.setX(x);
//        this.setY(y);
        this.setTranslateX(0);
        this.setTranslateY(0);
    }

    private void addNewBlock(Group root, LinkedList<Block> activeBlocks) {
        activeBlocks.add(new Block(root));
        if (activeBlocks.size() > 8) {
            root.getChildren().remove(activeBlocks.getFirst());
            activeBlocks.removeFirst();
        }
    }


}
