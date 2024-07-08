package logica;

public class CaballitoDeMar extends Acuatico{
    public CaballitoDeMar(){
        super(Temperatura.BAJA,Tamaño.PEQUEÑO);
        super.xSize = 50;
        super.ySize = 50;
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/caballito de mar.png");
    }
    public int getSolitario() {
        return 0;
    }
}

