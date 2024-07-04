package logica;

public abstract class Volador extends Animal{
    public Volador(Temperatura tem,Tamaño espacioHabitat)
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
