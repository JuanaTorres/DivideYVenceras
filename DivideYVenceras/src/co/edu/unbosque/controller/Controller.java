package co.edu.unbosque.controller;

import java.util.Random;


import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.model.Vector;
import co.edu.unbosque.view.View;


public class Controller {

	private View vista;
	private Matriz num;
	private Vector vector;

	public Controller() {
		vista = new View();
		vector = new Vector();
		int t = 0;
		int c = 0;
		int dato = vista.pedirDato(
				"Por favor escoja el ejercicio que quiere realizar\n1.Mediana de dos vectores\n2.Multiplicación de dos Matrices");
		switch (dato) {
			case 1: {
				int op = vista.pedirDato("Por favor ingresa la opción que quieres\n1.Generar vectores \n2.Quiero crear los 2 vectores");
				var tam = vista.pedirDato("Ingresa el tamaño de los array");
				if(op == 1) {
					var rangoInicial = vista.pedirDato("Ingresa el rango inicial");
					var rangoFinal = vista.pedirDato("Ingresa el rango final");
					var vector1 = vector.crear(rangoInicial, rangoFinal, tam);
					var vector2 = vector.crear(rangoInicial, rangoFinal, tam);
					var unionVector = vector.juntarVectores(vector1, vector2);
					var mediana = vector.mediana(vector1, vector2,0,tam, 0, tam);
					vista.imprimirMensaje("Solución al ejercicio \nVector1 --> "+vector.toString(vector1)+"\nVector2 --> "+vector.toString(vector2)+"\nLa mediana entre los arrays igual a "+mediana+"\nEl vector final es --> "+vector.toString(unionVector));
					if(vista.pedirDato("Desea seguir o parar el programa \n1.Seguir\n2.Cualquier número para salir")==1) {
						new Controller();
					}else {
						salir();
					}
				}else if (op == 2) {
					var x = 0;
					var vector1 = new int[tam];
						var vector2 = new int[tam];
						for (int i = 0; i < vector1.length; i++) {
							vector1[i] = vista.pedirDato("Valor en la posición "+i+" del vector uno");	
						}
						for (int i = 0; i < vector2.length; i++) {
							vector2[i] = vista.pedirDato("Valor en la posición "+i+" del vector dos ");	
						}
						vector.ordenar(vector1);
						vector.ordenar(vector2);
						var unionVector = vector.juntarVectores(vector1, vector2);
						vista.imprimirMensaje("Solución al ejercicio \nVector1 --> "+vector.toString(vector1)+"\nVector2 --> "+vector.toString(vector2)+"\nLa mediana entre los arrays igual a \nEl vector final es --> "+vector.toString(unionVector));
						var mediana = vector.mediana(vector1, vector2,0,tam, 0, tam);
						vista.imprimirMensaje("Solución al ejercicio \nVector1 --> "+vector.toString(vector1)+"\nVector2 --> "+vector.toString(vector2)+"\nLa mediana entre los arrays igual a "+mediana+"\nEl vector final es --> "+vector.toString(unionVector));

						if(vista.pedirDato("Desea seguir o parar el programa \n1.Seguir\n2.Cualquier número para salir")==1) {
							new Controller();
						}else {
							salir();
						}
					}else {
						vista.imprimirMensaje("Disculpa, Ingresaste un número incorrecto");
						salir();
					}
				break;
			}
			case 2: {
				dato = vista
						.pedirDato("Por favor escoge una solución \n1.Manera super efe\n2.Forma de Divide y Venceras;)");
				do {
					t = vista.pedirDato("Digite el tama�o de cantidad de filas: ");
				} while (t <= 0);
				do {
					c = vista.pedirDato("Digite el tama�o de cantidad de columnas: ");
				} while (c <= 0);
				num = new Matriz(t, c);
				break;
			}
			default:{
				vista.imprimirMensaje("Disculpa, Ingresaste un número incorrecto");
				salir();
			}
		}	

		

		funcionar();
	}
	public void escogerMatriz(int opcion) {
		
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
	public void salir() {
		System.exit(0);
	}

}
