package TicTacToe.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellstate;
    private Symbol symbol;

    //making of a cell
    public Cell(int i, int j){
        this.row = i;
        tjis.col = j;
        this.cellstate = CellState.EMPTY;
        this.symbol = null;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellstate() {
        return cellstate;
    }

    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
