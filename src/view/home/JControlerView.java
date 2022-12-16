package view.home;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

public class JControlerView {
    
    public static JLogin js = null;
    
    public static void main(String[] args) {
       style();
       js =  new JLogin();
    }


    public static void style(){
        for (LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
