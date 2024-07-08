import logica.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LimiteDeAnimalesTest {

    private Habitat habitat;

    @Before
    public void setUp() {
        habitat = new Habitat(TipoSuelo.ARENA, Vegetacion.ESCASA, Temperatura.BAJA, Tamaño.GRANDE, TipoHabitat.TERRESTRE);
    }

    @Test
    public void agregarAnimalConExito() throws LimiteAnimalesExcedidoException {
        for (int i = 0; i < 4; i++) {
            habitat.agregarAnimals(new Leon());
        }
        assertEquals("Debe haber 4 animales en el hábitat", 4, habitat.getAnimals().size());
    }

    @Test(expected = LimiteAnimalesExcedidoException.class)
    public void agregarSextoAnimalLanzaExcepcion() throws LimiteAnimalesExcedidoException {
        for (int i = 0; i < 5; i++) {
            habitat.agregarAnimals(new Leon());
        }
        habitat.agregarAnimals(new Leon()); // Intentar agregar un sexto animal
    }

    @Test
    public void puedeAgregarAnimalTest() {
        assertTrue("Debe poder agregar animales si hay menos de 5", habitat.puedeAgregarAnimal());
        for (int i = 0; i < 5; i++) {
            try {
                habitat.agregarAnimals(new Leon());
            } catch (LimiteAnimalesExcedidoException e) {
                fail("No debería lanzar LimiteAnimalesExcedidoException");
            }
        }
        assertFalse("No debe poder agregar animales si hay 5 o más", habitat.puedeAgregarAnimal());
    }
}
