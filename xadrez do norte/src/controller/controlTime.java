package controller;

import java.lang.Runnable;

import javax.swing.JOptionPane;

import model.board;
import view.jBoard;

public class controlTime implements Runnable{

    private jBoard jBoard;

    public static int timepassed = 0;

    public controlTime(jBoard jBoard) {
        super();
        this.jBoard = jBoard;

    }

    @Override
    public void run() {
        while (true) {
            
            try {
                Thread.sleep(1000);
                timepassed += 1000;
                if(timepassed >= board.TIME_PLAY) {
                    JOptionPane.showMessageDialog(null,"O jogador "+jBoard.getBoard().getTurn()+ " Perdeu a vez");
                    jBoard.getBoard().switchTurn();
                    timepassed = 0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
