package mod_paquetes;

/**
 * Clase que representa el estado de un paquete cuando ha sido entregado.
 * Extiende la clase EstadoDelPaquete para implementar comportamientos específicos del estado "Entregado".
 */
public class Entregado extends EstadoDelPaquete {

    /**
     * Constructor de la clase Entregado.
     *
     * @param paquete El paquete asociado a este estado
     */
    public Entregado(Paquete paquete) {
        super(paquete); // Llama al constructor de la superclase con el paquete
    }

    /**
     * Método para iniciar el envío del paquete.
     * En el estado "Entregado", este método no realiza ninguna acción.
     */
    @Override
    public void iniciarEnvio() {
        // No realiza ninguna acción en el estado "Entregado"
    }

    /**
     * Método para completar el envío del paquete.
     * En el estado "Entregado", este método no realiza ninguna acción.
     */
    @Override
    public void completarEnvio() {
        // No realiza ninguna acción en el estado "Entregado"
    }

    /**
     * Representa el estado "Entregado" como una cadena de texto.
     *
     * @return La cadena "Entregado"
     */
    @Override
    public String toString() {
        return "Entregado"; // Devuelve la representación textual del estado
    }
}

