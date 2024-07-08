package logica;

/**
 * Clase que representa a un Caimán, un animal terrestre.
 */
public class Caiman extends Terrestre {

    /**
     * Constructor para inicializar un Caimán con temperatura alta y tamaño mediano.
     */
    public Caiman() {
        super(Temperatura.ALTA, Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/caiman.png");
    }

    /**
     * Método que indica si el Caimán es solitario.
     *
     * @return 0, ya que el Caimán no es solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
