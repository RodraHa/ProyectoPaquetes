package mod_paquetes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import mod_administracion.Usuario;

/**
 * Clase que representa un inventario de paquetes utilizando el patrón Singleton.
 * Solo debe haber una instancia de Inventario en la aplicación.
 */
public final class Inventario {
    private static Inventario instancia; // Instancia única de la clase Inventario
    private ArrayList<Paquete> paquetes; // Lista para almacenar los paquetes

    /**
     * Constructor privado para prevenir la creación de instancias desde fuera de la clase.
     * Inicializa la lista de paquetes.
     */
    private Inventario() {
        paquetes = new ArrayList<>();
    }

    /**
     * Método estático para obtener la instancia única de Inventario.
     * Si la instancia no existe, se crea una nueva.
     *
     * @return La instancia única de Inventario
     */
    public static Inventario obtenerInstancia() {
        if (instancia == null) {
            instancia = new Inventario(); // Crea una nueva instancia si no existe
        }
        return instancia; // Retorna la instancia existente o recién creada
    }

    /**
     * Agrega un nuevo paquete al inventario con los detalles proporcionados.
     *
     * @param volumen Volumen del paquete
     * @param peso Peso del paquete
     * @param contenido Contenido del paquete
     * @param remitente Usuario que envía el paquete
     * @param provinciaOrigen Provincia de origen del paquete
     * @param provinciaDestino Provincia de destino del paquete
     * @param direccionDestino Dirección de destino del paquete
     * @param nombreDestinatario Nombre del destinatario
     * @return El paquete recién agregado al inventario
     */
    public Paquete agregarPaquete(double volumen, double peso, String contenido, Usuario remitente, Provincia provinciaOrigen, Provincia provinciaDestino, String direccionDestino, String nombreDestinatario) {
        String nuevoCodigo = getSiguienteCodigoTracking(); // Obtiene un nuevo código de seguimiento
        Paquete paquete = new Paquete(nuevoCodigo, volumen, peso, contenido, remitente, provinciaOrigen, provinciaDestino, direccionDestino, nombreDestinatario);
        paquetes.add(paquete); // Agrega el paquete a la lista de paquetes
        return paquete; // Retorna el paquete recién creado
    }

    /**
     * Genera el siguiente código de seguimiento para un nuevo paquete.
     *
     * @return El siguiente código de seguimiento como una cadena
     */
    public String getSiguienteCodigoTracking() {
        if (paquetes.isEmpty()) {
            return "1"; // Retorna "1" si el inventario está vacío
        }
        // Obtiene el código del último paquete en la lista y lo incrementa
        int codigo = Integer.parseInt(paquetes.get(paquetes.size() - 1).obtenerCodigo());
        codigo++;
        return String.valueOf(codigo); // Retorna el nuevo código como cadena
    }

    /**
     * Agrega un paquete existente al inventario.
     *
     * @param paquete El paquete a agregar
     */
    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete); // Agrega el paquete a la lista de paquetes
    }

    /**
     * Elimina un paquete del inventario.
     *
     * @param paquete El paquete a eliminar
     */
    public void eliminarPaquete(Paquete paquete) {
        paquetes.remove(paquete); // Elimina el paquete de la lista de paquetes
    }

    /**
     * Verifica si un paquete con el código de seguimiento especificado existe en el inventario.
     *
     * @param codigoTracking Código de seguimiento del paquete
     * @return True si el paquete existe, false en caso contrario
     */
    public Boolean existePaquete(String codigoTracking) {
        // Recorre la lista de paquetes para verificar la existencia del paquete con el código dado
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return true; // Retorna true si se encuentra el paquete
            }
        }
        return false; // Retorna false si no se encuentra el paquete
    }

    /**
     * Obtiene el paquete con el código de seguimiento especificado.
     *
     * @param codigoTracking Código de seguimiento del paquete
     * @return El paquete con el código especificado, o null si no se encuentra
     */
    public Paquete obtenerPaquete(String codigoTracking) {
        // Recorre la lista de paquetes para obtener el paquete con el código dado
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return paquete; // Retorna el paquete si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra el paquete
    }

    /**
     * Verifica el estado del paquete con el código de seguimiento especificado.
     *
     * @param codigoTracking Código de seguimiento del paquete
     * @return El estado del paquete, o null si el paquete no se encuentra
     */
    public EstadoDelPaquete verificarEstadoPaquete(String codigoTracking) {
        // Recorre la lista de paquetes para verificar el estado del paquete con el código dado
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return paquete.obtenerEstado(); // Retorna el estado del paquete si se encuentra
            }
        }
        return null; // Retorna null si el paquete no se encuentra
    }

    /**
     * Obtiene una lista de todos los paquetes que están en estado "Pendiente".
     *
     * @return Lista de paquetes que están en estado pendiente
     */
    public ArrayList<Paquete> obtenerPaquetesPendientes() {
        ArrayList<Paquete> paquetesPendientes = new ArrayList<>();
        // Recorre la lista de paquetes para encontrar los que están en estado pendiente
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerEstado() instanceof Pendiente) {
                paquetesPendientes.add(paquete); // Agrega el paquete a la lista si está pendiente
            }
        }
        return paquetesPendientes; // Retorna la lista de paquetes pendientes
    }

    /**
     * Obtiene una lista de todos los paquetes en el inventario.
     *
     * @return Lista de todos los paquetes en el inventario
     */
    public ArrayList<Paquete> obtenerPaquetes() {
        return paquetes; // Retorna la lista completa de paquetes
    }

    /**
     * Guarda el inventario en un archivo serializado.
     */
    public void guardarInventario() {
        String filePath = "src\\archivos\\inventario.ser"; // Ruta del archivo donde se guardará el inventario
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(paquetes); // Escribe la lista de paquetes en el archivo
        } catch (IOException e) {
            e.printStackTrace(); // Imprime el error en caso de excepción
        }
    }

    /**
     * Carga el inventario desde un archivo serializado.
     */
    public void cargarInventario() {
        String filePath = "src\\archivos\\inventario.ser"; // Ruta del archivo desde donde se cargará el inventario
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            paquetes = (ArrayList<Paquete>) ois.readObject(); // Lee la lista de paquetes desde el archivo
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo"); // Imprime un mensaje si ocurre una excepción
        }
    }
}
