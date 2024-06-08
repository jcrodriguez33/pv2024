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

import ar.edu.unju.pv2024.model.ObraSocial;
import ar.edu.unju.pv2024.model.Paciente;
import ar.edu.unju.pv2024.service.PacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacienteService pacienteService;

	@GetMapping("/")
	public String pacienteList(Model model) {
		List<Paciente> pacientes = pacienteService.getPacientes();
		model.addAttribute("pacientes", pacientes);
		return "pacienteList";
	}

	@GetMapping("/nuevo")
	public ModelAndView pacienteNuevo() {
		Paciente paciente = new Paciente();
		List<ObraSocial> obrasSociales = pacienteService.getObrasSociales();
		ModelAndView model = new ModelAndView("pacienteForm");
		model.addObject("paciente", paciente);
		model.addObject("obrasSociales", obrasSociales);
		return model;
	}

	@PostMapping("/guardar")
	public String pacienteGuardar(@ModelAttribute("paciente") Paciente paciente, RedirectAttributes redirectAttributes, Model model) {
		// FIXME - Desde el formulario html del paciente solo se carga el id de la Obra
		// Social seleccionada por
		// tanto hay que buscar en el servicio la obras social con ese id y despues
		// asignarla al paciente.
		if (pacienteService.existe(paciente)) {
			List<ObraSocial> obrasSociales = pacienteService.getObrasSociales();
			model.addAttribute("paciente", paciente);
			model.addAttribute("obrasSociales", obrasSociales);
			model.addAttribute("error", "Numero de Documento Existente");
			return "pacienteForm";
		} else {
			ObraSocial obraSocial = pacienteService.getObraSocialBy(paciente.getObraSocial().getId());
			paciente.setObraSocial(obraSocial);
			pacienteService.guardar(paciente);
			redirectAttributes.addFlashAttribute("success", "Los Datos se Registraron Correctamente");
			return "redirect:/pacientes/";	
		}		
	}

	@GetMapping("/editar")
	public ModelAndView pacienteView(@RequestParam(name = "numeroDocumento") Integer numeroDocumento) {
		ModelAndView modelAndView = new ModelAndView("pacienteForm");
		List<Paciente> pacientes = pacienteService.getPacientes();
		Optional<Paciente> paciente = pacientes.stream()
				.filter(paciente1 -> paciente1.getNumeroDocumento().equals(numeroDocumento)).findFirst();
		List<ObraSocial> obrasSociales = pacienteService.getObrasSociales();
		modelAndView.addObject("obrasSociales", obrasSociales);
		modelAndView.addObject("paciente", paciente.get());
		return modelAndView;
	}

}
