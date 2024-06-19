package Visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonRetroceder extends JButton {
    public BotonRetroceder(PanelHabitat panelHabitat, PanelEleccionHabitats panelEleccionHabitats){
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelHabitat.setVisible(false);
                panelEleccionHabitats.setVisible(true);
            }
        });
    }
}
