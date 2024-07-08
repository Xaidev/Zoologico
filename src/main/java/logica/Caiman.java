package logica;

public class Caiman extends Terrestre {
    public Caiman(){
        super(Temperatura.ALTA,Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/caiman.png");
    }
    public int getSolitario() {
        return 0;
    }
}
