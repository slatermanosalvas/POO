package uni1a;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas Unitarias para ContenidoController (Lógica de negocio).
 */
public class ContenidoControllerTest {

    private ContenidoController controller;
    private int tamañoInicial;

    @BeforeEach
    void setUp() {
        // Inicializa el contador de IDs y el controlador antes de cada test
        ContenidoAudiovisual.resetIdCounter();
        controller = new ContenidoController();
        // El tamaño inicial es el de los datos base (5 elementos)
        tamañoInicial = controller.obtenerTodosLosContenidos().size();
    }

    @Test
    void testInicializacion_DebeCargarDatosBase() {
        // ARRANGE/ACT hecho en @BeforeEach
        
        // ASSERT: Debe cargar los 5 contenidos base
        assertEquals(5, tamañoInicial, "El controlador debe inicializarse con 5 contenidos base.");
    }

    @Test
    void testAgregarContenido_DeberiaIncrementarLista() {
        // ARRANGE
        Pelicula testPelicula = new Pelicula("Test Nuevo", 10, "Test", "Test");

        // ACT
        boolean agregado = controller.agregarContenido(testPelicula);

        // ASSERT
        assertTrue(agregado, "El contenido deberia poder agregarse.");
        assertEquals(tamañoInicial + 1, controller.obtenerTodosLosContenidos().size(), "La lista debe incrementar en uno.");
    }

    @Test
    void testBuscarContenidoPorTitulo_DeberiaEncontrar() {
        // ACT: Buscar por una palabra clave de un título base ("Avatar")
        ContenidoAudiovisual encontrado = controller.buscarPorTitulo("Avat"); 

        // ASSERT
        assertNotNull(encontrado, "Debería encontrar la película 'Avatar'.");
        assertEquals("Avatar", encontrado.getTitulo(), "El título encontrado no coincide.");
    }

    @Test
    void testBuscarContenidoPorTitulo_NoDeberiaEncontrar() {
        // ACT: Buscar por un título que no existe
        ContenidoAudiovisual encontrado = controller.buscarPorTitulo("Título Falso");

        // ASSERT
        assertNull(encontrado, "No debería encontrar ningún contenido.");
    }
}