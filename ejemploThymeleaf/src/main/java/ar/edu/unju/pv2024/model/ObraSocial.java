package ar.edu.unju.pv2024.model;

import org.springframework.stereotype.Component;

@Component
public class ObraSocial {
	private Integer id;
	private String nombre;

	public ObraSocial(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public ObraSocial() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
