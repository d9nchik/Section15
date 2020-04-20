package sample.exercise31;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pendulum extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Circle circle1 = new Circle();
        circle1.setRadius(3);
        circle1.setCenterY(10);

        Circle circle = new Circle();
        circle.setRadius(10);
        circle.setFill(Color.ORANGE);

        Arc arc = new Arc(150, 60, 100, 100, 225, 90);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.WHITE);


        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(arc);
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setNode(circle);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);

        pane.widthProperty().addListener(e -> {
            circle1.setCenterX(pane.getWidth() / 2);
            arc.setCenterX(pane.getWidth() / 2);
            resetTransition(pathTransition);
        });


        Line arrow = new Line();
        arrow.setStartY(circle1.getCenterY());
        arrow.startXProperty().bind(circle1.centerXProperty());

        arrow.endXProperty().bind(circle.translateXProperty().add(circle.getCenterX()));
        arrow.endYProperty().bind(circle.translateYProperty().add(circle.getCenterY()));

        pane.getChildren().addAll(arc, arrow, circle1, circle);

        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Exercise 31");
        primaryStage.setScene(scene);
        primaryStage.show();
        pathTransition.play();

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    pathTransition.setDuration(pathTransition.getDuration().subtract(Duration.millis(50)));
                    resetTransition(pathTransition);
                    Duration duration;
                    break;
                case DOWN:
                    pathTransition.setDuration(pathTransition.getDuration().add(Duration.millis(50)));
                    duration = pathTransition.getCurrentTime();
                    pathTransition.stop();
                    pathTransition.jumpTo(duration);
                    pathTransition.play();
                    break;
                case S:
                    pathTransition.stop();
                    break;
                case R:
                    pathTransition.play();
            }
        });
    }

    private void resetTransition(PathTransition pathTransition) {
        Duration duration = pathTransition.getCurrentTime();
        pathTransition.stop();
        pathTransition.jumpTo(duration);
        pathTransition.play();
    }
}
