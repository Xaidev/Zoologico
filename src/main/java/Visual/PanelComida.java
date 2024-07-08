package Visual;

import logica.ComidaCarnivoro;
import logica.ComidaHerbivoro;
import logica.Habitat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComida extends JPanel {
    public PanelComida(Habitat h, PanelHabitat ph, PanelPrincipal panelPrincipal) {
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0, 0, 2000, 2000);

        int startPosY = 500;
        int heigthButton = 30;
        JLabel Title = new JLabel("AGREGAR COMIDA:");
        Title.setBounds(800, startPosY - 20, 300, 20);
        this.add(Title);

        PanelGridComidas panelGridComidas = new PanelGridComidas(800, startPosY + heigthButton, h, ph, panelPrincipal);
        this.add(panelGridComidas);

        JButton AgregarComidaCarnivoro = new JButton("Carnivoro");
        AgregarComidaCarnivoro.setBounds(800, startPosY, 100, heigthButton);
        JButton AgregarComidaHervivoro = new JButton("Hebivoro");
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
                    System.out.println("elpepe");
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
                    System.out.println("etesech");
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

/*
    JButton AgregarComidaOmnivoro = new JButton("Omnivoro");
    AgregarComidaOmnivoro.setBounds(1000,startPosY,100,heigthButton);
    AgregarComidaOmnivoro.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            h.getDeposito().addObjeto(new ComidaOmnivoro());
            Thread.sleep(200);
            panelGridComidas.drawComidas();
        }catch (Exception error){
            System.out.println(error.toString());
            System.out.println("asd");
        }

    }
    this.add(AgregarComidaOmnivoro);
});
*/