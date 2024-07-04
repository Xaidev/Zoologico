package logica;

import javax.swing.*;
import java.util.ArrayList;

public class AnimalsThreadPorHabitat {
    private ArrayList<Animal> animals;

    public void Eventos(){
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
                        Thread.sleep(200);
                        Eventos();
                    } catch (Exception e){
                        System.out.println("Fallo en la hebra");
                        break;
                    }
                }
            }
        };
        hilo.start();
    }
}