import Visual.PanelEleccionHabitats;
import Visual.PanelHabitat;
import Visual.PanelPrincipal;
import logica.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class PanelHabitatTest {

    private ArrayList<Animal> animals;
    private PanelPrincipal panelPrincipal;
    private PanelEleccionHabitats panelEleccionHabitats;
    private PanelHabitat panelHabitat;

    @Before
    public void setUp() {
        panelPrincipal = new PanelPrincipal();
        panelEleccionHabitats = new PanelEleccionHabitats(panelPrincipal);
    }

    @Test(expected = CamposHabitatIncompletosException.class)
    public void testSetHabitatWithNullFields() throws CamposHabitatIncompletosException {
        Habitat habitatIncompleto = new Habitat(TipoSuelo.ARENA, null, null, null, TipoHabitat.TERRESTRE);
        panelHabitat = new PanelHabitat(habitatIncompleto, 1, panelPrincipal, panelEleccionHabitats);
        panelHabitat.setHabitat(habitatIncompleto);
    }

    @Test
    public void testSetHabitatWithCompleteFields() {
        Habitat habitatCompleto = new Habitat(TipoSuelo.ARENA, Vegetacion.ESCASA, Temperatura.BAJA, Tamaño.GRANDE, TipoHabitat.TERRESTRE);
        panelHabitat = new PanelHabitat(habitatCompleto, 1, panelPrincipal, panelEleccionHabitats);
        try {
            panelHabitat.setHabitat(habitatCompleto);
            // Añadir aserciones aquí para verificar el estado de panelHabitat si es necesario
        } catch (CamposHabitatIncompletosException e) {
            fail("No debería lanzar CamposHabitatIncompletosException con campos completos");
        }
    }
}