package DemoCalculatrice;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[]args){
        var frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        JButton btn1 = new JButton("1");
        btn1.addActionListener(ev -> {
            try{
                throw new RuntimeException("erreur");
            }catch (Exception err){
                JDialog popup = new JDialog();
                popup.setTitle(err.getMessage());
                popup.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                popup.setVisible(true);

            }
        });
        frame.getContentPane().add(btn1);

        JButton btn2 = new JButton("2");
        btn2.addActionListener(ev -> {});
        frame.getContentPane().add(btn2);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
