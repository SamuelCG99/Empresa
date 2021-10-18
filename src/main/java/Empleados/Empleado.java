package Empleados;

public class Empleado {

	private int id;
	private String nombre;
	private String dni;
	private String sexo;
	private int categoria;
	private int annyo;
	
	public Empleado() {
		this.id = 0;
		this.nombre = "";
		this.dni = "";
		this.sexo = "";
		this.categoria = 0;
		this.annyo = 0;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getAnnyo() {
		return annyo;
	}
	public void setAnnyo(int annyo) {
		this.annyo = annyo;
	}
	
	
	
}
