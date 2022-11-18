package model;

//create by @Lucastavaresfds
public class horse extends piece{

    public horse(numberColor color, int line, int column) {
        super(color, line, column, "src/img/"+color+"HORSE.png");
    }
    public horse(numberColor color, int line, int column, String image) {
        super(color, line, column, image);
    }
    @Override
    public boolean analyzeMovement(int destinationLine, int destinationColumn) {
        return true;
    }
}
