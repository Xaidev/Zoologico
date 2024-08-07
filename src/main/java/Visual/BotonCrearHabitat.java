package Visual;

import logica.*;

import javax.swing.*;

/**
 * BotonCrearHabitat es una clase que crea un botón que al ser presionado muestra un menú emergente con las opciones de hábitat.
 */
public class BotonCrearHabitat {
    private final JButton boton;
    private final JPopupMenu menu;

    /**
     * Constructor de la clase BotonCrearHabitat.
     *
     * @param panelHabitat El panel de hábitat al cual se agregarán los hábitats creados.
     */
    public BotonCrearHabitat(PanelHabitat panelHabitat) {
        boton = new JButton("Crear Hábitat");
        menu = new JPopupMenu();

        // Tipo de Hábitat
        for (TipoHabitat th : TipoHabitat.values()) {
            JMenuItem item = new JMenuItem(th.name());
            item.addActionListener(e -> {
                try {
                    Habitat habitat = crearHabitat(th);
                    if (habitat != null) {
                        panelHabitat.setHabitat(habitat);
                    }
                } catch (CamposHabitatIncompletosException camposHabitatIncompletosException) {
                    JOptionPane.showMessageDialog(null, "Faltan campos por completar", "Error", JOptionPane.ERROR_MESSAGE);

                }
            });
            menu.add(item);
        }

        boton.addActionListener(e -> menu.show(boton, boton.getWidth() / 2, boton.getHeight() / 2));
    }

    /**
     * Getter del botón.
     *
     * @return El botón de crear hábitat.
     */
    public JButton getBoton() {
        return boton;
    }

    /**
     * Crea un hábitat con los atributos seleccionados por el usuario.
     *
     * @param tipoHabitat Tipo de hábitat a crear (acuático o terrestre).
     * @return El hábitat creado.
     * @throws CamposHabitatIncompletosException Si no se completan todos los campos necesarios para crear el hábitat.
     */
    public Habitat crearHabitat(TipoHabitat tipoHabitat) throws CamposHabitatIncompletosException {
        HabitatDirector director = new HabitatDirector();
        HabitatBuilder builder = null;
        String subTipo = null;

        if (tipoHabitat == TipoHabitat.TERRESTRE) {
            String[] opciones = {"Artico", "Bosque", "Desierto", "Jungla", "Pantano", "Savana"};
            subTipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de hábitat terrestre",
                    "Selección de hábitat", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (subTipo == null) {
                return null;
            }

            switch (subTipo) {
                case "Artico":
                    builder = new BuilderArtico();
                    break;
                case "Bosque":
                    builder = new BuilderBosque();
                    break;
                case "Desierto":
                    builder = new BuilderDesierto();
                    break;
                case "Jungla":
                    builder = new BuilderJungla();
                    break;
                case "Pantano":
                    builder = new BuilderPantano();
                    break;
                case "Savana":
                    builder = new BuilderSavana();
                    break;
                default:
                    return null;
            }
        } else if (tipoHabitat == TipoHabitat.ACUATICO) {
            builder = new BuilderOceano();
        }

        if (builder != null) {
            director.setBuilder(builder);

            TipoSuelo[] suelos = OpcionesHabitat.getSuelos(tipoHabitat, subTipo);
            TipoSuelo tipoSuelo = (TipoSuelo) JOptionPane.showInputDialog(null, "Seleccione el tipo de suelo",
                    "Tipo de Suelo", JOptionPane.QUESTION_MESSAGE, null, suelos, suelos[0]);

            if (tipoSuelo == null) {
                throw new CamposHabitatIncompletosException(null);
            }

            Vegetacion[] vegetaciones = OpcionesHabitat.getVegetacion(tipoHabitat, subTipo);
            Vegetacion vegetacion = (Vegetacion) JOptionPane.showInputDialog(null, "Seleccione el tipo de vegetación",
                    "Tipo de Vegetación", JOptionPane.QUESTION_MESSAGE, null, vegetaciones, vegetaciones[0]);

            if (vegetacion == null) {
                throw new CamposHabitatIncompletosException(null);
            }

            Temperatura[] temperaturas = OpcionesHabitat.getTemperaturas(tipoHabitat, subTipo);
            Temperatura temperatura = (Temperatura) JOptionPane.showInputDialog(null, "Seleccione la temperatura",
                    "Temperatura", JOptionPane.QUESTION_MESSAGE, null, temperaturas, temperaturas[0]);

            if (temperatura == null) {
                throw new CamposHabitatIncompletosException(null);
            }

            Tamaño tamaño = (Tamaño) JOptionPane.showInputDialog(null, "Seleccione el tamaño",
                    "Tamaño", JOptionPane.QUESTION_MESSAGE, null, Tamaño.values(), Tamaño.values()[0]);

            if (tamaño == null) {
                throw new CamposHabitatIncompletosException(null);
            }

            return director.construirHabitat(tipoSuelo, vegetacion, temperatura, tamaño);
        }

        return null;
    }
}
