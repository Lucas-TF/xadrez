package model;

//create by @Lucastavaresfds
public abstract class piece {
    
    
    private numberColor color; 
    private int line, column;
    private String image;
    private boolean eliminated = false;
    private boolean select = false;
    private board board;
    
    public piece(numberColor color, int line, int column, String image){
        this.color = color;
        this.line = line;
        this.column = column;
        this.image = image;
    }

    public abstract boolean analyzeMovement(int destinationLine,int destinationColumn);

    public numberColor getColor() {
        return this.color;
    }
    public void setColor(numberColor color) {
        this.color = color;
    }
    public int getLine() {
        return this.line;
    }
    public void setLine(int line) {
        this.line = line;
    }
    public int getColumn() {
        return this.column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public boolean isEliminated() {
        return this.eliminated;
    }
    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }
    public boolean isSelect() {
        return this.select;
    }
    public void setSelect(boolean select) {
        this.select = select;
    }
    public board getBoard() {
        return this.board;
    }
    public void setBoard(board board) {
        this.board = board;
    }

}
