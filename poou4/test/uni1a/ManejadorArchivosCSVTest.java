package uni1a;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Pruebas Unitarias para ManejadorArchivosCSV (Persistencia).
 */
public class ManejadorArchivosCSVTest {

    private static final String ARCHIVO_PRUEBA = "test_contenidos.csv";
    private List<ContenidoAudiovisual> listaOriginal;

    @BeforeEach
    void setUp() {
        // ARRANGE: Preparación de la lista de prueba
        ContenidoAudiovisual.resetIdCounter();
        listaOriginal = new ArrayList<>();
        listaOriginal.add(new Pelicula("Pelicula Test", 90, "Acción", "Estudio A"));
        listaOriginal.add(new SerieDeTV("Serie Test", 45, "Drama")); 
        listaOriginal.add(new Instagram("Reel Test", 10, "Comedia", "user_test", 1000));
        
        // Asegurarse de que el archivo de prueba no exista al inicio
        File file = new File(ARCHIVO_PRUEBA);
        if (file.exists()) {
            file.delete();
        }
    }

    @AfterEach
    void tearDown() {
        // Limpieza: Eliminar el archivo de prueba después de cada test
        File file = new File(ARCHIVO_PRUEBA);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testEscribirYLeer_LecturaExitosa() {
        // 1. Act: Guardar los datos
        ManejadorArchivosCSV.escribirContenidosACSV(listaOriginal, ARCHIVO_PRUEBA);

        // 2. Act: Leer los datos guardados
        // Importante: Resetear el ID antes de leer para que los IDs coincidan
        ContenidoAudiovisual.resetIdCounter(); 
        List<ContenidoAudiovisual> cargados = ManejadorArchivosCSV.leerContenidosDesdeCSV(ARCHIVO_PRUEBA);

        // 3. Assert (Verificación)
        assertNotNull(cargados, "La lista cargada no debe ser null."); // **CORRECCIÓN NPE**
        assertFalse(cargados.isEmpty(), "La lista cargada no debe estar vacía.");
        assertEquals(listaOriginal.size(), cargados.size(), "El número de elementos debe coincidir.");
        
        // Verificación de datos específicos
        assertEquals("Pelicula Test", cargados.get(0).getTitulo());
        assertTrue(cargados.get(1) instanceof SerieDeTV);
        assertEquals(3, cargados.size());
    }

    @Test
    void testLeerContenidosDesdeCSV_ArchivoNoExiste() {
        // ARRANGE: El archivo no existe (asegurado en @BeforeEach)
        
        // 1. Act: Intentar leer
        List<ContenidoAudiovisual> cargados = ManejadorArchivosCSV.leerContenidosDesdeCSV(ARCHIVO_PRUEBA);
        
        // 2. Assert
        assertNotNull(cargados, "Si el archivo no existe, debe devolver una lista vacía (no null).");
        assertTrue(cargados.isEmpty(), "Si el archivo no existe, la lista debe estar vacía.");
    }
}