package mod_paquetes;

import java.io.Serializable;
import java.util.ArrayList;

public class Seguimiento implements Serializable {
    private EstadoDelPaquete estadoActual;
    private ArrayList<String> estadosAnteriores;
    private String incidente;

    public Seguimiento(EstadoDelPaquete estado) {
        this.estadoActual = estado;
        this.estadosAnteriores = new ArrayList<>();
    }

    public void notificar(EstadoDelPaquete estado) {
        estadosAnteriores.add(estadoActual.toString());
        this.estadoActual = estado;
    }

    public boolean verificarEntregaPendiente() {
        return estadoActual instanceof Pendiente;
    }

    public ArrayList<String> obtenerEstadosAnteriores() {
        return estadosAnteriores;
    }
}
