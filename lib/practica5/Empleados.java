package prog3.practica5;

public class Empleados {
	private String nombre;
	private int categoria;
	private int antiguedad;
	
	public Empleados(String nombre,int categoria,int antiguedad) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.antiguedad = antiguedad;
	}
	public Empleados() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
}
