package ar.edu.unju.pv2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.pv2024.dto.MedicoDto;
import ar.edu.unju.pv2024.dto.PacienteDto;
import ar.edu.unju.pv2024.service.PacienteService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	@Autowired
	private PacienteService pacienteService; 
	
	@GetMapping("/")
	public String medicoList(Model model) {
		List<MedicoDto>  medicos = pacienteService.getMedicosAtencion();
		model.addAttribute("medicos", medicos);
		return "medicoList";
	}
	
	@GetMapping("/verPacientes")
	public String verPacientes(@RequestParam(name = "idMedico") Integer idMedico, Model model) {
		MedicoDto medico = pacienteService.getMedicoBy(idMedico);		
		List<PacienteDto> pacientes = pacienteService.getPacientesBy(idMedico);
		model.addAttribute("pacientesMedico", pacientes);		
		model.addAttribute("medico", medico);
		return "pacientesMedicoList";
	}
}
