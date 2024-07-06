package logica;

public class Guacamayo extends Volador {
    public Guacamayo(){
        super(Temperatura.MEDIA,Tamaño.PEQUEÑO);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.QUEBRADO);
        super.setRutaImagen("src/imagenes animales/guacamayo.png");
    }
    public int getSolitario() {
        return 0;
    }
}
