package logica;
import java.util.ArrayList;

/**
 * Arreglo donde se guardaran todos los objetos
 */

public class Deposito<T> {
    private ArrayList<T> deposito;

    /**
     * Constructor de Deposito se instancia un nuevo objeto
     */
    public Deposito(){
        this.deposito = new ArrayList<>();
    }

    /**
     * Agrega un objeto al array, si el array esta lleno nos lanza una excepción
     * @param t Objeto a agregar
     * @throws ExcesoDeComidaEnElHabitat Excepción que se lanza si el array esta lleno
     */
    public void addObjeto(T t) throws ExcesoDeComidaEnElHabitat{
        if(deposito.size() >= 10){
            throw new ExcesoDeComidaEnElHabitat("Exceso de comida en el habitat");
        }
        deposito.add(t);
    }
    public T lookObjeto(int index){
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
    public T getObjeto(T t, String s) throws NoHayComidaEnElHabitat{
        if(deposito.isEmpty()){
            throw new NoHayComidaEnElHabitat("No hay comida en el habitat");
        }
       for(T obj : deposito){
           if(obj.equals(t)){
               deposito.remove(obj);
               return obj;
           }
       }
       throw new NoHayComidaEnElHabitat(s);
    }

    /**
     * Limpia el array
     */
    public void limpiarDeposito(){
        deposito.clear();
    }
}