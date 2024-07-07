package Visual;

import javax.swing.*;
import java.util.ArrayList;


public class PanelPrincipal extends JPanel {
    private final PanelMenu panelMenu;
    private final PanelEleccionHabitats panelEleccionHabitats;
    private ArrayList<PanelHabitat> panelHabitatArrayList;
    private BotonMenu botonMenu;
    private int numeroHabitat;
    private PanelAvisos panelAvisos;


    public PanelPrincipal() {
        this.setLayout(null);

        panelEleccionHabitats = new PanelEleccionHabitats(this);
        panelHabitatArrayList = new ArrayList<>();
        panelMenu = new PanelMenu();
        panelAvisos = new PanelAvisos();


        this.panelHabitatArrayList = panelEleccionHabitats.getPanelHabitats();


        cargarBotonMenu(this);
        this.add(panelMenu);
        this.add(panelEleccionHabitats);
        for (PanelHabitat panelHabitat : panelHabitatArrayList) {
            this.add(panelHabitat);
            panelHabitat.setVisible(false);
        }
        panelEleccionHabitats.setVisible(false);
    }

    public void cambiarAPanelEleccionHabitatDesdeMenu() {
        panelMenu.setVisible(false);
        panelEleccionHabitats.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public void cambiarAPanelEleccionHabitat() {
        // Oculta todos los paneles de hábitat
        for (PanelHabitat panel : panelHabitatArrayList) {
            panel.setVisible(false);
        }
        panelEleccionHabitats.setVisible(true);

        this.revalidate();
        this.repaint();
    }

    public void cambiarAPanelHabitat(int numeroHabitat) {
        // Oculta todos los paneles de hábitat
        for (PanelHabitat panel : panelHabitatArrayList) {
            panel.setVisible(false);
        }
        // Muestra el panel seleccionado
        PanelHabitat panelHabitatActual = panelHabitatArrayList.get(numeroHabitat);
        panelHabitatActual.setVisible(true);

        // Oculta el panel de selección de hábitat
        panelEleccionHabitats.setVisible(false);

        // Añade el panel seleccionado si no ha sido añadido antes
        if (!this.isAncestorOf(panelHabitatActual)) {
            this.add(panelHabitatActual);
        }
        this.revalidate();
        this.repaint();
    }

    public PanelAvisos getPanelAvisos(){
        return panelAvisos;
    }

    public int getNumeroHabitat() {
        return numeroHabitat;
    }

    public void setNumeroHabitat(int numeroHabitat) {
        this.numeroHabitat = numeroHabitat;
    }

    public void cargarBotonMenu(PanelPrincipal panelPrincipal) {
        botonMenu = new BotonMenu(panelPrincipal);
        botonMenu.setBounds(0, 0, 1200, 700);
        botonMenu.setOpaque(false);
        botonMenu.setContentAreaFilled(false);
        panelPrincipal.add(botonMenu);
    }

}

