import java.awt.Color;
import java.awt.Frame;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Client extends JFrame implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    private JTextArea texto;
    private JTextField txtMsg;
    private JButton btnSend;
    private JButton btnSair;
    private JLabel lblHistorico;
    private JLabel lblMsg;
    private JPanel pnlContent;
    private Socket socket;
    private OutputStream ou ;
    private Writer ouw;
    private BufferedWriter bfw;
    private JTextField txtIP;
    private JTextField txtPorta;
    private JTextField txtNome;

    public Client() throws IOException{
        
        JLabel lblMessage = new JLabel("Verificar!");
        txtIP = new JTextField("127.0.0.1");
        txtPorta = new JTextField("8080");
        txtNome = new JTextField("Cliente");
        Object[] texts = {lblMessage, txtIP, txtPorta, txtNome };
        JOptionPane.showMessageDialog(null, texts);
        pnlContent = new JPanel();
        texto              = new JTextArea(10,20);
        texto.setEditable(false);
        texto.setBackground(new Color(240,240,240));
        txtMsg                       = new JTextField(20);
        lblHistorico     = new JLabel("Histórico");
        lblMsg        = new JLabel("Mensagem");
        btnSend                     = new JButton("Enviar");
        btnSend.setToolTipText("Enviar Mensagem");
        btnSair           = new JButton("Sair");
        btnSair.setToolTipText("Sair do Chat");
        btnSend.addActionListener(this);
        btnSair.addActionListener(this);
        btnSend.addKeyListener(this);
        txtMsg.addKeyListener(this);
        JScrollPane scroll = new JScrollPane(texto);
        texto.setLineWrap(true);
        pnlContent.add(lblHistorico);
        pnlContent.add(scroll);
        pnlContent.add(lblMsg);
        pnlContent.add(txtMsg);
        pnlContent.add(btnSair);
        pnlContent.add(btnSend);
        pnlContent.setBackground(Color.LIGHT_GRAY);
        texto.setBorder(BorderFactory.createEtchedBorder(Color.BLUE,Color.BLUE));
        txtMsg.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
        setTitle(txtNome.getText());
        setContentPane(pnlContent);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(250,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        var frm = getFrames()[0];

        frm.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
              
                try {
                    sendMessage("/quit");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
              
            }
        });
    }   

    /***
     * Método usado para conectar no server socket, retorna IO Exception caso dê algum erro.
    * @throws IOException
    */
    public void conectar(){
        try{
            socket = new Socket(txtIP.getText(),Integer.parseInt(txtPorta.getText()));
            ou = socket.getOutputStream();
            ouw = new OutputStreamWriter(ou);
            bfw = new BufferedWriter(ouw);
            bfw.write(txtNome.getText()+"\r\n");
            bfw.flush();
            //bfw.write(txtNome.getText()+"Entrou no chat\r\n");
        }catch(IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o servidor!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

    
    /***
     * Método usado para enviar mensagem para o server socket
    * @param msg do tipo String
    * @throws IOException retorna IO Exception caso dê algum erro.
    */
    public void sendMessage(String msg) throws IOException{
        boolean isQuit = msg.trim().equals("/quit");
        
        if(isQuit){
  
            bfw.write("/quit\r\n");
            sair();
            
        }else{
            boolean isChangeNick = msg.startsWith("/nick");
            if(isChangeNick){
                String[] split = msg.split(" ", 2);
                if(split.length == 2){
                    bfw.write(msg+"\r\n");
                    //txtNome.setText(split[1]);
                }else{
                    //System.out.println("Erro ao alterar o nickname do " + txtNome.getT);
                }
            }else{
                bfw.write(msg+"\r\n");
            }
        }
        bfw.flush();
        txtMsg.setText("");
    }

    /**
     * Método usado para receber mensagem do servidor
     * @throws IOException retorna IO Exception caso dê algum erro.
     */
    public void escutar() throws IOException{

        InputStream in = socket.getInputStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader bfr = new BufferedReader(inr);
        String msg = "";
    
        while(!"Sair".equalsIgnoreCase(msg)){
    
            if(bfr.ready()){
                msg = bfr.readLine();
                if(msg.equals("Sair")){
                    texto.append("Servidor caiu! \r\n");
                }else{
                    texto.append(msg+"\r\n");
                }
            }

        }
    }

    /***
     * Método usado quando o usuário clica em sair
    * @throws IOException retorna IO Exception caso dê algum erro.
    */
    public void sair(){
       
        try{
            bfw.close();
            ouw.close();
            ou.close();
            socket.close();
            texto.append("Desconectado \r\n");
        }catch(IOException e){
            e.printStackTrace();
        }

        new Thread(()->{
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.exit(0);
        }).start();
       

    }  

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
   
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                sendMessage(txtMsg.getText());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getActionCommand().equals(btnSend.getActionCommand())){
                sendMessage(txtMsg.getText());
            }
            else{
                if(e.getActionCommand().equals(btnSair.getActionCommand())){
                    sendMessage("/quit");
                }
            }
        } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
        
    }

    public static void main(String []args) throws IOException{

        Client app = new Client();
        app.conectar();
        app.escutar();
        
     }
    
}
