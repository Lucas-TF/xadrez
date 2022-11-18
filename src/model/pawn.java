package model;

//create by @Lucastavaresfds
public class pawn extends piece {

    private numberColor color;

    public pawn(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"PAWN.png");
        this.color = color;
    }

    public pawn(numberColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) {
        piece pieceInsite = getBoard().getPiece(destinationLine, destinationColumn);
        int newsite = 0;
        if(color == numberColor.WHITE) {
            newsite = getLine()+1;
        }else{
            newsite = getLine()-1;
        }
        if(pieceInsite == null && destinationColumn != getColumn() || destinationLine != newsite) {
            return false;
        }
        return true;
    }
}
