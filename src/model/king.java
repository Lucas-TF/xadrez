package model;

/**
 * create by @Lucastavaresfds
 * King class xadrez 
 */
public class king extends piece {

    public king(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"KING.png");
        setImaking(true);
    }

    public king(numberColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) {
        if(destinationLine == getLine()+1 && destinationColumn > getColumn()+1 
        || destinationLine > getLine()+1 && destinationColumn == getColumn()+1 
        || destinationLine == getLine()-1 && destinationColumn < getColumn()-1
        || destinationLine < getLine()-1 && destinationColumn == getColumn()-1
        || destinationLine == getLine()+1 && destinationColumn < getColumn()-1
        || destinationLine > getLine()+1 && destinationColumn == getColumn()-1
        || destinationLine == getLine()-1 && destinationColumn > getColumn()+1
        || destinationLine < getLine()-1 && destinationColumn == getColumn()+1
        || destinationLine > getLine()+1 || destinationColumn > getColumn()+1
        || destinationLine < getLine()-1 || destinationColumn < getColumn()-1) {
            return false;   
        }
        return true;
    }
    
}
