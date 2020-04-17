package sample.exercise17;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoundingRectangle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle plane = new Rectangle(0, 0, 155, 120);
        plane.setFill(Color.WHITE);
        plane.setStroke(Color.BLACK);

        Pane bubblePane = new Pane(plane);
        VBox vBox = new VBox(new Text("INSTRUCTION\nAdd: Left Click\nRemove: Right Click"));
        vBox.setStyle("-fx-border-color: black");
        HBox pane = new HBox(vBox, bubblePane);
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setSpacing(10);

        Scene scene = new Scene(pane, 300, 160);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 17");
        primaryStage.show();

        bubblePane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY && e.getX() < 150 && e.getX() > 5 && e.getY() < 115 && e.getY() > 5) {
                final int RADIUS = 4;
                final Circle circle = new Circle(e.getX(), e.getY(), RADIUS);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
                bubblePane.getChildren().add(circle);
            } else if (e.getButton() == MouseButton.SECONDARY) {
                Point2D point2D = new Point2D(e.getX(), e.getY());
                bubblePane.getChildren().removeIf(node -> node instanceof Circle && node.contains(point2D));
            }
        });
    }
}
