package logica;

public class Leon extends Terrestre {
    public Leon(){
        super(Temperatura.ALTA,Tamaño.GRANDE);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/leon.png");
    }
    public int getSolitario() {
        return 0;
    }
}
