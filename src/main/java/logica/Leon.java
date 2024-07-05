package logica;

public class Leon extends Terrestre {
    public Leon(){
        super(Temperatura.ALTA,Tamaño.GRANDE);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.setRutaImagen("src/imagenes animales/leon.png");
    }
    @Override
    public void alimentar() {
        super.alimentar();
        System.out.println("El león se está alimentando.");
    }
}
