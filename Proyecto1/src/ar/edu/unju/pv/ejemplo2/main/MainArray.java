package ar.edu.unju.pv.ejemplo2.main;

import java.util.Scanner;

public class MainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros;
		numeros = new int[3];
		



		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < numeros.length; i++) {	
			System.out.println("Ingrese un entero:");
			 int  numero = teclado.nextInt();
			 numeros[i] = numero;
		}
		
	}

}
