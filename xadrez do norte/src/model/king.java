package model;

//create by @Lucastavaresfds
public class king extends piece {

    public king(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"KING.png");
    }

    public king(numberColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) {
        return true;
    }
    
}
