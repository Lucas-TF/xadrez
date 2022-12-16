package view.home;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TrayIcon.MessageType;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
/**
 * Classe da criação de salas.
 */
public class JCreateRoom extends JFrame{

    private JLabel lbTitle, lbNameRoom, lbPasswordRoom;
    private JTextField txtNameRoom; 
    private JPasswordField txtPasswordRoom;
    private JButton btnCreate, btnCancel;

    /**
     * Construtor que cria a tela.
     */
    public JCreateRoom(){
        Box vBox_Principal = new Box(BoxLayout.Y_AXIS);
        
        Box hBox_Title = new Box(BoxLayout.X_AXIS);
        Box hBox_Name = new Box(BoxLayout.X_AXIS);
        Box hBox_Password = new Box(BoxLayout.X_AXIS);
        Box hBox_Buttons = new Box(BoxLayout.X_AXIS);

        lbTitle = new JLabel("Criar Sala");
        lbTitle.setFont(new Font("arial", Font.BOLD , 25));
        hBox_Title.add(lbTitle);
        

        lbNameRoom = new JLabel("Nome da Sala:");
        lbNameRoom.setPreferredSize(new Dimension(100,30));
        txtNameRoom = new JTextField();
        // hBox_Name.setBounds(85,30,120,30);
        formatName(txtNameRoom); //Formatação de texto digitado.
        hBox_Name.add(lbNameRoom);
        hBox_Name.add(txtNameRoom);
       

        lbPasswordRoom = new JLabel("Senha da Sala:");
        // lbPasswordRoom.setBounds(45,70,60, 30);
        lbPasswordRoom.setPreferredSize(new Dimension(100,30));
        txtPasswordRoom = new JPasswordField();
        // txtPasswordRoom.setBounds(85, 70, 120, 30);
        hBox_Password.add(lbPasswordRoom);
        hBox_Password.add(txtPasswordRoom);

        btnCreate = new JButton("Criar");
        btnCancel = new JButton("Cancelar");
        hBox_Buttons.add(btnCreate);
        hBox_Buttons.add(btnCancel);
        Keys(); // Ações dos botões

        
        hBox_Name.setMaximumSize(new Dimension( 300, 40));
        hBox_Name.setBorder(new EmptyBorder(0,0,10,0));
        hBox_Password.setMaximumSize(new Dimension( 300, 40));
        hBox_Password.setBorder(new EmptyBorder(0,0,10,0));
        hBox_Buttons.setAlignmentX(CENTER_ALIGNMENT);

        vBox_Principal.add(hBox_Title);
        vBox_Principal.add(hBox_Name);
        vBox_Principal.add(hBox_Password);
        vBox_Principal.add(hBox_Buttons);
        vBox_Principal.setBorder(new EmptyBorder(10,10,10,10));
    
        add(vBox_Principal);


        this.setTitle("Criar Sala");
        setResizable(false);
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Método para ações, principalmente dos botões.
     */
    private void Keys(){
        btnCancel.addActionListener(action->{
            dispose();
        });

        btnCreate.addActionListener(action->{
            createRoom();
        });
    }


    /**
     * Método para criar a sala.
     */
    private void createRoom(){
        StringBuffer nameRoom = new StringBuffer(txtNameRoom.getText());
        StringBuffer passwordRoom = new StringBuffer(String.valueOf(txtPasswordRoom.getPassword()));
        if(nameRoom == null || nameRoom.isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o nome da sala!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }else{
            //TO DO: Salvar os valores da sala no banco de dados e ir para a tela de xadrez em seguida.
        }
    }

    /**
     * Método para formatar o campo name.
     */
    private void formatName(JTextField tf){
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
            //     String key = KeyEvent.getKeyText(evt.getKeyCode());
            //     if(key.equals("Comma") || key.equals("Quote")){
            //         tf.setText(tf.getText().replace("'", "").replace("\"", "").replace(",", ""));
            //     }
            //    System.out.println(key);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                String key = KeyEvent.getKeyText(e.getKeyCode());
                if(key.equals("Comma") || key.equals("Quote")){
                    tf.setText(tf.getText().replace("'", "").replace("\"", "").replace(",", "").replace("`", ""));
                }
            }
        });

    }

    
}