package Visual;

import logica.Animal;
import logica.Habitat;

import javax.swing.*;

public class DibujarAnimales extends JPanel {
    public DibujarAnimales(Habitat h,PanelHabitat panel){
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0,0,2000,2000);
        panel.add(this);

        for (Animal a : h.getAnimals()){
            UpdateAnimal(a,panel);
        }
    }

    public void UpdateAnimal(Animal a,PanelHabitat panel){
        this.add(a.animalLabel);
        panel.crearImagen(a.animalLabel,a.getRutaImagen(),a.startX,a.startY,a.xSize,a.ySize);
    }
}
