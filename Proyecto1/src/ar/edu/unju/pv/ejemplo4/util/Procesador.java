package ar.edu.unju.pv.ejemplo4.util;

public enum Procesador {
	I3(4, "Intel Core 3"), I5(8, "Intel Core 5"), I7(16, "Intel Core 7");
	private int nucleos;
	private String descripcion;
	
	private Procesador(int nucleos, String descripcion) {
		this.nucleos = nucleos;
		this.descripcion = descripcion;
	}
	public int getNucleos() {
		return nucleos;
	}
	public String getDescripcion() {
		return descripcion;
	}	
}
