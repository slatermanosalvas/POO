package uni1a;


import java.util.ArrayList;
import java.util.List;


public class SerieDeTV extends ContenidoAudiovisual {
// Composición: una serie posee temporadas que no tienen sentido fuera de la serie
private List<Temporada> temporadas;


public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
super(titulo, duracionEnMinutos, genero);
this.temporadas = new ArrayList<>();
}


public void agregarTemporada(Temporada t) {
if (t != null) {
t.setSeriePadre(this); // establece la referencia de composición
temporadas.add(t);
}
}


public List<Temporada> getTemporadas() { return temporadas; }


@Override
public void mostrarDetalles() {
System.out.println("Detalles de la serie:\n");
System.out.println("ID: " + getId());
System.out.println("Título: " + getTitulo());
System.out.println("Duración estimada por episodio (min): " + getDuracionEnMinutos());
System.out.println("Género: " + getGenero());
System.out.println("Temporadas: " + temporadas.size());
for (Temporada t : temporadas) {
System.out.println(" - Temporada " + t.getNumero() + ": " + t.getEpisodios() + " episodios");
}
System.out.println();
}
}