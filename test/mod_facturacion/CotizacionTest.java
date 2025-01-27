/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package mod_facturacion;

import java.io.File;
import java.util.ArrayList;
import mod_administracion.Cliente;
import mod_administracion.Usuario;
import mod_paquetes.Paquete;
import mod_transporte.Provincia;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author migue
 */
public class CotizacionTest {
    
    private Cotizacion cotizacion;
    private Paquete paquete;

    @org.junit.Before
    public void setUp() {
        // Asegúrate de que el archivo de conductores está limpio antes de cada prueba
        File file1 = new File("src/archivos/facturas.ser");
        if (file1.exists()) {
            file1.delete();
        }
        
        cotizacion = Cotizacion.obtenerInstancia();
        String codigoTracking = "123";
        double volumen = 1.5;
        double peso = 2.0;
        String contenido = "Documentos";
        Usuario remitente = new Cliente("John", "Hernandez", "1701173875", "La Loma", "0959645428", "john.hernandez@gmail.com"); // Asegúrate de que Usuario tenga un constructor adecuado
        Provincia provinciaOrigen = Provincia.PICHINCHA;
        Provincia provinciaDestino = Provincia.GUAYAS;
        String direccionDestino = "Calle Falsa 123";
        String nombreDestinatario = "Jane Doe";
        
        paquete = new Paquete(codigoTracking, volumen, peso, contenido, remitente, provinciaOrigen, provinciaDestino, direccionDestino, nombreDestinatario); // Suponiendo que Paquete tiene un constructor por defecto
    }

    @Test
    public void testGetSiguienteCodigoFactura() {
        
        cotizacion.eliminarFactura("123");
        String codigo = cotizacion.getSiguienteCodigoFactura();
        System.out.println("Valor de codigo después de primera llamada: " + codigo);
        assertEquals("1", codigo);

        cotizacion.emitirFacturaPaquete(paquete);
        codigo = cotizacion.getSiguienteCodigoFactura();
        System.out.println("Valor de codigo después de emitir factura: " + codigo);
        assertEquals("2", codigo);
    }
    
    @Test
    public void testObtenerInstancia() {
        Cotizacion instancia1 = Cotizacion.obtenerInstancia();
        Cotizacion instancia2 = Cotizacion.obtenerInstancia();
        assertSame(instancia1, instancia2);
    }

    @Test
    public void testObtenerPrecioPaquete() {
        
        Precio precio = cotizacion.obtenerPrecioPaquete(paquete);
        assertNotNull(precio);
    }

    @Test
    public void testEmitirFacturaPaquete() {
        cotizacion.emitirFacturaPaquete(paquete);
        ArrayList<Factura> facturas = cotizacion.obtenerFacturas();
        assertFalse(facturas.isEmpty());
        assertEquals(1, facturas.size());
    }



    @Test
    public void testObtenerFacturas() {
        ArrayList<Factura> facturas = cotizacion.obtenerFacturas();
        assertNotNull(facturas);
    }

    @Test
    public void testEliminarFactura() {
        cotizacion.emitirFacturaPaquete(paquete);
        ArrayList<Factura> facturas = cotizacion.obtenerFacturas();
        String codigoTracking = facturas.get(0).obtenerCodigoTracking();
        
        cotizacion.eliminarFactura(codigoTracking);
        System.out.println(codigoTracking);
        facturas = cotizacion.obtenerFacturas();

        assertTrue(facturas.isEmpty());
    }

    @Test
    public void testGuardarCotizacion() {
        // Este test sólo verifica que el método se ejecuta sin lanzar excepciones
        try {
            cotizacion.guardarCotizacion();
        } catch (Exception e) {
            fail("Guardar cotización no debe lanzar excepciones");
        }
    }

    @Test
    public void testCargarCotizacion() {
        // Este test sólo verifica que el método se ejecuta sin lanzar excepciones
        try {
            cotizacion.cargarCotizacion();
        } catch (Exception e) {
            fail("Cargar cotización no debe lanzar excepciones");
        }
    }
}
