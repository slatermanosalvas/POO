package uni1a;

/**
 * Clase que extiende ContenidoAudiovisual para representar Documentales.
 * Implementa la relación de Composición con Investigador.
 */
public class Documental extends ContenidoAudiovisual {

    private String tema;
    private Investigador investigador;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema, Investigador investigador) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigador = investigador;
    }

    @Override
    public String obtenerDetallesFormatoTexto() {
        String investigadorInfo = (investigador != null) ? " | Investigador: " + investigador.getNombre() : "";
        
        return obtenerDetallesBaseTexto() + 
               " | Tipo: Documental" + 
               " | Tema: " + this.tema +
               investigadorInfo;
    }

    // Getters
    public String getTema() { return tema; }
    public Investigador getInvestigador() { return investigador; }
}