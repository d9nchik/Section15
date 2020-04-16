package sample.exercise12;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IsMouseInsideCircle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 60, 50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        Text text = new Text();

        Pane pane = new Pane(circle, text);

        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 12");
        primaryStage.show();

        scene.setOnMouseMoved(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            if (circle.contains(new Point2D(e.getX(), e.getY())))
                text.setText("Mouse point is inside the circle");
            else
                text.setText("Mouse point is outside circle");
        });
    }
}
