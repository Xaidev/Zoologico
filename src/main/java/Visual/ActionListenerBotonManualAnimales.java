package Visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener para el botón que abre el panel manual de animales.
 */
public class ActionListenerBotonManualAnimales implements ActionListener {
    private final PanelManual panel;

    /**
     * Constructor que inicializa el ActionListener con el panel que se abrirá al hacer clic en el botón.
     *
     * @param panel El PanelManual que se abrirá en una nueva ventana.
     */
    public ActionListenerBotonManualAnimales(PanelManual panel) {
        this.panel = panel;
    }

    /**
     * Método que se ejecuta cuando se realiza la acción (clic en el botón).
     * Crea una nueva ventana y agrega el panel manual de animales.
     *
     * @param e Evento de acción generado por el botón.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame nuevaVentana = new JFrame("Manual Animales");
        nuevaVentana.setSize(600, 400);
        nuevaVentana.setResizable(false);
        nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            nuevaVentana.getContentPane().add(panel);
            nuevaVentana.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
