package logica;

/**
 * Clase que representa un jaguar, un animal terrestre.
 */
public class Jaguar extends Terrestre {

    /**
     * Constructor que inicializa las características del jaguar.
     * El jaguar tiene temperatura alta, tamaño grande, y puede sobrevivir en varios tipos de suelo.
     * Se alimenta principalmente de carne.
     */
    public Jaguar() {
        super(Temperatura.ALTA, Tamaño.GRANDE);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.QUEBRADO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/jaguar.png");
    }

    /**
     * Obtiene el valor que indica si el jaguar es solitario.
     *
     * @return 1, indicando que el jaguar es solitario.
     */
    public int getSolitario() {
        return 1;
    }
}
