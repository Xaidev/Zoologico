package logica;

import java.util.ArrayList;

public class FiltroSelectorAnimal {
    private final Habitat habitat;

    // NO SON ANIMALES, SOLO ES PARA TENER SUS ATRIBUTOS
    private final ArrayList<Animal> prototypeAnimalClases;
    public FiltroSelectorAnimal(Habitat h){
        habitat = h;
        prototypeAnimalClases = new ArrayList<Animal>();
        for (SelectorAnimal a : SelectorAnimal.values()){
            Animal c = crearAnimal(a);
            prototypeAnimalClases.add(c);
        }
    }

    public boolean adaptabilidadAnimal(SelectorAnimal a){
        Animal selected = prototypeAnimalClases.get(a.ordinal());
        if (habitat == null)
            return false;
        if(!selected.getTemperaturaAdecuada().equals(habitat.getTemperatura()))
            return false;
        if(!tamañoMargen(habitat,selected))
            return false;
        int i = 0;
        for(TipoSuelo suelo : selected.getSuelosDisponibles()){
            i++;
            if (suelo == null)
                break;
            if(suelo.equals(habitat.getTipoSuelo()))
                break;

            if(selected.getSuelosDisponibles().size() == i)
                return false;
        }


        return (selected.getTipoHabitat().equals(habitat.getTipoHabitat()));
    }

    boolean tamañoMargen(Habitat h,Animal a)
    {
        // RETORNA TRUE SI EL TAMAÑO ES CORRECTO
        if(a.getEspacioHabitat().equals(Tamaño.PEQUEÑO))
            return true;
        if(h.getTamaño().equals(Tamaño.PEQUEÑO))
            return false;
        if(a.getEspacioHabitat().equals(Tamaño.MEDIANO))
            return true;
        if(h.getTamaño().equals(Tamaño.MEDIANO))
            return false;

        return true;
    }

    public Animal crearAnimal(SelectorAnimal a){
        Animal aux;
        switch (a){
            default -> aux = null;
            case Buho -> aux = new Buho();
            case Caiman ->aux =  new Caiman();
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
