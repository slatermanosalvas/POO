package uni1a;

/**
 * Clase que representa una Temporada dentro de una SerieDeTV (Composición).
 */
public class Temporada {

    private int numero;
    private int episodios;

    public Temporada(int numero, int episodios) {
        this.numero = numero;
        this.episodios = episodios;
    }

    // Getters
    public int getNumero() { return numero; }
    public int getEpisodios() { return episodios; }
}