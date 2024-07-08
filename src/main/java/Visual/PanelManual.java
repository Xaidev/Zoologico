package Visual;

import logica.SelectorAnimal;

import javax.swing.*;
import java.awt.*;
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
    public PanelManual() {
        this.setLayout(new GridLayout(SelectorAnimal.values().length, 0));
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
    }
}
