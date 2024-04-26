package ar.edu.unju.pv.ejemplo3.model;

import java.time.LocalDate;

import ar.edu.unju.pv.ejemplo3.util.EstadoTurno;

public class Turno {
	private String paciente;
	private String medico;
	private LocalDate fecha;
	private EstadoTurno estado;
	
	public Turno(String paciente, String medico, LocalDate fecha, EstadoTurno estado) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.fecha = fecha;
		this.estado = estado;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public EstadoTurno getEstado() {
		return estado;
	}
	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Turno [paciente=" + paciente + ", medico=" + medico + ", fecha=" + fecha + ", estado=" + estado + "]";
	}
	
}
