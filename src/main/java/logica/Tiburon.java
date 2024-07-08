package logica;

public class Tiburon extends Acuatico{
    public Tiburon(){
       super(Temperatura.BAJA,Tamaño.GRANDE);
       setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/Tiburon.png");
    }
    public int getSolitario() {
        return 0;
    }
}
