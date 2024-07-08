package logica;

/**
 * Clase que representa un Oso Polar, una especie de animal terrestre.
 */
public class OsoPolar extends Terrestre {

    /**
     * Constructor para inicializar un Oso Polar con sus características específicas.
     */
    public OsoPolar() {
        super(Temperatura.BAJA, Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.ACUOSO);
        super.sobreviveEnSuelo(TipoSuelo.CONGELADO);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/oso polar.png");
    }

    /**
     * Método que indica si el Oso Polar prefiere vivir de manera solitaria.
     *
     * @return 1, indicando que el Oso Polar prefiere vivir solitario.
     */
    public int getSolitario() {
        return 1;
    }
}
