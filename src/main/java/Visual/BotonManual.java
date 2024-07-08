package Visual;

import javax.swing.*;

/**
 * BotonManual es una clase que representa un botón para abrir el manual de animales.
 */
public class BotonManual extends JButton {

    /**
     * Constructor de la clase BotonManual.
     *
     * @param panel El panel al que está asociado el botón para abrir el manual de animales.
     */
    public BotonManual(PanelManual panel) {
        super("Manual Animales");
        this.setBounds(100, 0, 100, 50);
        this.setOpaque(false);
        this.setVisible(true);

        ActionListenerBotonManualAnimales actionListener = new ActionListenerBotonManualAnimales(panel);
        this.addActionListener(actionListener);
    }
}
