package poo;


import uni1a.*;


public class PruebaAudioVisual {
public static void main(String[] args) {
System.out.println("Hello from Eclipse!");


// Crear actores y relacionarlos con la película (agregación)
Actor actor1 = new Actor("Sam Worthington", 1976, "Australia");
Actor actor2 = new Actor("Zoe Saldana", 1978, "USA");


Pelicula avatar = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
avatar.agregarActor(actor1);
avatar.agregarActor(actor2);


// Crear serie y temporadas (composición)
SerieDeTV got = new SerieDeTV("Game of Thrones", 60, "Fantasy");
Temporada t1 = new Temporada(1, 10);
Temporada t2 = new Temporada(2, 10);
got.agregarTemporada(t1);
got.agregarTemporada(t2);


// Crear documental con investigador (composición)
Investigador carl = new Investigador("Carl Sagan", "Astronomy");
Documental cosmos = new Documental("Cosmos", 45, "Science", "Astronomy", carl);


// Crear nuevas subclases
Instagram insta = new Instagram("MiniDoc Insta", 2, "Educativo", "@science_insta", 120000);
TikTok tt = new TikTok("Short Explainer", 1, "Ciencia", "@sagan_official", 45000);


// Array con todos los contenidos para probar mostrarDetalles
ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[] { avatar, got, cosmos, insta, tt };


for (ContenidoAudiovisual contenido : contenidos) {
contenido.mostrarDetalles();
}


// Ejemplo de manipulación adicional: listar actores de Avatar
System.out.println("Actores en " + avatar.getTitulo() + ":");
for (Actor a : avatar.getActores()) {
System.out.println(" - " + a);
}
}
}
