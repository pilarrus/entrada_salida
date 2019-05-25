import java.io.Serializable;

public class Persona implements Serializable {
	/**
	 * Primero definimos las clases de datos que vamos a escribir y leer en el fichero.
	 * Estas clases deben implementar la interface Serializable.
	 * También todos los atributos de estas clases deben ser tipos primitivos
	 * (int, double, float, etc) o bien clases que a su vez implementen la interface Serializable.
	 */
	
	//private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellidos;
	private int edad;
	private int id; //Identifica al objeto
	
	public Persona(String nombre, String apellidos, int edad, int id) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", id=" + id + "]";
	}

}
