package logica;

public class TiburonMartillo extends Acuatico{
    public TiburonMartillo(){
       super(Temperatura.BAJA,Tamaño.GRANDE);
    }
    public int getSolitario() {
        return 0;
    }
}
