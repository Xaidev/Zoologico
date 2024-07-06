package logica;

public class TortugaMarina extends Acuatico{
    public TortugaMarina(){
        super(Temperatura.MEDIA,Tamaño.MEDIANO);
        super.setRutaImagen("src/imagenes animales/tortuga.png");
    }
    public int getSolitario() {
        return 0;
    }
}
