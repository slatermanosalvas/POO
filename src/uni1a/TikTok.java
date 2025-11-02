package uni1a;


public class TikTok extends ContenidoAudiovisual {
private String creador;
private long likes;


public TikTok(String titulo, int duracionEnMinutos, String genero, String creador, long likes) {
super(titulo, duracionEnMinutos, genero);
this.creador = creador;
this.likes = likes;
}


public String getCreador() { return creador; }
public long getLikes() { return likes; }


@Override
public void mostrarDetalles() {
System.out.println("Detalles de TikTok:");
System.out.println("ID: " + getId());
System.out.println("Título: " + getTitulo());
System.out.println("Duración en minutos: " + getDuracionEnMinutos());
System.out.println("Creador: " + creador);
System.out.println("Likes: " + likes);
System.out.println();
}
}