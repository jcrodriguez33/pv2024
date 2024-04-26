package ar.edu.unju.pv.ejemplo2;

import java.time.LocalDate;

public class Turno {
	private String paciente;
	private LocalDate fecha;
	private EstadoTurno estado;
	
	public Turno(String paciente, LocalDate fecha, EstadoTurno estado) {
		super();
		this.paciente = paciente;
		this.fecha = fecha;
		this.estado = estado;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
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
		return "Turno [paciente=" + paciente + ", fecha=" + fecha + ", estado=" + estado + "]";
	}
	
}
