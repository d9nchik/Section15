package sample.exercise20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TrianglesAndAngles extends Application {
    private final Circle circle1 = getCircle(40, 40);
    private final Circle circle2 = getCircle(120, 150);
    private final Circle circle3 = getCircle(40, 150);

    private final Text text1 = getText(circle1);
    private final Text text2 = getText(circle2);
    private final Text text3 = getText(circle3);

    public static void main(String[] args) {
        launch(args);
    }

    private static Circle getCircle(int x, int y) {
        final int RADIUS = 10;
        return new Circle(x, y, RADIUS);
    }

    private static double getDistance(Circle circle1, Circle circle2) {
        return Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2) +
                Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Line line1 = getBinnedLine(circle1, circle2);
        Line line2 = getBinnedLine(circle2, circle3);
        Line line3 = getBinnedLine(circle3, circle1);

        updateText();

        pane.getChildren().addAll(line1, line2, line3, circle1, circle2, circle3, text1, text2, text3);

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
        circle.setCenterX(e.getX());
        circle.setCenterY(e.getY());
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
