package ar.edu.unju.pv.ejemplo4.main;

import ar.edu.unju.pv.ejemplo4.model.Computadora;
import ar.edu.unju.pv.ejemplo4.util.Procesador;

public class Main {
	public static void main(String[] args) {
		Computadora computadora1 = new Computadora("WD SSD 540G", "DDR 4 16GB", Procesador.I5);
		System.out.println(computadora1);
	}
}
