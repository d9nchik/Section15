package sample.exercise13;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IsMouseInsideRectangle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle(30, 35, 100, 30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        Text text = new Text();

        Pane pane = new Pane(rectangle, text);

        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 13");
        primaryStage.show();

        scene.setOnMouseMoved(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            if (rectangle.contains(new Point2D(e.getX(), e.getY())))
                text.setText("Mouse point is inside the rectangle");
            else
                text.setText("Mouse point is outside rectangle");
        });
    }
}
