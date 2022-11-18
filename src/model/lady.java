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
        return true;
    }
    
}
