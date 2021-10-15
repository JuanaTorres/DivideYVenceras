package co.edu.unbosque.controller;

import java.util.Random;

import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.view.View;

public class Controller {

	private View vista;
	private Matriz num;

	public Controller() {
		vista = new View();
		int t = 0;
		int c = 0;
		int dato = vista.pedirDato(
				"Por favor escoja el ejercicio que quiere realizar\n1.Mediana de dos vectores\n2.Multiplicación de dos Matrices");
		switch (dato) {
			case 1: {
	
				break;
			}
			case 2: {
				dato = vista
						.pedirDato("Por favor escoge una solución \n1.Manera super efe\n2.Forma de Devide y Venceras;)");
				break;
			}
			default:{
				vista.imprimirMensaje("Disculpa, Ingresaste un número incompleto");
			}
		}	

		do {
			t = vista.pedirDato("Digite el tama�o de cantidad de filas: ");
		} while (t <= 0);
		do {
			c = vista.pedirDato("Digite el tama�o de cantidad de columnas: ");
		} while (c <= 0);
		num = new Matriz(t, c);

		funcionar();
	}

	public void funcionar() {
		vista.imprimirMensaje(".: BIENVENIDO AL PROGRAMA MATRIZ:.");

		int op = vista.pedirDato(
				"Seleccione el modo de ingreso de los dato; " + "\n1.Manual" + "\n2.Aletoria" + "\n\nOpcion: ");

		capturarMatriz(op);
		String a = num.imprimirMatriz();

		vista.imprimirMensaje("El matriz es de \n \n " + a);
	}

	public void capturarMatriz(int op) {
		if (op == 1) {

			for (int i = 0; i < num.getFilas(); i++) {
				for (int j = 0; j < num.getColumnas(); j++) {
					num.asignarValorMatriz(vista.pedirDato("Valor dde la pos [" + i + "][ " + j + "]: "), i, j);
				}
			}
		} else {
			for (int i = 0; i < num.getFilas(); i++) {
				for (int j = 0; j < num.getColumnas(); j++) {
					Random rmd = new Random();
					int valor = 7 + rmd.nextInt(13);
					num.asignarValorMatriz(valor, i, j);
				}
			}
		}
	}

}
