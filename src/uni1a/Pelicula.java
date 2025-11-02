package uni1a;


import java.util.ArrayList;
import java.util.List;


public class Pelicula extends ContenidoAudiovisual {
private String estudio;
// Agregación: una película puede tener varios actores; los actores pueden existir fuera de la película
private List<Actor> actores;


public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
super(titulo, duracionEnMinutos, genero);
this.estudio = estudio;
this.actores = new ArrayList<>();
}


public String getEstudio() { return estudio; }
public void setEstudio(String estudio) { this.estudio = estudio; }


public void agregarActor(Actor actor) {
if (actor != null && !actores.contains(actor)) actores.add(actor);
}


public List<Actor> getActores() { return actores; }


@Override
public void mostrarDetalles() {
System.out.println("Detalles de la película:");
System.out.println("ID: " + getId());
System.out.println("Título: " + getTitulo());
System.out.println("Duración en minutos: " + getDuracionEnMinutos());
System.out.println("Género: " + getGenero());
System.out.println("Estudio: " + estudio);
System.out.println("Actores:");
if (actores.isEmpty()) System.out.println(" (sin actores registrados)");
else atoresPrint:
for (Actor a : actores) {
System.out.println(" - " + a.getNombre() + " (" + a.getNacionalidad() + ")");
}
System.out.println();
}
}