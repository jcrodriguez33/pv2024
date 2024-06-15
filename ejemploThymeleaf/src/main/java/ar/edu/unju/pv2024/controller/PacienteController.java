package ar.edu.unju.pv2024.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.pv2024.dto.ObraSocialDto;
import ar.edu.unju.pv2024.dto.PacienteDto;
import ar.edu.unju.pv2024.service.PacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacienteService pacienteService;

	@GetMapping("/")
	public String pacienteList(Model model) {
		List<PacienteDto> pacientes = pacienteService.getPacientes();
		model.addAttribute("pacientes", pacientes);
		return "pacienteList";
	}

	@GetMapping("/nuevo")
	public ModelAndView pacienteNuevo() {
		PacienteDto paciente = new PacienteDto();
		List<ObraSocialDto> obrasSociales = pacienteService.getObrasSociales();
		ModelAndView model = new ModelAndView("pacienteForm");
		model.addObject("paciente", paciente);
		model.addObject("obrasSociales", obrasSociales);
		return model;
	}

	@PostMapping("/guardar")
	public String pacienteGuardar(@ModelAttribute("paciente") PacienteDto pacienteDto, RedirectAttributes redirectAttributes, Model model) {
		if (pacienteService.existe(pacienteDto)) {
			List<ObraSocialDto> obrasSociales = pacienteService.getObrasSociales();
			model.addAttribute("paciente", pacienteDto);
			model.addAttribute("obrasSociales", obrasSociales);
			model.addAttribute("error", "Numero de Documento Existente");
			return "pacienteForm";
		} else {
			System.out.println(pacienteDto.getFechaNacimiento());
			pacienteService.guardar(pacienteDto);
			redirectAttributes.addFlashAttribute("success", "Los Datos se Registraron Correctamente");
			return "redirect:/pacientes/";	
		}		
	}

	@GetMapping("/editar")
	public ModelAndView pacienteView(@RequestParam(name = "numeroDocumento") Integer numeroDocumento) {
		ModelAndView modelAndView = new ModelAndView("pacienteForm");
		List<PacienteDto> pacientes = pacienteService.getPacientes();
		Optional<PacienteDto> paciente = pacientes.stream()
				.filter(paciente1 -> paciente1.getNumeroDocumento().equals(numeroDocumento)).findFirst();
		List<ObraSocialDto> obrasSociales = pacienteService.getObrasSociales();
		modelAndView.addObject("obrasSociales", obrasSociales);
		modelAndView.addObject("paciente", paciente.get());
		return modelAndView;
	}

}
