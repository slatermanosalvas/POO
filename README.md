Proyecto de Programación Orientada a Objetos: Contenido Audiovisual
Este proyecto en Java implementa un sistema básico de gestión y consulta de Contenido Audiovisual (Películas, Series, Documentales) utilizando los principios de la Programación Orientada a Objetos (POO), incluyendo herencia, polimorfismo y composición.

El proyecto está organizado bajo el patrón de diseño Modelo-Vista-Controlador (MVC), además de incluir clases de utilidad y pruebas unitarias con JUnit.

1. Estructura y Componentes del Código
El proyecto utiliza una estructura de carpetas y paquetes clara para separar el código de producción, el código de ejecución y el código de prueba.

Estructura de Carpetas
src/uni1a: Contiene las clases de dominio y lógica de negocio. Es el código de producción principal.

src/main: Contiene la clase PruebaAudioVisual.java, que es el punto de entrada (clase main) del sistema.

test/uni1a: Contiene las clases que terminan en Test. Estas son las Pruebas Unitarias (JUnit 5).

Clases de Producción (src/uni1a)
ContenidoAudiovisual (Clase Abstracta, Modelo): Clase base con atributos comunes (título, duración, género, ID).

Pelicula, SerieDeTV, Documental (Clases Concretas, Modelo): Implementan la herencia de ContenidoAudiovisual.

Actor, Investigador, Instagram, Temporada (Clases de Composición): Representan entidades relacionadas con el contenido.

ContenidoController (Controlador, MVC): Contiene la lógica de negocio, manejo de colecciones y búsqueda.

VistaConsola (Vista, MVC): Maneja la interacción con el usuario mediante la consola (menús, entradas, salidas).

ManejadorArchivosCSV (Utilidad): Clase para la lectura y escritura de objetos ContenidoAudiovisual a un archivo CSV.

2. Cómo Clonar y Ejecutar el Proyecto
Requisitos
Java Development Kit (JDK) 17 o superior.

Entorno de Desarrollo Integrado (IDE) Eclipse.

Git instalado en tu sistema.

2.1. Clonar el Repositorio
Abre la terminal de tu sistema y ejecuta el siguiente comando, reemplazando la URL con la de tu repositorio de GitHub:

git clone [URL_DE_TU_REPOSITORIO]
2.2. Importar el Proyecto en Eclipse
Abre Eclipse.

Ve a File -> Import....

Selecciona General -> Existing Projects into Workspace (Proyectos existentes en el espacio de trabajo).

Haz clic en Browse (Examinar...) y selecciona la carpeta poo_tareaunidad4 que acabas de clonar.

Asegúrate de que el proyecto esté seleccionado y haz clic en Finish (Finalizar).

2.3. Configurar la Librería JUnit
Para ejecutar las pruebas correctamente, asegúrate de que JUnit 5 esté añadido al proyecto:

Haz clic derecho en el proyecto -> Properties -> Java Build Path -> Pestaña Libraries.

Haz clic en Add Library... y selecciona JUnit.

Asegúrate de que la versión sea JUnit 5 y presiona Finish.

2.4. Ejecutar la Aplicación Principal
Busca el archivo PruebaAudioVisual.java en el paquete src/main.

Haz clic derecho en PruebaAudioVisual.java.

Selecciona Run As -> Java Application (Aplicación Java).

El menú de la aplicación se mostrará en la consola de Eclipse.

3. Ejecución de Pruebas Unitarias
El proyecto incluye pruebas unitarias que verifican la lógica de negocio en el ContenidoController y la funcionalidad de lectura/escritura del ManejadorArchivosCSV.

3.1. Clases de Prueba
Las clases de prueba se encuentran en el paquete test/uni1a:

SerieDeTVTest.java: Prueba la lógica específica de la clase SerieDeTV.

ContenidoControllerTest.java: Prueba la adición, búsqueda y gestión de contenidos.

ManejadorArchivosCSVTest.java: Prueba la correcta lectura y carga de datos desde un archivo simulado.

3.2. Ejecutar todas las Pruebas
En el "Package Explorer", haz clic derecho en la carpeta de pruebas test.

Selecciona Run As -> JUnit Test.

Eclipse abrirá la pestaña JUnit mostrando el resumen de las pruebas ejecutadas, indicando cuántas fueron exitosas y cuántas fallaron.
