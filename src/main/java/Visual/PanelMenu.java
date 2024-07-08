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
        this.setBackground(Color.black);
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
        JLabel title = new JLabel();
        PanelHabitat.crearImagen(title,"src/main/java/Visual/Imagenes/Menu.png",0,0,1184,662);
        this.add(title);
        super.paintComponent(g);
    }
}
