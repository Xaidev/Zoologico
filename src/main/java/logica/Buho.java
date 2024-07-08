package logica;

public class Buho extends Volador{
    public Buho(){
        super(Temperatura.MEDIA,Tamaño.PEQUEÑO);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        super.xSize = 100;
        super.ySize = 100;
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/buho.png");
    }
    public int getSolitario() {
        return 0;
    }
}
