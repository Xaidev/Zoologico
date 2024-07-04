package Visual;

import javax.swing.*;

public class Ventana extends JFrame {
    private final PanelPrincipal panelPrincipal;

    public Ventana(){
        panelPrincipal = new PanelPrincipal();
        this.setTitle("Zoologico");
        this.setSize(1200,700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelPrincipal);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
