package sample.exercise36;

import sample.exercise34.Border;

public class SimpleTest {
    public static void main(String[] args) {
        Border border = new Border();
        for (int i = 10; i <= 80; i += 5) {
            border.setAmountOfBorders(i);
            WalkWithCounter counter = new WalkWithCounter(border);
            for (int j = 1; j < 10_000; j++) {
                counter.redraw();
            }
            System.out.printf("For a lattice of size %d, the probability of dead-end paths is %.1f%%\n", i,
                    counter.getDeadEndPaths() / 100.0);
        }
    }
}
