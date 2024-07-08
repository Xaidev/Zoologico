package logica;

import Visual.PanelGridComidas;
import Visual.PanelPrincipal;
import java.util.ArrayList;

/**
 * Clase que representa un depósito de comida para hábitats.
 * Almacena objetos de tipo Comida y gestiona su manipulación y visualización.
 */
public class Deposito {
    private PanelGridComidas visualDeposito;
    private PanelPrincipal visualPrincipal;
    private final ArrayList<Comida> deposito;
    private int i;

    /**
     * Establece el panel de visualización del depósito de comida.
     * @param p PanelGridComidas a establecer
     */
    public void setVisualDeposito(PanelGridComidas p) {
        visualDeposito = p;
    }

    /**
     * Establece el panel principal de visualización.
     * @param p PanelPrincipal a establecer
     */
    public void setVisualPrincipal(PanelPrincipal p) {
        visualPrincipal = p;
    }

    /**
     * Constructor de Deposito que inicializa un nuevo depósito vacío.
     */
    public Deposito() {
        this.deposito = new ArrayList<>();
        i = 0;
    }

    /**
     * Agrega un objeto Comida al depósito.
     * @param t Objeto de tipo Comida a agregar
     * @throws ExcesoDeComidaEnElHabitat Excepción lanzada si el depósito está lleno
     */
    public void addObjeto(Comida t) throws ExcesoDeComidaEnElHabitat {
        if (deposito.size() >= 10) {
            throw new ExcesoDeComidaEnElHabitat("Exceso de comida en el hábitat");
        }
        deposito.add(t);
    }

    /**
     * Retorna el objeto Comida en la posición indicada.
     * @param index Índice del objeto a buscar
     * @return Objeto de tipo Comida encontrado, o null si el depósito está vacío
     */
    public Comida lookObjeto(int index) {
        if (deposito.isEmpty())
            return null;
        return deposito.get(index);
    }

    /**
     * Obtiene y elimina un objeto Comida del depósito que coincida con el tipo especificado.
     * @param t Objeto de tipo Comida a obtener
     * @param s Mensaje de excepción si no se encuentra el tipo de comida
     * @param numeroHabitat Número del hábitat relacionado
     * @param habitat Hábitat asociado
     * @return Objeto de tipo Comida obtenido
     * @throws NoHayComidaEnElHabitat Excepción lanzada si no hay comida del tipo especificado en el depósito
     */
    public Comida getObjeto(Comida t, String s, int numeroHabitat, Habitat habitat) throws NoHayComidaEnElHabitat {
        if (!visualPrincipal.getPanelAvisosHabitat(numeroHabitat).repetido("No hay alimento para: " + s)) {
            visualPrincipal.getPanelAvisosHabitat(numeroHabitat).addAviso("No hay alimento para: " + s, i);
            visualPrincipal.getPanelAvisosEleccionHabitat().addAviso("No hay alimento para el hábitat: " + (numeroHabitat + 1), numeroHabitat);
            i++;
        }
        for (Comida obj : deposito) {
            if (obj.compareTo(t) || t.compareTo(new ComidaOmnivoro())
                    || (t.compareTo(new ComidaCarnivoro()) && obj.compareTo(new ComidaOmnivoro()))) {
                deposito.remove(obj);
                visualDeposito.drawComidas();
                return obj;
            }
        }
        throw new NoHayComidaEnElHabitat(s);
    }

    /**
     * Retorna la cantidad de objetos Comida en el depósito.
     * @return Tamaño del depósito de comida
     */
    public int getSize() {
        return deposito.size();
    }

    /**
     * Limpia el depósito, eliminando todos los objetos Comida almacenados.
     */
    public void limpiarDeposito() {
        deposito.clear();
    }
}
