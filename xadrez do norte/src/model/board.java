package model;

import controller.controlTime;
import view.jXadrez;

//create by @Lucastavaresfds
public class board {
   
    private piece[][] pieces;
    private piece pieceSelect =  null;
    private numberColor turn = numberColor.WHITE;

    public static final int TIME_PLAY = 10000;

    public board() {
        this.pieces = new piece[8][8];
        tower whiteTower1 = new tower(numberColor.WHITE, 0, 0);
        tower whiteTower2 = new tower(numberColor.WHITE, 0, 7);
        horse whiteHorse1 = new horse(numberColor.WHITE, 0, 1);
        horse whiteHorse2 = new horse(numberColor.WHITE, 0, 6);
        bishop whiteBishop1 = new bishop(numberColor.WHITE, 0, 2);
        bishop whiteBishop2 = new bishop(numberColor.WHITE, 0, 5);
        lady whiteLady = new lady(numberColor.WHITE, 0, 3);
        king whiteKing = new king(numberColor.WHITE, 0, 4);
        for (int i = 0; i<8; i++) {
            pawn whitePawn = new pawn(numberColor.WHITE, 1, i);
            this.addPiece(whitePawn);
        }
        this.addPiece(whiteTower1);
        this.addPiece(whiteTower2);
        this.addPiece(whiteHorse1);
        this.addPiece(whiteHorse2);
        this.addPiece(whiteBishop1);
        this.addPiece(whiteBishop2);
        this.addPiece(whiteLady);
        this.addPiece(whiteKing);    

        tower blackTower1 = new tower(numberColor.BLACK, 7, 0);
        tower blackTower2 = new tower(numberColor.BLACK, 7, 7);
        horse blackHorse1 = new horse(numberColor.BLACK, 7, 1);
        horse blackHorse2 = new horse(numberColor.BLACK, 7, 6);
        bishop blackBishop1 = new bishop(numberColor.BLACK, 7, 2);
        bishop blackBishop2 = new bishop(numberColor.BLACK, 7, 5);
        lady blackLady = new lady(numberColor.BLACK, 7, 3);
        king blackKing = new king(numberColor.BLACK, 7, 4);
        for (int i = 0; i<8; i++) {
            pawn whitePawn = new pawn(numberColor.BLACK, 6, i);
            this.addPiece(whitePawn);
        }
        this.addPiece(blackTower1);
        this.addPiece(blackTower2);
        this.addPiece(blackHorse1);
        this.addPiece(blackHorse2);
        this.addPiece(blackBishop1);
        this.addPiece(blackBishop2);
        this.addPiece(blackLady);
        this.addPiece(blackKing);
    }


    public numberColor getTurn() {
        return this.turn;
    }

    public piece getPiece(int line,int column) {
        return this.pieces[line][column];
    }

    public void setPiece(piece piece) {
        this.pieces[piece.getLine()][piece.getColumn()] =  piece;
        piece.setBoard(this);
    }

    public void addPiece(piece piece) {
        this.pieces[piece.getLine()][piece.getColumn()] = piece;
        piece.setBoard(this);
    }

    public void selectPiece(piece piece) {
        if(piece.isSelect()) {
            piece.setSelect(false);
            this.pieceSelect = null;
        } else {
            piece.setSelect(true);
            this.pieceSelect =  piece;
        }
    }

    public void movPiece(piece piece, int newLine, int newColumn) {
        if(piece.analyzeMovement(newLine,newColumn)) {
            this.pieces[piece.getLine()][piece.getColumn()] = null;
            piece.setLine(newLine);
            piece.setColumn(newColumn);
            this.setPiece(piece);
            this.selectPiece(piece);
            this.switchTurn();
        }
    }

    public void switchTurn() {
        if(this.turn.equals(numberColor.WHITE)) {
            this.turn = numberColor.BLACK;
        } else {
            this.turn = numberColor.WHITE;
        }
        jXadrez.setTurn(turn);
        controlTime.timepassed = 0;
    }

    public void makesMove(int line, int column) {
        
        piece piece = this.getPiece(line, column);

        if(this.pieceSelect ==  null) {
            if(piece != null && piece.getColor().equals(this.turn)) {
                this.selectPiece(piece);
            } 
        } else {
            if(pieceSelect == piece) {
                this.selectPiece(piece);
            } else {
                if(piece == null || !piece.getColor().equals(this.pieceSelect.getColor())) {
                    this.movPiece(this.pieceSelect, line, column);
                }
            }
        }
    }
}
