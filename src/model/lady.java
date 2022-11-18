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
        return true;
    }
}
