package moreira.portfolio;

import moreira.portfolio.graphics.Brush;
import moreira.portfolio.graphics.Grid;
import moreira.portfolio.utilities.FileManager;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;



public class Moves implements KeyboardHandler {
    private Brush brush;
    private Grid grid;

    public Moves(Brush brush, Grid grid) {
        this.brush = brush;
        this.grid = grid;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            /* Moves */
            case KeyboardEvent.KEY_UP ->    { brush.moveUp();if (brush.isPainting()) {grid.paintCell(brush.getRow(), brush.getCol());}}
            case KeyboardEvent.KEY_DOWN ->  { brush.moveDown(); if (brush.isPainting()) { grid.paintCell(brush.getRow(), brush.getCol());} }
            case KeyboardEvent.KEY_LEFT ->  { brush.moveLeft(); if (brush.isPainting()) { grid.paintCell(brush.getRow(), brush.getCol());} }
            case KeyboardEvent.KEY_RIGHT -> { brush.moveRight(); if (brush.isPainting()) { grid.paintCell(brush.getRow(), brush.getCol());} }
            /* Paint */
            case KeyboardEvent.KEY_SPACE -> { brush.setPainting(true); grid.paintCell(brush.getRow(), brush.getCol()); }
            /* Quit */
            case KeyboardEvent.KEY_Q -> System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            /* Paint */
            case KeyboardEvent.KEY_SPACE -> brush.setPainting(false);
            /* Save & Load */
            case KeyboardEvent.KEY_S -> FileManager.write(grid.toString());
            case KeyboardEvent.KEY_L -> grid.fromString(FileManager.read());
        }
    }
}

