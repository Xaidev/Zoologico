package logica;

public class OsoPolar extends Terrestre {
    public OsoPolar(){
        super(Temperatura.BAJA,Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.ACUOSO);
        super.sobreviveEnSuelo(TipoSuelo.CONGELADO);
        super.setRutaImagen("src/imagenes animales/oso polar.png");
    }

    public int getSolitario() {
        return 1;
    }
}
