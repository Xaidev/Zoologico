package logica;

public abstract class Comida {
    String tipo;
    public Comida(String arg){
        tipo = arg;
    }
    public boolean compareTo(Comida c){
        return tipo.equals(c.tipo);
    }
}
