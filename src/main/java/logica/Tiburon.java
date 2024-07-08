package logica;

public class Tiburon extends Acuatico{
    public Tiburon(){
        super(Temperatura.BAJA,Tamaño.GRANDE);
        super.xSize = 250;
        super.ySize = 250;
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/Tiburon.png");
    }
    public int getSolitario() {
        return 0;
    }
}
