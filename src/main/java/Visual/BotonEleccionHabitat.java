package Visual;

import javax.swing.*;
/**
 * BotonEleccionHabitat
 */
public class BotonEleccionHabitat extends JButton {

    private final PanelPrincipal panelPrincipal;

    /**
     * Constructor de la clase BotonEleccionHabitat
     * @param panelPrincipal
     * @param numeroHabitat
     */
    public BotonEleccionHabitat(PanelPrincipal panelPrincipal, int numeroHabitat) {
        this.panelPrincipal = panelPrincipal;
        this.addActionListener(e -> {
            BotonEleccionHabitat.this.panelPrincipal.cambiarAPanelHabitat(numeroHabitat);
            BotonEleccionHabitat.this.panelPrincipal.setNumeroHabitat(numeroHabitat);
        });
    }
}
