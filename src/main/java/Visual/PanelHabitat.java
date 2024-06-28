package Visual;

import logica.Animal;
import logica.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelHabitat extends JPanel {

    private BotonRetroceder botonRetroceder;
    private Habitat habitat;
    private ArrayList animals;

    public PanelHabitat(Habitat habitat, ArrayList<Animal> animals, PanelEleccionHabitats panelEleccionHabitats){
        this.setLayout(null);
        this.habitat = habitat;
        this.animals = animals;
        this.botonRetroceder = new BotonRetroceder(this, panelEleccionHabitats);

        if(habitat != null) {
            //Logica de botones para la creacion del habitat
            BotonCrearHabitat botonCrearHabitat = new BotonCrearHabitat();
            add(botonCrearHabitat.getBoton());
        } else {
            //Logica de agregar alimento a "deposito" alimentos, y cargar imagenes de animal y animaciones

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0,0,800,700);
        g.setColor(Color.BLACK);
    }
}
