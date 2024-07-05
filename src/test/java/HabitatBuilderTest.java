import logica.BuilderBosque;
import logica.Habitat;
import logica.TipoSuelo;
import logica.Vegetacion;
import logica.Temperatura;
import logica.Tamaño;
import org.junit.Test;
import static org.junit.Assert.*;

public class HabitatBuilderTest {

    @Test
    public void testBuilderBosque() {
        BuilderBosque builder = new BuilderBosque();
        Habitat habitat = builder.setTipoSuelo(TipoSuelo.TIERRA)
                .setVegetacion(Vegetacion.ABUNDANTE)
                .setTemperatura(Temperatura.MEDIA)
                .setTamaño(Tamaño.GRANDE)
                .build();

        assertEquals(TipoSuelo.TIERRA, habitat.getTipoSuelo());
        assertEquals(Vegetacion.ABUNDANTE, habitat.getVegetacion());
        assertEquals(Temperatura.MEDIA, habitat.getTemperatura());
        assertEquals(Tamaño.GRANDE, habitat.getTamaño());
    }
}