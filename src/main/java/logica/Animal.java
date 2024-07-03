package logica;

import java.awt.*;

public abstract class Animal {
    public int x;
    public int y;

    public int xSize;
    public int ySize;
    public Image sprite;

    private Temperatura temperaturaAdecuada;
    private TipoHabitat tipoHabitat;
    private Tamaño espacioHabitat;

    public abstract void desplazarse();
    public abstract void alimentar();

    public Animal(TipoHabitat h,Temperatura t,Tamaño s){
        tipoHabitat = h;
        temperaturaAdecuada = t;
        espacioHabitat = s;
    }

    public Temperatura getTemperaturaAdecuada(){
        return temperaturaAdecuada;
    }
    public TipoHabitat getTipoHabitad(){
        return tipoHabitat;
    }
    public Tamaño getEspacioHabitat(){
        return espacioHabitat;
    }
}
