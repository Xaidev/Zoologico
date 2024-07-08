package Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * PanelAvisos es una clase que representa un panel que muestra avisos en forma de etiquetas.
 * Extiende de JPanel y permite agregar, verificar y limpiar avisos mostrados en el panel.
 */
public class PanelAvisos extends JPanel {

    /**
     * Lista de etiquetas donde se muestran los avisos.
     */
    public ArrayList<JLabel> spaces;

    /**
     * Constructor de la clase PanelAvisos.
     *
     * @param interior Indica si el panel está en un entorno interior (true) o no (false).
     */
    public PanelAvisos(boolean interior) {
        this.setLayout(new GridLayout(5, 0, 0, 0));
        this.setOpaque(false);

        spaces = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            JLabel aux = new JLabel();
            if (!interior)
                aux.setForeground(Color.white);
            spaces.add(aux);
            this.add(aux);
        }
        for (int i = 0; i < 5; i++) {
            spaces.get(i).setText("");
        }

        this.setVisible(true);
    }

    /**
     * Agrega un aviso en la posición especificada del panel.
     *
     * @param aviso El texto del aviso a agregar.
     * @param i     La posición donde se agregará el aviso.
     */
    public void addAviso(String aviso, int i) {
        spaces.get(i % 5).setText(aviso);
    }

    /**
     * Verifica si un aviso ya está presente en el panel.
     *
     * @param s El texto del aviso a verificar.
     * @return true si el aviso está presente, false en caso contrario.
     */
    public boolean repetido(String s) {
        for (int i = 0; i < 5; i++) {
            if (spaces.get(i).getText().equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Limpia el aviso en la posición especificada del panel.
     *
     * @param i La posición del aviso a limpiar.
     */
    public void clearAviso(int i) {
        spaces.get(i).setText("");
    }

    /**
     * Limpia todos los avisos con un texto específico en el panel.
     *
     * @param s El texto del aviso a limpiar.
     */
    public void clearAvisos(String s) {
        for (int i = 0; i < 5; i++) {
            if (spaces.get(i).getText().equals(s)) {
                spaces.get(i).setText("");
            }
        }
    }
}
