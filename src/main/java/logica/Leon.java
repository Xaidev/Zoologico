package logica;

/**
 * Clase que representa un león, un animal terrestre.
 */
public class Leon extends Terrestre {

    /**
     * Constructor que inicializa las características del león.
     * El león tiene temperatura alta, tamaño grande, y puede sobrevivir en suelos de arena y tierra.
     * Se alimenta principalmente de carne.
     */
    public Leon() {
        super(Temperatura.ALTA, Tamaño.GRANDE);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/leon.png");
    }

    /**
     * Obtiene el valor que indica si el león es solitario.
     *
     * @return 0, indicando que el león no es solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
