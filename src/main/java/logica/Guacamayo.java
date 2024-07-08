package logica;

public class Guacamayo extends Volador {
    public Guacamayo(){
        super(Temperatura.MEDIA,Tamaño.PEQUEÑO);
        super.xSize = 100;
        super.ySize = 100;
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.QUEBRADO);
        setTipoComida(new ComidaHerbivoro());
        super.setRutaImagen("src/imagenes animales/guacamayo.png");
    }
    public int getSolitario() {
        return 0;
    }
}
