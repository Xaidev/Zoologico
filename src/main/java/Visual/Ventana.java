package Visual;

import logica.AnimalsThreadPorHabitat;
import logica.Habitat;

import javax.swing.*;
import java.util.ArrayList;

public class Ventana extends JFrame {
    public final PanelPrincipal panelPrincipal;

    public Ventana(){
        panelPrincipal = new PanelPrincipal();
        this.setTitle("Zoologico");
        this.setSize(1200,700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelPrincipal);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }

    public static void addAnimalThread(Habitat h){
        AnimalsThreadPorHabitat aux = new AnimalsThreadPorHabitat(h.getAnimals());
    }
}
