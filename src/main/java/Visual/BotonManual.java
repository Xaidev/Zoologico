package Visual;

import javax.swing.*;

public class BotonManual extends JButton {

    public BotonManual(PanelManual panel){
        super("Manual Animales");
        this.setBounds(100,0,100,50);
        this.setOpaque(false);
        this.setVisible(true);

        ActionListenerBotonManualAnimales actionListener = new ActionListenerBotonManualAnimales(panel);
        this.addActionListener(actionListener);
    }
}
