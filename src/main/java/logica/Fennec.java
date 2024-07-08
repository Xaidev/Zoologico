package logica;

public class Fennec extends Terrestre{
    public Fennec(){
        super(Temperatura.ALTA,Tamaño.PEQUEÑO);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        setTipoComida(new ComidaOmnivoro());
        super.setRutaImagen("src/imagenes animales/zorro fennec.png");
    }
    public int getSolitario() {
        return 0;
    }
}
