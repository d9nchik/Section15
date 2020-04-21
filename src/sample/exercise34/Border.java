package sample.exercise34;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Border extends Pane {
    private final int borderSize = 16;
    private final int amountOfBorders = 16;

    public Border() {
        for (int i = 0; i < amountOfBorders; i++) {
            for (int j = 0; j < amountOfBorders; j++) {
                Rectangle rectangle = new Rectangle(i * borderSize, j * borderSize, borderSize, borderSize);
                rectangle.setFill(null);
                rectangle.setStroke(Color.LIGHTGRAY);
                getChildren().add(rectangle);
            }
        }
    }

    public int getBorderSize() {
        return borderSize;
    }

    public int getAmountOfBorders() {
        return amountOfBorders;
    }
}
