package Visual;

import logica.Habitat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ActionListenerHabitat implements ActionListener {
    private PanelHabitat panelHabitat;
    public ActionListenerHabitat(PanelHabitat panelHabitat){
        this.panelHabitat = panelHabitat;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        panelHabitat.repaint();
    }
}
