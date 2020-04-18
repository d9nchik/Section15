package sample.exercise21;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class TrianglesAndAnglesOnTheCircle extends Application {
    private static final int BIG_CIRCLE_RADIUS = 50;
    private final Circle circle1 = getCircle();
    private final Circle circle2 = getCircle();
    private final Circle circle3 = getCircle();
    private final Text text1 = getText(circle1);
    private final Text text2 = getText(circle2);
    private final Text text3 = getText(circle3);
    private final Circle bigCircle = new Circle(0, 0, BIG_CIRCLE_RADIUS);

    public static void main(String[] args) {
        launch(args);
    }

    private static Circle getCircle() {
        final int RADIUS = 10;
        double angle = 2 * Math.PI * (new Random().nextDouble());
        return new Circle(BIG_CIRCLE_RADIUS * Math.cos(angle), BIG_CIRCLE_RADIUS * Math.sin(angle), RADIUS);
    }

    private static double getDistance(Circle circle1, Circle circle2) {
        return Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2) +
                Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();

        Line line1 = getBinnedLine(circle1, circle2);
        Line line2 = getBinnedLine(circle2, circle3);
        Line line3 = getBinnedLine(circle3, circle1);

        updateText();


        bigCircle.setFill(null);
        bigCircle.setStroke(Color.BLACK);

        Group triangle = new Group(bigCircle, line1, line2, line3, circle1, circle2, circle3, text1, text2, text3);

        pane.getChildren().addAll(triangle);

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 20");
        primaryStage.show();

        circle1.setOnMouseDragged(e -> draggingOfCircle(circle1, e));
        circle2.setOnMouseDragged(e -> draggingOfCircle(circle2, e));
        circle3.setOnMouseDragged(e -> draggingOfCircle(circle3, e));
    }

    private Text getText(Circle circle) {
        Text text = new Text();
        text.xProperty().bind(circle.centerXProperty().add(10));
        text.yProperty().bind(circle.centerYProperty().add(10));
        return text;
    }

    private Line getBinnedLine(Circle circle1, Circle circle2) {
        Line line = new Line();
        line.startXProperty().bind(circle1.centerXProperty());
        line.startYProperty().bind(circle1.centerYProperty());
        line.endXProperty().bind(circle2.centerXProperty());
        line.endYProperty().bind(circle2.centerYProperty());
        return line;
    }

    private void draggingOfCircle(Circle circle, MouseEvent e) {
        double distance = Math.sqrt(Math.pow(e.getX(), 2) + Math.pow(e.getY(), 2));
        circle.setCenterX(e.getX() / distance * BIG_CIRCLE_RADIUS);
        circle.setCenterY(e.getY() / distance * BIG_CIRCLE_RADIUS);
        updateText();
    }

    private void updateText() {
        double a = getDistance(circle1, circle2);
        double b = getDistance(circle2, circle3);
        double c = getDistance(circle3, circle1);
        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c)
                / (-2 * b * c)));
        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c)
                / (-2 * a * c)));
        double C = 180 - A - B;
        text1.setText("" + ((int) (B * 100)) / 100.0);
        text2.setText("" + ((int) (C * 100)) / 100.0);
        text3.setText("" + ((int) (A * 100) / 100.0));
    }
}
