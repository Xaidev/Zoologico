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
    private Deposito<Comida> comida;

    public Habitat(TipoSuelo tipoSuelo, Vegetacion vegetacion, Temperatura temperatura, Tamaño tamaño, TipoHabitat tipoHabitat) {
        comida = new Deposito<Comida>(10);
        this.tipoSuelo = tipoSuelo;
        this.vegetacion = vegetacion;
        this.temperatura = temperatura;
        this.tamaño = tamaño;
        this.tipoHabitat = tipoHabitat;
        this.animals = new ArrayList<>();
    }

    public void agregarAnimals(Animal animal) throws LimiteAnimalesExcedidoException {
        boolean existeJaguarOsoPolar = animals.stream().anyMatch(a -> a instanceof Jaguar || a instanceof OsoPolar);

        if ( animal instanceof OsoPolar && existeJaguarOsoPolar) {
            throw new LimiteAnimalesExcedidoException("No se puede agregar más de un Oso Polar");
        }
        if(animal instanceof Jaguar && existeJaguarOsoPolar){
            throw new LimiteAnimalesExcedidoException("No se puede agregar más de un Jaguar");
        }

        if (existeJaguarOsoPolar || animals.size() >= 5) {
            throw new LimiteAnimalesExcedidoException("No se pueden agregar más animales");
        }
        animals.add(animal);
    }

    public boolean puedeAgregarAnimal() {
        return animals.size() < 5;
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
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

    public Deposito<Comida> getComida(){
        return comida;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "tipoSuelo=" + tipoSuelo +
                ", vegetacion=" + vegetacion +
                ", temperatura=" + temperatura +
                ", tamaño=" + tamaño +
                ", tipoHabitat=" + tipoHabitat +
                '}';
    }
}