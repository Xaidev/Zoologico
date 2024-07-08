package logica;

/**
 * Clase que representa un Búho, que es un tipo de animal volador.
 */
public class Buho extends Volador {

    /**
     * Constructor para la clase Buho.
     * Inicializa las propiedades específicas del búho.
     */
    public Buho() {
        super(Temperatura.MEDIA, Tamaño.PEQUEÑO);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        super.xSize = 100;
        super.ySize = 100;
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/buho.png");
    }

    /**
     * Indica si el búho es un animal solitario.
     *
     * @return 0 indicando que el búho no es un animal solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
