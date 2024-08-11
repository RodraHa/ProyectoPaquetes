/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_paquetes.Paquete;

public class ErrorDireccion extends Incidente {

    @Override
    public String getMensajeRegistro(Paquete paquete) {
        return "El paquete no se puede entregar en la dirección \"" + paquete.getDireccionDestino() + "\".";
    }

    @Override
    public String getMensajeResolucion(Paquete paquete) {
        return "Se ha cambiado la dirección de entrega del paquete a \"" + paquete.getDireccionDestino() + "\".";
    }

    @Override
    public String getMensajeSolicitud() {
        return "Por favor ingrese la nueva dirección de entrega.";
    }

    @Override
    public void manejar(Paquete paquete, String[] argumentos) {
        if (paquete.getDireccionDestino().equals(argumentos[0])) {
            return;
        }
        paquete.cambiarDireccionDestino(argumentos[0]);
    }

    @Override
    public String toString() {
        return "Error de dirección";
    }
}
