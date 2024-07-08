package Visual;


import logica.SelectorAnimal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelManual extends JPanel {
    public ArrayList<JLabel> labels;

    public PanelManual() {
        this.setLayout(new GridLayout(SelectorAnimal.values().length, 0));
        labels = new ArrayList<>();
        for (int i = 0; i < SelectorAnimal.values().length; i++) {
            JLabel aux = new JLabel();
            labels.add(aux);
            this.add(aux);
        }
    }

    public void addTexto(String s, int i) {
        labels.get(i).setText(s);
    }
}
