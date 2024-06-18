package Visual;

import javax.swing.*;


public class PanelPrincipal extends JPanel {
    private final PanelMenu panelMenu;

    public PanelPrincipal(){
        this.setLayout(null);
        panelMenu = new PanelMenu();
        this.add(panelMenu);
    }
}

