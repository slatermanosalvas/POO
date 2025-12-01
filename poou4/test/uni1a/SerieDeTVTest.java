package uni1a;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas Unitarias para la clase SerieDeTV (Lógica de Negocio).
 */
public class SerieDeTVTest {

    private SerieDeTV serie;

    @BeforeEach
    void setUp() {
        // ARRANGE: Crear una nueva serie con duración base de 50 min/episodio
        serie = new SerieDeTV("Test Series", 50, "Drama");
    }

    @Test
    void testCalcularDuracionTotalEnMinutos_SinTemporadas() {
        // ACT
        int duracionTotal = serie.calcularDuracionTotalEnMinutos();

        // ASSERT: Una serie sin temporadas debe tener 0 minutos de duración total
        assertEquals(0, duracionTotal, "Una serie sin temporadas debe devolver 0 minutos.");
    }

    @Test
    void testCalcularDuracionTotalEnMinutos_ConUnaTemporada() {
        // ARRANGE: Agregar 1 temporada de 10 episodios
        serie.agregarTemporada(new Temporada(1, 10)); // 10 episodios * 50 min = 500 min

        // ACT
        int duracionTotal = serie.calcularDuracionTotalEnMinutos();

        // ASSERT
        assertEquals(500, duracionTotal, "La duración total debe ser 500 minutos.");
    }

    @Test
    void testCalcularDuracionTotalEnMinutos_ConMultiplesTemporadas() {
        // ARRANGE: Agregar 3 temporadas
        serie.agregarTemporada(new Temporada(1, 10)); // 500 min
        serie.agregarTemporada(new Temporada(2, 5));  // 250 min
        serie.agregarTemporada(new Temporada(3, 8));  // 400 min
        // Total esperado: 500 + 250 + 400 = 1150 min

        // ACT
        int duracionTotal = serie.calcularDuracionTotalEnMinutos();

        // ASSERT
        assertEquals(1150, duracionTotal, "La duración total debe ser la suma de episodios * duración base.");
    }
}