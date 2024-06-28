package Visual;

import javax.swing.*;

public class BotonMenu extends JButton {

    public BotonMenu(PanelPrincipal panelPrincipal){
        this.setOpaque(false);
        this.addActionListener(actionEvent -> {
            panelPrincipal.cambiarAPanelHabitat();
        });
    }
}
