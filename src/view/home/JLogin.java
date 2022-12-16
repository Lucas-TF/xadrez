package view.home;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.connectToDatabase.Quest;


public class JLogin extends JFrame implements MouseListener{
    
    private JLabel lblNick,lblPassword;
    private JTextField txtNick;
    private JPasswordField psPassword;
    private JButton btnEnter;
    private final JLabel lblCadastro;

    /**
     * Construtor tela Login
     */
    public JLogin() {
        JLabel lblMessage = new JLabel("Login");
        lblMessage.setBounds(10, 5, 100, 30);
        lblMessage.setFont(new Font("arial", Font.BOLD , 25));
        lblNick = new JLabel("Nome:");
        lblNick.setBounds(45, 30, 40, 30);
        txtNick = new JTextField();
        txtNick.setBounds(85,30,120,30);
        lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(45,70,40, 30);
        psPassword = new JPasswordField();
        psPassword.setBounds(85,70,120,30);
        btnEnter = new JButton("Entrar");
        btnEnter.setBounds(100, 110, 80, 25);
        lblCadastro = new JLabel("Não tem uma conta? Cadastre-se agora.");
        lblCadastro.setBounds(30,130,250,30);
        lblCadastro.addMouseListener(this);

        add(lblMessage);
        add(lblNick);
        add(txtNick);
        add(lblPassword);
        add(psPassword);
        add(btnEnter);
        add(lblCadastro);
        
        this.setTitle("HOME");
        this.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnEnter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(txtNick.getText().equals("")) | !(String.valueOf(psPassword.getPassword()).equals(""))) { 
                    if(!(Quest.Count("Select id from tbusuarios where nome='"+txtNick.getText()+"' and senha='"+String.valueOf(psPassword.getPassword())+"'").equals("0"))){  
                        new JRooms();    
                        dispose();   
                    } else{
                        JOptionPane.showMessageDialog(null,"Usuario ou Senha Incorreta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Preencha todos os campos");
                }
                
            }
        });   
    }     

    
    @Override
    public void mouseClicked(MouseEvent e) {
        new JRegister(); 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        lblCadastro.setForeground(Color.BLUE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        lblCadastro.setForeground(Color.BLACK);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)) ;
    }
}