package logica;

public abstract class Terrestre extends Animal {
    public Terrestre(Temperatura tem,Tamaño espacioHabitat)
    {
        super(TipoHabitat.TERRESTRE,tem,espacioHabitat);
    }

    @Override
    public void alimentar() {

    }
    @Override
    public void desplazarse() {

    }
}
