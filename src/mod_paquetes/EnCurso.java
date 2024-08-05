package mod_paquetes;

/**
 * Clase que representa el estado de un paquete cuando está en curso de envío.
 * Extiende la clase EstadoDelPaquete para implementar comportamientos específicos del estado "En Curso".
 */
public class EnCurso extends EstadoDelPaquete {

    /**
     * Constructor de la clase EnCurso.
     *
     * @param paquete El paquete asociado a este estado
     */
    public EnCurso(Paquete paquete) {
        super(paquete); // Llama al constructor de la superclase con el paquete
    }

    /**
     * Método para iniciar el envío del paquete.
     * En el estado "En Curso", este método no realiza ninguna acción.
     */
    @Override
    public void iniciarEnvio() {
        // No realiza ninguna acción en el estado "En Curso"
    }

    /**
     * Método para completar el envío del paquete.
     * Cambia el estado del paquete a "Entregado".
     */
    @Override
    public void completarEnvio() {
        // Cambia el estado del paquete a "Entregado"
        paquete.cambiarEstado(new Entregado(paquete));
    }

    /**
     * Representa el estado "En Curso" como una cadena de texto.
     *
     * @return La cadena "En curso"
     */
    @Override
    public String toString() {
        return "En curso"; // Devuelve la representación textual del estado
    }
}
