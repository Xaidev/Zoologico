package Visual;

import javax.swing.*;


public class BotonRetroceder extends JButton {
    private final PanelPrincipal panelPrincipal;

    public BotonRetroceder(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.addActionListener(actionEvent -> {
            System.out.println("Botón retroceder presionado");
            BotonRetroceder.this.panelPrincipal.cambiarAPanelEleccionHabitat();
            this.setVisible(false);
        });
    }
}
