package Visual;

import logica.TipoHabitat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonCrearHabitat {
    private JButton boton;
    private JPopupMenu menu;

    public BotonCrearHabitat() {
        boton = new JButton("Habitat");
        menu = new JPopupMenu();

        for (TipoHabitat th : TipoHabitat.values()) {
            JMenuItem item = new JMenuItem(th.name());
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Seleccionado: " + th.name());
                }
            });
            menu.add(item);
        }

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.show(boton, boton.getWidth() / 2, boton.getHeight() / 2);
            }
        });
    }

    public JButton getBoton() {
        return boton;
    }
}
