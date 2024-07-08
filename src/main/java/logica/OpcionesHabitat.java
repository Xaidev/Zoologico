package logica;

/**
 * Clase que proporciona métodos estáticos para obtener opciones de suelo, vegetación y temperatura
 * según el tipo de hábitat y subtipo especificados.
 */
public class OpcionesHabitat {

    /**
     * Obtiene los tipos de suelo disponibles para un hábitat dado.
     *
     * @param tipoHabitat Tipo de hábitat (acuático o terrestre)
     * @param subTipo     Subtipo específico de hábitat terrestre (por ejemplo, "Artico", "Bosque", "Desierto", etc.)
     * @return Arreglo de tipos de suelo disponibles
     */
    public static TipoSuelo[] getSuelos(TipoHabitat tipoHabitat, String subTipo) {
        switch (tipoHabitat) {
            case ACUATICO:
                return new TipoSuelo[]{TipoSuelo.ACUOSO, TipoSuelo.LIMO, TipoSuelo.ARCILLA};
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

    /**
     * Obtiene los tipos de vegetación disponibles para un hábitat dado.
     *
     * @param tipoHabitat Tipo de hábitat (acuático o terrestre)
     * @param subTipo     Subtipo específico de hábitat terrestre (por ejemplo, "Artico", "Bosque", "Desierto", etc.)
     * @return Arreglo de tipos de vegetación disponibles
     */
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

    /**
     * Obtiene las temperaturas adecuadas disponibles para un hábitat dado.
     *
     * @param tipoHabitat Tipo de hábitat (acuático o terrestre)
     * @param subTipo     Subtipo específico de hábitat terrestre (por ejemplo, "Artico", "Bosque", "Desierto", etc.)
     * @return Arreglo de temperaturas adecuadas disponibles
     */
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
