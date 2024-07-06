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
        try {
            volar();
        } catch (InterruptedException e) {
            System.out.println("Error en volar");
        }
    }
    int yMove;
    void volar() throws InterruptedException {
        random = Math.random()*100;
        int changeDir = (int) Math.floor(random);

        int flyamount = 10;
        if(changeDir % 10 == 1 && super.animalLabel.getY() == super.startY){
            for (int i = flyamount; i > 0; i--) {
                super.animalLabel.setLocation(super.animalLabel.getX(), super.animalLabel.getY() - flyamount);
                super.thread.sleep(10);
            }
        }
        if(changeDir % 2 == 1 && super.animalLabel.getY() < super.startY){
            for (int i = flyamount; i > 0; i--) {
                super.animalLabel.setLocation(super.animalLabel.getX(), super.animalLabel.getY() + 1);
                super.thread.sleep(10);
            }
        }
    }
}
