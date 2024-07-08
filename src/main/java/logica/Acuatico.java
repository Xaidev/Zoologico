package logica;

import javax.swing.*;

/**
 * Clase abstracta que representa a un animal acuático.
 */
public abstract class Acuatico extends Animal {

    /**
     * Constructor para un objeto Acuatico.
     *
     * @param tem          La temperatura del hábitat.
     * @param espacioHabitat El tamaño del hábitat.
     */
    public Acuatico(Temperatura tem, Tamaño espacioHabitat) {
        super(TipoHabitat.ACUATICO, tem, espacioHabitat);
    }

    int dirX = 0;
    int dirY = 0;

    /**
     * Método que define cómo se desplaza el animal acuático.
     * Se mueve en la dirección X y Y de acuerdo a reglas predefinidas y aleatorias.
     */
    @Override
    public void desplazarse() {
        JLabel label = super.animalLabel;

        random = Math.random() * 100;
        int changeDir = (int) Math.floor(random);
        random = Math.random() * 100;
        int ranY = (int) Math.floor(random);
        random = Math.random() * 100;
        int ranX = (int) Math.floor(random);

        if (changeDir % 10 == 0) {
            dirX = ranX % 3;
            dirY = ranY % 3;
        }

        if (label.getX() > 700 - super.xSize)
            dirX = 1;
        if (label.getX() < super.xSize)
            dirX = 0;
        if (label.getY() > 700 - super.ySize)
            dirY = 1;
        if (label.getY() < 0)
            dirY = 0;

        for (int i = 0; i < 100; i++) {
            if (dirX == 0)
                label.setLocation(label.getX() + 1, label.getY());
            if (dirX == 1)
                label.setLocation(label.getX() - 1, label.getY());
            if (dirY == 0)
                label.setLocation(label.getX(), label.getY() + 1);
            if (dirY == 1)
                label.setLocation(label.getX(), label.getY() - 1);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
