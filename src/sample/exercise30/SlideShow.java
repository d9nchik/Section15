package sample.exercise30;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SlideShow extends Application {

    private int counter = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            pane.getChildren().clear();
            pane.getChildren().add(new ImageView("src/image/card/" + counter + ".png"));
            counter = 1 + counter % 54;
        }));
        timeline.setCycleCount(Animation.INDEFINITE);


        Scene scene = new Scene(pane, 75, 96);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 30");
        primaryStage.show();
        timeline.play();
    }
}
