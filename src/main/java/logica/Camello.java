package logica;

public class Camello extends Terrestre{
    public Camello(){
        super(Temperatura.ALTA,Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
        setTipoComida(new ComidaHerbivoro());
    }
    public int getSolitario() {
        return 0;
    }
}
