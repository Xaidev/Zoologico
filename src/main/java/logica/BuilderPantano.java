package logica;

/**
 * Clase que implementa el patrón de diseño Builder para construir un hábitat de pantano.
 */
public class BuilderPantano implements HabitatBuilder {
    private TipoSuelo tipoSuelo;
    private Vegetacion vegetacion;
    private Temperatura temperatura;
    private Tamaño tamaño;

    /**
     * Establece el tipo de suelo para el hábitat.
     *
     * @param tipoSuelo El tipo de suelo.
     * @return La instancia del builder.
     */
    @Override
    public HabitatBuilder setTipoSuelo(TipoSuelo tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
        return this;
    }

    /**
     * Establece la vegetación para el hábitat.
     *
     * @param vegetacion La vegetación.
     * @return La instancia del builder.
     */
    @Override
    public HabitatBuilder setVegetacion(Vegetacion vegetacion) {
        this.vegetacion = vegetacion;
        return this;
    }

    /**
     * Establece la temperatura para el hábitat.
     *
     * @param temperatura La temperatura.
     * @return La instancia del builder.
     */
    @Override
    public HabitatBuilder setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
        return this;
    }

    /**
     * Establece el tamaño del hábitat.
     *
     * @param tamaño El tamaño del hábitat.
     * @return La instancia del builder.
     */
    @Override
    public HabitatBuilder setTamaño(Tamaño tamaño) {
        this.tamaño = tamaño;
        return this;
    }

    /**
     * Construye y devuelve el hábitat configurado.
     *
     * @return El hábitat configurado.
     */
    @Override
    public Habitat build() {
        return new Habitat(tipoSuelo, vegetacion, temperatura, tamaño, TipoHabitat.TERRESTRE);
    }
}
