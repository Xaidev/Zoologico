package Visual;

import logica.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelGridComidas extends JPanel {
    private Habitat habitat;
    private Deposito comidas;
    private PanelPrincipal panelPr;
    private PanelHabitat panelHabitat;
    private ArrayList<JLabel> spaces;
    private int depositoTama;


    final int widthAllGrid = 400;
    public PanelGridComidas(int x, int y, Habitat h, PanelHabitat pH, PanelPrincipal panelPrincipal){
        habitat = h;
        panelHabitat = pH;
        panelPr = panelPrincipal;
        comidas = habitat.getDeposito();

        this.setOpaque(false);
        this.setLayout(new GridLayout(2,10));
        this.setBounds(x,y,widthAllGrid,widthAllGrid/4);

        spaces = new ArrayList<JLabel>();
        for (int i = 0; i < 10; i++){
            JLabel aux = new JLabel((i + 1) + "");
            spaces.add(aux);
            this.add(aux);
        }
        drawComidas();
    }

    public void drawComidas(){
        limpiarImagenes();
        comidas.setVisualDeposito(this);
        comidas.setVisualPrincipal(panelPr);
        if(comidas == null)
            return;
        System.out.println(comidas.getSize());

        for(int i = 0; i < comidas.getSize(); i++){
            try {
                if (comidas.lookObjeto(i) instanceof ComidaCarnivoro) {
                    crearImagen(spaces.get(i), "src/main/java/Visual/Imagenes/comidacarnivoro.png", 0, 0, 50, 50);
                } else if (comidas.lookObjeto(i) instanceof ComidaHerbivoro) {
                    crearImagen(spaces.get(i), "src/main/java/Visual/Imagenes/comidaherbivoro.png", 0, 0, 50, 50);
                } else if (comidas.lookObjeto(i) instanceof ComidaOmnivoro) {
                    crearImagen(spaces.get(i), "src/main/java/Visual/Imagenes/comidaomnivoro.png", 0, 0, 50, 50);
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al cargar las comidas");
                break;
            }
        }
    }

    public void limpiarImagenes(){
        for(int i = 0; i < 10; i++) {
            spaces.get(i).setIcon(null);
        }
        this.repaint();
    }

    public void crearImagen(JLabel label, String rutaImagen, int x, int y, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(rutaImagen);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        label.setIcon(newIcon);
        label.setBounds(x, y, ancho, alto);
        label.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
