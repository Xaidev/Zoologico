package Visual;

import logica.Animal;
import logica.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * PanelEleccionHabitats panel donde se eligen los espacios de los habitats
 */

public class PanelEleccionHabitats extends JPanel {
    private final ArrayList<Habitat> habitats;
    private final ArrayList<PanelHabitat> panelHabitats;
    private final BotonEleccionHabitat botonEleccionHabitatHabitat1;
    private final BotonEleccionHabitat botonEleccionHabitatHabitat2;
    private final BotonEleccionHabitat botonEleccionHabitatHabitat3;
    private final BotonEleccionHabitat botonEleccionHabitatHabitat4;
    private final ArrayList<Animal> animals;
    private final ArrayList<Integer> numeroHabitats;
    /**
     * Constructor de la clase PanelEleccionHabitats
     * @param panelPrincipal
     */
    public PanelEleccionHabitats(PanelPrincipal panelPrincipal) {
        this.setLayout(null);
        this.habitats = new ArrayList<>();
        this.panelHabitats = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.numeroHabitats = new ArrayList<>();
        this.setBounds(0, 0, 1200, 700);


        for (int i = 0; i < 4; i++) {
            habitats.add(null);
            panelHabitats.add(new PanelHabitat(habitats.get(i), animals, panelPrincipal, this));
            numeroHabitats.add(i);
        }


        botonEleccionHabitatHabitat1 = new BotonEleccionHabitat(panelPrincipal, numeroHabitats.get(0));
        botonEleccionHabitatHabitat1.setBounds(200, 120, 200, 200);
        botonEleccionHabitatHabitat1.setOpaque(false);
        botonEleccionHabitatHabitat1.setContentAreaFilled(false);
        this.add(botonEleccionHabitatHabitat1);

        botonEleccionHabitatHabitat2 = new BotonEleccionHabitat(panelPrincipal, numeroHabitats.get(1));
        botonEleccionHabitatHabitat2.setBounds(300, 380, 200, 200);
        botonEleccionHabitatHabitat2.setOpaque(false);
        botonEleccionHabitatHabitat2.setContentAreaFilled(false);
        this.add(botonEleccionHabitatHabitat2);

        botonEleccionHabitatHabitat3 = new BotonEleccionHabitat(panelPrincipal, numeroHabitats.get(2));
        botonEleccionHabitatHabitat3.setBounds(700, 120, 200, 200);
        botonEleccionHabitatHabitat3.setOpaque(false);
        botonEleccionHabitatHabitat3.setContentAreaFilled(false);
        this.add(botonEleccionHabitatHabitat3);

        botonEleccionHabitatHabitat4 = new BotonEleccionHabitat(panelPrincipal, numeroHabitats.get(3));
        botonEleccionHabitatHabitat4.setBounds(800, 380, 200, 200);
        botonEleccionHabitatHabitat4.setOpaque(false);
        botonEleccionHabitatHabitat4.setContentAreaFilled(false);
        this.add(botonEleccionHabitatHabitat4);

        this.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    /**
     * Getter de los habitats
     * @return habitats
     */
    public ArrayList<PanelHabitat> getPanelHabitats() {
        return panelHabitats;
    }

    /**
     * Setter de los habitats
     * @param numeroHabitat
     * @param habitat
     */
    public void setHabitat(int numeroHabitat, Habitat habitat) {
        habitats.set(numeroHabitat, habitat);
    }

    /**
     * Funcion para ver el estado acutal de los habitats
     */
    public void imprimirEstadoActualHabitats() {
        System.out.println("Estado actual de los habitats:");
        int i = 1;
        for (Habitat habitat : habitats) {
            if (habitat != null) {
                System.out.println(habitat);
            } else {
                System.out.println("El habitat no ha sido creado" + i);
            }
            i++;
        }
    }
}
