package sample.exercise5;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FinalVelocity extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10, 10, 10, 10));


        pane.add(new Label("Velocity: "), 0, 0);
        TextField velocity = new TextField();
        pane.add(velocity, 1, 0);
        pane.add(new Label("Acceleration: "), 0, 1);
        TextField acceleration = new TextField();
        pane.add(acceleration, 1, 1);
        pane.add(new Label("Time: "), 0, 2);
        TextField time = new TextField();
        pane.add(time, 1, 2);
        pane.add(new Label("Final Velocity: "), 0, 3);
        TextField result = new TextField();
        result.setEditable(false);
        pane.add(result, 1, 3);
        Button calculate = new Button("Calculate");
        pane.add(calculate, 1, 4);
        GridPane.setHalignment(calculate, HPos.RIGHT);

        calculate.setOnAction(e -> result.setText((Double.parseDouble(velocity.getText()) +
                Double.parseDouble(acceleration.getText()) * Double.parseDouble(time.getText())) + ""));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 5");
        primaryStage.show();
    }
}
