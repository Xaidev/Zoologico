package Visual;

import javax.swing.*;
import java.awt.*;



public class BotonRetroceder extends JButton {
    private final PanelPrincipal panelPrincipal;

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
