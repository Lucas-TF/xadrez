package model;

//create by @Lucastavaresfds
public class tower extends piece {

    public tower(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"TOWER.png");
    }
    public tower(numberColor color, int line, int column, String image) {
        super(color, line, column, image);
       
    }
    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) {
        int i = 1;
        if(getLine()<destinationLine){
            while(i<destinationLine) {
                piece pieceInsite = getBoard().getPiece(i, destinationColumn);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        } else if(getColumn()<destinationColumn) {
            while(i<destinationColumn) {
                piece pieceInsite = getBoard().getPiece(destinationLine, i);
                if(pieceInsite != null) {
                    return false;
                }
                i++;
            }
        } else if(getLine()>destinationLine) {
            i = getLine();
            while(i>destinationLine) {
                piece pieceInsite = getBoard().getPiece(i, destinationColumn);
                if(pieceInsite != null) {
                    return false;
                }
                i--;
            }
        } else if(getColumn()>destinationColumn) {
            i = getColumn();
            while(i>destinationColumn) {
                piece pieceInsite = getBoard().getPiece(destinationLine, i);
                if(pieceInsite != null) {
                    return false;
                }
                i--;
            }
        }
        if(destinationColumn != getColumn() && destinationLine != getLine()) {
            return false;
        }
        return true;
    }
}
