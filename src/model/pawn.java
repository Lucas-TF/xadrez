package model;

//create by @Lucastavaresfds
public class pawn extends piece {

    private boolean fistmovement = true;

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
        int newSite = 0;
        if(color == numberColor.WHITE) {
            if(fistmovement){
                newsite = getLine()+2;
                newSite = getLine()+1;
            }else{
                newsite = getLine()+1;
                newSite = getLine()+2;
            }
        }else{
            if(fistmovement) {
                newsite = getLine()-2;
                newSite = getLine()-1;
            }else {
                newsite = getLine()-1;
                newSite = getLine()-2;
            }
        }
        if(pieceInsite == null && destinationColumn != getColumn() || destinationLine != newsite && destinationLine != newSite) {
            return false;
        }
        return true;
    }

    public void setFistmovement(boolean fistmovement) {
        this.fistmovement = fistmovement;
    }
    
}
