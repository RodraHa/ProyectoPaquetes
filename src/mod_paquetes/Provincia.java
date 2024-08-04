package mod_paquetes;

import java.io.Serializable;

/**
 * Enum que representa las provincias con sus coordenadas geográficas.
 * Implementa Serializable para permitir la serialización del enum.
 */
public enum Provincia implements Serializable {
    // Definición de las provincias con sus coordenadas (latitud y longitud)
    PICHINCHA(-0.1464,  -78.4751),
    AZUAY(-2.90055, -79.00453),
    CHIMBORAZO(-1.6709800, -78.6471200),
    GUAYAS(-2.2058400, -79.9079500);

    private double latitud; // Latitud de la provincia
    private double longitud; // Longitud de la provincia

    /**
     * Constructor del enum Provincia.
     *
     * @param latitud Latitud de la provincia
     * @param longitud Longitud de la provincia
     */
    Provincia(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    /**
     * Obtiene la latitud de la provincia.
     *
     * @return Latitud de la provincia
     */
    public double getLatitud() {
        return latitud; // Retorna la latitud
    }

    /**
     * Obtiene la longitud de la provincia.
     *
     * @return Longitud de la provincia
     */
    public double getLongitud() {
        return longitud; // Retorna la longitud
    }

    /**
     * Retorna una representación en cadena del enum Provincia.
     *
     * @return Nombre de la provincia en formato de cadena
     */
    @Override
    public String toString() {
        return this.name(); // Retorna el nombre del enum (nombre de la provincia)
    }
}

