package logica;

import javax.swing.*;

public abstract class Acuatico extends Animal {
    public Acuatico(Temperatura tem,Tamaño espacioHabitat)
    {
        super(TipoHabitat.ACUATICO,tem,espacioHabitat);
    }

    @Override
    public void alimentar() {

    }
    @Override
    public void desplazarse() {
        JLabel label = super.animalLabel;
        label.setLocation(label.getX()+9,label.getY());
    }
}
