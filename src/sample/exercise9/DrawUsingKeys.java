package sample.exercise9;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class DrawUsingKeys extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Polyline line = new Polyline();
        ObservableList<Double> list = line.getPoints();
        list.addAll(100.0, 100.0);
        pane.getChildren().add(line);

        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("Exercise 9");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e -> {
            final int movement = 5;
            double y = list.get(list.size() - 1);
            double x = list.get(list.size() - 2);
            switch (e.getCode()) {
                case UP:
                    list.addAll(x, y - movement);
                    break;
                case DOWN:
                    list.addAll(x, y + movement);
                    break;
                case LEFT:
                    list.addAll(x - movement, y);
                    break;
                case RIGHT:
                    list.addAll(x + movement, y);
            }
        });
    }
}
