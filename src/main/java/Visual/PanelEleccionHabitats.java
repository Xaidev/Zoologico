package Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import logica.Animal;
import logica.Habitat;

public class PanelEleccionHabitats extends JPanel {
    private ArrayList<Habitat> habitats;
    private ArrayList<PanelHabitat> panelHabitats;
    private Boton botonHabitat1;
    private Boton botonHabitat2;
    private Boton botonHabitat3;
    private Boton botonHabitat4;
    private ArrayList<Animal> animals;

    public PanelEleccionHabitats(){
        this.setLayout(null);
        for(int i = 0; i < 4; i++){
            this.habitats.set(i, null);
        }
        for(int i = 0; i < 4; i++) {
            panelHabitats.set(i, new PanelHabitat(habitats.get(i), animals, this));
        }

        botonHabitat1 = new Boton(habitats.get(0),panelHabitats, 0);
        botonHabitat1.setBounds(100,100,50,50);
        botonHabitat1.add(this);

        botonHabitat2 = new Boton(habitats.get(1),panelHabitats, 1);
        botonHabitat2.setBounds(200,200,50,50);
        botonHabitat2.add(this);

        botonHabitat3 = new Boton(habitats.get(2),panelHabitats, 2);
        botonHabitat3.setBounds(300,100,50,50);
        botonHabitat3.add(this);

        botonHabitat4 = new Boton(habitats.get(3),panelHabitats, 3);
        botonHabitat4.setBounds(400,200,50,50);
        botonHabitat4.add(this);



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
