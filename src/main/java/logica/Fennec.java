package logica;

/**
 * Clase que representa un animal Fennec, que es un tipo de zorro terrestre.
 * Extiende de la clase Terrestre.
 */
public class Fennec extends Terrestre {

    /**
     * Constructor de Fennec que inicializa las características del animal.
     * Tiene temperatura alta y tamaño pequeño, sobrevive en suelos arenoso y arena.
     * Se alimenta de una dieta omnívora.
     */
    public Fennec() {
        super(Temperatura.ALTA, Tamaño.PEQUEÑO);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        setTipoComida(new ComidaOmnivoro());
        super.setRutaImagen("src/imagenes animales/zorro fennec.png");
    }

    /**
     * Método que devuelve la preferencia de solitud del Fennec.
     *
     * @return Un entero que representa la preferencia de solitud del Fennec.
     */
    public int getSolitario() {
        return 0;
    }
}
