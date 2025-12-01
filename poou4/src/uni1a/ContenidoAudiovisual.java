package uni1a;

/**
 * Clase base abstracta que representa cualquier contenido audiovisual.
 * Aplica Polimorfismo y herencia.
 */
public abstract class ContenidoAudiovisual {

    private static int nextId = 1;

    private int id;
    private String titulo;
    private int duracionEnMinutos;
    private String genero;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = nextId++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract String obtenerDetallesFormatoTexto();

    // Método de utilidad para las subclases
    public String obtenerDetallesBaseTexto() {
        return "ID: " + this.id + 
               " | Título: " + this.titulo + 
               " | Duración: " + this.duracionEnMinutos + " min" +
               " | Género: " + this.genero;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getDuracionEnMinutos() { return duracionEnMinutos; }
    public String getGenero() { return genero; }
    
    // Método para resetear el contador de IDs (Útil para pruebas de persistencia)
    public static void resetIdCounter() {
        nextId = 1;
    }
}