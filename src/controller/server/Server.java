package controller.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Server extends Thread{
    private static ArrayList<BufferedWriter>clientes;
    private static ServerSocket server;
    private String nome;
    private Socket con;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;
    private static boolean shutdown = false;

    /**
  * Método construtor
  * @param com do tipo Socket
  */
    public Server(Socket con){
        this.con = con;
        try {
            in  = con.getInputStream();
            inr = new InputStreamReader(in);
            bfr = new BufferedReader(inr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
  * Método run
  */
    public void run(){

        try{
    
            String msg;
            OutputStream ou = this.con.getOutputStream();
            Writer ouw = new OutputStreamWriter(ou);
            BufferedWriter bfw = new BufferedWriter(ouw);
            clientes.add(bfw);

            nome = msg = bfr.readLine();
            msg = nome + " Entrou no chat!";
            System.out.println(msg);
            sendToAll(bfw, msg);
            
            while(msg != null && !shutdown){

              

                msg = bfr.readLine();
                
                if(msg != null){
                    boolean isNotChangNickName = !msg.startsWith("/nick");
                    boolean isNotQuit = !msg.equals("/quit");
                    boolean isNotShutDown = !msg.equals("/shutdown");
                    
                    if(isNotChangNickName && isNotQuit && isNotShutDown){
                        msg = nome +": "+msg;
                    }
                    sendToAll(bfw, msg);
                }

                

            }

            
        
        }catch (Exception e) {
            e.printStackTrace();
    
        }
    }

    public String ChangeNickName(BufferedWriter bwSaida,String msg){
        try {
            String[] split = msg.split(" ", 2);
            if(split.length == 2){
                msg = "============="+nome +" alterou seu nickname para "+split[1]+"=============";
                System.out.println(msg.length());
                nome = split[1];
            
                bwSaida.write("=============Nick alterado com sucesso!=============");
                bwSaida.newLine();
                bwSaida.flush();

            }else{
                msg = "Erro ao alterar o nick para"+nome;
            
            
                bwSaida.write(msg);
                bwSaida.newLine();
                bwSaida.flush();
            
                msg = "";
            }

            System.out.println(msg);
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return msg;
    }

    /***
     * Método usado para enviar mensagem para todos os clients
     * @param bwSaida do tipo BufferedWriter
     * @param msg do tipo String
     * @throws IOException
     */
    public void sendToAll(BufferedWriter bwSaida, String msg) throws  IOException {

        boolean shutdown = false;
        if(msg.startsWith("/nick")){
    
            msg = ChangeNickName(bwSaida,msg);

        }else if(msg.equals("/quit")){

            msg = "============="+nome+" foi desconectado.=============";
            clientes.remove(bwSaida);
            System.out.println(msg);
        }else if(msg.equals("/shutdown")){
            msg = "=============Server desligado.=============";
            shutdown = true;
            System.out.println(msg);
        }

        for(BufferedWriter bw : clientes){
            bw.write(msg+"\r\n");
            bw.flush();
        }

        if(shutdown){
            ShutDown();
        }
    }

    public void ShutDown(){
        try {
            shutdown = true;
            for(BufferedWriter bw : clientes){
                
                bw.close();
            
            }

            if(!server.isClosed()){
               
                con.close();
                server.close();
                in.close();
                inr.close();
                bfr.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /***
   * Método main
   * @param args
   */
    public static void main(String []args) {

        try{
            //Cria os objetos necessário para instânciar o servidor
            JLabel lblMessage = new JLabel("Porta do Servidor:");
            JTextField txtPorta = new JTextField("8080");
            Object[] texts = {lblMessage, txtPorta };
            JOptionPane.showMessageDialog(null, texts);
            server = new ServerSocket(Integer.parseInt(txtPorta.getText()));
            clientes = new ArrayList<BufferedWriter>();
            JOptionPane.showMessageDialog(null,"Servidor ativo na porta: "+
            txtPorta.getText());
            
            System.out.println("Aguardando conexão...");
            while(shutdown == false){
                    try{
                        Socket con = server.accept();
                        //System.out.println("Cliente conectado...");
                        Thread t = new Server(con);
                        t.start();
                    }catch(SocketException e){
                        boolean serverIsNotClose = !shutdown;
                        if(serverIsNotClose){
                            e.printStackTrace();
                        }
                    }
            }
    
        }catch (Exception e) {
    
            e.printStackTrace();
        }
    }// Fim do método main
    }
