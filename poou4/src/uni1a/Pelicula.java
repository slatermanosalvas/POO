package uni1a;

/**
 * Clase que extiende ContenidoAudiovisual para representar Películas.
 * Implementa la relación de Agregación con Actor.
 */
public class Pelicula extends ContenidoAudiovisual {

    private String estudio;
    // La lista de Actores no se implementa completamente para la persistencia simple
    // private List<Actor> reparto; 

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
    }

    @Override
    public String obtenerDetallesFormatoTexto() {
        return obtenerDetallesBaseTexto() + 
               " | Tipo: Película" + 
               " | Estudio: " + this.estudio;
    }

    // Getter
    public String getEstudio() { return estudio; }
}