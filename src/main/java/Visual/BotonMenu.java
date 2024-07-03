package Visual;

import javax.swing.*;

public class BotonMenu extends JButton {
    private final PanelPrincipal panelPrincipal;

    public BotonMenu(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.addActionListener(e -> {
            BotonMenu.this.panelPrincipal.cambiarAPanelEleccionHabitatDesdeMenu();
            BotonMenu.this.setVisible(false);
        });
    }
}
