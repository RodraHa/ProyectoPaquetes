/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change esta licencia
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar esta plantilla
 */
package mod_incidentes;

import mod_paquetes.Paquete;

/**
 * Clase que representa un incidente de paquete perdido.
 * Esta clase extiende la clase abstracta Incidente y proporciona
 * implementaciones específicas para registrar y resolver el incidente.
 *
 * @autor Rodrigo Haro
 */
public class PaquetePerdido extends Incidente {

    /**
     * Registra el incidente de paquete perdido.
     *
     * @return Una cadena que describe el incidente registrado.
     */
    @Override
    public String registrar() {
        return "La ubicación de su paquete es desconocida";
    }


    @Override
    public String resolver(Paquete paquete, String[] argumentos) {
        return "";
    }

    @Override
    public String getMensaje() {
        return "";
    }

    @Override
    public boolean sePuedeResolver() {
        return false;
    }
}
