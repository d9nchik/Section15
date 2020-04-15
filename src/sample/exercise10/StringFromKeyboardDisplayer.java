package sample.exercise10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StringFromKeyboardDisplayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text();
        Pane pane = new Pane(text);
        StringBuilder stringBuilder = new StringBuilder();
        text.setX(10);
        text.setY(40);

        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("Exercise 10");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e -> {
            char symbol = (e.getText().length() != 0) ? e.getText().charAt(0) : (char) (0);
            if (symbol >= 'a' && symbol <= 'z')
                if (e.isShiftDown())
                    stringBuilder.append((char) (symbol - 'a' + 'A'));
                else
                    stringBuilder.append(symbol);
            else if (e.getCode() == KeyCode.ENTER) {
                text.setText(stringBuilder.toString());
                stringBuilder.setLength(0);
            } else if ((symbol + "").matches("\\s|\\w"))
                stringBuilder.append(symbol);
        });
    }
}
