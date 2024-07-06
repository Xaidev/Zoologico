package logica;
import java.util.ArrayList;

/**
 * Arreglo donde se guardaran todos los objetos
 */

public class Deposito<T> {
    private ArrayList<T> deposito;

    /**
     * Constructor de Deposito se instancia un nuevo objeto
     * @param ncantidad Cantidad de productos que tendrá el array
     */
    public Deposito(int ncantidad){
        this.deposito = new ArrayList<>(ncantidad);
    }

    /**
     * Agrega un objeto al array
     * @param t Es un objeto cualquiera que entra en el array
     */
    public void addObjeto(T t){
        deposito.add(t);
    }

    /**
     * Saca el primer objeto del array, y si el array esta vacío nos devuelve el nulo
     * @return Primer objeto o el nulo en el caso de estar vacío
     */
    public T getObjeto(){
        if(deposito.isEmpty()) {
            return  null;
        }
        return deposito.remove(0);
    }

    public T lookObjeto(int i){
        if(deposito.isEmpty()) {
            return  null;
        }
        return deposito.get(i);
    }

    public void Clear(){
        if(deposito.isEmpty()) {
            return;
        }
        deposito.clear();
    }
}
