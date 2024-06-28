package Visual;

import javax.swing.*;


public class PanelPrincipal extends JPanel {
    private final PanelMenu panelMenu;
    private final PanelEleccionHabitats panelEleccionHabitats;

    public PanelPrincipal(){
        this.setLayout(null);
        panelEleccionHabitats = new PanelEleccionHabitats();
        panelMenu = new PanelMenu();

        BotonMenu botonMenu = new BotonMenu(this);
        botonMenu.setBounds(0,0,1200,700);

        this.add(panelMenu);
        this.add(botonMenu);
    }

    public void cambiarAPanelHabitat(){
        panelMenu.setVisible(false);
        panelEleccionHabitats.setVisible(true);
    }
}

