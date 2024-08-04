package mod_paquetes;

/**
 * Clase que representa el estado "Pendiente" de un paquete.
 * Hereda de EstadoDelPaquete y representa el estado en que el paquete aún no ha sido enviado.
 */
public class Pendiente extends EstadoDelPaquete {

    /**
     * Constructor de la clase Pendiente.
     *
     * @param paquete el paquete asociado a este estado
     */
    public Pendiente(Paquete paquete) {
        super(paquete);
    }

    /**
     * Cambia el estado del paquete a "EnCurso" cuando se inicia el envío.
     */
    @Override
    public void iniciarEnvio() {
        paquete.cambiarEstado(new EnCurso(paquete));
    }

    /**
     * No realiza ninguna acción cuando se completa el envío en el estado "Pendiente".
     */
    @Override
    public void completarEnvio() {
        // No se realiza ninguna acción en el estado Pendiente
    }

    /**
     * Representa el estado "Pendiente" como una cadena de texto.
     *
     * @return el nombre del estado como cadena de texto
     */
    @Override
    public String toString() {
        return "Pendiente";
    }
}

