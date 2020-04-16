package sample.exercise11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveCircleUsingKeys extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle();
        circle.setRadius(15);

        Pane pane = new Pane(circle);
        pane.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 11");
        primaryStage.show();
        circle.setCenterX(pane.getWidth() / 2);
        circle.setCenterY(pane.getHeight() / 2);

        scene.setOnKeyPressed(e -> {
            final int MOVEMENT = 5;
            switch (e.getCode()) {
                case UP:
                    circle.setCenterY(circle.getCenterY() - MOVEMENT);
                    break;
                case DOWN:
                    circle.setCenterY(circle.getCenterY() + MOVEMENT);
                    break;
                case LEFT:
                    circle.setCenterX(circle.getCenterX() - MOVEMENT);
                    break;
                case RIGHT:
                    circle.setCenterX(circle.getCenterX() + MOVEMENT);
                    break;
            }
        });
    }
}
