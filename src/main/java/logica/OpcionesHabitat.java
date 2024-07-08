package logica;


public class OpcionesHabitat {
    public static TipoSuelo[] getSuelos(TipoHabitat tipoHabitat, String subTipo) {
        switch (tipoHabitat) {
            case ACUATICO:
                return new TipoSuelo[]{TipoSuelo.ACUOSO, TipoSuelo.LIMO,TipoSuelo.ARCILLA};
            case TERRESTRE:
                switch (subTipo) {
                    case "Artico":
                        return new TipoSuelo[]{TipoSuelo.CONGELADO};
                    case "Bosque":
                        return new TipoSuelo[]{TipoSuelo.TIERRA};
                    case "Desierto":
                        return new TipoSuelo[]{TipoSuelo.ARENOSO};
                    case "Jungla":
                        return new TipoSuelo[]{TipoSuelo.QUEBRADO};
                    case "Pantano":
                        return new TipoSuelo[]{TipoSuelo.ACUOSO};
                    case "Savana":
                        return new TipoSuelo[]{TipoSuelo.ARENA};
                    default:
                        return new TipoSuelo[]{};
                }
            default:
                return new TipoSuelo[]{};
        }
    }

    public static Vegetacion[] getVegetacion(TipoHabitat tipoHabitat, String subTipo) {
        switch (tipoHabitat) {
            case ACUATICO:
                return new Vegetacion[]{Vegetacion.ABUNDANTE, Vegetacion.MODERADA};
            case TERRESTRE:
                switch (subTipo) {
                    case "Artico":
                        return new Vegetacion[]{Vegetacion.ESCASA};
                    case "Bosque":
                        return new Vegetacion[]{Vegetacion.ABUNDANTE, Vegetacion.MODERADA};
                    case "Desierto":
                        return new Vegetacion[]{Vegetacion.ESCASA};
                    case "Jungla":
                        return new Vegetacion[]{Vegetacion.ABUNDANTE};
                    case "Pantano":
                        return new Vegetacion[]{Vegetacion.MODERADA, Vegetacion.ABUNDANTE};
                    case "Savana":
                        return new Vegetacion[]{Vegetacion.MODERADA};
                    default:
                        return new Vegetacion[]{};
                }
            default:
                return new Vegetacion[]{};
        }
    }

    public static Temperatura[] getTemperaturas(TipoHabitat tipoHabitat, String subTipo) {
        switch (tipoHabitat) {
            case ACUATICO:
                return new Temperatura[]{Temperatura.BAJA, Temperatura.MEDIA};
            case TERRESTRE:
                switch (subTipo) {
                    case "Artico":
                        return new Temperatura[]{Temperatura.BAJA};
                    case "Bosque":
                        return new Temperatura[]{Temperatura.MEDIA, Temperatura.BAJA};
                    case "Desierto":
                        return new Temperatura[]{Temperatura.ALTA};
                    case "Jungla":
                        return new Temperatura[]{Temperatura.ALTA, Temperatura.MEDIA};
                    case "Pantano":
                        return new Temperatura[]{Temperatura.MEDIA, Temperatura.ALTA};
                    case "Savana":
                        return new Temperatura[]{Temperatura.ALTA};
                    default:
                        return new Temperatura[]{};
                }
            default:
                return new Temperatura[]{};
        }
    }
}

