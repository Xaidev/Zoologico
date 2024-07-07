package Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelAvisos extends JPanel {

    private ArrayList<JLabel> spaces;


    public PanelAvisos(){
        this.setLayout(new GridLayout(4,0,0,0));
        this.setOpaque(false);
        this.setBounds(800,350,400,100);

        spaces = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            JLabel aux = new JLabel();
            spaces.add(aux);
            this.add(aux);
        }
        //Prueba
        addAviso("XD", 0);
        addAviso("XDDDD", 1);
        addAviso("XDDDDDDDDD", 2);
        addAviso("XDDDDDDDDDDDDDD", 3);
        this.setVisible(true);
    }


    public void addAviso(String aviso, int i){
        spaces.get(i).setText(aviso);
        System.out.println(spaces.get(i).getText());
    }

    public void clearAvisos(){
        this.removeAll();
    }

    public void updateAvisos(){
        this.repaint();
    }


}
