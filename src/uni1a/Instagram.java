package uni1a;


public class Instagram extends ContenidoAudiovisual {
private String usuario;
private long seguidores;


public Instagram(String titulo, int duracionEnMinutos, String genero, String usuario, long seguidores) {
super(titulo, duracionEnMinutos, genero);
this.usuario = usuario;
this.seguidores = seguidores;
}


public String getUsuario() { return usuario; }
public long getSeguidores() { return seguidores; }


@Override
public void mostrarDetalles() {
System.out.println("Detalles de Instagram:");
System.out.println("ID: " + getId());
System.out.println("Título: " + getTitulo());
System.out.println("Duración (sugerida) en minutos: " + getDuracionEnMinutos());
System.out.println("Usuario: " + usuario);
System.out.println("Seguidores: " + seguidores);
System.out.println();
}
}