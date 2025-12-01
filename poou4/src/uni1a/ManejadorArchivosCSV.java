package uni1a;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * ManejadorArchivosCSV: Implementa la persistencia de datos (SRP).
 */
public class ManejadorArchivosCSV {

    private static final String SEPARADOR = ",";

    /**
     * Guarda la lista de contenidos audiovisuales en un archivo CSV.
     * @param contenidos Lista de contenidos a guardar.
     * @param nombreArchivo Nombre del archivo.
     */
    public static void escribirContenidosACSV(List<ContenidoAudiovisual> contenidos, String nombreArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            pw.println("Tipo,ID,Titulo,Duracion,Genero,Extra1,Extra2");
            
            for (ContenidoAudiovisual c : contenidos) {
                StringBuilder sb = new StringBuilder();
                sb.append(c.getClass().getSimpleName()).append(SEPARADOR);
                sb.append(c.getId()).append(SEPARADOR);
                sb.append(c.getTitulo().replace(SEPARADOR, "")).append(SEPARADOR); 
                sb.append(c.getDuracionEnMinutos()).append(SEPARADOR);
                sb.append(c.getGenero().replace(SEPARADOR, ""));
                
                // Aplicando Polimorfismo y instanceof para manejar propiedades específicas
                if (c instanceof Pelicula) {
                    sb.append(SEPARADOR).append(((Pelicula) c).getEstudio());
                } else if (c instanceof Documental) {
                    Documental doc = (Documental) c;
                    sb.append(SEPARADOR).append(doc.getTema());
                    if (doc.getInvestigador() != null) {
                        sb.append(SEPARADOR).append(doc.getInvestigador().getNombre().replace(SEPARADOR, "")); 
                    }
                } else if (c instanceof SerieDeTV) {
                    // Guardamos el número de temporadas
                    sb.append(SEPARADOR).append(((SerieDeTV) c).getTemporadas().size());
                } else if (c instanceof Instagram) {
                    Instagram insta = (Instagram) c;
                    sb.append(SEPARADOR).append(insta.getUsuario());
                    sb.append(SEPARADOR).append(insta.getSeguidores());
                } else if (c instanceof TikTok) {
                    TikTok tt = (TikTok) c;
                    sb.append(SEPARADOR).append(tt.getCreador());
                    sb.append(SEPARADOR).append(tt.getLikes());
                }
                
                pw.println(sb.toString());
            }
            System.out.println("Datos guardados en " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Lee contenidos audiovisuales de un archivo CSV.
     * Importante: GARANTIZA que NUNCA devuelve 'null' (Solución al NullPointerException).
     * @param nombreArchivo Nombre del archivo.
     * @return Lista de contenidos cargados (o una lista vacía si hay error o archivo no existe).
     */
    public static List<ContenidoAudiovisual> leerContenidosDesdeCSV(String nombreArchivo) {
        List<ContenidoAudiovisual> listaCargada = new ArrayList<>();
        ContenidoAudiovisual.resetIdCounter(); // Resetear el contador para mantener IDs consistentes
        
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                if (linea.trim().isEmpty()) continue;
                
                String[] datos = linea.split(SEPARADOR, -1); // Usamos -1 para mantener los campos vacíos
                
                if (datos.length < 5) continue; 
                
                String tipo = datos[0];
                String titulo = datos[2];
                
                int duracion;
                try {
                    duracion = Integer.parseInt(datos[3]);
                } catch (NumberFormatException e) {
                    continue;
                }
                
                String genero = datos[4];
                
                // Recrear el objeto por tipo (solo los campos simples se recrean)
                switch (tipo) {
                    case "Pelicula":
                        String estudio = (datos.length > 5) ? datos[5] : "";
                        listaCargada.add(new Pelicula(titulo, duracion, genero, estudio));
                        break;
                    case "Documental":
                         Investigador inv = (datos.length > 6 && !datos[6].isEmpty()) ? new Investigador(datos[6]) : null;
                         listaCargada.add(new Documental(titulo, duracion, genero, 
                             (datos.length > 5 ? datos[5] : "General"),
                             inv
                         ));
                         break;
                    case "SerieDeTV":
                         SerieDeTV serie = new SerieDeTV(titulo, duracion, genero);
                         // NO cargamos las temporadas de forma simple, solo el objeto serie
                         listaCargada.add(serie);
                         break;
                    case "Instagram":
                         listaCargada.add(new Instagram(titulo, duracion, genero, 
                            (datos.length > 5 ? datos[5] : "@user"),
                            (datos.length > 6 && !datos[6].isEmpty() ? Long.parseLong(datos[6]) : 0)
                         ));
                         break;
                    case "TikTok":
                        listaCargada.add(new TikTok(titulo, duracion, genero,
                            (datos.length > 5 ? datos[5] : "@creator"),
                            (datos.length > 6 && !datos[6].isEmpty() ? Long.parseLong(datos[6]) : 0)
                         ));
                         break;
                    default:
                        // Ignorar tipos desconocidos
                }
            }
            System.out.println("Carga de " + listaCargada.size() + " contenidos desde " + nombreArchivo + " completada.");

        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + nombreArchivo + " no existe. Retornando lista vacía.");
        } catch (IOException e) {
            System.err.println("Error de IO al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
             System.err.println("Error de formato de número al parsear datos: " + e.getMessage());
        }
        
        return listaCargada; 
    }
}