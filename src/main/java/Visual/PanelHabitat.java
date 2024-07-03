package Visual;

import logica.Animal;
import logica.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelHabitat extends JPanel {

    private Habitat habitat;
    private final ArrayList<Animal> animals;
    private final JLabel habitatInfoLabel;
    private JButton botonCrearHabitat;
    private JButton botonRetroceder;
    private final PanelPrincipal panelPrincipal;
    private final PanelEleccionHabitats panelEleccionHabitats;

    public PanelHabitat(Habitat habitat, ArrayList<Animal> animals, PanelPrincipal panelPrincipal, PanelEleccionHabitats panelEleccionHabitats) {
        this.habitat = habitat;
        this.animals = animals;
        this.panelPrincipal = panelPrincipal;
        this.panelEleccionHabitats = panelEleccionHabitats;

        this.setLayout(null);
        this.setBounds(0, 0, 1200, 700);

        //Prueba del habitat
        //Aquí se añadiran los label de imagen dependiendo del tipo de text
        habitatInfoLabel = new JLabel();
        habitatInfoLabel.setBounds(500, 280, 500, 30);
        add(habitatInfoLabel);


        updateHabitatInfo();

        botonRetroceder = new BotonRetroceder(panelPrincipal);
        botonRetroceder.setBounds(0, 0, 100, 30);
        this.add(botonRetroceder);

        if (habitat == null) {
            BotonCrearHabitat botonCrearHabitat = new BotonCrearHabitat(this);
            this.botonCrearHabitat = botonCrearHabitat.getBoton();
            this.botonCrearHabitat.setBounds(550, 320, 100, 30);
            add(this.botonCrearHabitat);
            this.add(botonRetroceder);
        }
        this.setVisible(true);
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
        int numeroHabitat = panelPrincipal.getNumeroHabitat();
        panelEleccionHabitats.setHabitat(numeroHabitat, habitat);
        updateHabitatInfo();
        if (habitat != null && botonCrearHabitat != null) {
            this.botonCrearHabitat.setVisible(false);
        }
        panelEleccionHabitats.imprimirEstadoActualHabitats();
    }

    // Esta funcion será para añadir una imagen del habitat
    public void updateHabitatInfo() {
        if (habitat != null) {
            habitatInfoLabel.setText(habitat.toString());
        } else {
            habitatInfoLabel.setText("No se ha creado ningún hábitat");
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        // Asegurarse de que el botón de retroceso siempre esté visible cuando el panel esté visible
        if (visible) {
            botonRetroceder.setVisible(true);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
