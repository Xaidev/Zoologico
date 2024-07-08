package Visual;

import javax.swing.*;
import java.awt.*;

/**
 * BotonEleccionHabitat es una clase que extiende JButton y representa un botón para elegir un hábitat.
 */
public class BotonEleccionHabitat extends JButton {

    private final PanelPrincipal panelPrincipal;
    private final JLabel label;

    /**
     * Constructor de la clase BotonEleccionHabitat.
     *
     * @param panelPrincipal El panel principal donde se va a utilizar el botón.
     * @param numeroHabitat  Número que identifica el hábitat asociado al botón.
     */
    public BotonEleccionHabitat(PanelPrincipal panelPrincipal, int numeroHabitat) {
        this.panelPrincipal = panelPrincipal;
        this.label = new JLabel();


        this.addActionListener(e -> {
            BotonEleccionHabitat.this.panelPrincipal.cambiarAPanelHabitat(numeroHabitat);
            BotonEleccionHabitat.this.panelPrincipal.setNumeroHabitat(numeroHabitat);
        });


        this.add(label);
        label.setBounds(0, 0, 500, 500);
        label.setVisible(true);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(false);

    }

    /**
     * Obtiene el label asociado al botón.
     *
     * @return El JLabel asociado al botón.
     */
    public JLabel conseguirLabel() {
        return label;
    }

    /**
     * Crea una imagen en el label con las dimensiones proporcionadas.
     *
     * @param label      El JLabel donde se colocará la imagen.
     * @param rutaImagen La ruta de la imagen a cargar.
     * @param x          La posición X de la imagen en el label.
     * @param y          La posición Y de la imagen en el label.
     * @param ancho      El ancho deseado de la imagen.
     * @param alto       El alto deseado de la imagen.
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
