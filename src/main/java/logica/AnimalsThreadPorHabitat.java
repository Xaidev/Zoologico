package logica;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * Clase que maneja los hilos de los animales por hábitat.
 */
public class AnimalsThreadPorHabitat {
    private final ArrayList<Animal> animals;

    /**
     * Ejecuta los eventos de actualización para cada animal.
     *
     * @param thread El hilo que se está ejecutando.
     */
    public void Eventos(Thread thread) {
        for (Animal a : animals) {
            a.update(thread);
        }
    }

    /**
     * Constructor para la clase AnimalsThreadPorHabitat.
     *
     * @param a Lista de animales en el hábitat.
     */
    public AnimalsThreadPorHabitat(ArrayList<Animal> a) {
        animals = a;
        Thread hilo = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        Eventos(this);
                    } catch (ConcurrentModificationException e) {
                        continue;
                    } catch (Exception e) {
                        System.out.println(e);
                        break;
                    }
                }
            }
        };
        hilo.start();
    }
}
