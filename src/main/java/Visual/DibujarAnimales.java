package Visual;

import logica.Animal;
import logica.Habitat;

import javax.swing.*;

/**
 * La clase DibujarAnimales es un JPanel que se encarga de dibujar los animales en el hábitat correspondiente.
 */
public class DibujarAnimales extends JPanel {

    /**
     * Constructor de la clase DibujarAnimales.
     *
     * @param h     El hábitat que contiene los animales a dibujar.
     * @param panel El panel principal del hábitat donde se agregarán los animales.
     */
    public DibujarAnimales(Habitat h, PanelHabitat panel) {
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0, 0, 2000, 2000);
        panel.add(this);

        for (Animal a : h.getAnimals()) {
            UpdateAnimal(a, panel);
        }
    }

    /**
     * Actualiza la representación visual de un animal en el panel del hábitat.
     *
     * @param a     El animal cuya representación visual se actualizará.
     * @param panel El panel principal del hábitat donde se agregará el animal.
     */
    public void UpdateAnimal(Animal a, PanelHabitat panel) {
        this.add(a.animalLabel);
        PanelHabitat.crearImagen(a.animalLabel, a.getRutaImagen(), a.startX, a.startY, a.xSize, a.ySize);
    }
}
