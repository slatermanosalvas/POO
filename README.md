# Proyecto Audiovisual - Java


## Descripción
Proyecto en Java que modela distintos contenidos audiovisuales mediante POO: `ContenidoAudiovisual` (abstracta) y subclases: `Pelicula`, `SerieDeTV`, `Documental`, `Instagram`, `TikTok`. Se añadieron clases de apoyo: `Actor`, `Temporada`, `Investigador`.


## Relaciones implementadas
- **Pelicula - Actor**: Agregación (una película tiene actores; los actores existen por separado).
- **SerieDeTV - Temporada**: Composición (las temporadas pertenecen a la serie).
- **Documental - Investigador**: Composición (el investigador forma parte del documental).


## Estructura del proyecto (ruta dentro de `src`)
- `uni1a` (paquete): ContenidoAudiovisual, Pelicula, SerieDeTV, Documental, Instagram, TikTok, Actor, Temporada, Investigador
- `poo` (paquete): PruebaAudioVisual (clase `main` de prueba)


## Cómo ejecutar
1. Clona el repositorio.
2. Abre el proyecto en Eclipse o tu IDE preferido (asegúrate de usar Java 8+).
3. Ejecuta la clase `poo.PruebaAudioVisual`.


## Recomendaciones para el diagrama de clases
Usa draw.io o Lucidchart e incluye:
- Clases y atributos principales.
- Relaciones (especificar tipo: asociación/aggregación/composición).


## GitHub
- Crea un repositorio nuevo y sube todo el proyecto.
- Incluye al menos 3 commits representando: estructuración de paquetes, adición de clases nuevas, mejoras y pruebas.


## Mejoras posibles
- Añadir métodos para buscar contenidos por título/ID.
- Implementar serialización (guardar/cargar catálogo a JSON o XML).
- Añadir pruebas unitarias con JUnit.

