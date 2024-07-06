package logica;

import javax.swing.*;
import java.util.ArrayList;

public class AnimalsThreadPorHabitat {
    private ArrayList<Animal> animals;

    public void Eventos(Thread thread){
        for (Animal a: animals){
            a.update();
        }
    }

    public AnimalsThreadPorHabitat(ArrayList<Animal> a){
        animals = a;
        Thread hilo = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                        Eventos(this);
                    } catch (Exception e){
                        System.out.println(e.toString());
                        break;
                    }
                }
            }
        };
        hilo.start();
    }
}
