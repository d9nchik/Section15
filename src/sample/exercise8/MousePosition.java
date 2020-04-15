package sample.exercise8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MousePosition extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text();

        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 8");
        primaryStage.show();

        scene.setOnMouseReleased(e -> pane.getChildren().clear());

        scene.setOnMousePressed(e -> showCoordinates(pane, text, e));
    }

    private void showCoordinates(Pane pane, Text text, MouseEvent e) {
        text.setText("(" + e.getX() + ", " + e.getY() + ")");
        text.setX(e.getX());
        text.setY(e.getY());
        if (!pane.getChildren().contains(text))
            pane.getChildren().add(text);
    }
}
