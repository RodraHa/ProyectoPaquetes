package mod_paquetes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public final class Inventario implements Serializable {
    private static Inventario instancia;
    private ArrayList<Paquete> paquetes;

    private Inventario() {
        paquetes = new ArrayList<>();
    }

    public static Inventario obtenerInstancia() {
        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }

    public String getSiguienteCodigoTracking() {
        if (paquetes.isEmpty()) {
            return "1";
        }
        int codigo = Integer.parseInt(paquetes.get(paquetes.size() - 1).obtenerCodigo());
        codigo++;
        return String.valueOf(codigo);
    }

    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
    }

    public void eliminarPaquete(Paquete paquete) {
        paquetes.remove(paquete);
    }

    public boolean existePaquete(String codigoTracking) {
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return true;
            }
        }
        return false;
    }

    public Paquete obtenerPaquete(String codigoTracking) {
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return paquete;
            }
        }
        return null;
    }

    public ArrayList<Paquete> obtenerPaquetesPendientes() {
        ArrayList<Paquete> paquetesPendientes = new ArrayList<>();
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerEstado() instanceof Pendiente) {
                paquetesPendientes.add(paquete);
            }
        }
        return paquetesPendientes;
    }

    public ArrayList<Paquete> obtenerPaquetes() {
        return paquetes;
    }

    public void guardarInventario() {
        String filePath = "src\\archivos\\inventario.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(paquetes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarInventario() {
        String filePath = "src\\archivos\\inventario.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            paquetes = (ArrayList<Paquete>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
