package uni1a;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador (C) en el patrón MVC. 
 * Gestiona la lógica de negocio y la comunicación entre la Vista y el Modelo.
 */
public class ContenidoController {

    private List<ContenidoAudiovisual> contenidos;
    private final String NOMBRE_ARCHIVO = "contenidos_persistencia.csv";

    public ContenidoController() {
        // 1. Intentar cargar datos guardados
        contenidos = ManejadorArchivosCSV.leerContenidosDesdeCSV(NOMBRE_ARCHIVO);

        // 2. Si la lista está vacía (archivo no existía o estaba vacío), inicializar con datos de ejemplo
        if (contenidos.isEmpty()) {
            System.out.println("No se encontraron datos guardados. Inicializando con datos de ejemplo.");
            inicializarDatosBase();
        }
    }

    /**
     * Inicializa el sistema con datos de ejemplo.
     */
    private void inicializarDatosBase() {
        // Datos de Películas
        contenidos.add(new Pelicula("Avatar", 162, "Ciencia Ficción", "20th Century Fox"));
        
        // Datos de Documentales
        Investigador carl = new Investigador("Carl Sagan");
        contenidos.add(new Documental("Cosmos: Un Viaje Personal", 60, "Ciencia", "Astronomía", carl));
        
        // Datos de Series de TV
        SerieDeTV got = new SerieDeTV("Game of Thrones", 55, "Fantasía");
        got.agregarTemporada(new Temporada(1, 10));
        got.agregarTemporada(new Temporada(2, 10));
        contenidos.add(got);
        
        // Datos de Redes Sociales
        contenidos.add(new Instagram("Receta Rápida", 15, "Cocina", "chef_juan", 150000));
        contenidos.add(new TikTok("Bailes Virales", 3, "Baile", "laura_dance", 5000000));
    }

    /**
     * Agrega un nuevo contenido a la lista.
     * @param contenido El objeto ContenidoAudiovisual a agregar.
     * @return true si se agregó correctamente.
     */
    public boolean agregarContenido(ContenidoAudiovisual contenido) {
        return contenidos.add(contenido);
    }

    /**
     * Obtiene todos los contenidos audiovisuales.
     * @return Una lista de todos los contenidos.
     */
    public List<ContenidoAudiovisual> obtenerTodosLosContenidos() {
        return new ArrayList<>(contenidos); // Retorna una copia para mantener la encapsulación
    }

    /**
     * Busca un contenido por su título (aproximado).
     * @param titulo Título a buscar.
     * @return El primer ContenidoAudiovisual encontrado o null si no existe.
     */
    public ContenidoAudiovisual buscarPorTitulo(String titulo) {
        String tituloLower = titulo.toLowerCase().trim();
        for (ContenidoAudiovisual c : contenidos) {
            if (c.getTitulo().toLowerCase().contains(tituloLower)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Guarda la lista actual de contenidos en el archivo CSV.
     */
    public void guardarContenidos() {
        ManejadorArchivosCSV.escribirContenidosACSV(contenidos, NOMBRE_ARCHIVO);
    }
}