package Visual;

import javax.swing.*;
import java.awt.*;

/**
 * BotonRetroceder boton retroceder que al ser presionado cambia al panel eleccion habitat
 */
public class BotonRetroceder extends JButton {
    private final PanelPrincipal panelPrincipal;
    /**
     * Constructor de la clase BotonRetroceder
     * @param panelPrincipal
     */
    public BotonRetroceder(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.addActionListener(actionEvent -> {
            System.out.println("Botón retroceder presionado");
            BotonRetroceder.this.panelPrincipal.cambiarAPanelEleccionHabitat();
            this.setVisible(false);
        });
        JLabel label = new JLabel();
        crearImagen(label, "src/main/java/Visual/Imagenes/BotonRetroceder.png", 0, 0, 60, 60);
        this.add(label);
        this.setBounds(0, 0, 100, 50);
        this.setFocusPainted(false);
    }

    /**
     * Crea una imagen en un label con las dimensiones dadas
     * @param label Label donde se creará la imagen
     * @param rutaImagen Ruta de la imagen
     * @param x Posición en x
     * @param y Posición en y
     * @param ancho Ancho de la imagen
     * @param alto Alto de la imagen
     */
    public void crearImagen(JLabel label, String rutaImagen, int x, int y, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(rutaImagen);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        label.setIcon(newIcon);
        label.setBounds(x, y, ancho, alto);
        label.setVisible(true);
    }

}
