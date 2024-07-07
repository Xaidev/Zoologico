package logica;
import Visual.PanelGridComidas;
import Visual.PanelHabitat;
import Visual.PanelPrincipal;

import java.util.ArrayList;

/**
 * Arreglo donde se guardaran todos los objetos
 */

public class Deposito {
    private PanelGridComidas visualDeposito;
    private PanelPrincipal visualPrincipal;
    private ArrayList<Comida> deposito;
    private int i;

    public void setVisualDeposito(PanelGridComidas p){
        visualDeposito = p;
    }
    public void setVisualPrincipal(PanelPrincipal p){
        visualPrincipal = p;
    }

    /**
     * Constructor de Deposito se instancia un nuevo objeto
     */
    public Deposito(){
        this.deposito = new ArrayList<>();;
        i = 0;
    }

    /**
     * Agrega un objeto al array, si el array esta lleno nos lanza una excepción
     * @param t Objeto a agregar
     * @throws ExcesoDeComidaEnElHabitat Excepción que se lanza si el array esta lleno
     */
    public void addObjeto(Comida t) throws ExcesoDeComidaEnElHabitat{
        if(deposito.size() >= 10){
            throw new ExcesoDeComidaEnElHabitat("Exceso de comida en el habitat");
        }
        deposito.add(t);
    }
    public Comida lookObjeto(int index){
        if(deposito.isEmpty())
            return null;
        return deposito.get(index);
    }
    /**
     * Obtiene un objeto del array, si el array esta vacio nos lanza una excepción
     * @param t Objeto a obtener
     * @param s Mensaje de excepción
     * @return Objeto obtenido
     * @throws NoHayComidaEnElHabitat Excepción que se lanza si el array esta vacio
     */
    public Comida getObjeto(Comida t, String s, int numeroHabitat, Habitat habitat) throws NoHayComidaEnElHabitat{
        if(!visualPrincipal.getPanelAvisosHabitat(numeroHabitat).repetido("No hay alimento para: " + s)){
            visualPrincipal.getPanelAvisosHabitat(numeroHabitat).addAviso("No hay alimento para: " + s,i);
            visualPrincipal.getPanelAvisosEleccionHabitat().addAviso("No hay alimento para el habitat: " + (numeroHabitat + 1),numeroHabitat);
            i++;
            }
       for(Comida obj : deposito){
           if(obj.compareTo(t)|| t.compareTo(new ComidaOmnivoro())
           || (t.compareTo(new ComidaCarnivoro()) && obj.compareTo(new ComidaOmnivoro()))){
               deposito.remove(obj);
               visualDeposito.drawComidas();
               return obj;
           }
       }
       throw new NoHayComidaEnElHabitat(s);
    }

    public int getSize(){
        return deposito.size();
    }

    /**
     * Limpia el array
     */
    public void limpiarDeposito(){
        deposito.clear();
    }
}