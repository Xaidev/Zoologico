package Visual;

import logica.Habitat;

import javax.swing.*;
import java.util.ArrayList;

public class BotonEleccionHabitat extends JButton {

    public BotonEleccionHabitat(Habitat habitat, ArrayList<PanelHabitat> panelHabitats, int numeroHabitat){
        ActionListenerHabitat actionListenerHabitat = new ActionListenerHabitat(panelHabitats.get(numeroHabitat));
        this.addActionListener(actionListenerHabitat);
    }


}
