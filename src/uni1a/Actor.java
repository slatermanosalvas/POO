package uni1a;


public class Actor {
private String nombre;
private int anioNacimiento;
private String nacionalidad;


public Actor(String nombre, int anioNacimiento, String nacionalidad) {
this.nombre = nombre;
this.anioNacimiento = anioNacimiento;
this.nacionalidad = nacionalidad;
}


public String getNombre() { return nombre; }
public int getAnioNacimiento() { return anioNacimiento; }
public String getNacionalidad() { return nacionalidad; }


@Override
public String toString() {
return nombre + " (" + anioNacimiento + ", " + nacionalidad + ")";
}
}