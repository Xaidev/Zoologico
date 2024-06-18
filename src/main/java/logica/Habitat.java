package logica;

public class Habitat {
    private TipoSuelo tipoSuelo;
    private Vegetacion vegetacion;
    private Temperatura temperatura;
    private Tamaño tamaño;
    private TipoHabitat tipoHabitat;

    public Habitat(TipoSuelo tipoSuelo, Vegetacion vegetacion, Temperatura temperatura, Tamaño tamaño, TipoHabitat tipoHabitat) {
        this.tipoSuelo = tipoSuelo;
        this.vegetacion = vegetacion;
        this.temperatura = temperatura;
        this.tamaño = tamaño;
        this.tipoHabitat = tipoHabitat;
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