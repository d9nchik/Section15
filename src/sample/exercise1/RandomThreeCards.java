package sample.exercise1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class RandomThreeCards extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox stackPane = new VBox();

        HBox pane = new HBox();

        Button button = new Button("Refresh");
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().addAll(pane, button);

        getFourCards(pane);

        button.setOnAction(e->getFourCards(pane));

        Scene scene = new Scene(stackPane);
        primaryStage.setTitle("Exercise 1"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }

    private void getFourCards(HBox pane) {
        pane.getChildren().clear();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= 54; i++)
            arrayList.add(i);
        Collections.shuffle(arrayList);

        for (int i = 0; i < 4; i++)
            pane.getChildren().add(new ImageView("src/image/card/" + arrayList.get(i) + ".png"));
    }
}
