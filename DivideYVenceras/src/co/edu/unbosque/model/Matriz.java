package co.edu.unbosque.model;

public class Matriz {

	private int num[][];
	private int filas;
	private int columnas;

	public Matriz(int f, int c) {
		filas = f;
		columnas = c;
		num = new int[filas][columnas];

	}

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

	public void asignarValorMatriz(int valor, int f, int c) {

		num[f][c] = valor;

	}
	
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
