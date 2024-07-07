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
    private Deposito deposito;

    public Habitat(TipoSuelo tipoSuelo, Vegetacion vegetacion, Temperatura temperatura, Tamaño tamaño, TipoHabitat tipoHabitat) {
        this.tipoSuelo = tipoSuelo;
        this.vegetacion = vegetacion;
        this.temperatura = temperatura;
        this.tamaño = tamaño;
        this.tipoHabitat = tipoHabitat;
        this.animals = new ArrayList<>();
        this.deposito = new Deposito();
    }

    public void agregarAnimals(Animal animal) throws LimiteAnimalesExcedidoException {
        if(animal.getSolitario() == 1 && !animals.isEmpty()){
            throw new LimiteAnimalesExcedidoException("No se pueden agregar un animal solitario");
        }
        for(Animal a : animals){
            if(a.getSolitario() == 1){
                throw new LimiteAnimalesExcedidoException("No se pueden agregar mas animales solitarios");
            }
        }
        if(animals.size() == 5) {
            throw new LimiteAnimalesExcedidoException("No se pueden agregar mas animales");
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

    public Deposito getDeposito() {
        return deposito;
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