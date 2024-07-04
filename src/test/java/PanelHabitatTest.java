import Visual.PanelEleccionHabitats;
import Visual.PanelHabitat;
import Visual.PanelPrincipal;
import logica.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class PanelHabitatTest {

    @Test(expected = CamposHabitatIncompletosException.class)
    public void testSetHabitatWithNullFields() throws CamposHabitatIncompletosException {
        // Crear instancias necesarias para PanelHabitat
        ArrayList<Animal> animals = new ArrayList<>();
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        PanelEleccionHabitats panelEleccionHabitats = new PanelEleccionHabitats(panelPrincipal);

        // Crear un hábitat con campos nulos
        Habitat habitatIncompleto = new Habitat(TipoSuelo.ARENA, null, null, null, null);

        // Crear el PanelHabitat
        PanelHabitat panelHabitat = new PanelHabitat(habitatIncompleto, animals, panelPrincipal, panelEleccionHabitats);

        // Llamar a setHabitat y esperar que lance la excepción
        panelHabitat.setHabitat(habitatIncompleto);
    }

    @Test
    public void testSetHabitatWithCompleteFields() {
        // Crear instancias necesarias para PanelHabitat
        ArrayList<Animal> animals = new ArrayList<>();
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        PanelEleccionHabitats panelEleccionHabitats = new PanelEleccionHabitats(panelPrincipal);

        // Crear un hábitat con campos completos
        Habitat habitatCompleto = new Habitat(TipoSuelo.ARENA, Vegetacion.ESCASA, Temperatura.BAJA, Tamaño.GRANDE, TipoHabitat.TERRESTRE);

        // Crear el PanelHabitat
        PanelHabitat panelHabitat = new PanelHabitat(habitatCompleto, animals, panelPrincipal, panelEleccionHabitats);

        try {
            // Llamar a setHabitat y verificar que no lance excepción
            panelHabitat.setHabitat(habitatCompleto);
        } catch (CamposHabitatIncompletosException e) {
            fail("No debería lanzar CamposHabitatIncompletosException con campos completos");
        }
    }
}
