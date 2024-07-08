package logica;

public class ZorroArtico extends Terrestre {
    public ZorroArtico(){
        super(Temperatura.BAJA,Tamaño.MEDIANO);
        setTipoComida(new ComidaCarnivoro());
        super.sobreviveEnSuelo(TipoSuelo.CONGELADO);
    }
    public int getSolitario() {
        return 0;
    }
}
