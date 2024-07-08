package logica;

public class CaballitoDeMar extends Acuatico{
    public CaballitoDeMar(){
        super(Temperatura.BAJA,Tamaño.PEQUEÑO);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/caballito de mar.png");
    }
    public int getSolitario() {
        return 0;
    }
}

