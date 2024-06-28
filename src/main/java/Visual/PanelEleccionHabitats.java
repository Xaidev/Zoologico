package Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import logica.Animal;
import logica.Habitat;

public class PanelEleccionHabitats extends JPanel {
    private ArrayList<Habitat> habitats;
    private ArrayList<PanelHabitat> panelHabitats;
    private BotonEleccionHabitat botonEleccionHabitatHabitat1;
    private BotonEleccionHabitat botonEleccionHabitatHabitat2;
    private BotonEleccionHabitat botonEleccionHabitatHabitat3;
    private BotonEleccionHabitat botonEleccionHabitatHabitat4;
    private ArrayList<Animal> animals;

    public PanelEleccionHabitats(){
        this.setLayout(null);
        this.habitats = new ArrayList<>();
        this.panelHabitats = new ArrayList<>();
        this.animals = new ArrayList<Animal>();

        for(int i = 0; i < 4; i++){
            habitats.add(null);
        }

        for(int i = 0; i < 4; i++) {
            panelHabitats.add(new PanelHabitat(habitats.get(i), animals, this));
        }

        botonEleccionHabitatHabitat1 = new BotonEleccionHabitat(habitats.get(0),panelHabitats, 0);
        botonEleccionHabitatHabitat1.setBounds(100,100,50,50);
        botonEleccionHabitatHabitat1.add(this);

        botonEleccionHabitatHabitat2 = new BotonEleccionHabitat(habitats.get(1),panelHabitats, 1);
        botonEleccionHabitatHabitat2.setBounds(200,200,50,50);
        botonEleccionHabitatHabitat2.add(this);

        botonEleccionHabitatHabitat3 = new BotonEleccionHabitat(habitats.get(2),panelHabitats, 2);
        botonEleccionHabitatHabitat3.setBounds(300,100,50,50);
        botonEleccionHabitatHabitat3.add(this);

        botonEleccionHabitatHabitat4 = new BotonEleccionHabitat(habitats.get(3),panelHabitats, 3);
        botonEleccionHabitatHabitat4.setBounds(400,200,50,50);
        botonEleccionHabitatHabitat4.add(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
