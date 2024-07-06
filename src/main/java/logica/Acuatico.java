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
    int dirX = 0;
    int dirY = 0;
    @Override
    public void desplazarse() {
        JLabel label = super.animalLabel;

        random = Math.random()*100;
        int changeDir = (int) Math.floor(random);
        random = Math.random()*100;
        int ranY = (int) Math.floor(random);
        random = Math.random()*100;
        int ranX = (int) Math.floor(random);

        if(changeDir % 10 == 0){
            dirX = ranX%2;
            dirY = ranY%2;
        }

        if(label.getX() > 800 - super.xSize)
            dirX = 1;
        if(label.getX() < super.xSize)
            dirX = 0;
        if(label.getY() > 700 - super.ySize)
            dirY = 1;
        if(label.getY() < 0)
            dirY = 0;

        for(int i = 0; i < 10 ; i++){
            if(dirX == 0)
                label.setLocation(label.getX()+1,label.getY());
            if(dirX == 1)
                label.setLocation(label.getX()-1,label.getY());
            if(dirY == 0)
                label.setLocation(label.getX(),label.getY()+1);
            if(dirY == 1)
                label.setLocation(label.getX(),label.getY()-1);
        }
    }
}
