package uni1a;


public class Temporada {
private int numero;
private int episodios;
// referencia a la serie (composición)
private SerieDeTV seriePadre;


public Temporada(int numero, int episodios) {
this.numero = numero;
this.episodios = episodios;
}


public int getNumero() { return numero; }
public int getEpisodios() { return episodios; }


void setSeriePadre(SerieDeTV s) { this.seriePadre = s; }
public SerieDeTV getSeriePadre() { return seriePadre; }
}