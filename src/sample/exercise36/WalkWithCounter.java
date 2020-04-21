package sample.exercise36;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import sample.exercise34.Border;

import java.util.ArrayList;
import java.util.Collections;

public class WalkWithCounter extends Pane {
    protected final Polyline path = new Polyline();
    protected int borderSize;
    protected int amountOfBorders;
    protected int x;
    protected int y;
    protected boolean isEnd;
    private Border border = new Border();
    private int deadEndPaths = 0;

    public WalkWithCounter() {
        redraw();
    }

    public WalkWithCounter(Border border) {
        this.border = border;
    }

    protected void drawFragment() {
        ArrayList<Point2D> point2DS = getNeighbours();
        if (!isEnd) {
            Point2D myPoint = point2DS.get(0);
            x = (int) myPoint.getX();
            y = (int) myPoint.getY();
            path.getPoints().addAll(myPoint.getX(), myPoint.getY());
        }
    }

    private ArrayList<Point2D> getNeighbours() {
        ArrayList<Point2D> point2DS = new ArrayList<>();
        if (!isEnd && x > 0 && x / borderSize < amountOfBorders && y > 0 && y / borderSize < amountOfBorders) {
            Point2D point2D = new Point2D(x - borderSize, y);
            if (!path.contains(point2D))
                point2DS.add(point2D);
            point2D = new Point2D(x + borderSize, y);
            if (!path.contains(point2D))
                point2DS.add(point2D);
            point2D = new Point2D(x, y + borderSize);
            if (!path.contains(point2D))
                point2DS.add(point2D);
            point2D = new Point2D(x, y - borderSize);
            if (!path.contains(point2D))
                point2DS.add(point2D);
            if (point2DS.size() == 0) {
                isEnd = true;
                deadEndPaths++;
            }
            Collections.shuffle(point2DS);
            return point2DS;
        }
        isEnd = true;
        return point2DS;
    }

    private void drawMultiple() {
        while (!isEnd)
            drawFragment();
    }

    public void redraw() {
        isEnd = false;
        getChildren().clear();
        path.getPoints().clear();

        borderSize = border.getBorderSize();
        amountOfBorders = border.getAmountOfBorders();
        getChildren().addAll(border, path);
        y = x = amountOfBorders / 2 * borderSize;
        drawMultiple();
    }

    public int getDeadEndPaths() {
        return deadEndPaths;
    }
}
