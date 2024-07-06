package logica;

import javax.swing.*;

public abstract class Volador extends Terrestre{
    public Volador(Temperatura tem,Tamaño espacioHabitat)
    {
        super(tem,espacioHabitat);
    }

    @Override
    public void alimentar() {

    }
    @Override
    public void desplazarse() {
        super.desplazarse();
        volar();
    }
    int yMove;
    void volar(){
        random = Math.random()*100;
        int changeDir = (int) Math.floor(random);

        int flyamount = 70;
        if(changeDir % 100 == 1 && super.animalLabel.getY() == super.startY){
            super.animalLabel.setLocation(super.animalLabel.getX(),super.animalLabel.getY()-flyamount);
        }
        if(changeDir % 4 == 0 && super.animalLabel.getY() == super.startY-flyamount){
            super.animalLabel.setLocation(super.animalLabel.getX(),super.animalLabel.getY()+flyamount);
        }
    }
}
