package view.xadrez;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;

// Create by @Lucastavaresfds
public class jCell extends JPanel {
    
    public int getLine() {
        return this.line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    private jPiece jPiece;
    private int line, column;

    public jCell(int line, int column) {
        this.line =  line;
        this.column =  column;
    }

    public jCell(jPiece jPiece) {
        this.jPiece = jPiece;
        this.line = jPiece.getPiece().getLine();
        this.column =  jPiece.getPiece().getColumn();
        this.add(jPiece);
        if(this.jPiece.getPiece() != null && jPiece.getPiece().isSelect()) {
            this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        } 
    }
}