package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.controlTime;
import model.board;
import model.numberColor;

import java.awt.BorderLayout;
import java.awt.GridLayout;

// Create by @Lucastavaresfds
public class jXadrez extends JFrame {
    
    private static JLabel lbturn;

    private board board;

    private JButton resetGame,passTurn;

    public jXadrez() {
        setTitle("Xadrez classico");
        this.setLayout(new BorderLayout());
        this.board = new board();
        jBoard jBoard = new jBoard(board);
        this.add(jBoard,BorderLayout.CENTER);
        
        
        JPanel pntop = new JPanel();
        lbturn = new JLabel("VEZ DE BRANCO");
        pntop.add(lbturn);
        this.add(pntop, BorderLayout.NORTH);

        JPanel jpright = new JPanel();
        jpright.setLayout(new GridLayout(10,1));
        resetGame = new JButton("Reiniciar jogo");
        passTurn = new JButton("Passar a vez");
        jpright.add(resetGame);
        jpright.add(passTurn);

        this.add(jpright, BorderLayout.WEST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controlTime controlTime = new controlTime(jBoard);
        Thread threadTime = new Thread(controlTime);
        threadTime.start();

        this.pack();
        this.setVisible(true);
    }

    public static void setTurn(numberColor colorturn) {
        String a = "VEZ DE:"+colorturn;
        lbturn.setText(a);
    }

    public static void main(String args[]){
        new jXadrez();
    }
}
