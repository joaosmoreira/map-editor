package moreira.portfolio.graphics;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Brush {
    private Rectangle representation;
    private Grid grid;
    private boolean painting;
    private int row;
    private int col;

    public Brush(int col, int row, Grid grid) {
        representation = new Rectangle(Grid.colToX(col), Grid.rowToY(row), Grid.CELL_SIZE, Grid.CELL_SIZE);
        representation.setColor(Color.GREEN);
        representation.fill();
        this.grid = grid;
        this.row = row;
        this.col = col;
        painting = false;
    }

    public void moveUp (){
        if(row == 0){
            return;
        }
        row--;
        representation.translate(0, -Grid.CELL_SIZE);
    }


    public void moveDown (){
        if(row == grid.getRows() - 1){
            return;
        }
        row++;
        representation.translate(0, Grid.CELL_SIZE);
    }


    public void moveRight (){
        if(col == grid.getCols() - 1){
            return;
        }
        col++;
        representation.translate(Grid.CELL_SIZE, 0);
    }


    public void moveLeft (){
        if(col == 0){
            return;
        }
        --col;
        representation.translate(-Grid.CELL_SIZE, 0);
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    /* Painting*/
    public boolean isPainting() {
        return painting;
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }
}
