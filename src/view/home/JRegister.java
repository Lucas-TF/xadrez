package view.home;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.connectToDatabase.registerUser;

public class JRegister extends JFrame{
    
    private JLabel lblNick,lblPassword;
    private JTextField txtNick;
    private JPasswordField psPassword;
    private JButton btnCreate;

    public JRegister(){
        JLabel lblMessage = new JLabel("Cadastro de Usuario");
        lblMessage.setBounds(5, 0, 300, 30);
        lblMessage.setFont(new Font("arial", Font.BOLD , 25));
        lblNick = new JLabel("Nome:");
        lblNick.setBounds(45, 30, 40, 30);
        txtNick = new JTextField();
        txtNick.setBounds(85,30,120,30);
        lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(45,70,40, 30);
        psPassword = new JPasswordField();
        psPassword.setBounds(85,70,120,30);
        btnCreate = new JButton("Cadastrar");
        btnCreate.setBounds(95, 110, 100, 25);

        add(lblMessage);
        add(lblNick);
        add(txtNick);
        add(lblPassword);
        add(psPassword);
        add(btnCreate);

        this.setTitle("HOME");
        this.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(300,200);
        setVisible(true);

        btnCreate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Date a = new Date();
                if(registerUser.CED("Insert Into tbusuarios set nome='"+txtNick.getText()+"', senha='"+psPassword.getText()+"', dtc= now()")){
                    System.out.println("sucesso");
                };
            }
        });
    }
}
