package uni1a;


public class Documental extends ContenidoAudiovisual {
private String tema;
// Composición: el investigador forma parte esencial del documental
private Investigador investigador;


public Documental(String titulo, int duracionEnMinutos, String genero, String tema, Investigador investigador) {
super(titulo, duracionEnMinutos, genero);
this.tema = tema;
this.investigador = investigador; // composición: documental crea / contiene investigador
}


public String getTema() { return tema; }
public void setTema(String tema) { this.tema = tema; }


public Investigador getInvestigador() { return investigador; }
public void setInvestigador(Investigador investigador) { this.investigador = investigador; }


@Override
public void mostrarDetalles() {
System.out.println("Detalles del documental:");
System.out.println("ID: " + getId());
System.out.println("Título: " + getTitulo());
System.out.println("Duración en minutos: " + getDuracionEnMinutos());
System.out.println("Género: " + getGenero());
System.out.println("Tema: " + this.tema);
if (investigador != null) {
System.out.println("Investigador: " + investigador.getNombre() + " - " + investigador.getArea());
}
System.out.println();
}
}