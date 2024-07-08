package Visual;

import logica.Animal;
import logica.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * PanelEleccionHabitats panel donde se eligen los espacios de los habitats
 */

public class PanelEleccionHabitats extends JPanel {
    private final ArrayList<Habitat> habitats;
    private final ArrayList<PanelHabitat> panelHabitats;
    private final ArrayList<Integer> numeroHabitats;
    private ArrayList<BotonEleccionHabitat> botonesEleccionHabitat;

    /**
     * Constructor de la clase PanelEleccionHabitats
     * @param panelPrincipal
     */
    public PanelEleccionHabitats(PanelPrincipal panelPrincipal) {
        this.setLayout(null);
        this.setOpaque(false);
        this.habitats = new ArrayList<>();
        this.panelHabitats = new ArrayList<>();
        this.numeroHabitats = new ArrayList<>();
        this.botonesEleccionHabitat = new ArrayList<>();
        this.setBounds(0, 0, 1200, 700);


        for (int i = 0; i < 4; i++) {
            habitats.add(null);
            panelHabitats.add(new PanelHabitat(habitats.get(i), i, panelPrincipal, this));
            numeroHabitats.add(i);
        }

        for(int i = 0; i < 4; i++){
            botonesEleccionHabitat.add(new BotonEleccionHabitat(panelPrincipal, numeroHabitats.get(i)));
        }


        botonesEleccionHabitat.get(0).setBounds(188, 75, 250, 250);
        this.add(botonesEleccionHabitat.get(0));

        botonesEleccionHabitat.get(1).setBounds(287, 341, 250, 250);
        this.add(botonesEleccionHabitat.get(1));


        botonesEleccionHabitat.get(2).setBounds(682, 83, 250, 250);
        this.add(botonesEleccionHabitat.get(2));


        botonesEleccionHabitat.get(3).setBounds(770, 351, 250, 250);
        this.add(botonesEleccionHabitat.get(3));

        PanelAvisos panelAvisos = panelPrincipal.getPanelAvisosEleccionHabitat();
        panelAvisos.setBounds(960, 20, 400, 100);
        this.add(panelAvisos);
        this.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        JLabel title = new JLabel();
        PanelHabitat.crearImagen(title,"src/main/java/Visual/Imagenes/MapadeHabitats.png",0,0,1184,662);
        this.add(title);
        super.paintComponent(g);
    }
    /**
     * Getter de los habitats
     * @return habitats
     */
    public ArrayList<PanelHabitat> getPanelHabitats() {
        return panelHabitats;
    }

    public ArrayList<BotonEleccionHabitat> getBotonesEleccionHabitat() {
        return botonesEleccionHabitat;
    }

    /**
     * Setter de los habitats
     * @param numeroHabitat
     * @param habitat
     */
    public void setHabitat(int numeroHabitat, Habitat habitat) {
        habitats.set(numeroHabitat, habitat);
    }

    /**
     * Funcion para ver el estado acutal de los habitats
     */
    public void imprimirEstadoActualHabitats() {
        System.out.println("Estado actual de los habitats:");
        int i = 1;
        for (Habitat habitat : habitats) {
            if (habitat != null) {
                System.out.println(habitat);
            } else {
                System.out.println("El habitat no ha sido creado" + i);
            }
            i++;
        }
    }
}
