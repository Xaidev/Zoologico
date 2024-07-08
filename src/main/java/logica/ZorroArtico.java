package logica;

/**
 * Clase que representa un Zorro Ártico, que es un animal terrestre.
 * Extiende de la clase Terrestre y define características específicas del Zorro Ártico.
 */
public class ZorroArtico extends Terrestre {

    /**
     * Constructor de la clase ZorroArtico.
     * Define las condiciones ideales para la supervivencia del Zorro Ártico.
     */
    public ZorroArtico() {
        super(Temperatura.BAJA, Tamaño.MEDIANO);
        setTipoComida(new ComidaCarnivoro());
        super.sobreviveEnSuelo(TipoSuelo.CONGELADO);
        super.setRutaImagen("src/imagenes animales/Zorro artico.png");
    }

    /**
     * Método que indica si el Zorro Ártico prefiere estar solo.
     * @return 0, indicando que el Zorro Ártico no es solitario.
     */
    public int getSolitario() {
        return 0;
    }
}
