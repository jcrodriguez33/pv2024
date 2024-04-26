package ar.edu.unju.pv.ejemplo1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese una fecha (dd/MM/yyyy):");
		String fechaString = teclado.next();
		try {
			LocalDate fecha = LocalDate.parse(fechaString, formatoFecha);			
			System.out.println("La fecha en localdate es  " + fecha);	
		} catch (DateTimeParseException e) {
			System.out.println("El formato de la fecha ingresada es incorrecta");
		}
			
			System.out.println("FIN");
	}

}
