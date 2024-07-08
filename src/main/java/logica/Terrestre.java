package logica;

import javax.swing.*;

/**
 * Clase abstracta que representa animales terrestres.
 * Extiende la clase abstracta Animal e implementa el método desplazarse para el movimiento en pantalla.
 */
public abstract class Terrestre extends Animal {

    /**
     * Constructor de la clase Terrestre.
     *
     * @param tem           Temperatura adecuada para el animal terrestre.
     * @param espacioHabitat Tamaño del espacio necesario para el animal terrestre.
     */
    public Terrestre(Temperatura tem, Tamaño espacioHabitat) {
        super(TipoHabitat.TERRESTRE, tem, espacioHabitat);
    }

    int dir = 0;

    /**
     * Método que controla el desplazamiento del animal terrestre en la interfaz gráfica.
     * Utiliza un JLabel asociado al animal para moverlo horizontalmente de manera aleatoria.
     * Limita el movimiento dentro de los bordes de la pantalla.
     */
    @Override
    public void desplazarse() {
        JLabel label = super.animalLabel;

        double random = Math.random() * 100;
        int changeDir = (int) Math.floor(random);
        random = Math.random() * 100;
        int ranX = (int) Math.floor(random);

        if (changeDir % 4 == 1) {
            dir = ranX % 2;
        }

        if (label.getX() > 700 - super.ySize)
            dir = 1;
        if (label.getX() < 20)
            dir = 0;

        for (int i = 0; i < 100; i++) {
            if (dir == 0)
                label.setLocation(label.getX() + 1, label.getY());
            if (dir == 1)
                label.setLocation(label.getX() - 1, label.getY());
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
