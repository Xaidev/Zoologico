package Visual;

import logica.SelectorAnimal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * PanelManual es una clase que representa un panel para mostrar información de animales seleccionados.
 * Extiende de JPanel y contiene JLabels para mostrar textos de información de los animales.
 */
public class PanelManual extends JPanel {
    public ArrayList<JLabel> labels;

    /**
     * Constructor de la clase PanelManual.
     * Crea un panel con un GridLayout según la cantidad de tipos de animales definidos en SelectorAnimal.
     * Inicializa un ArrayList de JLabels para mostrar información de los animales.
     */
    private int x =  150;
    private int y = 30;
    private int auxY = 0;

    public PanelManual() {
        this.setLayout(null);
        this.setBounds(0,0,600,400);
        this.setBackground(Color.black);
        labels = new ArrayList<>();
        for (int i = 0; i < SelectorAnimal.values().length; i++) {
            JLabel aux = new JLabel();
            labels.add(aux);
            this.add(aux);
        }
    }

    /**
     * Método para agregar texto a un JLabel específico en el panel.
     *
     * @param s Texto a agregar al JLabel.
     * @param i Índice del JLabel en el ArrayList.
     */
    public void addTexto(String s, int i) {
        labels.get(i).setText(s);
        labels.get(i).setBounds(x,y+auxY,400,20);
        auxY += 30;
    }

    Image img;
    @Override
    protected void paintComponent(Graphics g) {
        try {
            img = ImageIO.read(new File("./src/main/java/Visual/Imagenes/Libro.png"));
            img = img.getScaledInstance(328*3,220*2,Image.SCALE_DEFAULT);
        } catch (IOException e) {
        }
        super.paintComponent(g);
        g.drawImage(img,0, 0, null);
    }
}
