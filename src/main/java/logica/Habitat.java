package logica;

import java.util.ArrayList;

/**
 * Clase que representa un hábitat donde residen varios animales.
 */
public class Habitat {
    private final TipoSuelo tipoSuelo;
    private final Vegetacion vegetacion;
    private final Temperatura temperatura;
    private final Tamaño tamaño;
    private final TipoHabitat tipoHabitat;
    private final ArrayList<Animal> animals;
    private final Deposito deposito;
    private int numeroHabitat;

    /**
     * Constructor de la clase `Habitat` que inicializa sus atributos básicos.
     *
     * @param tipoSuelo    Tipo de suelo del hábitat.
     * @param vegetacion   Tipo de vegetación presente en el hábitat.
     * @param temperatura  Temperatura del hábitat.
     * @param tamaño       Tamaño del hábitat.
     * @param tipoHabitat  Tipo de hábitat (terrestre o acuático).
     */
    public Habitat(TipoSuelo tipoSuelo, Vegetacion vegetacion, Temperatura temperatura, Tamaño tamaño, TipoHabitat tipoHabitat) {
        this.tipoSuelo = tipoSuelo;
        this.vegetacion = vegetacion;
        this.temperatura = temperatura;
        this.tamaño = tamaño;
        this.tipoHabitat = tipoHabitat;
        this.animals = new ArrayList<>();
        this.deposito = new Deposito();
    }

    /**
     * Establece el número del hábitat.
     *
     * @param numeroHabitat Número del hábitat a establecer.
     */
    public void setNumeroHabitat(int numeroHabitat) {
        this.numeroHabitat = numeroHabitat;
    }

    /**
     * Obtiene el número del hábitat.
     *
     * @return Número del hábitat.
     */
    public int getNumeroHabitat() {
        return numeroHabitat;
    }

    /**
     * Agrega un animal al hábitat, verificando restricciones de cantidad y tipo de animal.
     *
     * @param animal Animal a agregar al hábitat.
     * @throws LimiteAnimalesExcedidoException Si se excede el límite de animales en el hábitat.
     */
    public void agregarAnimals(Animal animal) throws LimiteAnimalesExcedidoException {
        if (animal.getSolitario() == 1 && !animals.isEmpty()) {
            throw new LimiteAnimalesExcedidoException("No se pueden agregar un animal solitario");
        }
        for (Animal a : animals) {
            if (a.getSolitario() == 1) {
                throw new LimiteAnimalesExcedidoException("No se pueden agregar más animales solitarios");
            }
        }
        if (animals.size() == 5) {
            throw new LimiteAnimalesExcedidoException("No se pueden agregar más animales");
        }

        animals.add(animal);
    }

    /**
     * Verifica si es posible agregar un animal más al hábitat.
     *
     * @return `true` si es posible agregar un animal más, `false` si el límite está alcanzado.
     */
    public boolean puedeAgregarAnimal() {
        return animals.size() < 5;
    }

    /**
     * Obtiene la lista de animales presentes en el hábitat.
     *
     * @return Lista de animales en el hábitat.
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * Verifica si hay algún animal en el hábitat con hambre.
     *
     * @return `true` si hay al menos un animal con hambre, `false` en caso contrario.
     */
    public boolean hayHambre() {
        for (Animal a : animals) {
            if (a.getHambrePercent() >= 100) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si una especie específica de animal en el hábitat tiene hambre.
     *
     * @param s Nombre de la especie del animal.
     * @return `true` si al menos un animal de la especie especificada tiene hambre, `false` en caso contrario.
     */
    public boolean especieConHambre(String s) {
        for (Animal a : animals) {
            if (a.getClass().getSimpleName().equals(s) && a.getHambrePercent() >= 100) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene el tipo de suelo del hábitat.
     *
     * @return Tipo de suelo del hábitat.
     */
    public TipoSuelo getTipoSuelo() {
        return tipoSuelo;
    }

    /**
     * Obtiene el tipo de vegetación presente en el hábitat.
     *
     * @return Tipo de vegetación del hábitat.
     */
    public Vegetacion getVegetacion() {
        return vegetacion;
    }

    /**
     * Obtiene la temperatura del hábitat.
     *
     * @return Temperatura del hábitat.
     */
    public Temperatura getTemperatura() {
        return temperatura;
    }

    /**
     * Obtiene el tamaño del hábitat.
     *
     * @return Tamaño del hábitat.
     */
    public Tamaño getTamaño() {
        return tamaño;
    }

    /**
     * Obtiene el tipo de hábitat (terrestre o acuático).
     *
     * @return Tipo de hábitat.
     */
    public TipoHabitat getTipoHabitat() {
        return tipoHabitat;
    }

    /**
     * Obtiene el depósito de comida asociado al hábitat.
     *
     * @return Depósito de comida del hábitat.
     */
    public Deposito getDeposito() {
        return deposito;
    }

    /**
     * Método toString que proporciona una representación en cadena del objeto `Habitat`.
     *
     * @return Representación en cadena del hábitat.
     */
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
