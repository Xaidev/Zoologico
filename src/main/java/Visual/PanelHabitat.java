package Visual;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * La clase PanelHabitat representa un JPanel para mostrar información del hábitat e interactuar con la creación y selección de hábitats.
 */
public class PanelHabitat extends JPanel {

    private Habitat habitat;
    private final JLabel habitatInfoLabel;
    private JButton botonCrearHabitat;
    private final JButton botonRetroceder;
    private final PanelPrincipal panelPrincipal;
    private final PanelEleccionHabitats panelEleccionHabitats;
    private int numeroHabitat;
    private ArrayList<BotonEleccionHabitat> botonesEleccionHabitat;
    private PanelManual panelManual;
    BotonManual botonManual;

    /**
     * Constructor de la clase PanelHabitat.
     *
     * @param habitat             El objeto hábitat que se mostrará y gestionará.
     * @param panelPrincipal      El panel principal de la aplicación.
     * @param panelEleccionHabitats El panel para la selección de hábitats.
     */
    public PanelHabitat(Habitat habitat, int numeroHabitat, PanelPrincipal panelPrincipal, PanelEleccionHabitats panelEleccionHabitats) {
        this.habitat = habitat;
        this.panelPrincipal = panelPrincipal;
        this.panelEleccionHabitats = panelEleccionHabitats;
        this.numeroHabitat = numeroHabitat;
        this.botonesEleccionHabitat = panelEleccionHabitats.getBotonesEleccionHabitat();
        this.panelManual = new PanelManual();

        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0, 0, 1200, 700);

        // Prueba del hábitat
        // Aquí se añadirán los label de imagen dependiendo del tipo de texto
        habitatInfoLabel = new JLabel();
        habitatInfoLabel.setBounds(0, 0, 900, 700);

        updateHabitatInfo();

        botonManual = new BotonManual(panelManual);
        botonRetroceder = new BotonRetroceder(panelPrincipal);
        this.add(botonRetroceder);

        if (habitat == null) {
            BotonCrearHabitat botonCrearHabitat = new BotonCrearHabitat(this);
            this.botonCrearHabitat = botonCrearHabitat.getBoton();
            this.botonCrearHabitat.setBounds(550, 320, 100, 50);
            add(this.botonCrearHabitat);
            this.add(botonRetroceder);
        }
        this.setVisible(true);
    }

    /**
     * Establece el hábitat y actualiza la información del hábitat.
     *
     * @param habitat El nuevo objeto hábitat.
     * @throws CamposHabitatIncompletosException Si faltan campos por completar en el hábitat.
     */
    public void setHabitat(Habitat habitat) throws CamposHabitatIncompletosException {
        if (habitat == null || habitat.getTipoSuelo() == null || habitat.getTipoHabitat() == null || habitat.getTamaño() == null || habitat.getTemperatura() == null || habitat.getVegetacion() == null) {
            System.out.println("Faltan campos por completar");
            throw new CamposHabitatIncompletosException("Faltan campos por completar");
        }
        this.habitat = habitat;
        numeroHabitat = panelPrincipal.getNumeroHabitat();
        habitat.setNumeroHabitat(numeroHabitat);
        panelEleccionHabitats.setHabitat(numeroHabitat, habitat);
        updateHabitatInfo();
        if (botonCrearHabitat != null) {
            this.botonCrearHabitat.setVisible(false);
        }
        panelPrincipal.getPanelAvisosHabitat(numeroHabitat).setBounds(800,350,400,100);
        this.add(panelPrincipal.getPanelAvisosHabitat(numeroHabitat));

        panelEleccionHabitats.imprimirEstadoActualHabitats();
    }

    /**
     * Actualiza la información visual del hábitat en función de sus características.
     */
    public void updateHabitatInfo() {
        if (habitat != null) {
            switch (habitat.getTipoHabitat()) {
                case ACUATICO:
                    switch (habitat.getTipoSuelo()) {
                        case ARCILLA:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatAcuatico.png", 0, 0, 1200, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatAcuatico.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                        case LIMO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatAcuatico.png", 0, 0, 800, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatAcuatico.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                        case ACUOSO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatAcuatico.png", 0, 0, 800, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatAcuatico.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                    }
                    break;
                case TERRESTRE:
                    switch (habitat.getTipoSuelo()) {
                        case ARENA:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatSavana.png", 0, 0, 800, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatSavana.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                        case ACUOSO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatPantano.png", 0, 0, 800, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatArtico.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                        case TIERRA:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatBosque.png", 0, 0, 800, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatBosque.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                        case ARENOSO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatDesierto.png", 0, 0, 800, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatDesierto.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                        case QUEBRADO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatJungla.png", 0, 0, 800, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatJungla.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                        case CONGELADO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatArtico.png" , 0, 0, 800, 700);
                            botonesEleccionHabitat.get(numeroHabitat).crearImagen(botonesEleccionHabitat.get(numeroHabitat).conseguirLabel(), "src/main/java/Visual/Imagenes/HabitatArtico.png", 0, 0, 200, 200);
                            botonesEleccionHabitat.get(numeroHabitat).setBorderPainted(false);
                            break;
                    }
                    break;
                default:
                    habitatInfoLabel.setText("No se ha creado...");
            }
            PanelAgregarAnimales agregarAnimales = new PanelAgregarAnimales(800, 0, habitat, this, panelManual);
            botonManual = new BotonManual(panelManual);
            this.add(botonManual);
            this.add(agregarAnimales);
            PanelComida panelComida = new PanelComida(habitat,this, panelPrincipal);
            this.add(panelComida);
        }
    }

    /**
     * Crea una imagen y la establece en un JLabel.
     *
     * @param label     El JLabel donde se mostrará la imagen.
     * @param rutaImagen La ruta de la imagen.
     * @param x         La coordenada x de la imagen.
     * @param y         La coordenada y de la imagen.
     * @param ancho     El ancho de la imagen.
     * @param alto      El alto de la imagen.
     */
    public void crearImagen(JLabel label, String rutaImagen, int x, int y, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(rutaImagen);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        label.setIcon(newIcon);
        label.setBounds(x, y, ancho, alto);
        label.setVisible(true);
    }

    /**
     * Establece la visibilidad del panel.
     *
     * @param visible Si el panel debe ser visible o no.
     */
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            botonRetroceder.setVisible(true);
            botonManual.setVisible(true);
        }
    }

    public int getNumeroHabitat() {
        return numeroHabitat;
    }

    /**
     * Sobrescribe el método paintComponent para agregar el JLabel de información del hábitat al panel.
     *
     * @param g El contexto gráfico en el cual dibujar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        add(habitatInfoLabel);
        super.paintComponent(g);
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }
}
