package modelo;

public class Piloto {
	private int numero;
	private String nombre;
	private String nacionalidad;
	private int edad;
	private String escuderia;
	public Piloto(int numero, String nombre, String nacionalidad, int edad, String escuderia) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.escuderia = escuderia;
	}
	@Override
	public String toString() {
		return "Piloto [numero=" + numero + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad
				+ ", escuderia=" + escuderia + "]";
	}
	public int getNumero() {
		return numero;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public int getEdad() {
		return edad;
	}
	public String getEscuderia() {
		return escuderia;
	}
	
	
	
	
	
}
