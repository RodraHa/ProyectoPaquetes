package mod_paquetes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import mod_administracion.Usuario;

import java.util.ArrayList;

/**
 * Clase que representa un paquete en el sistema de seguimiento.
 * Implementa Serializable para permitir la serialización del objeto.
 */
public class Paquete implements Serializable {
    private String codigoTracking; // Código de seguimiento único del paquete
    private double volumen; // Volumen del paquete en metros cúbicos
    private double peso; // Peso del paquete en kilogramos
    private String contenido; // Descripción del contenido del paquete
    private Usuario remitente; // Usuario que envía el paquete
    private Provincia provinciaOrigen; // Provincia de origen del paquete
    private Provincia provinciaDestino; // Provincia de destino del paquete
    private String direccionDestino; // Dirección de destino del paquete
    private String nombreDestinatario; // Nombre del destinatario del paquete
    private EstadoDelPaquete estado; // Estado actual del paquete
    private Seguimiento seguimiento; // Objeto para el seguimiento del paquete

    /**
     * Constructor de la clase Paquete.
     * Inicializa todos los atributos del paquete y establece su estado inicial como "Pendiente".
     *
     * @param codigoTracking Código de seguimiento del paquete
     * @param volumen Volumen del paquete
     * @param peso Peso del paquete
     * @param contenido Contenido del paquete
     * @param remitente Usuario que envía el paquete
     * @param provinciaOrigen Provincia de origen del paquete
     * @param provinciaDestino Provincia de destino del paquete
     * @param direccionDestino Dirección de destino del paquete
     * @param nombreDestinatario Nombre del destinatario del paquete
     */
    public Paquete(String codigoTracking, double volumen, double peso, String contenido, Usuario remitente, Provincia provinciaOrigen, Provincia provinciaDestino, String direccionDestino, String nombreDestinatario) {
        this.codigoTracking = codigoTracking;
        this.volumen = volumen;
        this.peso = peso;
        this.contenido = contenido;
        this.remitente = remitente;
        this.provinciaOrigen = provinciaOrigen;
        this.provinciaDestino = provinciaDestino;
        this.direccionDestino = direccionDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.estado = new Pendiente(this); // Establece el estado inicial como Pendiente
        this.seguimiento = new Seguimiento(estado); // Inicializa el objeto de seguimiento con el estado inicial
    }

    /**
     * Cambia el estado del paquete y notifica al objeto de seguimiento.
     *
     * @param estado Nuevo estado del paquete
     */
    public void cambiarEstado(EstadoDelPaquete estado) {
        this.estado = estado; // Actualiza el estado del paquete
        seguimiento.notificar(estado); // Notifica al objeto de seguimiento sobre el cambio de estado
    }

    /**
     * Obtiene el historial de estados anteriores del paquete.
     *
     * @return Lista de estados anteriores del paquete
     */
    public ArrayList<String> obtenerHistorialEstados() {
        return seguimiento.obtenerEstadosAnteriores(); // Retorna el historial de estados del paquete
    }

    /**
     * Calcula la distancia entre la provincia de origen y la provincia de destino del paquete.
     * Utiliza la fórmula de Haversine para calcular la distancia en kilómetros.
     *
     * @return Distancia estimada en kilómetros
     */
    public double calcularDistancia() {
        double longitude1 = provinciaOrigen.getLongitud(); // Longitud de la provincia de origen
        double longitude2 = provinciaDestino.getLongitud(); // Longitud de la provincia de destino
        double latitude1 = provinciaOrigen.getLatitud(); // Latitud de la provincia de origen
        double latitude2 = provinciaDestino.getLatitud(); // Latitud de la provincia de destino
        double theta = longitude1 - longitude2; // Diferencia de longitud
        double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
                Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) +
                        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
        );
        double convertedDistance = Math.round(distance * 1.609344); // Convierte la distancia a kilómetros y redondea
        BigDecimal bd = new BigDecimal(convertedDistance);
        bd = bd.setScale(2, RoundingMode.HALF_UP); // Redondea la distancia a dos decimales
        double roundedDistance = bd.doubleValue(); // Obtiene el valor redondeado como double
        return roundedDistance; // Retorna la distancia redondeada
    }

    /**
     * Obtiene el estado actual del paquete.
     *
     * @return El estado actual del paquete
     */
    public EstadoDelPaquete obtenerEstado() {
        return estado; // Retorna el estado actual del paquete
    }

    /**
     * Obtiene el código de seguimiento del paquete.
     *
     * @return Código de seguimiento del paquete
     */
    public String obtenerCodigo() {
        return codigoTracking; // Retorna el código de seguimiento del paquete
    }

    /**
     * Obtiene el volumen del paquete.
     *
     * @return Volumen del paquete en metros cúbicos
     */
    public double getVolumen() {
        return volumen; // Retorna el volumen del paquete
    }

    /**
     * Obtiene el usuario que envía el paquete.
     *
     * @return Usuario que envía el paquete
     */
    public Usuario getRemitente() {
        return remitente; // Retorna el usuario remitente
    }

    /**
     * Obtiene el peso del paquete.
     *
     * @return Peso del paquete en kilogramos
     */
    public double getPeso() {
        return peso; // Retorna el peso del paquete
    }

    /**
     * Obtiene la provincia de origen del paquete.
     *
     * @return Provincia de origen del paquete
     */
    public Provincia getProvinciaOrigen() {
        return provinciaOrigen; // Retorna la provincia de origen
    }

    /**
     * Obtiene la provincia de destino del paquete.
     *
     * @return Provincia de destino del paquete
     */
    public Provincia getProvinciaDestino() {
        return provinciaDestino; // Retorna la provincia de destino
    }

    /**
     * Obtiene la dirección de destino del paquete.
     *
     * @return Dirección de destino del paquete
     */
    public String getDireccionDestino() {
        return direccionDestino; // Retorna la dirección de destino
    }

    /**
     * Obtiene el código de seguimiento del paquete.
     *
     * @return Código de seguimiento del paquete
     */
    public String getCodigoTracking() {
        return codigoTracking; // Retorna el código de seguimiento del paquete
    }

    /**
     * Obtiene el nombre del destinatario del paquete.
     *
     * @return Nombre del destinatario
     */
    public String getNombreDestinatario() {
        return nombreDestinatario; // Retorna el nombre del destinatario
    }

    /**
     * Retorna una representación en cadena del objeto Paquete.
     *
     * @return Información detallada del paquete en formato de cadena
     */
    public String toString() {
        return "Paquete: \n" +
                "Código Tracking = '" + codigoTracking + "'\n" +
                "Volumen = " + volumen + " m3\n" +
                "Peso = " + peso + " Kg\n" +
                "Contenido = '" + contenido + "'\n" +
                "Remitente = " + remitente + "\n" +
                "Provincia de Origen = " + provinciaOrigen.name() + "\n" +
                "Provincia de Destino = " + provinciaDestino.name() + "\n" +
                "Dirección de Destino = '" + direccionDestino + '\'' + "\n" +
                "Estado = " + estado + "\n" +
                "Distancia Estimada = " + calcularDistancia() + " Km\n" +
                "Destinatario = " + nombreDestinatario + "\n";
    }

    /**
     * Obtiene el contenido del paquete.
     *
     * @return Contenido del paquete
     */
    public String getContenido() {
        return this.contenido; // Retorna el contenido del paquete
    }

    /**
     * Obtiene el objeto de seguimiento del paquete.
     *
     * @return Objeto de seguimiento del paquete
     */
    public Seguimiento obtenerSeguimiento() {
        return this.seguimiento; // Retorna el objeto de seguimiento del paquete
    }
}
