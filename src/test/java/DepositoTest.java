import Visual.PanelGridComidas;
import Visual.PanelPrincipal;
import logica.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DepositoTest {
    private Deposito deposito;
    private Comida comida;

    @Before
    public void setUp() {
        deposito = new Deposito();
        comida = new Comida("cualquiera");  // Asegúrate de tener una clase Comida y sus subclases disponibles
    }

    @Test
    public void testConstructor() {
        assertEquals(0, deposito.getSize());
    }

    @Test
    public void testAddObjeto() throws ExcesoDeComidaEnElHabitat {
        deposito.addObjeto(comida);
        assertEquals(1, deposito.getSize());
    }

    @Test(expected = ExcesoDeComidaEnElHabitat.class)
    public void testAddObjetoExcesoDeComidaEnElHabitat() throws ExcesoDeComidaEnElHabitat {
        for (int i = 0; i < 10; i++) {
            deposito.addObjeto(new Comida("cualquiera"));
        }
        deposito.addObjeto(comida);  // Esto debería lanzar ExcesoDeComidaEnElHabitat
    }

    @Test
    public void testLookObjeto() throws ExcesoDeComidaEnElHabitat {
        deposito.addObjeto(comida);
        assertEquals(comida, deposito.lookObjeto(0));
    }

    @Test
    public void testLookObjetoEmptyDeposito() {
        assertNull(deposito.lookObjeto(0));
    }

    @Test
    public void testGetSize() throws ExcesoDeComidaEnElHabitat {
        assertEquals(0, deposito.getSize());
        deposito.addObjeto(comida);
        assertEquals(1, deposito.getSize());
    }

    @Test
    public void testLimpiarDeposito() throws ExcesoDeComidaEnElHabitat {
        deposito.addObjeto(comida);
        deposito.limpiarDeposito();
        assertEquals(0, deposito.getSize());
    }

    @Test
    public void testGetObjeto() throws NoHayComidaEnElHabitat, ExcesoDeComidaEnElHabitat {
        PanelPrincipal panelPrincipal = new PanelPrincipal();  // Asegúrate de tener una clase PanelPrincipal
        Habitat habitat = new Habitat(TipoSuelo.ARENA, Vegetacion.ESCASA, Temperatura.ALTA, Tamaño.GRANDE, TipoHabitat.TERRESTRE);  // Asegúrate de tener una clase Habitat
        PanelGridComidas panelGridComidas = new PanelGridComidas(0,0,habitat, panelPrincipal.getPanelHabitatArrayList().get(0),panelPrincipal );  // Asegúrate de tener una clase PanelGridComidas

        deposito.setVisualPrincipal(panelPrincipal);
        deposito.setVisualDeposito(panelGridComidas);

        deposito.addObjeto(comida);

        Comida result = deposito.getObjeto(comida, "mensaje", 1, habitat);
        assertEquals(comida, result);
        assertEquals(0, deposito.getSize());
    }

    @Test(expected = NoHayComidaEnElHabitat.class)
    public void testGetObjetoNoHayComidaEnElHabitat() throws NoHayComidaEnElHabitat {
        PanelPrincipal panelPrincipal = new PanelPrincipal();  // Asegúrate de tener una clase PanelPrincipal
        Habitat habitat = new Habitat(TipoSuelo.ARENA, Vegetacion.ESCASA, Temperatura.ALTA, Tamaño.GRANDE, TipoHabitat.TERRESTRE);  // Asegúrate de tener una clase Habitat

        deposito.setVisualPrincipal(panelPrincipal);

        deposito.getObjeto(comida, "mensaje", 1, habitat);  // Esto debería lanzar NoHayComidaEnElHabitat
    }
}
