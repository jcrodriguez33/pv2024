package ar.edu.unju.pv2024.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.pv2024.model.ObraSocial;
import ar.edu.unju.pv2024.model.Paciente;

@Service
public class PacienteService {
	private static List<ObraSocial> obrasSociales;
	private static List<Paciente> pacientes;

	static {
		ObraSocial obraSocial1 = new ObraSocial(1, "ISJ");
		ObraSocial obraSocial2 = new ObraSocial(2, "OSDE");
		ObraSocial obraSocial3 = new ObraSocial(3, "MEDIFE");
		obrasSociales = new ArrayList<>();
		obrasSociales.add(obraSocial1);
		obrasSociales.add(obraSocial2);
		obrasSociales.add(obraSocial3);
		Paciente paciente1 = new Paciente(1000, "JUANA RAMOS", LocalDate.now(), obraSocial1);
		Paciente paciente2 = new Paciente(1001, "DALMIRA MAMANI", LocalDate.now(), obraSocial2);
		Paciente paciente3 = new Paciente(1002, "SANTOS TREJO", LocalDate.now(), obraSocial1);
		Paciente paciente4 = new Paciente(1003, "DARIO RAMOS", LocalDate.now(), obraSocial2);
		Paciente paciente5 = new Paciente(1004, "DIEGO LAMAS", LocalDate.now(), obraSocial1);
		pacientes = new ArrayList<>();
		pacientes.add(paciente1);
		pacientes.add(paciente2);
		pacientes.add(paciente3);
		pacientes.add(paciente4);
		pacientes.add(paciente5);
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public List<ObraSocial> getObrasSociales() {
		return obrasSociales;
	}

	public void guardar(Paciente paciente) {
		Integer indice = getIndexFor(paciente);
		if (indice != null) {
			pacientes.set(indice, paciente);
		} else {
			pacientes.add(paciente);
		}
		
	}

	public ObraSocial getObraSocialBy(Integer id) {
		for (ObraSocial obraSocial : obrasSociales) {
			if (obraSocial.getId().equals(id)) {
				return obraSocial;
			}
		}
		return null;
	}
	
	public Integer getIndexFor(Paciente paciente) {
		for (int i = 0; i < pacientes.size(); ++i) {
			if (pacientes.get(i).getNumeroDocumento().equals(paciente.getNumeroDocumento())){
				return i;
			}
		}
		return null;
	}
}
