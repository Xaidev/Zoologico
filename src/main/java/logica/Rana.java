package logica;

public class Rana extends Terrestre {
    public Rana(){
        super(Temperatura.MEDIA,Tamaño.PEQUEÑO);
        super.sobreviveEnSuelo(TipoSuelo.ACUOSO);
        super.setRutaImagen("src/imagenes animales/rana.png");
    }
    public int getSolitario() {
        return 0;
    }
}
