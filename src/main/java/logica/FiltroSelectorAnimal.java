package logica;

import java.util.ArrayList;

/**
 * Clase que gestiona la selección y adaptabilidad de animales basada en un hábitat dado.
 * Utiliza prototipos de animales para evaluar su adecuación al hábitat.
 */
public class FiltroSelectorAnimal {
    private final Habitat habitat;
    // NO SON ANIMALES, SOLO ES PARA TENER SUS ATRIBUTOS
    private final ArrayList<Animal> prototypeAnimalClases;

    /**
     * Constructor de FiltroSelectorAnimal que inicializa con un hábitat dado.
     * Crea prototipos de animales disponibles para el selector.
     *
     * @param h El hábitat para el cual se realizará la selección de animales.
     */
    public FiltroSelectorAnimal(Habitat h) {
        habitat = h;
        prototypeAnimalClases = new ArrayList<Animal>();
        for (SelectorAnimal a : SelectorAnimal.values()) {
            Animal c = crearAnimal(a);
            prototypeAnimalClases.add(c);
        }
    }

    /**
     * Evalúa la adaptabilidad de un animal específico al hábitat actual.
     *
     * @param a El tipo de animal a evaluar.
     * @return true si el animal es adecuado para el hábitat, false en caso contrario.
     */
    public boolean adaptabilidadAnimal(SelectorAnimal a) {
        Animal selected = prototypeAnimalClases.get(a.ordinal());
        if (habitat == null)
            return false;
        if (!selected.getTemperaturaAdecuada().equals(habitat.getTemperatura()))
            return false;
        if (!tamañoMargen(habitat, selected))
            return false;
        int i = 0;
        for (TipoSuelo suelo : selected.getSuelosDisponibles()) {
            i++;
            if (suelo == null)
                break;
            if (suelo.equals(habitat.getTipoSuelo()))
                break;

            if (selected.getSuelosDisponibles().size() == i)
                return false;
        }
        return (selected.getTipoHabitat().equals(habitat.getTipoHabitat()));
    }

    /**
     * Verifica si el tamaño del hábitat es adecuado para el animal.
     *
     * @param h El hábitat a evaluar.
     * @param a El animal para el cual se evalúa el tamaño del hábitat.
     * @return true si el tamaño del hábitat es adecuado para el animal, false en caso contrario.
     */
    boolean tamañoMargen(Habitat h, Animal a) {
        // RETORNA TRUE SI EL TAMAÑO ES CORRECTO
        if (a.getEspacioHabitat().equals(Tamaño.PEQUEÑO))
            return true;
        if (h.getTamaño().equals(Tamaño.PEQUEÑO))
            return false;
        if (a.getEspacioHabitat().equals(Tamaño.MEDIANO))
            return true;
        return !h.getTamaño().equals(Tamaño.MEDIANO);
    }

    /**
     * Crea un objeto animal basado en el tipo especificado.
     *
     * @param a El tipo de animal a crear.
     * @return Una instancia del animal creado.
     */
    public Animal crearAnimal(SelectorAnimal a) {
        Animal aux;
        switch (a) {
            default -> aux = null;
            case Buho -> aux = new Buho();
            case Caiman -> aux = new Caiman();
            case Camello -> aux = new Camello();
            case Ciervo -> aux = new Ciervo();
            case Elefante -> aux = new Elefante();
            case Fennec -> aux = new Fennec();
            case Guacamayo -> aux = new Guacamayo();
            case Jaguar -> aux = new Jaguar();
            case Leon -> aux = new Leon();
            case OsoPolar -> aux = new OsoPolar();
            case ZorroArtico -> aux = new ZorroArtico();
            case TortugaMarina -> aux = new TortugaMarina();
            case Rana -> aux = new Rana();
            case Tiburon -> aux = new Tiburon();
            case CaballitoDeMar -> aux = new CaballitoDeMar();
        }
        aux.setHabitat(habitat);
        return aux;
    }
}
