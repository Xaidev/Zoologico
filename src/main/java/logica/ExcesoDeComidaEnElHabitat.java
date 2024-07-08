package logica;

/**
 * Excepcion que se lanza cuando hay exceso de comida en el habitat
 */
public class ExcesoDeComidaEnElHabitat extends Exception {
    public ExcesoDeComidaEnElHabitat(String mensaje) {
        super(mensaje);
    }
}
