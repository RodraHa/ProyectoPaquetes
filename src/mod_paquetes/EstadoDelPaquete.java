package mod_paquetes;

import java.io.Serializable;

public abstract class EstadoDelPaquete implements Serializable {
    protected Paquete paquete;

    public EstadoDelPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
  @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EstadoDelPaquete that = (EstadoDelPaquete) obj;
        // Comparación de atributos específicos si es necesario
        return true;
    }
    
    public abstract void iniciarEnvio();
    public abstract void completarEnvio();
}