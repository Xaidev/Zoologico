package logica;

/**
 * Clase que representa a un Guacamayo, un animal volador.
 */
public class Guacamayo extends Volador {

    /**
     * Constructor que inicializa las características del Guacamayo.
     * Establece la temperatura y tamaño adecuados, así como los tipos de suelo donde puede sobrevivir.
     * Además, define su tipo de comida y la ruta de la imagen que lo representa.
     */
    public Guacamayo() {
        super(Temperatura.MEDIA, Tamaño.PEQUEÑO);
        super.xSize = 100;
        super.ySize = 100;
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.QUEBRADO);
        setTipoComida(new ComidaHerbivoro());
        super.setRutaImagen("src/imagenes animales/guacamayo.png");
    }

    /**
     * Método que devuelve la información sobre si el Guacamayo es solitario.
     *
     * @return 0, indicando que el Guacamayo no es solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
