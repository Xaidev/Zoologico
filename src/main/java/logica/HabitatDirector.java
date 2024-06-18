package logica;

public class HabitatDirector {
    private HabitatBuilder builder;

    public void setBuilder(HabitatBuilder builder) {
        this.builder = builder;
    }

    public Habitat construirHabitat(TipoSuelo tipoSuelo, Vegetacion vegetacion, Temperatura temperatura, Tamaño tamaño) {
        return builder.setTipoSuelo(tipoSuelo)
                .setVegetacion(vegetacion)
                .setTemperatura(temperatura)
                .setTamaño(tamaño)
                .build();
    }
}