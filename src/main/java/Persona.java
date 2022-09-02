import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = -2424067014487926043L;
	private String name;
	private double id;
	
	public Persona() {}
	
	public Persona(String nombre, double identification) {
		name = nombre;
		id = identification;
	}
	
	public String toString() {
		return "{" + name + ", " + id + " }";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}
}
