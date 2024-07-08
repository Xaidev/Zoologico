package logica;

/**
 * Clase que representa un elefante, un animal terrestre.
 * Extiende de la clase Terrestre.
 */
public class Elefante extends Terrestre {

    /**
     * Constructor de Elefante que inicializa las características del animal.
     * Tiene temperatura alta y tamaño grande, sobrevive en suelos de tierra, arena y arenoso.
     * Se alimenta de una dieta herbívora.
     */
    public Elefante() {
        super(Temperatura.ALTA, Tamaño.GRANDE);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        setTipoComida(new ComidaHerbivoro());
        super.setRutaImagen("src/imagenes animales/elefante.png");
    }

    /**
     * Método que devuelve la preferencia de solitud del Elefante.
     *
     * @return Un entero que representa la preferencia de solitud del Elefante.
     */
    @Override
    public int getSolitario() {
        return 0;
    }
}
