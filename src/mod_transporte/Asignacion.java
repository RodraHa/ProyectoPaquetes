package mod_transporte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mod_administracion.Conductor;
import mod_administracion.Usuario;
import mod_paquetes.EnCurso;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Provincia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que gestiona la asignación de vehículos a conductores y de paquetes a vehículos.
 * Implementa el patrón Singleton para asegurar que solo exista una instancia.
 */
public class Asignacion {
    private static Asignacion instancia; // Instancia única de la clase Asignacion
    private HashMap<Conductor, Vehiculo> asignacionConductores; // Mapea conductores a vehículos
    private HashMap<Vehiculo, ArrayList<Paquete>> asignacionPaquetes; // Mapea vehículos a paquetes
    private ArrayList<Conductor> conductores; // Lista de conductores
    private ArrayList<Vehiculo> vehiculos; // Lista de vehículos

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private Asignacion() {
        asignacionConductores = new HashMap<Conductor, Vehiculo>();
        asignacionPaquetes = new HashMap<Vehiculo, ArrayList<Paquete>>();
        conductores = new ArrayList<Conductor>();
        vehiculos = new ArrayList<Vehiculo>();
    }

    /**
     * Obtiene la instancia única de la clase Asignacion.
     *
     * @return Instancia de Asignacion
     */
    public static Asignacion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Asignacion();
        }
        return instancia;
    }

    /**
     * Agrega un conductor a la lista de conductores y guarda la lista actualizada.
     *
     * @param usuario Conductor a agregar
     */
    public void agregarConductor(Conductor usuario) {
        conductores.add(usuario);
        guardarConductores(); // Método para guardar la lista de conductores (implementación no proporcionada)
    }

    /**
     * Agrega un vehículo a la lista de vehículos y guarda la lista actualizada.
     *
     * @param vehiculo Vehículo a agregar
     */
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        guardarVehiculo(); // Método para guardar la lista de vehículos (implementación no proporcionada)
    }

    /**
     * Elimina un vehículo de la lista de vehículos.
     *
     * @param vehiculo Vehículo a eliminar
     */
    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    /**
     * Elimina un conductor de la lista de conductores.
     *
     * @param conductor Conductor a eliminar
     */
    public void eliminarConductor(Conductor conductor) {
        conductores.remove(conductor);
    }

    /**
     * Obtiene un conductor de la lista de conductores según su cédula.
     *
     * @param cedula Cédula del conductor a buscar
     * @return Conductor correspondiente a la cédula, o null si no se encuentra
     */
    public Conductor obtenerConductorPorCedula(String cedula){
        for (Conductor conductor : conductores) {
            if (conductor.getCedula().equals(cedula)) {
                return conductor;
            }
        }
        return null;
    }

    /**
     * Asigna paquetes a un vehículo basado en la capacidad del vehículo y el destino del paquete.
     *
     * @param vehiculo El vehículo al que se asignarán los paquetes.
     * @param destino La provincia de destino de los paquetes que se asignarán.
     * @return true si los paquetes se asignaron con éxito, false de lo contrario.
     */
    public boolean asignarPaquetesAVehiculo(Vehiculo vehiculo, Provincia destino) {
        ArrayList<Paquete> paquetesPendientes  = Inventario.obtenerInstancia().obtenerPaquetesPendientes();
        ArrayList<Paquete> paquetes;
        int conteoPaquetes = 0;

        // Verifica si hay paquetes pendientes.
        if (paquetesPendientes.isEmpty()) {
            return false;
        } else if (asignacionPaquetes.containsKey(vehiculo)) {
            // Obtiene la lista de paquetes ya asignados al vehículo.
            paquetes = asignacionPaquetes.get(vehiculo);
            conteoPaquetes = paquetes.size();
        } else {
            // Crea una nueva lista de paquetes si el vehículo no tiene paquetes asignados aún.
            paquetes = new ArrayList<>();
            asignacionPaquetes.put(vehiculo, paquetes);
        }

        double capacidad = vehiculo.getCapacidad();

        // Asigna paquetes al vehículo basado en la capacidad disponible y el destino del paquete.
        for (Paquete paquete : paquetesPendientes) {
            if (capacidad >= paquete.getVolumen() ) {
                if(paquete.getProvinciaDestino() == destino) {
                    paquetes.add(paquete);
                    paquete.cambiarEstado(new EnCurso(paquete));
                    capacidad -= paquete.getVolumen();
                }
            } else {
                break;
            }
        }

        // Verifica si se asignaron paquetes nuevos al vehículo.
        if(paquetes == null || paquetes.size() == conteoPaquetes) {
            return false;
        }

        // Actualiza la capacidad del vehículo y guarda la relación de paquetes.
        vehiculo.setCapacidad(capacidad);
        guardarRelacionPaquetes();
        return true;
    }

    /**
     * Obtiene la relación entre vehículos y los paquetes asignados a ellos.
     *
     * @return Un HashMap donde las llaves son vehículos y los valores son listas de paquetes asignados.
     */
    public HashMap<Vehiculo, ArrayList<Paquete>> obtenerRelacionPaqueteVehiculo(){
        return asignacionPaquetes;
    }

    /**
     * Asigna un conductor a un vehículo.
     *
     * @param conductor El conductor que se asignará al vehículo.
     * @param vehiculo El vehículo al que se asignará el conductor.
     */
    public void asignarConductorAVehiculo(Conductor conductor, Vehiculo vehiculo) {
        // Verifica si el conductor ya está asignado a un vehículo.
        if (asignacionConductores.containsKey(conductor)) {
            return;
        }
        // Verifica si el vehículo ya tiene un conductor asignado.
        if (asignacionConductores.containsValue(vehiculo)) {
            return;
        }
        // Asigna el conductor al vehículo y guarda la relación.
        asignacionConductores.put(conductor, vehiculo);
        guardarRelacionConductores();
    }

    /**
     * Obtiene la lista de paquetes asignados a un vehículo basado en el conductor.
     *
     * @param conductor El conductor cuyo vehículo se usará para obtener los paquetes.
     * @return Una lista de paquetes asignados al vehículo del conductor, o null si no se encuentra el conductor.
     */
    public ArrayList<Paquete> obtenerPaquetesConductor(Conductor conductor) {
        // Verifica si el conductor está asignado a algún vehículo.
        if (!asignacionConductores.containsKey(conductor)) {
            return null;
        }
        // Obtiene el vehículo asignado al conductor y los paquetes asignados a ese vehículo.
        Vehiculo vehiculo = asignacionConductores.get(conductor);
        return asignacionPaquetes.get(vehiculo);
    }

    /**
     * Obtiene el conductor asignado a un vehículo.
     *
     * @param vehiculo El vehículo para el cual se desea obtener el conductor.
     * @return El conductor asignado al vehículo, o null si no se encuentra el conductor.
     */
    public Conductor obtenerConductorDeVehiculo(Vehiculo vehiculo){
        for (Map.Entry<Conductor, Vehiculo> entry : asignacionConductores.entrySet()) {
            if (entry.getValue().getNumeroPlaca().equals(vehiculo.getNumeroPlaca())) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Guarda la lista de vehículos en un archivo de serialización.
     */
    public void guardarVehiculo() {
        conexionConSer(vehiculos, "FlotaVehiculos");
    }

    /**
     * Carga la lista de vehículos desde un archivo de serialización.
     */
    public void cargarVehiculos() {
        String filePath = "src\\archivos\\FlotaVehiculos.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            vehiculos = (ArrayList<Vehiculo>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }

    /**
     * Guarda la lista de conductores en un archivo de serialización.
     */
    public void guardarConductores() {
        conexionConSer(conductores, "Conductores");
    }


    /**
     * Carga la lista de conductores desde un archivo de serialización.
     */
    public void cargarConductores() {
        String filePath = "src\\archivos\\Conductores.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            conductores = (ArrayList<Conductor>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }

    /**
     * Guarda la relación entre conductores y vehículos en un archivo de serialización.
     */
    public void guardarRelacionConductores() {
        String filePath = "src\\archivos\\AsignacionConductores.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(asignacionConductores);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga la relación entre conductores y vehículos desde un archivo de serialización.
     */
    public void cargarRelacionConductores() {
        String filePath = "src\\archivos\\AsignacionConductores.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            asignacionConductores = (HashMap<Conductor, Vehiculo>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }

    /**
     * Guarda la relación entre vehículos y paquetes en un archivo de serialización.
     */
    public void guardarRelacionPaquetes() {
        String filePath = "src\\archivos\\AsignacionPaquetes.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(asignacionPaquetes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga la relación entre vehículos y paquetes desde un archivo de serialización.
     */
    public void cargarRelacionPaquetes() {
        String filePath = "src\\archivos\\AsignacionPaquetes.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            asignacionPaquetes = (HashMap<Vehiculo, ArrayList<Paquete>>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }

    /**
     * Guarda un ArrayList en un archivo de serialización.
     *
     * @param array El ArrayList que se guardará en el archivo.
     * @param ruta El nombre del archivo (sin extensión) donde se guardará el ArrayList.
     */
    public void conexionConSer(ArrayList array, String ruta) {
        String filePath = "src\\archivos\\" + ruta + ".ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(array);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la asignación actual entre conductores y vehículos.
     *
     * @return Un HashMap donde las llaves son conductores y los valores son vehículos asignados.
     */
    public HashMap<Conductor, Vehiculo> getAsignacionConductores() {
        return asignacionConductores;
    }

    /**
     * Obtiene un vehículo basado en su número de placa.
     *
     * @param placa El número de placa del vehículo que se desea obtener.
     * @return El vehículo con el número de placa especificado, o null si no se encuentra el vehículo.
     */
    public Vehiculo obtenerVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumeroPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    /**
     * Agrega una lista de conductores a la lista existente de conductores y guarda la lista actualizada.
     *
     * @param usuarios La lista de conductores que se agregarán.
     */
    public void agregarConductores(ArrayList usuario) {
        conductores.addAll(usuario);
        guardarConductores();
    }

    /**
     * Obtiene la lista de conductores.
     *
     * @return Una lista de todos los conductores.
     */
    public ArrayList<Conductor> obtenerConductores() {
        return conductores;
    }

    /**
     * Obtiene una colección iterable de vehículos.
     *
     * @return Una colección iterable de vehículos.
     */
    public Iterable<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }


}
