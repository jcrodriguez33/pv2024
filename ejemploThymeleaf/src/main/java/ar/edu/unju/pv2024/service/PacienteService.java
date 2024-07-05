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

import ar.edu.unju.pv2024.dto.MedicoDto;
import ar.edu.unju.pv2024.dto.ObraSocialDto;
import ar.edu.unju.pv2024.dto.PacienteDto;
import ar.edu.unju.pv2024.model.Medico;
import ar.edu.unju.pv2024.model.ObraSocial;
import ar.edu.unju.pv2024.model.Paciente;
import ar.edu.unju.pv2024.repository.MedicoRepository;
import ar.edu.unju.pv2024.repository.ObraSocialRepository;
import ar.edu.unju.pv2024.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ObraSocialRepository obraSocialRepository;
	@Autowired
	private MedicoRepository medicoRepository;

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

	public List<MedicoDto> getMedicosAtencionBy(Integer numeroDocumento) {
		Paciente paciente  = pacienteRepository.findById(numeroDocumento).get();
		List<MedicoDto> medicos = new ArrayList<>();
		for (Medico medico : paciente.getMedicosAtencion()) {
			MedicoDto medicoDto = new MedicoDto();
			medicoDto.setId(medico.getId());
			medicoDto.setNombre(medico.getNombre());
			medicos.add(medicoDto);
		}
		return medicos;
	}

	public List<MedicoDto> getMedicosAtencion() {
		List<MedicoDto> medicos = new ArrayList<>();
		for (Medico medico : medicoRepository.findAll()) {
			MedicoDto medicoDto = new MedicoDto();
			medicoDto.setId(medico.getId());
			medicoDto.setNombre(medico.getNombre());
			medicos.add(medicoDto);
		}
		return medicos;
	}

	public void agregarMedicoFor(Integer numeroDocumento, Integer idMedico) {
		Paciente paciente  = pacienteRepository.findById(numeroDocumento).get();
		Medico medico = medicoRepository.findById(idMedico).get();
		paciente.getMedicosAtencion().add(medico);
		pacienteRepository.save(paciente);
		
	}

	public MedicoDto getMedicoBy(Integer idMedico) {
		Medico medico = medicoRepository.findById(idMedico).get();
		MedicoDto medicoDto = new MedicoDto();
		medicoDto.setId(medico.getId());
		medicoDto.setNombre(medico.getNombre());
		return medicoDto;
	}

	public List<PacienteDto> getPacientesBy(Integer idMedico) {
		Medico medico = medicoRepository.findById(idMedico).get();		
		List<PacienteDto> pacientesDto = new ArrayList<>();
		SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy");
		for (Paciente paciente : medico.getPacientes()) {
			Date fechaNacimiento = Date
					.from(paciente.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant());
			String fechaString = smf.format(fechaNacimiento);
			PacienteDto pacienteDto = new PacienteDto(paciente.getNumeroDocumento(), paciente.getNombre(), fechaString,
					paciente.getObraSocial().getId(), paciente.getObraSocial().getNombre());
			pacientesDto.add(pacienteDto);
		}
		
		return pacientesDto;
	}
}
