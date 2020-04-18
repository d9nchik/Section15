package sample.exercise26;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PendulumSwing extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Circle circle = new Circle();
        circle.setRadius(10);
        circle.setFill(Color.ORANGE);

        Arc arc = new Arc(150, 100, 100, 30, 195, 150);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);

        pane.getChildren().addAll(arc, circle);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(arc);
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setNode(circle);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), circle);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.1);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();

        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("Exercise 26");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> {
            pathTransition.pause();
            fadeTransition.pause();
        });
        scene.setOnMouseReleased(e -> {
            pathTransition.play();
            fadeTransition.play();
        });
    }
}
