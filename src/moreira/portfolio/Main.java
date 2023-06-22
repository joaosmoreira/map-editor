package moreira.portfolio;

import moreira.portfolio.graphics.Brush;
import moreira.portfolio.graphics.Grid;

public class Main {

    public static void main(String[] args) {
        Grid g = new Grid(20, 20);
        Brush brush = new Brush(0, 0, g);
        Moves dude = new Moves(brush, g);
        KeyboardManager.initKeyEvents(dude);
    }

}
