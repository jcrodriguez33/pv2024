package ar.edu.unju.pv.ejemplo3;

public class Prueba {

	public static void main(String[] args) {
		Computadora computadora = new Computadora("WD SSD 450GB", "DDR4 8GB", Procesador.I5);
		System.out.println(computadora);
		computadora.setProcesador(Procesador.I7);
		System.out.println(computadora);
	}

}
