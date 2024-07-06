package logica;

public class Caiman extends Terrestre {
    public Caiman(){
        super(Temperatura.ALTA,Tamaño.MEDIANO);
        super.sobreviveEnSuelo(TipoSuelo.ARENA);
        super.sobreviveEnSuelo(TipoSuelo.ARENOSO);
    }
    public int getSolitario() {
        return 0;
    }
}
