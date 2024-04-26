package ar.edu.unju.pv.ejemplo3.main;

import java.time.LocalDate;

import ar.edu.unju.pv.ejemplo3.model.Turno;
import ar.edu.unju.pv.ejemplo3.util.EstadoTurno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Turno turno = new Turno("Juana Lopez", "Dr. Flores", LocalDate.now(), EstadoTurno.ESPERA);
		System.out.println(turno);
		turno.setEstado(EstadoTurno.FINALIZADO);
		System.out.println(turno);
		
		
	}

}
