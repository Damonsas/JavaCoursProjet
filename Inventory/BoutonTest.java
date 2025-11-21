package Inventory;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoutonTest {
   private JButton btn;

   public BoutonTest(String name){
       btn = new JButton();
   }

    public void addActionListener(){
        try{
            throw new RuntimeException("erreur");
        }catch (Exception err){
            JDialog popup = new JDialog();
            popup.setTitle(err.getMessage());
            popup.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            popup.setVisible(true);

        }
    }
}



