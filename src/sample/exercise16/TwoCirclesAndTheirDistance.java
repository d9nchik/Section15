package sample.exercise16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TwoCirclesAndTheirDistance extends Application {
    private final Circle circle1 = getCircle(40, 40);
    private final Circle circle2 = getCircle(120, 150);
    private final Text text = new Text();

    public static void main(String[] args) {
        launch(args);
    }

    private static Circle getCircle(int x, int y) {
        final int RADIUS = 10;
        Circle circle1 = new Circle(x, y, RADIUS);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        return circle1;
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Line line = new Line();
        line.startXProperty().bind(circle1.centerXProperty());
        line.startYProperty().bind(circle1.centerYProperty());
        line.endXProperty().bind(circle2.centerXProperty());
        line.endYProperty().bind(circle2.centerYProperty());

        updateText();
        text.xProperty().bind(circle1.centerXProperty().add(circle2.centerXProperty()).divide(2));
        text.yProperty().bind(circle1.centerYProperty().add(circle2.centerYProperty()).divide(2));

        pane.getChildren().addAll(line, circle1, circle2, text);

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 16");
        primaryStage.show();

        circle1.setOnMouseDragged(e -> draggingOfCircle(circle1, e));
        circle2.setOnMouseDragged(e -> draggingOfCircle(circle2, e));
    }

    private void draggingOfCircle(Circle circle, MouseEvent e) {
        circle.setCenterX(e.getX());
        circle.setCenterY(e.getY());
        updateText();
    }

    private int getDistance() {
        return (int) Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2) +
                Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));
    }

    private void updateText() {
        text.setText("" + getDistance());
    }
}
