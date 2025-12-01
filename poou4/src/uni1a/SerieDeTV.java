package uni1a;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende ContenidoAudiovisual para representar Series de TV.
 * Implementa la relación de Composición con Temporada.
 */
public class SerieDeTV extends ContenidoAudiovisual {

    private List<Temporada> temporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
    }

    /**
     * Calcula la duración total de la serie.
     * @return Duración total en minutos.
     */
    public int calcularDuracionTotalEnMinutos() {
        int duracionTotal = 0;
        for (Temporada t : temporadas) {
            // Duración base por episodio * número de episodios
            duracionTotal += this.getDuracionEnMinutos() * t.getEpisodios(); 
        }
        return duracionTotal;
    }

    @Override
    public String obtenerDetallesFormatoTexto() {
        String detalleTemporadas = " | Temporadas: " + temporadas.size();
        if (!temporadas.isEmpty()) {
            detalleTemporadas += " | Duración Total Estimada: " + calcularDuracionTotalEnMinutos() + " min";
        }

        return obtenerDetallesBaseTexto() + 
               " | Tipo: Serie de TV" + 
               detalleTemporadas;
    }

    // Getters y métodos de gestión
    public List<Temporada> getTemporadas() { return temporadas; }
    
    public void agregarTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
    }
}