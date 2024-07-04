package logica;

public class BuilderJungla implements HabitatBuilder {
    private TipoSuelo tipoSuelo;
    private Vegetacion vegetacion;
    private Temperatura temperatura;
    private Tamaño tamaño;

    @Override
    public HabitatBuilder setTipoSuelo(TipoSuelo tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
        return this;
    }

    @Override
    public HabitatBuilder setVegetacion(Vegetacion vegetacion) {

        this.vegetacion = vegetacion;
        return this;
    }

    @Override
    public HabitatBuilder setTemperatura(Temperatura temperatura) {

        this.temperatura = temperatura;
        return this;
    }

    @Override
    public HabitatBuilder setTamaño(Tamaño tamaño) {
        this.tamaño = tamaño;
        return this;
    }

    @Override
    public Habitat build() {
        return new Habitat(tipoSuelo, vegetacion, temperatura, tamaño, TipoHabitat.TERRESTRE);
    }
}