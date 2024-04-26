package ar.edu.unju.pv.ejemplo2.model;

import java.time.LocalDate;

public class Paciente {
	private int numeroDocumento;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String grupoSanguineo;
	
	public Paciente() {
		
	}
	
	public Paciente(int numeroDocumento, String nombre, LocalDate fechaNacimiento) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	@Override
	public String toString() {
		return "numeroDocumento=" + numeroDocumento + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento;
	}

}
