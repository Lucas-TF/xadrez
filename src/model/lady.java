package model;

//create by @Lucastavaresfds
public class lady extends piece {

    public lady(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"LADY.png");
    }

    public lady(numberColor color, int line, int column, String image) {
        super(color, line, column, image);   
    }

    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) {
        int i = 1;
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
        if(getLine()<destinationLine && destinationColumn == getColumn()){
            while(getLine()+i<destinationLine) {
                piece pieceInsite = getBoard().getPiece(getLine()+i, destinationColumn);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        } else if(getColumn()>destinationColumn && destinationLine == getLine()) {
            while((getColumn()-i)>destinationColumn) {
                piece pieceInsite = getBoard().getPiece(destinationLine, getColumn()-i);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        } else if(getLine()>destinationLine && destinationColumn == getColumn()) {
            while((getLine()-i)>destinationLine) {
                piece pieceInsite = getBoard().getPiece(getLine()-i, destinationColumn);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        } else if(getColumn()<destinationColumn && destinationLine == getLine()) {
            while(i<destinationColumn) {
                piece pieceInsite = getBoard().getPiece(destinationLine, i);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        } else if(destinationLine > getLine() && destinationColumn > getColumn()) {
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
