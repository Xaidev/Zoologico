package logica;

import Visual.PanelPrincipal;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Animal {

    public JLabel animalLabel;
    private PanelPrincipal panelPrincipal;
    private String rutaImagen = "src/imagenes animales/buho.png";
    public int startX = 0;
    public int startY = 300;
    public boolean one;
    public int xSize = 100;
    public int ySize = 100;
    private Temperatura temperaturaAdecuada;
    private TipoHabitat tipoHabitat;
    private Tamaño espacioHabitat;
    private ArrayList<TipoSuelo> suelosDisponibles;

    private Habitat actualHabitat;

    // POR DEFECTO ES OMNIVORO
    private Comida tipoAlimento = new ComidaOmnivoro();

    public Animal(TipoHabitat h, Temperatura t, Tamaño s) {
        animalLabel = new JLabel("Hola");
        suelosDisponibles = new ArrayList<TipoSuelo>();
        tipoHabitat = h;
        temperaturaAdecuada = t;
        espacioHabitat = s;
        one = false;
        xSize *= (3-espacioHabitat.ordinal() + 1);
        ySize *= (3-espacioHabitat.ordinal() + 1);
    }

    public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setHabitat(Habitat h){
        actualHabitat = h;
    }

    public void setTipoComida(Comida c){
        tipoAlimento = c;
    }
    public String getTipoComida(){
        switch (tipoAlimento.getClass().getSimpleName()){
            case "ComidaCarnivoro":
                return "Carnivoro";
            case "ComidaHerbivoro":
                return "Herbivoro";
        }
        return null;
    }

    public void setRutaImagen(String arg) {
        rutaImagen = arg;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public Temperatura getTemperaturaAdecuada() {
        return temperaturaAdecuada;
    }

    public TipoHabitat getTipoHabitat() {
        return tipoHabitat;
    }

    public Tamaño getEspacioHabitat() {
        return espacioHabitat;
    }

    public ArrayList<TipoSuelo> getSuelosDisponibles() {
        return suelosDisponibles;
    }

    public void sobreviveEnSuelo(TipoSuelo s) {
        suelosDisponibles.add(s);
    }

    int probabtimeMove = 3000;

    public void setProbabilityMove(int arg) {
        probabtimeMove = arg;
    }

    int offsetTimeMove = 0;

    public void setOffsetTimeMove(int arg) {
        offsetTimeMove = arg;
    }

    public abstract void desplazarse();

    int hambrePercent = 50;
    // RETORNA FALSE SI NO HAY QUE ALIMENTARLO
    public boolean alimentar(){
        System.out.println(hambrePercent);
        if(hambrePercent >= 100){
            buscarComida();
            return true;
        }
        if(!actualHabitat.hayHambre()){
            panelPrincipal.getPanelAvisosEleccionHabitat().clearAviso(actualHabitat.getNumeroHabitat());
        }
        if(!actualHabitat.especieConHambre(getClass().getSimpleName())){
            panelPrincipal.getPanelAvisosHabitat(actualHabitat.getNumeroHabitat()).clearAvisos("No hay alimento para: " + getClass().getSimpleName());
        }
        return false;
    }
    public int getHambrePercent(){
        return hambrePercent;
    }

    public abstract int getSolitario();

    public Thread thread;
    // Actualiza cada 100 milisegundos
    public void update(Thread thread){
        this.thread = thread;
        if(alimentar())
            return;
        quiereMoverse();
    }

    Timer moveDelay = new Timer(1000,null);
    double random;
    void quiereMoverse()
    {
        if (moveDelay.isRunning() && moveDelay.getDelay() <= probabtimeMove){
            desplazarse();
            hambrePercent += (int) Math.floor(random)%10;
            return;
        }
        else if (moveDelay.isRunning())
            return;

        random = Math.random()*100;
        int wait = ((int) Math.floor(random)%4)+1;

        moveDelay = new Timer(wait*1000 +offsetTimeMove, null);
        moveDelay.start();
        moveDelay.setRepeats(false);
    }

    void buscarComida(){
        Deposito deposito = actualHabitat.getDeposito();
        try {
            deposito.getObjeto(tipoAlimento,getClass().getSimpleName(), actualHabitat.getNumeroHabitat(), actualHabitat);
            hambrePercent = 0;
        }
        catch (Exception e){
            System.out.println(e.toString() + "pepe");
        }
    }
}
