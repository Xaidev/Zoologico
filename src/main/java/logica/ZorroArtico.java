package logica;

public class ZorroArtico extends Terrestre {
    public ZorroArtico(){
        super(Temperatura.BAJA,Tamaño.MEDIANO);
        setTipoComida(new ComidaCarnivoro());
        super.sobreviveEnSuelo(TipoSuelo.CONGELADO);
        super.setRutaImagen("src/imagenes animales/Zorro artico.png");
    }
    public int getSolitario() {
        return 0;
    }
}
