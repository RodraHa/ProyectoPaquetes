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
    
    public boolean asignarPaquetesAVehiculo(Vehiculo vehiculo, Provincia destino) {
        ArrayList<Paquete> paquetesPendientes  = Inventario.obtenerInstancia().obtenerPaquetesPendientes();
        ArrayList<Paquete> paquetes;
        int conteoPaquetes = 0;
        if (paquetesPendientes.isEmpty()) {
            return false;
        } else if (asignacionPaquetes.containsKey(vehiculo)) {
            paquetes = asignacionPaquetes.get(vehiculo);
            conteoPaquetes = paquetes.size();
        } else {
            paquetes = new ArrayList<>();
            asignacionPaquetes.put(vehiculo, paquetes);
        }
        double capacidad = vehiculo.getCapacidad();

        for (Paquete paquete : paquetesPendientes) {
            if (capacidad >= paquete.getVolumen() ) {
                if(paquete.getProvinciaDestino() == destino){
                paquetes.add(paquete);
                paquete.cambiarEstado(new EnCurso(paquete));
                capacidad -= paquete.getVolumen();
                }
            }else{
                break;
            }
        }
        if(paquetes == null || paquetes.size()== conteoPaquetes){
            return false;
        }
        vehiculo.setCapacidad(capacidad);
         guardarRelacionPaquetes();
        return true;
    }
    public HashMap<Vehiculo, ArrayList<Paquete>> obtenerRelacionPaqueteVehiculo(){
        return asignacionPaquetes;
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

    public ArrayList<Paquete> obtenerVehiculoConductor(Conductor conductor) {
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
    
    public ArrayList<Paquete> obtenerPaquetesDeConductor(Conductor conductor){
        Vehiculo vehiculo = null;
        for (Map.Entry<Conductor, Vehiculo> entry : asignacionConductores.entrySet()) {
            if (entry.getKey().getCedula().equals(conductor.getCedula())) {
                vehiculo = entry.getValue();
                break;
            }
        }
        if(vehiculo == null){
            return null;
        }
        System.out.println("hay vehiculo");
        for(Map.Entry<Vehiculo, ArrayList<Paquete>> entry : asignacionPaquetes.entrySet()){
            if(entry.getKey().getNumeroPlaca().equals(vehiculo.getNumeroPlaca())){
                System.out.println("hay inventario");
                return entry.getValue();
            }
        }
        return null;
    }
    
    
    public void guardarVehiculo() {
        vehiculos.clear();
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
        conductores.clear();
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
        asignacionConductores.clear();
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
    
    public void guardarRelacionPaquetes() {
        asignacionPaquetes.clear();
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
            asignacionPaquetes = (HashMap<Vehiculo,ArrayList<Paquete>>) ois.readObject();
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

    public Iterable<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
    
}
