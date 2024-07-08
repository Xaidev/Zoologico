package logica;

public class Tiburon extends Acuatico{
    public Tiburon(){
       super(Temperatura.BAJA,Tamaño.GRANDE);
       setTipoComida(new ComidaCarnivoro());
    }
    public int getSolitario() {
        return 0;
    }
}
