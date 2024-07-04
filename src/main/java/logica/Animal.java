package logica;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Animal {

    public JLabel animalLabel;
    private String rutaImagen = "src/imagenes animales/buho.png";
    public int startX = 0;
    public int startY = 300;

    public int xSize = 100;
    public int ySize = 100;

    private Temperatura temperaturaAdecuada;
    private TipoHabitat tipoHabitat;
    private Tamaño espacioHabitat;
    private ArrayList<TipoSuelo> suelosDisponibles;

    public Animal(TipoHabitat h,Temperatura t,Tamaño s){
        animalLabel = new JLabel("Hola");
        suelosDisponibles = new ArrayList<TipoSuelo>();
        tipoHabitat = h;
        temperaturaAdecuada = t;
        espacioHabitat = s;

        xSize *= espacioHabitat.ordinal() + 1;
        ySize *= espacioHabitat.ordinal() + 1;
    }
    public void setRutaImagen(String arg){
        rutaImagen = arg;
    }
    public String getRutaImagen(){
        return rutaImagen;
    }
    public Temperatura getTemperaturaAdecuada(){
        return temperaturaAdecuada;
    }
    public TipoHabitat getTipoHabitat(){
        return tipoHabitat;
    }
    public Tamaño getEspacioHabitat(){
        return espacioHabitat;
    }

    public ArrayList<TipoSuelo> getSuelosDisponibles() {
        return suelosDisponibles;
    }
    public void sobreviveEnSuelo(TipoSuelo s){
        suelosDisponibles.add(s);
    }

    public abstract void desplazarse();
    public abstract void alimentar();

    public void update(){
        desplazarse();
        alimentar();
    }
}
