package logica;

public class Elefante extends Terrestre{
    public Elefante(){
        super(Temperatura.ALTA,Tamaño.GRANDE);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        setTipoComida(new ComidaHerbivoro());
        super.setRutaImagen("src/imagenes animales/elefante.png");
    }

    @Override
    public int getSolitario() {
        return 0;
    }
}
