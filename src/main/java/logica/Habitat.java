package logica;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Habitat {
    private TipoSuelo tipoSuelo;
    private Vegetacion vegetacion;
    private Temperatura temperatura;
    private Tamaño tamaño;
    private TipoHabitat tipoHabitat;
    private ArrayList<Animal> animals;

    public Habitat(TipoSuelo tipoSuelo, Vegetacion vegetacion, Temperatura temperatura, Tamaño tamaño, TipoHabitat tipoHabitat) {
        this.tipoSuelo = tipoSuelo;
        this.vegetacion = vegetacion;
        this.temperatura = temperatura;
        this.tamaño = tamaño;
        this.tipoHabitat = tipoHabitat;
        this.animals = new ArrayList<>();
    }

    public void agregarAnimals(Animal animal) {
        animals.add(animal);
    }

    public TipoSuelo getTipoSuelo() {
        return tipoSuelo;
    }

    public Vegetacion getVegetacion() {
        return vegetacion;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public Tamaño getTamaño() {
        return tamaño;
    }

    public TipoHabitat getTipoHabitat() {
        return tipoHabitat;
    }
}