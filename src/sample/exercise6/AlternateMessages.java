package sample.exercise6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlternateMessages extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Text[] text = new Text[2];
        Font font = new Font(14);
        text[0] = new Text("Welcome to java");
        text[1] = new Text("LearningJavaFX");
        text[0].setFont(font);
        text[1].setFont(font);
        pane.getChildren().add(text[0]);


        Scene scene = new Scene(pane, 100, 100);
        scene.setOnMouseClicked(e -> {
            final boolean contains = pane.getChildren().contains(text[0]);
            pane.getChildren().clear();
            if (contains) {
                pane.getChildren().add(text[1]);
            } else {
                pane.getChildren().add(text[0]);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 6");
        primaryStage.show();
    }

}
