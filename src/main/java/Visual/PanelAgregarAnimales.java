package Visual;

import logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarAnimales extends JPanel {
    public PanelAgregarAnimales(int x, int y, Habitat habitat, PanelHabitat panelHabitat, PanelManual panelManual) {
        DibujarAnimales panelDibujarAnimales = new DibujarAnimales(habitat, panelHabitat);
        JLabel labelTitle;
        this.setBounds(x, y, 300, 700);
        this.setVisible(true);
        this.setOpaque(false);


        SelectorAnimal[] nombresAnimales = SelectorAnimal.values();
        this.setLayout(new GridLayout(nombresAnimales.length + 1, 1));

        FiltroSelectorAnimal filtro = new FiltroSelectorAnimal(habitat);

        int i = 0;
        labelTitle = new JLabel("Animales Disponibles");
        this.add(labelTitle);

        for (SelectorAnimal a : nombresAnimales) {
            if (!filtro.adaptabilidadAnimal(a))
                continue;

            Animal tipoAnimal = filtro.crearAnimal(a);
            panelManual.addTexto(tipoAnimal.getClass().getSimpleName() + " requiere de comida de tipo: " + tipoAnimal.getTipoComida(), i);
            i++;
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
        if (i == 0) {
            labelTitle.setText("No hay animales disponibles");
        }
        Ventana.addAnimalThread(habitat);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
