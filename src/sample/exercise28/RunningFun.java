package sample.exercise28;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunningFun extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        final Fan fan = new Fan(50);
        vBox.getChildren().add(fan);

        Button pause = new Button("Pause");
        pause.setOnAction(e -> fan.pause());
        Button resume = new Button("Resume");
        resume.setOnAction(e -> fan.play());
        Button reverse = new Button("Reverse");
        reverse.setOnAction(e -> fan.reverse());

        HBox hBox = new HBox(pause, resume, reverse);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        vBox.getChildren().add(hBox);


        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 28");
        primaryStage.show();


    }


}

class Fan extends Pane {
    private boolean reverse;
    private final Timeline animation = new Timeline(new KeyFrame(Duration.millis(200), e -> rotate()));

    public Fan(double radius) {

        for (int i = 0; i < 6; i++) {
            Arc arc = new Arc(0, 0, radius, radius, 30 * (2 * i + 1), 30);
            arc.centerXProperty().bind(widthProperty().divide(2));
            arc.centerYProperty().bind(heightProperty().divide(2));
            if (i % 2 == 0)
                arc.setFill(Color.ORANGE);
            arc.setType(ArcType.ROUND);
            getChildren().add(arc);
        }

        Circle circle = new Circle(0, 0, radius);
        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(heightProperty().divide(2));
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }

    private void rotate() {
        if (reverse)
            setRotate(getRotate() - 10);
        else
            setRotate(getRotate() + 10);
    }

    public void play() {
        animation.play();
    }

    public void stop() {
        animation.stop();
    }

    public void pause() {
        animation.pause();
    }

    public void reverse() {
        reverse = !reverse;
    }
}
