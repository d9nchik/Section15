package sample.exercise23;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StopSign extends Application {
    private final StackPane pane = new StackPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        pane.setPadding(new Insets(11, 11, 11, 11));

        Scene scene = new Scene(pane, 140, 140);
        resize();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 23");
        primaryStage.show();

        pane.widthProperty().addListener(ov -> resize());
        pane.heightProperty().addListener(ov -> resize());
    }

    private void resize() {
        pane.getChildren().clear();
        final double RADIUS = Math.min(pane.getWidth(), pane.getHeight()) / 2;
        Polygon polygon = new Polygon();
        for (int i = 0; i < 8; i++) {
            polygon.getPoints().add(RADIUS * (Math.cos(Math.PI * (1 / 8.0 + i / 4.0))));
            polygon.getPoints().add(RADIUS * (Math.sin(Math.PI * (1 / 8.0 + i / 4.0))));
        }
        polygon.setFill(Color.RED);
        Text text = new Text("STOP");
        text.setFont(Font.font("Times New Roman", RADIUS * 3 / 7));
        text.setFill(Color.WHITE);
        pane.getChildren().addAll(polygon, text);
    }
}
