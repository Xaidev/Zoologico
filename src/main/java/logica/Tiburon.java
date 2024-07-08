package logica;

/**
 * Clase que representa un tiburón, subclass de Acuatico.
 * Define las características específicas del tiburón, como temperatura adecuada, tamaño,
 * tipo de comida y ruta de imagen.
 */
public class Tiburon extends Acuatico {

    /**
     * Constructor de la clase Tiburón.
     * Inicializa las características del tiburón: temperatura, tamaño, tipo de comida y ruta de imagen.
     */
    public Tiburon() {
        super(Temperatura.BAJA, Tamaño.GRANDE);
        super.xSize = 250;
        super.ySize = 250;
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/Tiburon.png");
    }

    /**
     * Método para obtener información sobre si el tiburón es solitario.
     *
     * @return 0, indicando que el tiburón no es solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
