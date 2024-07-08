package logica;

/**
 * Clase que dirige la construcción de un hábitat utilizando un builder.
 */
public class HabitatDirector {
    private HabitatBuilder builder;

    /**
     * Establece el builder a utilizar para la construcción del hábitat.
     *
     * @param builder Builder que construirá el hábitat.
     */
    public void setBuilder(HabitatBuilder builder) {
        this.builder = builder;
    }

    /**
     * Construye un hábitat con los atributos dados utilizando el builder configurado.
     *
     * @param tipoSuelo   Tipo de suelo del hábitat.
     * @param vegetacion  Tipo de vegetación del hábitat.
     * @param temperatura Temperatura del hábitat.
     * @param tamaño      Tamaño del hábitat.
     * @return Hábitat construido.
     * @throws IllegalStateException Si el builder no ha sido inicializado.
     */
    public Habitat construirHabitat(TipoSuelo tipoSuelo, Vegetacion vegetacion, Temperatura temperatura, Tamaño tamaño) {
        if (this.builder == null) {
            throw new IllegalStateException("Builder no ha sido inicializado");
        }
        return builder.setTipoSuelo(tipoSuelo)
                .setVegetacion(vegetacion)
                .setTemperatura(temperatura)
                .setTamaño(tamaño)
                .build();
    }
}
