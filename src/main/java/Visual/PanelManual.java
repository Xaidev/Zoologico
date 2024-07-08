package Visual;


import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PanelManual extends JPanel {
    public ArrayList<JLabel> labels;

    public PanelManual(){
        this.setLayout(new GridLayout(5,0));
        labels = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            JLabel aux = new JLabel();
            labels.add(aux);
            this.add(aux);
        }
    }
    public void addTexto(String s, int i){
        labels.get(i).setText(s);
    }
}
