package Visual;

import logica.Animal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerBotonManualAnimales implements ActionListener {
    private PanelManual panel;

    public ActionListenerBotonManualAnimales(PanelManual panel){
        this.panel = panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame nuevaVentana = new JFrame("Manual Animales");
        nuevaVentana.setSize(600, 400);
        nuevaVentana.setResizable(false);
        nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try{
            nuevaVentana.getContentPane().add(panel);
            nuevaVentana.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
