package Visual;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BotonCrearHabitat {
    private final JButton boton;
    private final JPopupMenu menu;

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

    public JButton getBoton() {
        return boton;
    }

    public Habitat crearHabitat(TipoHabitat tipoHabitat) throws CamposHabitatIncompletosException{
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

            if(tipoSuelo == null){
                throw new CamposHabitatIncompletosException(null);
            }
            Vegetacion[] vegetaciones = OpcionesHabitat.getVegetacion(tipoHabitat, subTipo);
            Vegetacion vegetacion = (Vegetacion) JOptionPane.showInputDialog(null, "Seleccione el tipo de vegetación",
                    "Tipo de Vegetación", JOptionPane.QUESTION_MESSAGE, null, vegetaciones, vegetaciones[0]);
            if(vegetacion == null){
                throw new CamposHabitatIncompletosException(null);
            }

            Temperatura[] temperaturas = OpcionesHabitat.getTemperaturas(tipoHabitat, subTipo);
            Temperatura temperatura = (Temperatura) JOptionPane.showInputDialog(null, "Seleccione la temperatura",
                    "Temperatura", JOptionPane.QUESTION_MESSAGE, null, temperaturas, temperaturas[0]);
            if(temperatura == null){
                throw new CamposHabitatIncompletosException(null);
            }


            Tamaño tamaño = (Tamaño) JOptionPane.showInputDialog(null, "Seleccione el tamaño",
                    "Tamaño", JOptionPane.QUESTION_MESSAGE, null, Tamaño.values(), Tamaño.values()[0]);
            if(tamaño == null){
                throw new CamposHabitatIncompletosException(null);
            }

            return director.construirHabitat(tipoSuelo, vegetacion, temperatura, tamaño);
        }

        return null;
    }
}