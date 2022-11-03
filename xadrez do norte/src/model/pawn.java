package model;

//create by @Lucastavaresfds
public class pawn extends piece {

    private boolean fistmovement = true;

    public pawn(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"PAWN.png");
    }

    public pawn(numberColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) {
        return true;
    }
    
}
