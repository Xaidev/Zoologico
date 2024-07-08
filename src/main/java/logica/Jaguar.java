package logica;

public class Jaguar extends Terrestre{
    public Jaguar(){
        super(Temperatura.ALTA,Tamaño.GRANDE);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.QUEBRADO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        setTipoComida(new ComidaCarnivoro());
        super.setRutaImagen("src/imagenes animales/jaguar.png");
    }
    public int getSolitario() {
        return 1;
    }
}
