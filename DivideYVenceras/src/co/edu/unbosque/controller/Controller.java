package co.edu.unbosque.controller;

import java.util.Random;

import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.model.Strassen;
import co.edu.unbosque.model.Vector;
import co.edu.unbosque.view.View;

public class Controller {

	private View vista;
	private Matriz num;
	private Matriz num2;
	private Vector vector;
	private Strassen matrix;

	public Controller() {
		matrix = new Strassen();
		vista = new View();
		vector = new Vector();
		funcionar();

	}

	public void funcionar() {
		int t = 0;
		int c = 0;
		int dato = vista.pedirDato(
				"Por favor escoja el ejercicio que quiere realizar\n1.Mediana de dos vectores\n2.Multiplicacion de dos Matrices");
		switch (dato) {
		case 1: {
			int op = vista.pedirDato(
					"Por favor ingresa la opcion que quieres\n1.Generar vectores \n2.Quiero crear los 2 vectores");
			var tam = vista.pedirDato("Ingresa el tamaño de los array");
			if (op == 1) {
				var vector1 = vector.crear(tam);
				var vector2 = vector.crear(tam);
				var unionVector = vector.juntarVectores(vector1, vector2);
				var mediana = vector.mediana(vector1, vector2, 0, tam - 1, 0, tam - 1);
				vista.imprimirMensaje("Soluci9n al ejercicio \nVector1 >> " + vector.toString(vector1) + "\nVector2 >> "
						+ vector.toString(vector2) + "\nLa mediana entre los arrays igual a " + mediana
						+ "\nEl vector final es --> " + vector.toString(unionVector));

			} else if (op == 2) {
				var x = 0;
				var vector1 = new int[tam];
				var vector2 = new int[tam];
				for (int i = 0; i < vector1.length; i++) {
					vector1[i] = vista.pedirDato("Valor en la posicion " + i + " del vector uno");
				}
				for (int i = 0; i < vector2.length; i++) {
					vector2[i] = vista.pedirDato("Valor en la posicion " + i + " del vector dos ");
				}
				vector.ordenar(vector1);
				vector.ordenar(vector2);
				var unionVector = vector.juntarVectores(vector1, vector2);
				var mediana = vector.mediana(vector1, vector2, 0, tam - 1, 0, tam - 1);
				vista.imprimirMensaje("Solucion al ejercicio \nVector1 --> " + vector.toString(vector1)
						+ "\nVector2 >> " + vector.toString(vector2) + "\nLa mediana entre los arrays igual a "
						+ mediana + "\nEl vector final es >> " + vector.toString(unionVector));

			} else {
				vista.imprimirMensaje("Disculpa, Ingresaste un numero incorrecto");
				salir();
			}
			break;
		}
		case 2: {
			dato = vista.pedirDato("Por favor escoge una solucion \n1.Manera normal\n2.Forma de Divide y Venceras ;)");
			do {
				t = vista.pedirDato("Digite el tamano de las matrices nxn: ");
				c = t;
			} while (t <= 0);

			num = new Matriz(t, c);
			int op = vista.pedirDato("Seleccione el modo de ingreso de los datos para la primera matriz ; "
					+ "\n1.Manual" + "\n2.Aletoria" + "\n\nOpcion: ");

			capturarMatriz(op, num);
			String a = num.imprimirMatriz();

			vista.imprimirMensaje("El matriz es de \n \n" + a);

			num2 = new Matriz(t, c);
			op = vista.pedirDato("Seleccione el modo de ingreso de los datos para la segunda matriz ; " + "\n1.Manual"
					+ "\n2.Aletoria" + "\n\nOpcion: ");

			capturarMatriz(op, num2);
			a = num2.imprimirMatriz();

			vista.imprimirMensaje("El matriz es de \n \n" + a);
			if (dato == 1) {
				int[][] Z = matrix.multiplicacionNomal(num.getNum(), num2.getNum());

				vista.imprimirMensaje("Matriz final\n" + matrix.imprimirMatriz(Z));

			} else if (dato == 2) {

				int[][] Z = matrix.multiply(num.getNum(), num2.getNum());

				vista.imprimirMensaje("Matriz final\n" + matrix.imprimirMatriz(Z));

			} else {
				vista.imprimirMensajeError("Debe ingresar 1 o 2, dependiendo de su opcion a elegir");
				funcionar();
			}
			break;
		}
		default: {
			vista.imprimirMensaje("Disculpa, Ingresaste un numero incorrecto");
			salir();
		}

		}
		if (vista.pedirDato("Desea seguir o parar el programa \n1.Seguir\n2.Cualquier numero para salir") == 1) {
			funcionar();
		} else {
			salir();
		}
	}

	public void capturarMatriz(int op, Matriz num) {
		if (op == 1) {

			for (int i = 0; i < num.getFilas(); i++) {
				for (int j = 0; j < num.getColumnas(); j++) {
					num.asignarValorMatriz(vista.pedirDato("Valor de la pos [" + i + "][ " + j + "]: "), i, j);
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

	public void salir() {
		vista.imprimirMensaje("Hasta luego, gracias");
		System.exit(0);
	}

}
