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
        if(selected.getEspacioHabitat().equals(habitat.getTamaño()))
            return false;
        if(selected.getTemperaturaAdecuada().equals(habitat.getTemperatura()))
            return false;

        return (selected.getTipoHabitat().equals(habitat.getTipoHabitat()));
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
        }
        return aux;
    }
}
