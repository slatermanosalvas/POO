package main;

import uni1a.ContenidoController;
import uni1a.VistaConsola;

/**
 * Clase principal para iniciar el sistema.
 * Solo contiene la lógica de arranque del MVC.
 */
public class PruebaAudioVisual {

    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Contenido Audiovisual (MVC)...");

        // 1. Instanciar el Controlador
        ContenidoController controller = new ContenidoController();
        
        // 2. Instanciar la Vista, pasándole el Controlador
        VistaConsola vista = new VistaConsola(controller);
        
        // 3. Iniciar el bucle principal de la aplicación
        vista.mostrarMenu();
        
        System.out.println("\nSistema de Contenido Audiovisual finalizado.");
    }
}