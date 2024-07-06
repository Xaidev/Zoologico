package Visual;

import javax.swing.*;
/**
 * BotonMenu
 */
public class BotonMenu extends JButton {
    private final PanelPrincipal panelPrincipal;
    /**
     * Constructor de la clase BotonMenu
     * @param panelPrincipal
     */
    public BotonMenu(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.addActionListener(e -> {
            BotonMenu.this.panelPrincipal.cambiarAPanelEleccionHabitatDesdeMenu();
            BotonMenu.this.setVisible(false);
        });
    }
}
