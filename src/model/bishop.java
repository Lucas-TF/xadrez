package model;

//create by @Lucastavaresfds
public class bishop extends piece {

    public bishop(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"BISHOP.png");
    }
    public bishop(numberColor color, int line, int column, String image) {
        super(color, line, column, image);
    }
    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) {
        return true;
    }
    
}