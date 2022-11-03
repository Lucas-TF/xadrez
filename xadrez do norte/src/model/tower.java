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
        return true;
    }
    
}
