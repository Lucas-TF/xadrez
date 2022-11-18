package view;

import javax.swing.JPanel;
import model.board;
import model.piece;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Create by @Lucastavaresfds
public class jBoard extends JPanel implements MouseListener {
     
    private board board;

    public jBoard(final board board) {
        this.board = board;
        this.drawBoard();
    }

    public void drawBoard() {
        this.removeAll();
        this.setLayout(new GridLayout(11,8));
        for(int i=0; i<11; i++) {
            for(int j=0; j<8; j++) {
                jCell jCell;
                piece piece = this.board.getPiece(i, j);
                if(piece == null) {
                    jCell = new jCell(i, j);
                } else {
                    jCell = new jCell(new jPiece(piece));
                }
                if((i + j) % 2 == 0) {
                    jCell.setBackground(Color.WHITE);
                   
                } else {
                    jCell.setBackground(new Color(0,255,0));
                }
                this.add(jCell);
                jCell.addMouseListener(this);
            } 
        }
        this.revalidate();
    }

    public board getBoard() {
        return this.board;
    }
    public void setBoard(board board) {
        this.board = board;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        jCell jCell = (jCell) e.getSource();
        this.board.makesMove(jCell.getLine(), jCell.getColumn());
        this.drawBoard();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}