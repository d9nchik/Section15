package sample.exercise4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static void calculate(TextField firstNumber, TextField secondNumber, TextField result, char operation) {
        switch (operation) {
            case '+':
                result.setText((Double.parseDouble(firstNumber.getText()) + Double.parseDouble(secondNumber.getText()) + ""));
                break;
            case '-':
                result.setText((Double.parseDouble(firstNumber.getText()) - Double.parseDouble(secondNumber.getText()) + ""));
                break;
            case '*':
                result.setText((Double.parseDouble(firstNumber.getText()) * Double.parseDouble(secondNumber.getText()) + ""));
                break;
            case '/':
                result.setText((Double.parseDouble(firstNumber.getText()) / Double.parseDouble(secondNumber.getText()) + ""));
                break;
            default:
                result.setText("");
        }
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        HBox legend = new HBox();
        TextField firstNumber = new TextField();
        final int prefColumnCount = 3;
        firstNumber.setPrefColumnCount(prefColumnCount);
        TextField secondNumber = new TextField();
        secondNumber.setPrefColumnCount(prefColumnCount);
        TextField result = new TextField();
        result.setEditable(false);
        result.setPrefColumnCount(prefColumnCount);
        legend.getChildren().addAll(new Text("Number 1: "), firstNumber, new Text("Number 2: "), secondNumber,
                new Text("Result: "), result);
        vbox.getChildren().add(legend);

        HBox buttons = new HBox();
        Button add = new Button("Add");
        add.setOnAction(e -> calculate(firstNumber, secondNumber, result, '+'));
        Button subtract = new Button("Subtract");
        subtract.setOnAction(e -> calculate(firstNumber, secondNumber, result, '-'));
        Button multiply = new Button("Multiply");
        multiply.setOnAction(e -> calculate(firstNumber, secondNumber, result, '*'));
        Button divide = new Button("Divide");
        divide.setOnAction(e -> calculate(firstNumber, secondNumber, result, '/'));
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(add, subtract, multiply, divide);
        vbox.getChildren().addAll(buttons);

        Scene scene = new Scene(vbox);
        primaryStage.setTitle("Exercise 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
