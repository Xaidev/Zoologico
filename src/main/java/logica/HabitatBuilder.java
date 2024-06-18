package logica;

public interface HabitatBuilder {
        HabitatBuilder setTipoSuelo(TipoSuelo tipoSuelo);
        HabitatBuilder setVegetacion(Vegetacion vegetacion);
        HabitatBuilder setTemperatura(Temperatura temperatura);
        HabitatBuilder setTamaño(Tamaño tamaño);
        Habitat build();
}
