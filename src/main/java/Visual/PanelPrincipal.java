package Visual;

import javax.swing.*;
import java.util.ArrayList;

/**
 * PanelPrincipal es una clase que representa el panel principal de la interfaz.
 * Contiene un menú, opciones para seleccionar hábitats y muestra los hábitats seleccionados.
 */
public class PanelPrincipal extends JPanel {
    private final PanelMenu panelMenu;
    private final PanelEleccionHabitats panelEleccionHabitats;
    private ArrayList<PanelHabitat> panelHabitatArrayList;
    private BotonMenu botonMenu;
    private int numeroHabitat;
    private final ArrayList<PanelAvisos> panelAvisosArrayList;
    private final PanelAvisos panelAvisosEleccionHabitat;

    /**
     * Constructor de la clase PanelPrincipal.
     * Inicializa todos los componentes del panel principal y los añade al panel.
     */
    public PanelPrincipal() {
        this.setLayout(null);
        panelAvisosEleccionHabitat = new PanelAvisos(false);
        panelAvisosArrayList = new ArrayList<>();
        panelEleccionHabitats = new PanelEleccionHabitats(this);
        panelHabitatArrayList = new ArrayList<>();
        panelMenu = new PanelMenu();


        for (int i = 0; i < 4; i++) {
            panelAvisosArrayList.add(new PanelAvisos(true));
        }


        this.panelHabitatArrayList = panelEleccionHabitats.getPanelHabitats();


        cargarBotonMenu(this);


        this.add(panelMenu);
        this.add(panelEleccionHabitats);
        for (PanelHabitat panelHabitat : panelHabitatArrayList) {
            this.add(panelHabitat);
            panelHabitat.setVisible(false);
        }
        panelEleccionHabitats.setVisible(false);
        panelAvisosEleccionHabitat.setVisible(false);
        panelEleccionHabitats.setVisible(false);
    }

    /**
     * Cambia la vista al panel de selección de hábitats desde el menú principal.
     * Oculta el menú principal y muestra el panel de selección de hábitats.
     */
    public void cambiarAPanelEleccionHabitatDesdeMenu() {
        panelMenu.setVisible(false);
        panelEleccionHabitats.setVisible(true);
        panelAvisosEleccionHabitat.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    /**
     * Cambia la vista al panel de selección de hábitats.
     * Oculta todos los paneles de hábitats y muestra el panel de selección de hábitats.
     */
    public void cambiarAPanelEleccionHabitat() {
        for (PanelHabitat panel : panelHabitatArrayList) {
            panel.setVisible(false);
        }
        panelEleccionHabitats.setVisible(true);
        panelAvisosEleccionHabitat.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    /**
     * Cambia la vista al panel de hábitat seleccionado.
     * Oculta todos los paneles de hábitats y muestra el panel del hábitat seleccionado.
     *
     * @param numeroHabitat Número del hábitat seleccionado
     */
    public void cambiarAPanelHabitat(int numeroHabitat) {
        for (PanelHabitat panel : panelHabitatArrayList) {
            panel.setVisible(false);
        }

        PanelHabitat panelHabitatActual = panelHabitatArrayList.get(numeroHabitat);
        panelHabitatActual.setVisible(true);
        panelAvisosArrayList.get(numeroHabitat).setVisible(true);


        panelEleccionHabitats.setVisible(false);


        if (!this.isAncestorOf(panelHabitatActual)) {
            this.add(panelHabitatActual);
        }
        this.revalidate();
        this.repaint();
    }

    /**
     * Obtiene el panel de avisos del hábitat especificado.
     *
     * @param a Índice del hábitat
     * @return Panel de avisos del hábitat
     */
    public PanelAvisos getPanelAvisosHabitat(int a) {
        return panelAvisosArrayList.get(a);
    }

    /**
     * Obtiene el panel de avisos para la elección de hábitats.
     *
     * @return Panel de avisos para la elección de hábitats
     */
    public PanelAvisos getPanelAvisosEleccionHabitat() {
        return panelAvisosEleccionHabitat;
    }

    /**
     * Obtiene la lista de paneles de hábitats.
     *
     * @return Lista de paneles de hábitats
     */
    public ArrayList<PanelHabitat> getPanelHabitatArrayList() {
        return panelHabitatArrayList;
    }

    /**
     * Obtiene el número del hábitat seleccionado.
     *
     * @return Número del hábitat seleccionado
     */
    public int getNumeroHabitat() {
        return numeroHabitat;
    }

    /**
     * Establece el número del hábitat seleccionado.
     *
     * @param numeroHabitat Número del hábitat seleccionado
     */
    public void setNumeroHabitat(int numeroHabitat) {
        this.numeroHabitat = numeroHabitat;
    }

    /**
     * Carga el botón de menú en el panel principal.
     *
     * @param panelPrincipal Panel principal al que se añade el botón de menú
     */
    public void cargarBotonMenu(PanelPrincipal panelPrincipal) {
        botonMenu = new BotonMenu(panelPrincipal);
        botonMenu.setBounds(0, 0, 1200, 700);
        botonMenu.setOpaque(false);
        botonMenu.setContentAreaFilled(false);
        panelPrincipal.add(botonMenu);
    }
}
