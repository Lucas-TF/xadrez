package view.home;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Container;
/**
 *  Tela inicial 
 */
public class JRooms extends JFrame{

    private JTextField txtfind;
    private JButton btnCreate,btnfind;
    private Box vbox;
    private Box hbox;
    /**
     *  Construtor da tela inicial 
     */
    public JRooms(){
        Dimension d = new Dimension();
        d.setSize(475,30);
        hbox = Box.createHorizontalBox();
        vbox = Box.createVerticalBox();
        hbox.setPreferredSize(d);
        btnCreate = new JButton("Criar Sala");
        txtfind = new JTextField();
        btnfind = new JButton("Procurar Sala");
            
        hbox.add(btnCreate);
        hbox.add(getSpace(10,30));
        hbox.add(txtfind);
        hbox.add(getSpace(10,30));
        hbox.add(btnfind);
        vbox.add(hbox);
        add(vbox);
        vbox.add(getSpace(475, 10));
    
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("sim ele");
        lista.add("ele mesmo");
        lista.add("nao pode ser ele");
        for(int i=0; i<3; i++){
            vbox.add(getSite(hbox, lista.get(i),lista.get(1)));
            vbox.add(getSpace(475,10));
        }
        setTitle("HOME");
        this.setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnCreate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              new JCreateRoom();
              dispose(); 
            }
        });
    }
    public Container getSpace(int w ,int h){
        Dimension a = new Dimension();
        Container espace = new Container();
        a.setSize(w,h);
        espace.setPreferredSize(a);
        espace.setMaximumSize(a); 
        return espace;
    }
    public Box getSite(Box sala,String nome,String dono){
        Dimension d = new Dimension();
        d.setSize(100,30);
        sala = Box.createHorizontalBox();
        JTextField nomedasala = new JTextField(nome);
        nomedasala.setPreferredSize(d);
        JTextField donodasala = new JTextField(dono);
        JButton btnEnter = new JButton("Entrar");
        nomedasala.setEditable(false);
        donodasala.setEditable(false);
        sala.add(nomedasala);
        sala.add(getSpace(10,30));
        sala.add(donodasala);
        sala.add(getSpace(10,30));
        sala.add(btnEnter);
        return sala;
    }
}

