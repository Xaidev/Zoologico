package Visual;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * PanelGridComidas es una clase que representa un panel para mostrar visualmente el depósito de comida de un hábitat.
 * Extiende de JPanel y muestra imágenes de diferentes tipos de comida (carnívora, herbívora, omnívora).
 */
public class PanelGridComidas extends JPanel {
    final int widthAllGrid = 400;
    private Habitat habitat;
    private Deposito comidas;
    private PanelPrincipal panelPr;
    private ArrayList<JLabel> spaces;

    /**
     * Constructor de la clase PanelGridComidas.
     *
     * @param x              Posición en x donde se ubicará el panel.
     * @param y              Posición en y donde se ubicará el panel.
     * @param h              El hábitat asociado donde se gestiona la comida.
     * @param pH             El panel de hábitat principal donde se mostrarán los cambios.
     * @param panelPrincipal El panel principal de la aplicación.
     */
    public PanelGridComidas(int x, int y, Habitat h, PanelHabitat pH, PanelPrincipal panelPrincipal) {
        habitat = h;
        panelPr = panelPrincipal;
        comidas = habitat.getDeposito();

        this.setOpaque(false);
        this.setLayout(new GridLayout(2, 10));
        this.setBounds(x, y, widthAllGrid, widthAllGrid / 4);

        spaces = new ArrayList<JLabel>();
        for (int i = 0; i < 10; i++) {
            JLabel aux = new JLabel((i + 1) + "");
            spaces.add(aux);
            this.add(aux);
        }
        drawComidas();
    }

    /**
     * Método para dibujar las imágenes de comida en el panel.
     * Llama al método limpiarImagenes antes de dibujar las nuevas imágenes.
     */
    public void drawComidas() {
        limpiarImagenes();
        comidas.setVisualDeposito(this);
        comidas.setVisualPrincipal(panelPr);
        if (comidas == null)
            return;
        System.out.println(comidas.getSize());

        for (int i = 0; i < comidas.getSize(); i++) {
            try {
                if (comidas.lookObjeto(i) instanceof ComidaCarnivoro) {
                    crearImagen(spaces.get(i), "src/main/java/Visual/Imagenes/comidacarnivoro.png", 0, 0, 50, 50);
                } else if (comidas.lookObjeto(i) instanceof ComidaHerbivoro) {
                    crearImagen(spaces.get(i), "src/main/java/Visual/Imagenes/comidaherbivoro.png", 0, 0, 50, 50);
                } else if (comidas.lookObjeto(i) instanceof ComidaOmnivoro) {
                    crearImagen(spaces.get(i), "src/main/java/Visual/Imagenes/comidaomnivoro.png", 0, 0, 50, 50);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar las comidas");
                break;
            }
        }
    }

    /**
     * Método para limpiar las imágenes de comida en el panel.
     * Elimina las imágenes actuales de los JLabels.
     */
    public void limpiarImagenes() {
        for (int i = 0; i < 10; i++) {
            spaces.get(i).setIcon(null);
        }
        this.repaint();
    }

    /**
     * Método para crear una imagen y colocarla en un JLabel.
     *
     * @param label     JLabel donde se colocará la imagen.
     * @param rutaImagen Ruta de la imagen a cargar.
     * @param x         Posición en x de la imagen.
     * @param y         Posición en y de la imagen.
     * @param ancho     Ancho de la imagen.
     * @param alto      Alto de la imagen.
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
