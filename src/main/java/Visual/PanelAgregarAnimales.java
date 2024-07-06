package Visual;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAgregarAnimales extends JPanel {
    public PanelAgregarAnimales(int x, int y, Habitat habitat, PanelHabitat panelHabitat) {
        DibujarAnimales panelDibujarAnimales = new DibujarAnimales(habitat, panelHabitat);

        this.setBounds(x, y, 200, 700);
        this.setVisible(true);


        SelectorAnimal[] nombresAnimales = SelectorAnimal.values();
        this.setLayout(new GridLayout(nombresAnimales.length + 1, 1));

        JLabel labelTitle = new JLabel("Animales Disponibles");
        this.add(labelTitle);

        FiltroSelectorAnimal filtro = new FiltroSelectorAnimal(habitat);

        for (SelectorAnimal a : nombresAnimales) {
            if (!filtro.adaptabilidadAnimal(a))
                continue;

            JButton b = new JButton(a.name());
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Animal aux = filtro.crearAnimal(a);
                    try {
                        habitat.agregarAnimals(aux);
                    } catch (LimiteAnimalesExcedidoException ex) {
                        throw new RuntimeException(ex);
                    }
                    panelDibujarAnimales.UpdateAnimal(aux, panelHabitat);
                }
            });
            this.add(b);
        }

        Ventana.addAnimalThread(habitat);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
