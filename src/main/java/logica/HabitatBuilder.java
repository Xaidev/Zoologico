package logica;

/**
 * Interfaz que define los métodos necesarios para construir un hábitat.
 */
public interface HabitatBuilder {
    /**
     * Establece el tipo de suelo del hábitat.
     *
     * @param tipoSuelo Tipo de suelo a establecer.
     * @return Instancia del builder para encadenamiento de métodos.
     */
    HabitatBuilder setTipoSuelo(TipoSuelo tipoSuelo);

    /**
     * Establece el tipo de vegetación del hábitat.
     *
     * @param vegetacion Tipo de vegetación a establecer.
     * @return Instancia del builder para encadenamiento de métodos.
     */
    HabitatBuilder setVegetacion(Vegetacion vegetacion);

    /**
     * Establece la temperatura del hábitat.
     *
     * @param temperatura Temperatura a establecer.
     * @return Instancia del builder para encadenamiento de métodos.
     */
    HabitatBuilder setTemperatura(Temperatura temperatura);

    /**
     * Establece el tamaño del hábitat.
     *
     * @param tamaño Tamaño a establecer.
     * @return Instancia del builder para encadenamiento de métodos.
     */
    HabitatBuilder setTamaño(Tamaño tamaño);

    /**
     * Construye y devuelve un objeto de tipo `Habitat` con los parámetros establecidos.
     *
     * @return Objeto `Habitat` construido.
     */
    Habitat build();
}
