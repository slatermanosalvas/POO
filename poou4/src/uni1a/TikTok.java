package uni1a;

/**
 * Clase que extiende ContenidoAudiovisual para representar videos de TikTok.
 */
public class TikTok extends ContenidoAudiovisual {

    private String creador;
    private long likes;

    public TikTok(String titulo, int duracionEnMinutos, String genero, String creador, long likes) {
        super(titulo, duracionEnMinutos, genero);
        this.creador = creador;
        this.likes = likes;
    }

    @Override
    public String obtenerDetallesFormatoTexto() {
        return obtenerDetallesBaseTexto() + 
               " | Tipo: TikTok" + 
               " | Creador: @" + this.creador +
               " | Likes: " + this.likes;
    }

    // Getters
    public String getCreador() { return creador; }
    public long getLikes() { return likes; }
}