package sample.exercise27;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingText extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Welcome to Java");

        Pane pane = new Pane();

        Line line = new Line();
        line.endYProperty().bind(pane.heightProperty().divide(2));
        line.startYProperty().bind(pane.heightProperty().divide(2));
        line.setStartX(-40);
        line.endXProperty().bind(pane.widthProperty().add(40));
        line.setFill(Color.WHITE);
        line.setStroke(Color.WHITE);

        pane.getChildren().addAll(line, text);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(line);
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setNode(text);
        pathTransition.setCycleCount(Timeline.INDEFINITE);


        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 27");
        primaryStage.show();
        pathTransition.play();

        scene.setOnMousePressed(e -> pathTransition.pause());
        scene.setOnMouseReleased(e -> pathTransition.play());
    }
}
