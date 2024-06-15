package ar.edu.unju.pv2024.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PacienteDto {
	private Integer numeroDocumento;
	private String nombre;
	private String fechaNacimiento;
	private Integer idObraSocial;
	private String obraSocial;
}
