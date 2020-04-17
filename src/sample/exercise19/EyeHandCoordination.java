package sample.exercise19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class EyeHandCoordination extends Application {
    private final Circle circle = new Circle(10);
    private final Pane pane = new Pane(circle);
    private final long time = System.currentTimeMillis();
    private int counter = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(pane, 300, 100);
        generateCircle();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 19");
        primaryStage.show();


        circle.setOnMouseClicked(e -> generateCircle());
    }

    private void generateCircle() {
        Random random = new Random();
        int randomX = random.nextInt((int) (pane.getWidth() - 40)) + 20;
        int randomY = random.nextInt((int) (pane.getHeight() - 40)) + 20;
        Color color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), random.nextDouble());
        circle.setFill(color);
        circle.setCenterX(randomX);
        circle.setCenterY(randomY);
        if (++counter == 20) {
            long timeSpent = System.currentTimeMillis() - time;
            pane.getChildren().clear();
            pane.getChildren().add(new Text(pane.getWidth() / 4, pane.getHeight() / 4,
                    "Time spent is " + timeSpent + " milliseconds"));
        }
    }
}
