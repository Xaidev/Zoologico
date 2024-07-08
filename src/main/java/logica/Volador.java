package logica;

/**
 * Clase abstracta que representa a los animales voladores.
 * Extiende de la clase Terrestre y proporciona métodos y comportamientos específicos de vuelo.
 */
public abstract class Volador extends Terrestre {

    /**
     * Constructor de la clase Volador.
     * @param tem Temperatura adecuada para el hábitat del animal volador.
     * @param espacioHabitat Tamaño del espacio habitable necesario para el animal volador.
     */
    public Volador(Temperatura tem, Tamaño espacioHabitat) {
        super(tem, espacioHabitat);
    }

    /**
     * Método que controla el desplazamiento del animal volador.
     * Llama al método desplazarse de la superclase Terrestre y luego intenta volar.
     */
    @Override
    public void desplazarse() {
        super.desplazarse(); // Llama al método desplazarse de la clase Terrestre
        try {
            volar(); // Intenta volar
        } catch (InterruptedException e) {
            System.out.println("Error en volar");
        }
    }

    /**
     * Variable para controlar el movimiento vertical durante el vuelo.
     */
    int yMove;

    /**
     * Método que simula el vuelo del animal.
     * Puede mover el animal hacia arriba si ciertas condiciones se cumplen.
     * @throws InterruptedException si ocurre un problema durante la ejecución del hilo.
     */
    void volar() throws InterruptedException {
        random = Math.random() * 100;
        int changeDir = (int) Math.floor(random);

        int flyamount = 10;
        if (changeDir % 8 == 1 && super.animalLabel.getY() == super.startY) {
            for (int i = flyamount; i > 0; i--) {
                super.animalLabel.setLocation(super.animalLabel.getX(), super.animalLabel.getY() - flyamount);
                Thread.sleep(10);
            }
        }
        if (changeDir % 2 == 1 && super.animalLabel.getY() < super.startY) {
            for (int i = flyamount; i > 0; i--) {
                super.animalLabel.setLocation(super.animalLabel.getX(), super.animalLabel.getY() + 1);
                Thread.sleep(10);
            }
        }
    }
}
