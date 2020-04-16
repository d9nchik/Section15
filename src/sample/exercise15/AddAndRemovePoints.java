package sample.exercise15;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AddAndRemovePoints extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 15");
        primaryStage.show();

        scene.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                final int RADIUS = 4;
                final Circle circle = new Circle(e.getX(), e.getY(), RADIUS);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
                pane.getChildren().add(circle);
            } else if (e.getButton() == MouseButton.SECONDARY) {
                Point2D point2D = new Point2D(e.getX(), e.getY());
                pane.getChildren().removeIf(node -> node instanceof Circle && node.contains(point2D));
            }
        });
    }
}
