/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_transporte;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FlotaVehiculo {
    private ArrayList<Vehiculo> vehiculos;
    
    public Iterable<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
    
    public Vehiculo obtenerVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumeroPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        guardarVehiculo();
    }
    
    public void guardarVehiculo() {
        conexionConSer(vehiculos, "FlotaVehiculos");
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
    
}
