package mod_paquetes;

import java.io.Serializable;

/**
 * Clase abstracta que representa el estado de un paquete.
 * Esta clase proporciona una estructura para los diferentes estados que un paquete puede tener durante su ciclo de vida.
 * Implementa la interfaz Serializable para permitir la serialización del estado del paquete.
 */
public abstract class EstadoDelPaquete implements Serializable {
    // Paquete asociado con este estado
    protected Paquete paquete;

    /**
     * Constructor de la clase EstadoDelPaquete.
     *
     * @param paquete el paquete que tiene este estado
     */
    public EstadoDelPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    /**
     * Método abstracto para iniciar el envío del paquete.
     * Debe ser implementado por las clases concretas que representan estados específicos del paquete.
     */
    public abstract void iniciarEnvio();

    /**
     * Método abstracto para completar el envío del paquete.
     * Debe ser implementado por las clases concretas que representan estados específicos del paquete.
     */
    public abstract void completarEnvio();
}
