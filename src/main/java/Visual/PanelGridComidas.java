package Visual;

import logica.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelGridComidas extends JPanel {
    private Habitat habitat;
    private Deposito<Comida> comidas;
    private PanelHabitat panelHabitat;
    private ArrayList<JLabel> spaces;

    final int cantComida = 10;
    final int widthAllGrid = 400;
    public PanelGridComidas(int x, int y, Habitat h, PanelHabitat pH){
        habitat = h;
        panelHabitat = pH;
        comidas = habitat.getDeposito();

        this.setOpaque(false);
        this.setLayout(new GridLayout(2,cantComida));
        this.setBounds(x,y,widthAllGrid,widthAllGrid/4);

        spaces = new ArrayList<JLabel>();
        for (int i = 0; i < cantComida; i++){
            JLabel aux = new JLabel((i + 1) + "");
            spaces.add(aux);
            this.add(aux);
        }
        drawComidas();
    }

    public void drawComidas(){
        if(comidas == null)
            return;

        for(int i = 0; i < cantComida; i++){
            try {
                comidas.lookObjeto(i);
            }
            catch (Exception e){
                System.out.println(e.toString());
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
