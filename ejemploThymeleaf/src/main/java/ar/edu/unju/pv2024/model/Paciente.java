package ar.edu.unju.pv2024.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Paciente {
	private Integer numeroDocumento;
	private String nombre;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private ObraSocial obraSocial;

	public Paciente(Integer numeroDocumento, String nombre, LocalDate fechaNacimiento, ObraSocial obraSocial) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.obraSocial = obraSocial;
	}
	public Paciente() {
	}
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
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
	public ObraSocial getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}
	
	
}
