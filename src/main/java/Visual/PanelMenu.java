package Visual;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {

    public PanelMenu() {
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 700);
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Prueba de dibujo
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Presiona Click Para Continuar", getWidth() / 2 - 150, getHeight() / 2 + 100);

        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Zoologico", getWidth() / 2 - 120, getHeight() / 2 - 100);

    }
}
