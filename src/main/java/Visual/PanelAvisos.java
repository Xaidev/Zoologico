package Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelAvisos extends JPanel {

    public ArrayList<JLabel> spaces;


    public PanelAvisos(){
        this.setLayout(new GridLayout(5,0,0,0));
        this.setOpaque(false);

        spaces = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            JLabel aux = new JLabel();
            spaces.add(aux);
            this.add(aux);
        }
        for(int i = 0; i < 4 ; i++){
            spaces.get(i).setText("");
        }

        this.setVisible(true);
    }


    public void addAviso(String aviso, int i){
        spaces.get(i%4).setText(aviso);
    }

    public boolean repetido(String s){
        for(int i = 0; i < 4; i++){
            if(spaces.get(i).getText().equals(s)){
                return true;
            }
        }
        return false;
    }


    public void clearAviso(int i){
        spaces.get(i).setText("");
    }

    public void clearAvisos(String s){
        for(int i = 0; i < 4; i++){
            if(spaces.get(i).getText().equals(s)){
                spaces.get(i).setText("");
            }
        }
    }
}
