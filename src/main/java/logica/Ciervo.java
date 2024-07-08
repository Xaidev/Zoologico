package logica;

/**
 * Clase que representa a un Ciervo, un animal terrestre.
 */
public class Ciervo extends Terrestre {

    /**
     * Constructor para inicializar un Ciervo con temperatura alta y tamaño mediano.
     */
    public Ciervo() {
        super(Temperatura.ALTA, Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.QUEBRADO);
        setTipoComida(new ComidaHerbivoro());
        super.setRutaImagen("src/imagenes animales/ciervo.png");
    }

    /**
     * Método que indica si el Ciervo es solitario.
     *
     * @return 0, ya que el Ciervo no es solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
