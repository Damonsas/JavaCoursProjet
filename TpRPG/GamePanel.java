package TpRPG;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    Image background;
    Image orc;
    Image elf;

    public GamePanel() {
        background = new ImageIcon("assets/background.jpg").getImage();
        orc = new ImageIcon("assets/orc.png").getImage();
        elf = new ImageIcon("assets/elf.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        // Characters
        g.drawImage(orc, 100, 300, 150, 150, this);
        g.drawImage(elf, 550, 300, 150, 150, this);
    }
}

