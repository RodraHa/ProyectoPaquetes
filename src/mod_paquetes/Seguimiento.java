package mod_paquetes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que maneja el seguimiento de un paquete, incluyendo el estado actual,
 * estados anteriores, y el registro de incidentes.
 * Implementa Serializable para permitir la serialización de la instancia.
 */
public class Seguimiento implements Serializable {
    private EstadoDelPaquete estadoActual; // Estado actual del paquete
    private ArrayList<String> estadosAnteriores; // Lista de estados anteriores del paquete
    private String registroIncidente; // Descripción del incidente registrado
    private String resolucionIncidente; // Descripción de la resolución del incidente

    /**
     * Constructor de la clase Seguimiento.
     *
     * @param estado Estado inicial del paquete
     */
    public Seguimiento(EstadoDelPaquete estado) {
        this.estadoActual = estado; // Inicializa el estado actual
        this.estadosAnteriores = new ArrayList<>(); // Inicializa la lista de estados anteriores
    }

    /**
     * Notifica un cambio en el estado del paquete y actualiza la lista de estados anteriores.
     *
     * @param estado Nuevo estado del paquete
     */
    public void notificar(EstadoDelPaquete estado) {
        estadosAnteriores.add(estadoActual.toString()); // Agrega el estado actual a la lista de estados anteriores
        this.estadoActual = estado; // Actualiza el estado actual
    }

    /**
     * Verifica si la entrega del paquete está pendiente.
     *
     * @return true si el estado actual es Pendiente, false en caso contrario
     */
    public boolean verificarEntregaPendiente() {
        return estadoActual instanceof Pendiente; // Verifica si el estado actual es una instancia de Pendiente
    }

    /**
     * Obtiene el estado actual del paquete.
     *
     * @return Estado actual del paquete
     */
    public EstadoDelPaquete obtenerEstado() {
        return this.estadoActual; // Retorna el estado actual
    }

    /**
     * Obtiene la lista de estados anteriores del paquete.
     *
     * @return Lista de estados anteriores
     */
    public ArrayList<String> obtenerEstadosAnteriores() {
        return estadosAnteriores; // Retorna la lista de estados anteriores
    }

    /**
     * Registra un incidente relacionado con el paquete.
     *
     * @param definicion Descripción del incidente
     */
    public void registrarIncidente(String definicion) {
        registroIncidente = definicion; // Asigna la descripción del incidente
    }

    /**
     * Registra la resolución del incidente relacionado con el paquete.
     *
     * @param definicion Descripción de la resolución del incidente
     */
    public void resolverIncidente(String definicion) {
        resolucionIncidente = definicion; // Asigna la descripción de la resolución del incidente
    }

    /**
     * Obtiene la descripción del incidente registrado.
     *
     * @return Descripción del incidente
     */
    public String obtenerRegistroIncidente() {
        return this.registroIncidente; // Retorna la descripción del incidente registrado
    }

    /**
     * Obtiene la descripción de la resolución del incidente.
     *
     * @return Descripción de la resolución del incidente
     */
    public String obtenerResolucion() {
        return this.resolucionIncidente; // Retorna la descripción de la resolución del incidente
    }
}
