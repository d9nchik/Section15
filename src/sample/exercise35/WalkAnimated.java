package sample.exercise35;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import sample.exercise34.Border;
import sample.exercise34.Walk;

public class WalkAnimated extends Walk {
    private boolean isAnimated;
    private Timeline animation;

    public WalkAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
        redraw();
    }

    public WalkAnimated() {
        this(false);
    }

    @Override
    public void redraw() {
        if (!isAnimated)
            super.redraw();
        else {
            isEnd = false;
            getChildren().clear();
            path.getPoints().clear();
            Border border = new Border();
            borderSize = border.getBorderSize();
            amountOfBorders = border.getAmountOfBorders();
            getChildren().addAll(border, path);
            y = x = amountOfBorders / 2 * borderSize;
            animation = new Timeline(new KeyFrame(Duration.millis(500), e -> {
                super.drawFragment();
                if (isEnd)
                    animation.stop();
            }));
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
        }
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public Timeline getAnimation() {
        return animation;
    }

    public void setAnimation(Timeline animation) {
        this.animation = animation;
    }
}
