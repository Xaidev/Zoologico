package logica;

/**
 * Clase que representa una tortuga marina, que es un tipo de animal acuático.
 * Extiende de la clase Acuatico y define características específicas como temperatura, tamaño,
 * tipo de comida y ruta de la imagen asociada.
 */
public class TortugaMarina extends Acuatico {

    /**
     * Constructor de la clase TortugaMarina.
     * Inicializa una tortuga marina con temperatura media y tamaño mediano.
     * Establece el tipo de comida como herbívoro y define la ruta de la imagen asociada.
     */
    public TortugaMarina() {
        super(Temperatura.MEDIA, Tamaño.MEDIANO);
        setTipoComida(new ComidaHerbivoro());
        super.setRutaImagen("src/imagenes animales/tortuga.png");
    }

    /**
     * Método que devuelve si la tortuga marina es solitaria.
     * En este caso, la tortuga marina no es solitaria (devuelve 0).
     *
     * @return 0 indicando que la tortuga marina no es solitaria
     */
    public int getSolitario() {
        return 0;
    }
}
