package logica;

/**
 * Clase que representa un Caballito de Mar, un animal acuático.
 */
public class CaballitoDeMar extends Acuatico {

    /**
     * Constructor para inicializar un Caballito de Mar con temperatura baja y tamaño pequeño.
     */
    public CaballitoDeMar() {
        super(Temperatura.BAJA, Tamaño.PEQUEÑO);
        super.xSize = 50;
        super.ySize = 50;
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/caballito de mar.png");
    }

    /**
     * Método que indica si el Caballito de Mar es solitario.
     *
     * @return 0, ya que el Caballito de Mar no es solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
