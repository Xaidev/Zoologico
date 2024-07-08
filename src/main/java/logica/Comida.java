package logica;

/**
 * Clase que representa un tipo de comida genérica.
 */
public class Comida {
    String tipo;

    /**
     * Constructor para inicializar la comida con un tipo específico.
     *
     * @param arg Tipo de comida a inicializar.
     */
    public Comida(String arg) {
        tipo = arg;
    }

    /**
     * Método que compara si dos comidas son del mismo tipo.
     *
     * @param c Comida a comparar.
     * @return true si las comidas son del mismo tipo, false de lo contrario.
     */
    public boolean compareTo(Comida c) {
        return tipo.equals(c.tipo);
    }
}
