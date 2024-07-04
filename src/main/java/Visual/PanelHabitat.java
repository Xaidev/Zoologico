package Visual;

import logica.Animal;
import logica.CamposHabitatIncompletosException;
import logica.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelHabitat extends JPanel {

    private Habitat habitat;
    private final ArrayList<Animal> animals;
    private final JLabel habitatInfoLabel;
    private JButton botonCrearHabitat;
    private JButton botonRetroceder;
    private final PanelPrincipal panelPrincipal;
    private final PanelEleccionHabitats panelEleccionHabitats;

    public PanelHabitat(Habitat habitat, ArrayList<Animal> animals, PanelPrincipal panelPrincipal, PanelEleccionHabitats panelEleccionHabitats) {
        this.habitat = habitat;
        this.animals = animals;
        this.panelPrincipal = panelPrincipal;
        this.panelEleccionHabitats = panelEleccionHabitats;

        this.setLayout(null);
        this.setBounds(0, 0, 1200, 700);

        //Prueba del habitat
        //Aquí se añadiran los label de imagen dependiendo del tipo de text
        habitatInfoLabel = new JLabel();
        habitatInfoLabel.setBounds(0, 0, 900, 700);
        add(habitatInfoLabel);


        updateHabitatInfo();

        botonRetroceder = new BotonRetroceder(panelPrincipal);

        this.add(botonRetroceder);

        if (habitat == null) {
            BotonCrearHabitat botonCrearHabitat = new BotonCrearHabitat(this);
            this.botonCrearHabitat = botonCrearHabitat.getBoton();
            this.botonCrearHabitat.setBounds(550, 320, 100, 30);
            add(this.botonCrearHabitat);
            this.add(botonRetroceder);
        }
        this.setVisible(true);
    }

    public void setHabitat(Habitat habitat) throws CamposHabitatIncompletosException {
        if(habitat == null || habitat.getTipoSuelo() == null || habitat.getTipoHabitat() == null || habitat.getTamaño() == null || habitat.getTemperatura() == null || habitat.getVegetacion() == null){
            throw new CamposHabitatIncompletosException("Faltan campos por completar");
        }
        this.habitat = habitat;
        int numeroHabitat = panelPrincipal.getNumeroHabitat();
        panelEleccionHabitats.setHabitat(numeroHabitat, habitat);
        updateHabitatInfo();
        if (botonCrearHabitat != null) {
            this.botonCrearHabitat.setVisible(false);
        }
        panelEleccionHabitats.imprimirEstadoActualHabitats();
    }

    // Esta funcion será para añadir una imagen del habitat
    public void updateHabitatInfo() {
        if (habitat != null) {
            switch (habitat.getTipoHabitat()) {
                case ACUATICO:
                    switch (habitat.getTipoSuelo()) {
                        case ARCILLA:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/arcilla.jpg", 0, 0, 1200, 700);
                            break;
                        case LIMO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/limo.jpg", 0, 0, 800, 700);
                            break;
                        case ARENA:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/arena.jpg", 0, 0, 800, 700);
                            break;
                    }
                    break;
                case TERRESTRE:
                    switch (habitat.getTipoSuelo()) {
                        case ACUOSO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/pantano.jpg", 0, 0, 800, 700);
                            break;
                        case TIERRA:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatBosque.png", 0, 0, 800, 700);
                            break;
                        case ARENOSO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/desierto.jpg", 0, 0, 800, 700);
                            break;
                        case QUEBRADO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/jungla.jpg", 0, 0, 800, 700);
                            break;
                        case CONGELADO:
                            crearImagen(habitatInfoLabel, "src/main/java/Visual/Imagenes/HabitatArtico.png", 0, 0, 800, 700);
                            break;
                    }
                    break;
                default:
                    habitatInfoLabel.setText("No se ha creado...");
            }
            PanelAgregarAnimales agregarAnimales = new PanelAgregarAnimales(800,0,habitat,this);
            this.add(agregarAnimales);

        } else {
            habitatInfoLabel.setText("No se ha creado...");

        }
    }



    public void crearImagen(JLabel label, String rutaImagen, int x, int y, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(rutaImagen);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        label.setIcon(newIcon);
        label.setBounds(x, y, ancho, alto);
        label.setVisible(true);
    }



    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        // Asegurarse de que el botón de retroceso siempre esté visible cuando el panel esté visible
        if (visible) {
            botonRetroceder.setVisible(true);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
