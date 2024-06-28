package ar.edu.unju.pv2024.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.pv2024.dto.ObraSocialDto;
import ar.edu.unju.pv2024.dto.PacienteDto;
import ar.edu.unju.pv2024.model.ObraSocial;
import ar.edu.unju.pv2024.model.Paciente;
import ar.edu.unju.pv2024.repository.ObraSocialRepository;
import ar.edu.unju.pv2024.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ObraSocialRepository obraSocialRepository;

	public List<PacienteDto> getPacientes() {
		List<PacienteDto> pacientesDto = new ArrayList<>();
		List<Paciente> pacientes = pacienteRepository.findAll();
		SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy");
		for (Paciente paciente : pacientes) {
			Date fechaNacimiento = Date
					.from(paciente.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant());
			String fechaString = smf.format(fechaNacimiento);
			PacienteDto pacienteDto = new PacienteDto(paciente.getNumeroDocumento(), paciente.getNombre(), fechaString,
					paciente.getObraSocial().getId(), paciente.getObraSocial().getNombre());
			pacientesDto.add(pacienteDto);
		}
		return pacientesDto;
	}

	public List<ObraSocialDto> getObrasSociales() {
		List<ObraSocialDto> obrasSocialesDto = new ArrayList<>();
		List<ObraSocial> obrasSociales = obraSocialRepository.findAll();
		for (ObraSocial obraSocial : obrasSociales) {
			ObraSocialDto obraSocialDto = new ObraSocialDto(obraSocial.getId(), obraSocial.getNombre());
			obrasSocialesDto.add(obraSocialDto);
		}
		return obrasSocialesDto;
	}

	public void guardar(PacienteDto pacienteDto) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fechaNacimientoDate = smf.parse(pacienteDto.getFechaNacimiento());
			ObraSocial obraSocial = getObraSocialBy(pacienteDto.getIdObraSocial());
			LocalDate fechaNacimiento = fechaNacimientoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Paciente paciente;
			Optional<Paciente> opcional = pacienteRepository.findById(pacienteDto.getNumeroDocumento());
			if(opcional.isEmpty()) {
				paciente = new Paciente();
				paciente.setNumeroDocumento(pacienteDto.getNumeroDocumento());
			} else {
				paciente = opcional.get();
			}
			paciente.setNombre(pacienteDto.getNombre());
			paciente.setFechaNacimiento(fechaNacimiento);
			paciente.setObraSocial(obraSocial);
			pacienteRepository.save(paciente);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ObraSocial getObraSocialBy(Integer id) {
		return obraSocialRepository.findById(id).get();		
	}

	public boolean existe(PacienteDto pacienteBuscar) {
		if (pacienteRepository.findById(pacienteBuscar.getNumeroDocumento()).isPresent()) {
			return true;
		}
		return false;		
	}
}
