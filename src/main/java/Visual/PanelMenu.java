package Visual;

import javax.swing.*;
import java.awt.*;

/**
 * La clase PanelMenu es un JPanel que representa el menú principal del zoológico.
 */
public class PanelMenu extends JPanel {

    /**
     * Constructor de la clase PanelMenu.
     * Inicializa el panel con un diseño nulo, establece sus dimensiones y lo hace visible.
     */
    public PanelMenu() {
        this.setLayout(null);
        this.setBounds(0, 0, 1200, 700);
        this.setVisible(true);
    }

    /**
     * Sobrescribe el método paintComponent para dibujar el contenido del menú en el panel.
     *
     * @param g El contexto gráfico en el cual dibujar.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja texto en el panel
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Presiona Click Para Continuar", getWidth() / 2 - 150, getHeight() / 2 + 100);

        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Zoologico", getWidth() / 2 - 120, getHeight() / 2 - 100);
    }
}
