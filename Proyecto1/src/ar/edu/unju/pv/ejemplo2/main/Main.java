package ar.edu.unju.pv.ejemplo2.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.pv.ejemplo2.model.Paciente;

public class Main {

	public static void main(String[] args) {
		Paciente paciente1 = new Paciente();
		paciente1.setNumeroDocumento(10000);
		paciente1.setNombre("Mariela");
		paciente1.setFechaNacimiento(LocalDate.now());	
		Paciente paciente2 = new Paciente(10002, "Pedro", LocalDate.now());
		Paciente paciente3 = new Paciente(10003, "Maria", LocalDate.now());
		Paciente paciente4 = new Paciente(10004, "Mario", LocalDate.now());
		
		List<Paciente> pacientes = new ArrayList<>();
		pacientes.add(paciente1);
		pacientes.add(paciente2);
		pacientes.add(paciente3);
		pacientes.add(paciente4);	
		for (Paciente paciente : pacientes) {
			System.out.println(paciente);
		}
		System.out.println("La cantidad de pacientes es:" + pacientes.size());
		
		String buscar = "Maria";
		for (Paciente paciente : pacientes) {
			if (paciente.getNombre().equals(buscar)) {
				System.out.println("Encontrado ->" + paciente);	
			}			
		}
	}

}
