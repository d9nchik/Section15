package sample.exercise2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class EllipseRotater extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(30);

        Ellipse ellipse = new Ellipse(pane.getLayoutX() / 2, pane.getLayoutY() / 2, 20, 40);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);


        Button button = new Button("Rotate");
        button.setOnAction(e -> ellipse.setRotate(ellipse.getRotate() + 10));

        pane.getChildren().addAll(ellipse, button);

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
