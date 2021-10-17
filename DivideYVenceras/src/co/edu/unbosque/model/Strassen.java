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
public class Strassen {

    /**
     * Metodo constructor de la clase
     */
    public Strassen () {
	}

    /**
     * Metodo de multiplicar matrices por DYV
     *
     * @param A matriz A
     * @param B matriz B
     * @return R resultado de la multiplicacion
     *
     */
    public int[][] multiplicarDYV(int[][] A, int[][] B)
    {
        // Orden de matriz
        int n = A.length;
 
        // Creando una matriz cuadrada 2D con tamano n
        // n es entrada del usuario
        int[][] R = new int[n][n];
 
        // Caso base
        //Si solo hay un elemento
        if (n == 1)
 
            // Devolviendo la simple multiplicación de
            // dos elementos en las matrices
            R[0][0] = A[0][0] * B[0][0];
 
        // Matriz
        else {
            // Paso 1: Dividir la matriz en partes
            //almacenando subpartes en variables
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];
 
            // Paso 2: División de la matriz A en 4 mitades
            partir(A, A11, 0, 0);
            partir(A, A12, 0, n / 2);
            partir(A, A21, n / 2, 0);
            partir(A, A22, n / 2, n / 2);
 
            // Paso 2:
            //División de la matriz B en 4 mitades
            partir(B, B11, 0, 0);
            partir(B, B12, 0, n / 2);
            partir(B, B21, n / 2, 0);
            partir(B, B22, n / 2, n / 2);
 
            // Usar fórmulas como se describe en el algoritmo
 
            // M1:=(A1+A3)×(B1+B2)
            int[][] M1
                = multiplicarDYV(sumar(A11, A22), sumar(B11, B22));
           
            // M2:=(A2+A4)×(B3+B4)
            int[][] M2 = multiplicarDYV(sumar(A21, A22), B11);
           
            // M3:=(A1−A4)×(B1+A4)
            int[][] M3 = multiplicarDYV(A11, restar(B12, B22));
           
            // M4:=A1×(B2−B4)
            int[][] M4 = multiplicarDYV(A22, restar(B21, B11));
           
            // M5:=(A3+A4)×(B1)
            int[][] M5 = multiplicarDYV(sumar(A11, A12), B22);
           
            // M6:=(A1+A2)×(B4)
            int[][] M6
                = multiplicarDYV(restar(A21, A11), sumar(B11, B12));
           
            // M7:=A4×(B3−B1)
            int[][] M7
                = multiplicarDYV(restar(A12, A22), sumar(B21, B22));
 
            // P:=M2+M3−M6−M7
            int[][] C11 = sumar(restar(sumar(M1, M4), M5), M7);
           
            // Q:=M4+M6
            int[][] C12 = sumar(M3, M5);
           
            // R:=M5+M7
            int[][] C21 = sumar(M2, M4);
           
            // S:=M1−M3−M4−M5
            int[][] C22 = sumar(restar(sumar(M1, M3), M2), M6);
 
            // Paso 3: Unir 4 mitades en una matriz de resultados
            unir(C11, R, 0, 0);
            unir(C12, R, 0, n / 2);
            unir(C21, R, n / 2, 0);
            unir(C22, R, n / 2, n / 2);
        }
 
        // Paso 4: Retorna el resultado
        return R;
    }
 
    // Metodo 2
    /**
     * Metodo para restar dos matrices
     *
     * @param A matriz A
     * @param B matriz B
     * @return C matriz C retorna el resultado de la resta
     */
    public int[][] restar(int[][] A, int[][] B)
    {
        //Orden de matriz
        int n = A.length;
 
        //
        int[][] C = new int[n][n];
 
        // Iterando sobre elementos de matriz 2D
        // usando bucles for anidados
 
        // filas
        for (int i = 0; i < n; i++)
 
            //columnas
            for (int j = 0; j < n; j++)
                //Restar elementos correspondientes
                //de matrices
                C[i][j] = A[i][j] - B[i][j];
 
        // retorna la matriz resultante
        return C;
    }
 
    // Method 3
    /**
     * Metodo para sumar dos matrices
     * @param A matriz A
     * @param B matriz B
     * @return C matriz C  resultado de la suma
     */
    public int[][] sumar(int[][] A, int[][] B)
    {
 
        //Orden de matriz
        int n = A.length;

        int[][] C = new int[n][n];
 
        // Iterando sobre elementos de matriz 2D
        // usando bucles for anidados
 
        // filas
        for (int i = 0; i < n; i++)
 
            // columnas
            for (int j = 0; j < n; j++)
                //Agregar elementos correspondientes
                // a las matrices
                C[i][j] = A[i][j] + B[i][j];
 
        //Retorna matriz resultante
        return C;
    }
 
    
    // Method 4
    /**
     * Metodo que ayuda a partir la matriz en matrices mas pequenas
     * @param P
     * @param C
     * @param iB
     * @param jB
     */
    public void partir(int[][] P, int[][] C, int iB, int jB)
    {
        // Filas
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
 
            //columnas
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
 
                C[i1][j1] = P[i2][j2];
    }

    /**
     * Metodo para unir las matrices divididas a la matriz padre
     *
     * @param C matriz C
     * @param P matriz P
     * @param iB
     * @param jB
     */
    public void unir(int[][] C, int[][] P, int iB, int jB)
 
    {
        // Filas
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
 
            // Columna
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
 
                P[i2][j2] = C[i1][j1];
    }


    /**
     * Metodo para imprimir una matriz
     *
     * @param A matriz a imprimir
     * @return r String con los datos de la matriz
     */
    public String imprimirMatriz(int [][] A) {
		String r = "";
		int filas = A.length;
		int columnas = A[0].length;
		
		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {
				r = r + " " + A[i][j];
			}
			r = r + "\n";
			
		}
		return r;

	}


    /**
     * Medoto para multiplicar matrices de la manera convencional
     *
     * @param a matriz A
     * @param b matriz B
     * @return c matriz con el resultado de la multiplicacion
     */
    public int[][] multiplicacionNomal (int[][] a, int[][] b) {
    	
		int[][] c = new int[a.length][b[0].length];
		
		//Se valida si la matriz se puede multiplicar 
		if (a[0].length == b.length) {
	
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					for (int k = 0; k < a[0].length; k++) {
						// Se multiplica la matriz
						c[i][j] += a[i][k] * b[k][j];
					}
				}
			}
		}

		return c;
	}


    /**
     * Metodo para validar que el tamano de la matriz sea potencia de 2
     * @param num
     * @return booleano con la respuesta
     */
    public boolean validarPotencia(int num) {
    	double x=(Math.log10(num) / Math.log10(2));
    	if(x-Math.floor(x)==0.0) {
    		return true;
    	}
		return false;
 	}
}