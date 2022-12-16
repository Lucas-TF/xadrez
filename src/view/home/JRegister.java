package view.home;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.connectToDatabase.Quest;

/**
 * Tela de Cadastro de Usuário
 */
public class JRegister extends JFrame{
    
    private JLabel lblNick,lblPassword,lblcomfirm;
    private JTextField txtNick;
    private JPasswordField psPassword,comfirm;
    private JButton btnCreate;

    /**
     * Construtor da tela de Cadastro de Usuário
     */
    public JRegister(){
        JLabel lblMessage = new JLabel("Cadastro de Usuario");
        lblMessage.setBounds(45, 0, 300, 30);
        lblMessage.setFont(new Font("arial", Font.BOLD , 25));
        lblNick = new JLabel("Nome:");
        lblNick.setBounds(75, 30, 40, 30);
        txtNick = new JTextField();
        txtNick.setBounds(115,30,120,30);
        lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(75,65,40, 30);
        psPassword = new JPasswordField();
        psPassword.setBounds(115,65,120,30);
        lblcomfirm = new JLabel("Comfirma Senha:");
        lblcomfirm.setBounds(17,100,120,30);
        comfirm = new JPasswordField();
        comfirm.setBounds(115,100,120,30);
        btnCreate = new JButton("Cadastrar");
        btnCreate.setBounds(125, 130, 100, 25);

        add(lblMessage);
        add(lblNick);
        add(txtNick);
        add(lblPassword);
        add(psPassword);
        add(lblcomfirm);
        add(comfirm);
        add(btnCreate);

        this.setTitle("HOME");
        this.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(350,200);
        setVisible(true);

        btnCreate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
    }
    public void save(){
        if(!(txtNick.getText().isEmpty() || String.valueOf(psPassword.getPassword()).isEmpty() || String.valueOf(comfirm.getPassword()).isEmpty())) { 
            if(Quest.Count("Select id from tbusuarios where nome='"+txtNick.getText()+"'").equals("0")){  
                if(Quest.CED("Insert Into tbusuarios set nome='"+txtNick.getText()+"', senha='"+String.valueOf(psPassword.getPassword())+"', dtc= now()")){
                    JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
                    dispose();
                };
            } else{
                JOptionPane.showMessageDialog(null,"Nome ja cadastrado");
                txtNick.setText("");
                psPassword.setText("");
                comfirm.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Preencha todos os campos ou Verifique sua senha");
            psPassword.setText("");
            comfirm.setText("");
        }
    }
}



