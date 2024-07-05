import logica.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class HabitatDirectorTest {

    @Test
    public void testConstruirHabitat() {
        HabitatDirector director = new HabitatDirector();
        BuilderBosque builder = new BuilderBosque();
        director.setBuilder(builder);

        Habitat habitat = director.construirHabitat(TipoSuelo.TIERRA, Vegetacion.ABUNDANTE, Temperatura.MEDIA, Tamaño.GRANDE);

        assertNotNull(habitat);
        assertEquals(TipoSuelo.TIERRA, habitat.getTipoSuelo());
        assertEquals(Vegetacion.ABUNDANTE, habitat.getVegetacion());
        assertEquals(Temperatura.MEDIA, habitat.getTemperatura());
        assertEquals(Tamaño.GRANDE, habitat.getTamaño());
    }
}