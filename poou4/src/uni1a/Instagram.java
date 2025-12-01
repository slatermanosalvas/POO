package uni1a;

/**
 * Clase que extiende ContenidoAudiovisual para representar videos de Instagram.
 */
public class Instagram extends ContenidoAudiovisual {

    private String usuario;
    private long seguidores;

    public Instagram(String titulo, int duracionEnMinutos, String genero, String usuario, long seguidores) {
        super(titulo, duracionEnMinutos, genero);
        this.usuario = usuario;
        this.seguidores = seguidores;
    }

    @Override
    public String obtenerDetallesFormatoTexto() {
        return obtenerDetallesBaseTexto() + 
               " | Tipo: Instagram Reel/Video" + 
               " | Usuario: @" + this.usuario +
               " | Seguidores: " + this.seguidores;
    }

    // Getters
    public String getUsuario() { return usuario; }
    public long getSeguidores() { return seguidores; }
}