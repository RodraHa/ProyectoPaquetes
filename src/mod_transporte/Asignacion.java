package mod_transporte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mod_administracion.Conductor;
import mod_paquetes.EnCurso;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Asignacion {
    private static Asignacion instancia;
    private HashMap<Vehiculo, ArrayList<Paquete>> asignacionPaquetes;
    private ArrayList<Vehiculo> vehiculos;

    private Asignacion() {
        asignacionPaquetes = new HashMap<Vehiculo, ArrayList<Paquete>>();
        vehiculos = new ArrayList<Vehiculo>();
    }

    public static Asignacion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Asignacion();
        }
        return instancia;
    }


    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        guardarVehiculo();
    }


    public boolean asignarPaquetesAVehiculo(Vehiculo vehiculo, Provincia destino) {
        ArrayList<Paquete> paquetesPendientes = Inventario.obtenerInstancia().obtenerPaquetesPendientes();
        ArrayList<Paquete> paquetes;
        Vehiculo vehiculoAUsar = null;
        int conteoPaquetes = 0;
        for (Map.Entry<Vehiculo, ArrayList<Paquete>> entry : asignacionPaquetes.entrySet()) {
            if (entry.getKey().getNumeroPlaca().equals(vehiculo.getNumeroPlaca())) {
                vehiculoAUsar = entry.getKey();
                break;
            }
        }

        if (paquetesPendientes.isEmpty()) {
            return false;
        } else if (vehiculoAUsar == null) {
            paquetes = new ArrayList<>();
            asignacionPaquetes.put(vehiculo, paquetes);
        } else {
            paquetes = asignacionPaquetes.get(vehiculoAUsar);
            conteoPaquetes = paquetes.size();
        }
        double capacidad = vehiculo.getCapacidad();

        for (Paquete paquete : paquetesPendientes) {
            if (capacidad >= paquete.getVolumen()) {
                if (paquete.getProvinciaDestino() == destino) {
                    paquetes.add(paquete);
                    paquete.cambiarEstado(new EnCurso(paquete));
                    capacidad -= paquete.getVolumen();
                }
            } else {
                break;
            }
        }
        if (paquetes == null || paquetes.size() == conteoPaquetes) {
            return false;
        }

        vehiculo.setCapacidad(capacidad);
        if (vehiculoAUsar != null) {
            asignacionPaquetes.remove(vehiculoAUsar);
            asignacionPaquetes.put(vehiculo, paquetes);
        }
        guardarVehiculo();
        guardarRelacionPaquetes();
        Inventario.obtenerInstancia().guardarInventario();
        return true;
    }

    public HashMap<Vehiculo, ArrayList<Paquete>> obtenerRelacionPaqueteVehiculo() {
        return asignacionPaquetes;
    }






    public void guardarVehiculo() {
        conexionConSer(vehiculos, "FlotaVehiculos");
    }

    public void cargarVehiculos() {
        String filePath = "src\\archivos\\FlotaVehiculos.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            vehiculos = (ArrayList<Vehiculo>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }


    

    public void guardarRelacionPaquetes() {
        String filePath = "src\\archivos\\AsignacionPaquetes.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(asignacionPaquetes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarRelacionPaquetes() {
        String filePath = "src\\archivos\\AsignacionPaquetes.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            asignacionPaquetes = (HashMap<Vehiculo, ArrayList<Paquete>>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public void conexionConSer(ArrayList array, String ruta) {
        String filePath = "src\\archivos\\" + ruta + ".ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(array);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vehiculo obtenerVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumeroPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    public Iterable<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

}
