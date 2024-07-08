package logica;

public class Ciervo extends Terrestre{
    public Ciervo(){
        super(Temperatura.ALTA,Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.QUEBRADO);
        setTipoComida(new ComidaHerbivoro());
        super.setRutaImagen("src/imagenes animales/ciervo.png");
    }
    public int getSolitario() {
        return 0;
    }
}
