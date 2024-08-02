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

public class Asignacion {
    private static Asignacion instancia;
    private HashMap<Conductor, Vehiculo> asignacionConductores;
    private HashMap<Vehiculo, ArrayList<Paquete>> asignacionPaquetes;
    private ArrayList<Conductor> conductores;
    private ArrayList<Vehiculo> vehiculos;

    private Asignacion() {
        asignacionConductores = new HashMap<Conductor, Vehiculo>();
        asignacionPaquetes = new HashMap<Vehiculo, ArrayList<Paquete>>();
        conductores = new ArrayList<Conductor>();
        vehiculos = new ArrayList<Vehiculo>();
    }

    public static Asignacion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Asignacion();
        }
        return instancia;
    }

    public void agregarConductor(Conductor usuario) {
        conductores.add(usuario);
        guardarConductores();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        guardarVehiculo();
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarConductor(Conductor conductor) {
        conductores.remove(conductor);
    }
    
    public Conductor obtenerConductorPorCedula(String cedula){
        for(Conductor conductor: conductores){
            if(conductor.getCedula().equals(cedula)){
                return conductor;
            }
        }
        return null;
    }
    
    public void asignarPaquetesAVehiculo(Vehiculo vehiculo) {
        ArrayList<Paquete> paquetesPendientes  = Inventario.obtenerInstancia().obtenerPaquetesPendientes();
        ArrayList<Paquete> paquetes;
        if (paquetesPendientes.isEmpty()) {
            return;
        } else if (asignacionPaquetes.containsKey(vehiculo)) {
            paquetes = asignacionPaquetes.get(vehiculo);
        } else {
            paquetes = new ArrayList<>();
            asignacionPaquetes.put(vehiculo, paquetes);
        }
        double capacidadDisponible = vehiculo.getCapacidad();

        HashMap<Provincia, ArrayList<Paquete>> paquetesPorProvincia = new HashMap<>();

        for (Paquete paquete : paquetesPendientes) {
            Provincia provincia = paquete.getProvinciaDestino();
            paquetesPorProvincia.putIfAbsent(provincia, new ArrayList<>());
            paquetesPorProvincia.get(provincia).add(paquete);
        }

        for (Map.Entry<Provincia, ArrayList<Paquete>> entry : paquetesPorProvincia.entrySet()) {
            ArrayList<Paquete> paquetesProvincia = entry.getValue();
            for (Paquete paquete : paquetesProvincia) {
                if (capacidadDisponible >= paquete.getVolumen()) {
                    paquetes.add(paquete);
                    paquete.cambiarEstado(new EnCurso(paquete));
                    capacidadDisponible -= paquete.getVolumen();
                } else {
                    break;
                }
            }
        }
    }

    public void asignarConductorAVehiculo(Conductor conductor, Vehiculo vehiculo) {
        if (asignacionConductores.containsKey(conductor)) {
            return;
        }
        if (asignacionConductores.containsValue(vehiculo)) {
            return;
        }
        asignacionConductores.put(conductor, vehiculo);
        guardarRelacionConductores();
    }

    public ArrayList<Paquete> obtenerPaquetesConductor(Conductor conductor) {
        if (!asignacionConductores.containsKey(conductor)) {
            return null;
        }
        Vehiculo vehiculo = asignacionConductores.get(conductor);
        return asignacionPaquetes.get(vehiculo);
    }
    
    public Conductor obtenerConductorDeVehiculo(Vehiculo vehiculo){
        for (Map.Entry<Conductor, Vehiculo> entry : asignacionConductores.entrySet()) {
            if (entry.getValue().getNumeroPlaca().equals(vehiculo.getNumeroPlaca())) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public void guardarVehiculo() {
        conexionConSer(vehiculos,"FlotaVehiculos");
    }
    
    public void cargarVehiculos() {
        String filePath = "src\\archivos\\FlotaVehiculos.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            vehiculos = (ArrayList<Vehiculo>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }
    
    public void guardarConductores() {
        conexionConSer(conductores,"Conductores");
    }
    
    public void cargarConductores() {
        String filePath = "src\\archivos\\Conductores.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            conductores = (ArrayList<Conductor>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }
    public void guardarRelacionConductores() {
        String filePath = "src\\archivos\\AsignacionConductores.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(asignacionConductores);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void cargarRelacionConductores() {
        String filePath = "src\\archivos\\AsignacionConductores.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            asignacionConductores = (HashMap<Conductor,Vehiculo>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }
    
    public void conexionConSer(ArrayList array, String ruta){
        String filePath = "src\\archivos\\"+ruta+".ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(array);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public HashMap<Conductor, Vehiculo> getAsignacionConductores() {
        return asignacionConductores;
    }

    public Vehiculo obtenerVehiculo(String placa) {
        for(Vehiculo vehiculo: vehiculos){
            if(vehiculo.getNumeroPlaca().equals(placa)){
                return vehiculo;
            }
        }
        return null;
    }

    public void agregarConductores(ArrayList usuario) {
        conductores.addAll(usuario);
        guardarConductores();
    }

    public ArrayList<Conductor> obtenerConductores() {
        return conductores;
    }
    
}
