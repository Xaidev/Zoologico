package Visual;

import logica.ComidaCarnivoro;
import logica.ComidaHerbivoro;
import logica.ComidaOnnivoro;
import logica.Habitat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComida extends JPanel{
    public PanelComida(Habitat h, PanelHabitat ph){
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0,0,2000,2000);

        int startPosY = 500;
        int heigthButton = 30;
        JLabel Title = new JLabel("AGREGAR COMIDA:");
        Title.setBounds(800,startPosY-20,300,20);
        this.add(Title);

        PanelGridComidas panelGridComidas = new PanelGridComidas(800,startPosY+heigthButton,h,ph);
        this.add(panelGridComidas);

        JButton AgregarComidaCarnivoro = new JButton("Carnivoro");
        AgregarComidaCarnivoro.setBounds(800,startPosY,100,heigthButton);
        JButton AgregarComidaHervivoro = new JButton("Hervivoro");
        AgregarComidaHervivoro.setBounds(900,startPosY,100,heigthButton);
        JButton AgregarComidaOmnivoro = new JButton("Omnivoro");
        AgregarComidaOmnivoro.setBounds(1000,startPosY,100,heigthButton);
        JButton LimpiarComida = new JButton("Borrar");
        LimpiarComida.setBounds(1100,startPosY,80,heigthButton);

        AgregarComidaOmnivoro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    h.getDeposito().addObjeto(new ComidaOnnivoro());
                }catch (Exception error){
                    System.out.println(error.toString());
                }
                panelGridComidas.drawComidas();
            }
        });
        AgregarComidaCarnivoro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    h.getDeposito().addObjeto(new ComidaCarnivoro());
                }catch (Exception error){
                    System.out.println(error.toString());
                }
                panelGridComidas.drawComidas();
            }
        });
        AgregarComidaHervivoro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    h.getDeposito().addObjeto(new ComidaHerbivoro());
                }catch (Exception error){
                    System.out.println(error.toString());
                }
                panelGridComidas.drawComidas();
            }
        });
        LimpiarComida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                h.getDeposito().limpiarDeposito();
                panelGridComidas.drawComidas();
            }
        });

        this.add(AgregarComidaCarnivoro);
        this.add(AgregarComidaHervivoro);
        this.add(AgregarComidaOmnivoro);
        this.add(LimpiarComida);
    }
}
