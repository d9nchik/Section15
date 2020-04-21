package sample.exercise35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelfAvoidingWalkAnimated extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final WalkAnimated parent = new WalkAnimated(true);

        Button start = new Button("Start");
        VBox pane = new VBox(parent, start);
        pane.setSpacing(5);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise 34");
        primaryStage.setScene(scene);
        primaryStage.show();

        start.setOnAction(e -> parent.redraw());
    }
}
