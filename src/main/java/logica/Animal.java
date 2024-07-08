package logica;

import Visual.PanelPrincipal;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Clase abstracta que representa a un animal.
 */
public abstract class Animal {

    public JLabel animalLabel;
    private PanelPrincipal panelPrincipal;
    private String rutaImagen = "src/imagenes animales/buho.png";
    public int startX = 0;
    public int startY = 300;
    public boolean one;
    public int xSize = 100;
    public int ySize = 100;
    private final Temperatura temperaturaAdecuada;
    private final TipoHabitat tipoHabitat;
    private final Tamaño espacioHabitat;
    private final ArrayList<TipoSuelo> suelosDisponibles;

    private Habitat actualHabitat;

    // POR DEFECTO ES OMNIVORO
    private Comida tipoAlimento = new ComidaOmnivoro();

    /**
     * Constructor para un objeto Animal.
     *
     * @param h El tipo de hábitat.
     * @param t La temperatura adecuada.
     * @param s El tamaño del hábitat.
     */
    public Animal(TipoHabitat h, Temperatura t, Tamaño s) {
        animalLabel = new JLabel("Hola");
        suelosDisponibles = new ArrayList<TipoSuelo>();
        tipoHabitat = h;
        temperaturaAdecuada = t;
        espacioHabitat = s;
        one = false;
        xSize *= (3 - espacioHabitat.ordinal() + 1);
        ySize *= (3 - espacioHabitat.ordinal() + 1);
    }

    /**
     * Establece el panel principal.
     *
     * @param panelPrincipal El panel principal.
     */
    public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    /**
     * Obtiene el panel principal.
     *
     * @return El panel principal.
     */
    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * Establece el hábitat del animal.
     *
     * @param h El hábitat del animal.
     */
    public void setHabitat(Habitat h) {
        actualHabitat = h;
    }

    /**
     * Establece el tipo de comida del animal.
     *
     * @param c El tipo de comida.
     */
    public void setTipoComida(Comida c) {
        tipoAlimento = c;
    }

    /**
     * Obtiene el tipo de comida del animal.
     *
     * @return El tipo de comida.
     */
    public String getTipoComida() {
        switch (tipoAlimento.getClass().getSimpleName()) {
            case "ComidaCarnivoro":
                return "Carnivoro";
            case "ComidaHerbivoro":
                return "Herbivoro";
        }
        return null;
    }

    /**
     * Establece la ruta de la imagen del animal.
     *
     * @param arg La ruta de la imagen.
     */
    public void setRutaImagen(String arg) {
        rutaImagen = arg;
    }

    /**
     * Obtiene la ruta de la imagen del animal.
     *
     * @return La ruta de la imagen.
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * Obtiene la temperatura adecuada para el animal.
     *
     * @return La temperatura adecuada.
     */
    public Temperatura getTemperaturaAdecuada() {
        return temperaturaAdecuada;
    }

    /**
     * Obtiene el tipo de hábitat del animal.
     *
     * @return El tipo de hábitat.
     */
    public TipoHabitat getTipoHabitat() {
        return tipoHabitat;
    }

    /**
     * Obtiene el tamaño del hábitat del animal.
     *
     * @return El tamaño del hábitat.
     */
    public Tamaño getEspacioHabitat() {
        return espacioHabitat;
    }

    /**
     * Obtiene los tipos de suelo disponibles para el animal.
     *
     * @return Los tipos de suelo disponibles.
     */
    public ArrayList<TipoSuelo> getSuelosDisponibles() {
        return suelosDisponibles;
    }

    /**
     * Añade un tipo de suelo en el que el animal puede sobrevivir.
     *
     * @param s El tipo de suelo.
     */
    public void sobreviveEnSuelo(TipoSuelo s) {
        suelosDisponibles.add(s);
    }

    int probabtimeMove = 3000;

    /**
     * Establece la probabilidad de movimiento del animal.
     *
     * @param arg La probabilidad de movimiento.
     */
    public void setProbabilityMove(int arg) {
        probabtimeMove = arg;
    }

    int offsetTimeMove = 0;

    /**
     * Establece el tiempo de desplazamiento del animal.
     *
     * @param arg El tiempo de desplazamiento.
     */
    public void setOffsetTimeMove(int arg) {
        offsetTimeMove = arg;
    }

    /**
     * Método abstracto que define cómo se desplaza el animal.
     */
    public abstract void desplazarse();

    int hambrePercent = 50;

    /**
     * Alimenta al animal si es necesario.
     *
     * @return True si el animal necesita ser alimentado, de lo contrario false.
     */
    public boolean alimentar() {
        System.out.println(hambrePercent);
        if (hambrePercent >= 100) {
            buscarComida();
            return true;
        }
        if (!actualHabitat.hayHambre()) {
            panelPrincipal.getPanelAvisosEleccionHabitat().clearAviso(actualHabitat.getNumeroHabitat());
        }
        if (!actualHabitat.especieConHambre(getClass().getSimpleName())) {
            panelPrincipal.getPanelAvisosHabitat(actualHabitat.getNumeroHabitat()).clearAvisos("No hay alimento para: " + getClass().getSimpleName());
        }
        return false;
    }

    /**
     * Obtiene el porcentaje de hambre del animal.
     *
     * @return El porcentaje de hambre.
     */
    public int getHambrePercent() {
        return hambrePercent;
    }

    /**
     * Método abstracto que obtiene si el animal es solitario.
     *
     * @return 1 si el animal es solitario, de lo contrario 0.
     */
    public abstract int getSolitario();

    public Thread thread;

    /**
     * Actualiza el estado del animal cada 100 milisegundos.
     *
     * @param thread El hilo que se actualiza.
     */
    public void update(Thread thread) {
        this.thread = thread;
        if (alimentar())
            return;
        quiereMoverse();
    }

    Timer moveDelay = new Timer(1000, null);
    double random;

    /**
     * Determina si el animal quiere moverse.
     */
    void quiereMoverse() {
        if (moveDelay.isRunning() && moveDelay.getDelay() <= probabtimeMove) {
            desplazarse();
            hambrePercent += (int) Math.floor(random) % 10;
            return;
        } else if (moveDelay.isRunning())
            return;

        random = Math.random() * 100;
        int wait = ((int) Math.floor(random) % 4) + 1;

        moveDelay = new Timer(wait * 1000 + offsetTimeMove, null);
        moveDelay.start();
        moveDelay.setRepeats(false);
    }

    /**
     * Busca comida para el animal.
     */
    void buscarComida() {
        Deposito deposito = actualHabitat.getDeposito();
        try {
            deposito.getObjeto(tipoAlimento, getClass().getSimpleName(), actualHabitat.getNumeroHabitat(), actualHabitat);
            hambrePercent = 0;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
