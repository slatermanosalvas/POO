package uni1a;


public class Investigador {
private String nombre;
private String area; // área de investigación o especialidad


public Investigador(String nombre, String area) {
this.nombre = nombre;
this.area = area;
}


public String getNombre() { return nombre; }
public String getArea() { return area; }
}