package controller;

import java.awt.Color;
import java.lang.Runnable;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import model.board;
import view.jBoard;

public class controlTime implements Runnable{

    private jBoard jBoard;

    public int timepassed = 0;

    private JProgressBar progressBar;

    public controlTime(JProgressBar progressBar) {
        super();
        this.progressBar = progressBar;
    }
    
    public void resetTime() {
        timepassed = 0;
    }
    public void setJBoard(jBoard jBoard) {
        this.jBoard = jBoard;
    }

    @Override
    public void run() {
        while (true) {
            
            try {
                Thread.sleep(1);
                timepassed += 1;
                progressBar.setValue(timepassed);
                if(timepassed > 100000 && timepassed < 150000) {
                    progressBar.setForeground(Color.YELLOW);
                } else if(timepassed > 150000) {
                    progressBar.setForeground(Color.RED);
                }else {
                    progressBar.setForeground(Color.GREEN);
                }
                if(timepassed >= board.TIME_PLAY) {
                    JOptionPane.showMessageDialog(null,"O jogador "+jBoard.getBoard().getTurn()+ " Perdeu a vez");
                    if(jBoard.getBoard().getSelectPiece() != null) {
                        jBoard.getBoard().getSelectPiece().setSelect(false);
                        jBoard.getBoard().setPieceSelect(null);
                    }
                    jBoard.getBoard().switchTurn();
                    jBoard.drawBoard();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
