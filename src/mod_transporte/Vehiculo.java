package mod_transporte;

import java.io.Serializable;
import mod_paquetes.Provincia;

/**
 * Representa un vehículo en el sistema de transporte.
 * Los vehículos tienen un número de placa, capacidad de carga, ubicación actual y una línea de entrega asignada.
 */
public class Vehiculo implements Serializable {
    private String numeroPlaca;   // Número de placa del vehículo
    private double capacidad;    // Capacidad de carga del vehículo en metros cúbicos (35 a 45 m³)
    private Provincia ubicacion; // Ubicación actual del vehículo
    private LineaDeEntrega lineaDeEntrega; // Línea de entrega asignada al vehículo

    /**
     * Constructor para inicializar un vehículo con el número de placa, capacidad y ubicación.
     *
     * @param numeroPlaca el número de placa del vehículo
     * @param capacidad la capacidad de carga del vehículo en metros cúbicos
     * @param ubicacion la ubicación actual del vehículo
     */
    public Vehiculo(String numeroPlaca, double capacidad, Provincia ubicacion) {
        this.numeroPlaca = numeroPlaca;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Asigna una línea de entrega al vehículo.
     *
     * @param lineaDeEntrega la línea de entrega a asignar
     */
    public void asignarLineaDeEntrega(LineaDeEntrega lineaDeEntrega) {
        this.lineaDeEntrega = lineaDeEntrega;
    }

    /**
     * Obtiene la capacidad de carga del vehículo.
     *
     * @return la capacidad de carga del vehículo en metros cúbicos
     */
    public double getCapacidad() {
        return capacidad;
    }

    /**
     * Obtiene el número de placa del vehículo.
     *
     * @return el número de placa del vehículo
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * Obtiene la ubicación actual del vehículo.
     *
     * @return la ubicación del vehículo como un objeto de tipo Provincia
     */
    public Provincia getUbicacion() {
        return ubicacion;
    }

    /**
     * Devuelve una representación en cadena del vehículo.
     *
     * @return una cadena que representa el vehículo
     */
    @Override
    public String toString() {
        return "Vehiculo{" +
                "numeroPlaca='" + numeroPlaca + '\'' +
                '}';
    }

    /**
     * Establece la capacidad de carga del vehículo.
     *
     * @param capacidad la nueva capacidad de carga en metros cúbicos
     */
    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
}

