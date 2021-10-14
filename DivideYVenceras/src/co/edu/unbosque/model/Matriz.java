 package co.edu.unbosque.model;

public class Matriz {

	private int num[][];
	private int filas;
	private int columnas;
	
	public Matriz(int f, int c) {
	  filas=f;
	  columnas=c;
	  num=new int [filas][columnas];
	
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
		String r="";
		for (int i=0; i<filas; i++) {
			
			for (int j=0; j<columnas; j++) {
			r=r+" "+ num [i][j];
		}
			r=r+"\n";
		}
		return r;
		
	}public void asignarValorMatriz(int valor, int f, int c) {
		
		num[f][c]=valor;
		
	}
	public int[][] multiply(int[][] a, int[][] b) {
	    int[][] c = new int[a.length][b[0].length];
	    if (a[0].length == b.length) {
	        for (int i = 0; i < a.length; i++) {
	            for (int j = 0; j < b[0].length; j++) {
	                for (int k = 0; k < a[0].length; k++) {
	                    // aquí se multiplica la matriz
	                    c[i][j] += a[i][k] * b[k][j];
	                }
	            }
	        }
	    }
	    
	    return c;
	}

	
}