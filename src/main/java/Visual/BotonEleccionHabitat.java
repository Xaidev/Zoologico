package Visual;

import javax.swing.*;
import java.awt.*;

/**
 * BotonEleccionHabitat
 */
public class BotonEleccionHabitat extends JButton {

    private final PanelPrincipal panelPrincipal;
    private JLabel label;

    /**
     * Constructor de la clase BotonEleccionHabitat
     * @param panelPrincipal
     * @param numeroHabitat
     */
    public BotonEleccionHabitat(PanelPrincipal panelPrincipal, int numeroHabitat) {
        this.panelPrincipal = panelPrincipal;
        this.label = new JLabel();
        this.addActionListener(e -> {
            BotonEleccionHabitat.this.panelPrincipal.cambiarAPanelHabitat(numeroHabitat);
            BotonEleccionHabitat.this.panelPrincipal.setNumeroHabitat(numeroHabitat);
        });
        this.add(label);
        label.setBounds(0,0,500,500);
        label.setVisible(true);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(false);

    }


    public JLabel conseguirLabel(){
        return label;
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
