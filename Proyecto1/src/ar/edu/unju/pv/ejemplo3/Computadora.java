package ar.edu.unju.pv.ejemplo3;

public class Computadora {
	private String disco;
	private String memoria;
	private Procesador procesador;
	public Computadora(String disco, String memoria, Procesador procesador) {
		super();
		this.disco = disco;
		this.memoria = memoria;
		this.procesador = procesador;
	}
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	public String getMemoria() {
		return memoria;
	}
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	public Procesador getProcesador() {
		return procesador;
	}
	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}
	@Override
	public String toString() {
		return "Computadora [disco=" + disco + ", memoria=" + memoria + ", procesador=" + procesador.getProcesador() + "]";
	}
	
}
