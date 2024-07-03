package Visual;

import javax.swing.*;

public class BotonEleccionHabitat extends JButton {

    private final PanelPrincipal panelPrincipal;

    public BotonEleccionHabitat(PanelPrincipal panelPrincipal, int numeroHabitat) {
        this.panelPrincipal = panelPrincipal;
        this.addActionListener(e -> {
            BotonEleccionHabitat.this.panelPrincipal.cambiarAPanelHabitat(numeroHabitat);
            BotonEleccionHabitat.this.panelPrincipal.setNumeroHabitat(numeroHabitat);
        });
    }
}
