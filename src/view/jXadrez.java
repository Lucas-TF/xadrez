package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import controller.controlTime;
import model.board;
import model.numberColor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

// Create by @Lucastavaresfds
public class jXadrez extends JFrame {
    
    private static JLabel lbturn;

    public board board;

    private JButton resetGame,passTurn;
    private final controlTime controlTime;
    private final jBoard jBoard;
    public static final JPanel jCemetery = new JPanel();
    public JProgressBar progressBar;

    public jXadrez() {
        setTitle("Xadrez classico");
        this.setLayout(new BorderLayout());
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(180000);
        this.controlTime = new controlTime(progressBar);
        this.board = new board(controlTime);
        this.jBoard = new jBoard(board);
        controlTime.setJBoard(jBoard);
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

        resetGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        //jCemetery.setLayout(new FlowLayout());
        this.add(jCemetery,BorderLayout.EAST);

        this.add(jpright, BorderLayout.WEST);
        this.add(progressBar, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Thread threadTime = new Thread(controlTime);
        threadTime.start();

        this.pack();
        this.setVisible(true);
    }
    private void resetGame() {
        controlTime.resetTime();
        this.board = new board(controlTime);
        this.jBoard.setBoard(this.board);
        this.jBoard.drawBoard();
    }
    public static void setTurn(numberColor colorturn) {
        lbturn.setText("VEZ DE:"+colorturn);
    }

    public static void main(String args[]){
        new jXadrez();
    }
}
