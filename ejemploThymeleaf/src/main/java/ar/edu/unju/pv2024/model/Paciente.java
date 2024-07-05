package ar.edu.unju.pv2024.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Component

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {
	@Id
	private Integer numeroDocumento;
	private String nombre;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@ManyToOne
	@JoinColumn(name = "obra_social_id", nullable = false)
	private ObraSocial obraSocial;
	@ManyToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Medico> medicosAtencion;
	
}
