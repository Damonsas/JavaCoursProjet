package Inventory;

import javax.swing.JFrame;

public class CustomFrame {
    private JFrame frame;

    public CustomFrame(String title) {
        frame = new JFrame(title);
    }

    public void setVisibility(boolean visible) {
        frame.setVisible(visible);
    }

    public void setSize(int width, int height) {
        frame.setSize(width, height);
    }

    public void setDefaultClose(boolean exitOnClose) {
        if (exitOnClose) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}


