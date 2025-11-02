package uni1a;


public abstract class ContenidoAudiovisual {
private static int contar = 1; // empieza en 1 para IDs más legibles
private String titulo;
private int duracionEnMinutos;
private String genero;
private final int id;


public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
this.id = contar++;
this.titulo = titulo;
this.duracionEnMinutos = duracionEnMinutos;
this.genero = genero;
}


public String getTitulo() { return titulo; }
public void setTitulo(String titulo) { this.titulo = titulo; }


public int getDuracionEnMinutos() { return duracionEnMinutos; }
public void setDuracionEnMinutos(int duracionEnMinutos) { this.duracionEnMinutos = duracionEnMinutos; }


public String getGenero() { return genero; }
public void setGenero(String genero) { this.genero = genero; }


public int getId() { return id; }


public abstract void mostrarDetalles();
}