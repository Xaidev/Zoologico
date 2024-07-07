package Visual;

import logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarAnimales extends JPanel {
    public PanelAgregarAnimales(int x, int y, Habitat habitat, PanelHabitat panelHabitat) {
        DibujarAnimales panelDibujarAnimales = new DibujarAnimales(habitat, panelHabitat);

        this.setBounds(x, y, 200, 700);
        this.setVisible(true);
        this.setOpaque(false);


        SelectorAnimal[] nombresAnimales = SelectorAnimal.values();
        this.setLayout(new GridLayout(nombresAnimales.length + 1, 1));

        JLabel labelTitle = new JLabel("Animales Disponibles");
        this.add(labelTitle);

        FiltroSelectorAnimal filtro = new FiltroSelectorAnimal(habitat);

        for (SelectorAnimal a : nombresAnimales) {
            if (!filtro.adaptabilidadAnimal(a))
                continue;

            JButton b = new JButton(a.name());
            b.addActionListener(e -> {
                try {
                    Animal aux = filtro.crearAnimal(a);
                    aux.setPanelPrincipal(panelHabitat.getPanelPrincipal());
                    habitat.agregarAnimals(aux);
                    panelDibujarAnimales.UpdateAnimal(aux, panelHabitat);
                } catch (LimiteAnimalesExcedidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
