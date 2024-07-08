package Visual;

import logica.*;

import javax.swing.*;
import java.awt.*;

/**
 * PanelAgregarAnimales es una clase que representa un panel para agregar animales a un hábitat.
 * Extiende de JPanel y muestra una lista de botones de selección para diferentes tipos de animales disponibles en el hábitat.
 */
public class PanelAgregarAnimales extends JPanel {

    /**
     * Constructor de la clase PanelAgregarAnimales.
     *
     * @param x           Posición en el eje x del panel.
     * @param y           Posición en el eje y del panel.
     * @param habitat     El hábitat donde se agregarán los animales.
     * @param panelHabitat PanelHabitat donde se muestra el hábitat.
     * @param panelManual PanelManual donde se muestra el manual de animales.
     */
    public PanelAgregarAnimales(int x, int y, Habitat habitat, PanelHabitat panelHabitat, PanelManual panelManual) {
        DibujarAnimales panelDibujarAnimales = new DibujarAnimales(habitat, panelHabitat);
        JLabel labelTitle;
        this.setBounds(x, y, 300, 700);
        this.setVisible(true);
        this.setOpaque(false);

        SelectorAnimal[] nombresAnimales = SelectorAnimal.values();
        this.setLayout(new GridLayout(nombresAnimales.length + 1, 1));

        FiltroSelectorAnimal filtro = new FiltroSelectorAnimal(habitat);

        int i = 0;
        labelTitle = new JLabel("Animales Disponibles");
        labelTitle.setForeground(Color.white);
        this.add(labelTitle);

        for (SelectorAnimal a : nombresAnimales) {
            if (!filtro.adaptabilidadAnimal(a))
                continue;

            Animal tipoAnimal = filtro.crearAnimal(a);
            panelManual.addTexto(tipoAnimal.getClass().getSimpleName() + " requiere de comida de tipo: " + tipoAnimal.getTipoComida(), i);
            i++;
            JButton b = new JButton(a.name());
            b.addActionListener(e -> {
                try {
                    Animal aux = filtro.crearAnimal(a);
                    aux.setPanelPrincipal(panelHabitat.getPanelPrincipal());
                    habitat.agregarAnimals(aux);
                    panelDibujarAnimales.UpdateAnimal(aux, panelHabitat);
                } catch (LimiteAnimalesExcedidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            this.add(b);
        }
        if (i == 0) {
            labelTitle.setText("No hay animales disponibles");
        }
        Ventana.addAnimalThread(habitat);
    }

    /**
     * Override del método paintComponent de JPanel para personalizar la apariencia del panel.
     *
     * @param g Objeto Graphics utilizado para dibujar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
