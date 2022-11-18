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
        i = 1;
        if(destinationLine > getLine() && destinationColumn > getColumn()) {
            while((getLine()+i) < destinationLine) {
                piece pieceInsite = getBoard().getPiece(getLine()+i, getColumn()+i);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        }else if(destinationLine < getLine() && destinationColumn < getColumn()){
            while((getLine()-i) > destinationLine) {
                piece pieceInsite = getBoard().getPiece(getLine()-i, getColumn()-i);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        }else if(destinationLine < getLine() && destinationColumn > getColumn()){
            while((getLine()-i) > destinationLine) {
                piece pieceInsite = getBoard().getPiece(getLine()-i, getColumn()+i);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        } else if(destinationLine > getLine() && destinationColumn < getColumn()){
            while((getLine()+i) < destinationLine) {
                piece pieceInsite = getBoard().getPiece(getLine()+i, getColumn()-i);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        }  
        return true;
    }   
}