/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package mod_paquetes;

import java.util.ArrayList;
import mod_administracion.Cliente;
import mod_administracion.Usuario;
import mod_transporte.Provincia;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author migue
 */
public class PaqueteTest {
    
    private Paquete instance;
    
    @Before
    public void setUp() {
        // Inicializa la instancia de Paquete con valores de prueba
        String codigoTracking = "12345";
        double volumen = 1.5;
        double peso = 2.0;
        String contenido = "Documentos";
        Usuario remitente = new Cliente("John", "Hernandez", "1701173875", "La Loma", "0959645428", "john.hernandez@gmail.com"); // Asegúrate de que Usuario tenga un constructor adecuado
        Provincia provinciaOrigen = Provincia.PICHINCHA;
        Provincia provinciaDestino = Provincia.GUAYAS;
        String direccionDestino = "Calle Falsa 123";
        String nombreDestinatario = "Jane Doe";
        
        instance = new Paquete(codigoTracking, volumen, peso, contenido, remitente, provinciaOrigen, provinciaDestino, direccionDestino, nombreDestinatario);
    }
    
    public PaqueteTest() {
    }

     @Test
    public void testCambiarEstado() {
        System.out.println("cambiarEstado");
        EstadoDelPaquete estado = new Entregado(instance); // Asegúrate de inicializar EstadoDelPaquete
        instance.cambiarEstado(estado);
        assertEquals(estado, instance.obtenerEstado());
    }

    @Test
    public void testObtenerHistorialEstados() {
        System.out.println("obtenerHistorialEstados");
        ArrayList<String> expResult = new ArrayList<>(); // Define el resultado esperado
        expResult.add("Pendiente");
        expResult.add("En curso");
        instance.cambiarEstado(new EnCurso(instance));
        instance.cambiarEstado(new Entregado(instance));
        ArrayList<String> result = instance.obtenerHistorialEstados();
        assertEquals(expResult, result);
    }

    @Test
    public void testCalcularDistancia() {
        System.out.println("calcularDistancia");
        double expResult = 279.0; // Define el resultado esperado basado en las coordenadas ficticias de las provincias
        double result = instance.calcularDistancia();
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testObtenerEstado() {
        System.out.println("obtenerEstado");
        EstadoDelPaquete expResult = new Pendiente(instance); // Define el resultado esperado
        EstadoDelPaquete result = instance.obtenerEstado();
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerCodigo() {
        System.out.println("obtenerCodigo");
        String expResult = "12345"; // Define el resultado esperado
        String result = instance.obtenerCodigo();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetVolumen() {
        System.out.println("getVolumen");
        double expResult = 1.5; // Define el resultado esperado
        double result = instance.getVolumen();
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testGetRemitente() {
        System.out.println("getRemitente");
        Usuario expResult = new Cliente("John", "Hernandez", "1701173875", "La Loma", "0959645428", "john.hernandez@gmail.com"); // Define el resultado esperado
        Usuario result = instance.getRemitente();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPeso() {
        System.out.println("getPeso");
        double expResult = 2.0; // Define el resultado esperado
        double result = instance.getPeso();
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testGetProvinciaOrigen() {
        System.out.println("getProvinciaOrigen");
        Provincia expResult = Provincia.PICHINCHA; // Define el resultado esperado
        Provincia result = instance.getProvinciaOrigen();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetProvinciaDestino() {
        System.out.println("getProvinciaDestino");
        Provincia expResult = Provincia.GUAYAS; // Define el resultado esperado
        Provincia result = instance.getProvinciaDestino();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDireccionDestino() {
        System.out.println("getDireccionDestino");
        String expResult = "Calle Falsa 123"; // Define el resultado esperado
        String result = instance.getDireccionDestino();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNombreDestinatario() {
        System.out.println("getNombreDestinatario");
        String expResult = "Jane Doe"; // Define el resultado esperado
        String result = instance.getNombreDestinatario();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Paquete: \n" +
                "Código Tracking = '12345'\n" +
                "Volumen = 1.5 m3\n" +
                "Peso = 2.0 Kg\n" +
                "Contenido = 'Documentos'\n" +
                "Remitente = " + instance.getRemitente() + "\n" +
                "Provincia de Origen = " + instance.getProvinciaOrigen().name() + "\n" +
                "Provincia de Destino = " + instance.getProvinciaDestino().name() + "\n" +
                "Dirección de Destino = 'Calle Falsa 123'\n" +
                "Estado = " + instance.obtenerEstado() + "\n" +
                "Distancia Estimada = " + instance.calcularDistancia() + " Km\n" +
                "Destinatario = Jane Doe\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenido() {
        System.out.println("getContenido");
        String expResult = "Documentos"; // Define el resultado esperado
        String result = instance.getContenido();
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerSeguimiento() {
        System.out.println("obtenerSeguimiento");
        Seguimiento expResult = new Seguimiento(new Pendiente(instance)); // Define el resultado esperado
        Seguimiento result = instance.obtenerSeguimiento();
        assertEquals(expResult, result);
    }

    @Test
    public void testCambiarDireccionDestino() {
        System.out.println("cambiarDireccionDestino");
        String destino = "Nueva Dirección 456";
        instance.cambiarDireccionDestino(destino);
        assertEquals(destino, instance.getDireccionDestino());
    }

    @Test
    public void testIntercambiarDestinoOrigen() {
        System.out.println("intercambiarDestinoOrigen");
        Provincia originalOrigen = instance.getProvinciaOrigen();
        Provincia originalDestino = instance.getProvinciaDestino();
        instance.intercambiarDestinoOrigen();
        assertEquals(originalOrigen, instance.getProvinciaDestino());
        assertEquals(originalDestino, instance.getProvinciaOrigen());
    }
    
}
