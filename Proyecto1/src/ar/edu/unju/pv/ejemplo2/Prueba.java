package ar.edu.unju.pv.ejemplo2;

import java.time.LocalDate;

public class Prueba {

	public static void main(String[] args) {
//		EstadoTurno estado;
//		estado = EstadoTurno.ESPERA;
//		System.out.println(estado.toString());
		Turno turno = new Turno("Daniela",LocalDate.now(), EstadoTurno.ESPERA);
		System.out.println(turno);
	}

}
