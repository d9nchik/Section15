package sample.exercise14;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IsMouseInsidePolygon extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Polygon polygon = new Polygon(30.0, 10.0, 60.0, 30.0, 50.0, 70.0, 35.0, 35.0, 10.0, 50.0);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        Text text = new Text();

        Pane pane = new Pane(polygon, text);

        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 14");
        primaryStage.show();

        scene.setOnMouseMoved(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            if (polygon.contains(new Point2D(e.getX(), e.getY())))
                text.setText("Mouse point is inside the polygon");
            else
                text.setText("Mouse point is outside polygon");
        });
    }
}
