package model;

//create by @Lucastavaresfds
public class bishop extends piece {

    private piece pieceInsite;

    public bishop(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"BISHOP.png");
    }
    public bishop(numberColor color, int line, int column, String image) {
        super(color, line, column, image);
    }
    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) { 
        int i = 0;
        while(i<8) {
            if(destinationLine == getLine()+i && destinationColumn > getColumn()+i 
            || destinationLine > getLine()+i && destinationColumn == getColumn()+i 
            || destinationLine == getLine()-i && destinationColumn < getColumn()-i
            || destinationLine < getLine()-i && destinationColumn == getColumn()-i
            || destinationLine == getLine()+i && destinationColumn < getColumn()-i
            || destinationLine > getLine()+i && destinationColumn == getColumn()-i
            || destinationLine == getLine()-i && destinationColumn > getColumn()+i
            || destinationLine < getLine()-i && destinationColumn == getColumn()+i) {
                return false;
            }
            i++;
        } 
        return true;
    }   
}