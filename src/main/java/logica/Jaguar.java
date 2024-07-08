package logica;

public class Jaguar extends Terrestre{
    public Jaguar(){
        super(Temperatura.ALTA,Tamaño.GRANDE);
        super.sobreviveEnSuelo(TipoSuelo.TIERRA);
        super.sobreviveEnSuelo(TipoSuelo.QUEBRADO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        setTipoComida(new ComidaCarnivoro());
    }
    public int getSolitario() {
        return 1;
    }
}
