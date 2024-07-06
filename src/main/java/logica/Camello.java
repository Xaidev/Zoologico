package logica;

public class Camello extends Terrestre{
    public Camello(){
        super(Temperatura.ALTA,Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
    }
    public int getSolitario() {
        return 0;
    }
}
