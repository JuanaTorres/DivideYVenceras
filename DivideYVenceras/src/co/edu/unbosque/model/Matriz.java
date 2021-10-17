/**
* El package que contiene la clase
*/
package co.edu.unbosque.model;
/**
 * Clase Matriz que crea un arreglo bidimensional, asigna sus valores, tamanos e imprime
 * 
 * @authors Paula Andre Anaya Ramirez, Juana
 *          Valentina Torres Parrado and Andres Galvis Bolivar
 *          
 * @version 1.0
 *
 */
public class Matriz {

	private int num[][];
	private int filas;
	private int columnas;
/**
 * Constructor de la clase
 * @param f, numero de las filas
 * @param c, numero de columnas
 */
	public Matriz(int f, int c) {
		filas = f;
		columnas = c;
		num = new int[filas][columnas];

	}
/**
 * Metodo que guarda enun String los valores de la matriz
 * @return r, el String conlos valores de la matriz
 */
	public String imprimirMatriz() {
		String r = "";
		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {
				r = r + " " + num[i][j];
			}
			r = r + "\n";
		}
		return r;

	}
/**
 * Metodo que guarda los valores en la matriz
 * @param valor, valor a ingresar
 * @param f, numero de la fila
 * @param c, numero de la columna
 */
	public void asignarValorMatriz(int valor, int f, int c) {

		num[f][c] = valor;

	}
	
/**
 * Setters y Getters
 * @return
 */
	public int[][] getNum() {
		return num;
	}

	public void setNum(int[][] num) {
		this.num = num;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	
}