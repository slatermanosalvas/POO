package uni1a;

import java.util.List;
import java.util.Scanner;

/**
 * Vista (V) en el patrón MVC.
 * Gestiona la interacción con el usuario a través de la consola.
 */
public class VistaConsola {

    private ContenidoController controller;
    private Scanner scanner;

    public VistaConsola(ContenidoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        
        do {
            System.out.println("\n--- SISTEMA DE CONTENIDO AUDIOVISUAL (MVC) ---");
            System.out.println("1. Listar todos los contenidos");
            System.out.println("2. Buscar contenido por título");
            System.out.println("3. Añadir nueva Película");
            System.out.println("4. Guardar y Salir");
            System.out.print("Seleccione una opción: ");

            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    procesarOpcion(opcion);
                } else {
                    System.err.println("❌ Entrada no válida. Por favor, ingrese un número.");
                    scanner.nextLine(); // Limpiar el buffer
                }
            } catch (Exception e) {
                System.err.println("❌ Ocurrió un error inesperado: " + e.getMessage());
                opcion = 0; // Continuar mostrando el menú
            }

        } while (opcion != 4);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                listarContenidos();
                break;
            case 2:
                buscarContenido();
                break;
            case 3:
                agregarNuevaPelicula();
                break;
            case 4:
                controller.guardarContenidos();
                System.out.println("Guardando cambios y saliendo...");
                break;
            default:
                System.err.println("Opción no reconocida. Intente de nuevo.");
        }
    }

    // Lógica para la Opción 1
    private void listarContenidos() {
        System.out.println("\n--- LISTA DE CONTENIDOS ---");
        List<ContenidoAudiovisual> lista = controller.obtenerTodosLosContenidos();
        
        if (lista.isEmpty()) {
            System.out.println("La lista de contenidos está vacía.");
            return;
        }

        for (ContenidoAudiovisual c : lista) {
            System.out.println(c.obtenerDetallesFormatoTexto());
        }
    }
    
    // Lógica para la Opción 2
    private void buscarContenido() {
        System.out.print("Ingrese el título o una parte a buscar: ");
        String busqueda = scanner.nextLine();

        ContenidoAudiovisual encontrado = controller.buscarPorTitulo(busqueda);

        if (encontrado != null) {
            System.out.println("✅ Contenido Encontrado:");
            System.out.println(encontrado.obtenerDetallesFormatoTexto());
        } else {
            System.out.println("❌ No se encontró ningún contenido con ese título.");
        }
    }

    // Lógica para la Opción 3
    private void agregarNuevaPelicula() {
        System.out.println("\n--- Creación de Nueva Película ---");
        
        System.out.print("  Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("  Duración (minutos): ");
        int duracion = 0;
        try {
            duracion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("❌ Duración debe ser un número entero. Cancelando operación.");
            return;
        }
        
        System.out.print("  Género: ");
        String genero = scanner.nextLine();

        System.out.print("  Estudio: ");
        String estudio = scanner.nextLine();

        Pelicula nuevaPelicula = new Pelicula(titulo, duracion, genero, estudio);
        if (controller.agregarContenido(nuevaPelicula)) {
            System.out.println("✅ Película añadida temporalmente.");
        } else {
            System.err.println("❌ Error al añadir la película.");
        }
    }
}