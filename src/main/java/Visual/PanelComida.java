package Visual;

import logica.ComidaCarnivoro;
import logica.ComidaHerbivoro;
import logica.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PanelComida es una clase que representa un panel para la gestión de comida dentro de un hábitat.
 * Extiende de JPanel y contiene botones para agregar comida carnivora y herbívora, así como para limpiar el depósito de comida.
 */
public class PanelComida extends JPanel {

    /**
     * Constructor de la clase PanelComida.
     *
     * @param h             El hábitat asociado donde se gestionará la comida.
     * @param ph            El panel principal donde se mostrarán los cambios.
     * @param panelPrincipal El panel principal de la aplicación.
     */
    public PanelComida(Habitat h, PanelHabitat ph, PanelPrincipal panelPrincipal) {
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0, 0, 2000, 2000);

        int startPosY = 500;
        int heigthButton = 30;
        JLabel Title = new JLabel("AGREGAR COMIDA:");
        Title.setForeground(Color.white);
        Title.setBounds(800, startPosY - 20, 300, 20);
        this.add(Title);

        PanelGridComidas panelGridComidas = new PanelGridComidas(800, startPosY + heigthButton, h, ph, panelPrincipal);
        this.add(panelGridComidas);

        JButton AgregarComidaCarnivoro = new JButton("Carnivoro");
        AgregarComidaCarnivoro.setBounds(800, startPosY, 100, heigthButton);
        JButton AgregarComidaHervivoro = new JButton("Herbivoro");
        AgregarComidaHervivoro.setBounds(900, startPosY, 100, heigthButton);
        JButton LimpiarComida = new JButton("Borrar");
        LimpiarComida.setBounds(1100, startPosY, 80, heigthButton);

        AgregarComidaCarnivoro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    h.getDeposito().addObjeto(new ComidaCarnivoro());
                    Thread.sleep(200);
                    panelGridComidas.drawComidas();
                } catch (Exception error) {
                    System.out.println(error);
                }
            }
        });

        AgregarComidaHervivoro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    h.getDeposito().addObjeto(new ComidaHerbivoro());
                    Thread.sleep(200);
                    panelGridComidas.drawComidas();
                } catch (Exception error) {
                    System.out.println(error);
                }

            }
        });

        LimpiarComida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                h.getDeposito().limpiarDeposito();
                panelGridComidas.limpiarImagenes();
            }
        });

        this.add(AgregarComidaCarnivoro);
        this.add(AgregarComidaHervivoro);
        this.add(LimpiarComida);
    }
}
