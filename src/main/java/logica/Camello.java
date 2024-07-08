package logica;

/**
 * Clase que representa a un Camello, un animal terrestre.
 */
public class Camello extends Terrestre {

    /**
     * Constructor para inicializar un Camello con temperatura alta y tamaño mediano.
     */
    public Camello() {
        super(Temperatura.ALTA, Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        setTipoComida(new ComidaHerbivoro());
        super.setRutaImagen("src/imagenes animales/camello.png");
    }

    /**
     * Método que indica si el Camello es solitario.
     *
     * @return 0, ya que el Camello no es solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
