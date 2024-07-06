package logica;

/**
 * Clase que se encarga de construir un habitat
 */
public class HabitatDirector {
    private HabitatBuilder builder;

    /**
     * Constructor de la clase
     */
    public void setBuilder(HabitatBuilder builder) {
        this.builder = builder;
    }

    /**
     * Construye un habitat con los atributos dados
     * @param tipoSuelo Tipo de suelo del habitat
     * @param vegetacion Vegetacion del habitat
     * @param temperatura Temperatura del habitat
     * @param tamaño Tamaño del habitat
     * @return Habitat construido
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