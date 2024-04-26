package ar.edu.unju.pv.ejemplo3;

public enum Procesador {
	I3("Core 3 Intel", 4), I5("Core 5 Intel", 8), I7("Core 7 Intel", 12) ;
	private String procesador;
	private int nucleos;
	
	private Procesador(String procesador, int nucleos) {
		this.procesador = procesador;
		this.nucleos = nucleos;
	}

	public String getProcesador() {
		return procesador;
	}

	public int getNucleos() {
		return nucleos;
	}
	
}
