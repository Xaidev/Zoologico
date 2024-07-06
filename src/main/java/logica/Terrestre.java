package logica;

import javax.swing.*;

public abstract class Terrestre extends Animal {
    public Terrestre(Temperatura tem,Tamaño espacioHabitat)
    {
        super(TipoHabitat.TERRESTRE,tem,espacioHabitat);
    }

    @Override
    public void alimentar() {

    }
    int dir = 0;
    @Override
    public void desplazarse() {
        JLabel label = super.animalLabel;

        random = Math.random()*100;
        int changeDir = (int) Math.floor(random);
        random = Math.random()*100;
        int ranX = (int) Math.floor(random);

        if(changeDir % 4 == 1){
            dir = ranX%2;
        }

        if(label.getX() > 800 - super.ySize)
            dir = 1;
        if(label.getX() < 20)
            dir = 0;

        for(int i = 0; i < 7 ; i++){
            if(dir == 0)
                label.setLocation(label.getX()+1,label.getY());
            if(dir == 1)
                label.setLocation(label.getX()-1,label.getY());
        }
    }
}
