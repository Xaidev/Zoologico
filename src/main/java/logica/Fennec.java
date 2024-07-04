package logica;

public class Fennec extends Terrestre{
    public Fennec(){
        super(Temperatura.MEDIA,Tamaño.PEQUEÑO);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.setRutaImagen("src/imagenes animales/zorro fennec.png");
    }
}
