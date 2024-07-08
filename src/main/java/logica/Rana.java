package logica;

/**
 * Clase que representa una Rana, una especie de animal terrestre.
 */
public class Rana extends Terrestre {

    /**
     * Constructor para inicializar una Rana con sus características específicas.
     */
    public Rana() {
        super(Temperatura.MEDIA, Tamaño.PEQUEÑO);
        super.sobreviveEnSuelo(TipoSuelo.ACUOSO);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/rana.png");
    }

    /**
     * Método que indica si la Rana prefiere vivir de manera solitaria.
     *
     * @return 0, indicando que la Rana no prefiere vivir solitaria.
     */
    public int getSolitario() {
        return 0;
    }
}
