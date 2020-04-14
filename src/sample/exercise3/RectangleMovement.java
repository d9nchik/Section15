package sample.exercise3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleMovement extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();

        Rectangle rectangle = new Rectangle(75, 75, 20, 20);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        Pane e1 = new Pane(rectangle);
        e1.setPrefHeight(170);
        pane.getChildren().add(e1);

        HBox buttons = new HBox();
        Button left = new Button("Left");
        left.setOnAction(e -> rectangle.setX(rectangle.getX() - 10));
        Button right = new Button("Right");
        right.setOnAction(e -> rectangle.setX(rectangle.getX() + 10));
        Button up = new Button("Up");
        up.setOnAction(e -> rectangle.setY(rectangle.getY() - 10));
        Button down = new Button("Down");
        down.setOnAction(e -> rectangle.setY(rectangle.getY() + 10));
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(2);
        buttons.getChildren().addAll(left, right, up, down);
        pane.getChildren().add(buttons);

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 3");
        primaryStage.show();
    }
}
