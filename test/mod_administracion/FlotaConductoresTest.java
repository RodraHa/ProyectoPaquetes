/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package mod_administracion;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 *
 * @author migue
 */
public class FlotaConductoresTest {
    
    public FlotaConductoresTest() {
    }

    private FlotaConductores flota;
    private Conductor conductor;

    @Before
    public void setUp() {
        // Asegúrate de que el archivo de conductores está limpio antes de cada prueba
        File file = new File("src/archivos/Conductores.ser");
        if (file.exists()) {
            file.delete();
        }
        flota = new FlotaConductores();
        conductor = new Conductor("Juan", "Zambrano", "1714578955", "La Magdalena", "0974859611", "juan.zambrano@gmail.com");
    }
    
    
    @Test
    public void testEliminarConductor() {
        flota.agregarConductor(conductor);
        flota.eliminarConductor(conductor);
        // Verificar el resultado esperado
        Conductor resultado = flota.obtenerConductorPorCedula("1714578955");
        assertNull("El conductor no fue eliminado correctamente", resultado);
    }

    @Test
    public void testAgregarConductor() {
        flota.agregarConductor(conductor);
        assertTrue(flota.obtenerConductores().contains(conductor));
    }



    @Test
    public void testGuardarConductores() {
        flota.agregarConductor(conductor);

        // Verificar que el archivo se guarda correctamente
        flota.guardarConductores();
        File file = new File("src/archivos/Conductores.ser");
        assertTrue(file.exists());
    }

    @Test
    public void testCargarConductores() {
        flota.agregarConductor(conductor);
        flota.guardarConductores();

        // Crear una nueva instancia de FlotaConductores para cargar los datos desde el archivo
        FlotaConductores nuevaFlota = new FlotaConductores();
        assertTrue(nuevaFlota.obtenerConductores().contains(conductor));
    }

    @Test
    public void testObtenerConductorPorCedula() {
        flota.agregarConductor(conductor);
        Conductor result = flota.obtenerConductorPorCedula("1714578955");
        assertEquals(conductor, result);
    }

    @Test
    public void testObtenerConductorPorCedulaNoExistente() {
        Conductor result = flota.obtenerConductorPorCedula("1714578956");
        assertNull(result);
    }
    
}
