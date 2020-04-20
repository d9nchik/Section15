package sample.exercise29;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RacingCar extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Car car = new Car(100);

        Scene scene = new Scene(car, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 29");
        primaryStage.show();

        scene.setOnMousePressed(e -> car.pause());
        scene.setOnMouseReleased(e -> car.play());
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    car.raiseSpeed();
                    break;
                case DOWN:
                    car.brakeSpeed();
            }
        });
    }
}

class Car extends Pane {
    private final int y;
    private int x = 0;
    private int speed = 1;
    private final Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), e -> redraw()));

    public Car(int y) {
        this.y = y;
        redraw();
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }

    private void redraw() {
        getChildren().clear();
        x += speed;
        if (x >= getWidth())
            x = 0;
        Circle backWheel = new Circle(x + 15, y - 5, 5);
        Circle frontWheel = new Circle(x + 35, y - 5, 5);
        Rectangle body = new Rectangle(x, y - 20, 50, 10);
        body.setFill(Color.SKYBLUE);
        Polygon upOfCar = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
        upOfCar.setFill(Color.BLUE);
        getChildren().addAll(backWheel, frontWheel, body, upOfCar);
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

    public void raiseSpeed() {
        speed += 5;
    }

    public void brakeSpeed() {
        speed -= 5;
        if (speed < 0)
            speed = 0;
    }
}
