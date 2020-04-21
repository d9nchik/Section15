package sample.exercise32;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();
        ClockPaneAnimation pane = new ClockPaneAnimation();

        Button stop = new Button("Stop");
        Button start = new Button("Start");
        HBox buttons = new HBox(stop, start);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(5);
        vBox.getChildren().addAll(pane, buttons);
        vBox.setSpacing(5);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> pane.setCurrentTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        stop.setOnAction(e -> timeline.stop());
        start.setOnAction(e -> timeline.play());
        timeline.play();

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 32");
        primaryStage.show();
    }
}
