package sample.exercise7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DiscoCircle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Circle circle = new Circle();
        circle.setRadius(50);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setFill(Color.BLUE);
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 150, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 7");
        primaryStage.show();

        scene.setOnMousePressed(e -> circle.setFill(Color.RED));
        scene.setOnMouseReleased(e -> circle.setFill(Color.BLUE));
    }
}
