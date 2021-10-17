package co.edu.unbosque.model;

public class Strassen {
	
	
	
	public Strassen () {
		
	}
	 
    // Method 1
    // Function to multiply matrices
    public int[][] multiplicarDYV(int[][] A, int[][] B)
    {
        // Order of matrix
        int n = A.length;
 
        // Creating a 2D square matrix with size n
        // n is input from the user
        int[][] R = new int[n][n];
 
        // Base case
        // If there is only single element
        if (n == 1)
 
            // Returning the simple multiplication of
            // two elements in matrices
            R[0][0] = A[0][0] * B[0][0];
 
        // Matrix
        else {
            // Step 1: Dividing Matrix into parts
            // by storing sub-parts to variables
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];
 
            // Step 2: Dividing matrix A into 4 halves
            dividir(A, A11, 0, 0);
            dividir(A, A12, 0, n / 2);
            dividir(A, A21, n / 2, 0);
            dividir(A, A22, n / 2, n / 2);
 
            // Step 2: Dividing matrix B into 4 halves
            dividir(B, B11, 0, 0);
            dividir(B, B12, 0, n / 2);
            dividir(B, B21, n / 2, 0);
            dividir(B, B22, n / 2, n / 2);
 
            // Using Formulas as described in algorithm
 
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
 
            // Step 3: Join 4 halves into one result matrix
            unir(C11, R, 0, 0);
            unir(C12, R, 0, n / 2);
            unir(C21, R, n / 2, 0);
            unir(C22, R, n / 2, n / 2);
        }
 
        // Step 4: Return result
        return R;
    }
 
    // Method 2
    // Function to subtract two matrices
    public int[][] restar(int[][] A, int[][] B)
    {
        //
        int n = A.length;
 
        //
        int[][] C = new int[n][n];
 
        // Iterating over elements of 2D matrix
        // using nested for loops
 
        // Outer loop for rows
        for (int i = 0; i < n; i++)
 
            // Inner loop for columns
            for (int j = 0; j < n; j++)
 
                // Subtracting corresponding elements
                // from matrices
                C[i][j] = A[i][j] - B[i][j];
 
        // Returning the resultant matrix
        return C;
    }
 
    // Method 3
    // Function to add two matrices
    public int[][] sumar(int[][] A, int[][] B)
    {
 
        //
        int n = A.length;
 
        // Creating a 2D square matrix
        int[][] C = new int[n][n];
 
        // Iterating over elements of 2D matrix
        // using nested for loops
 
        // Outer loop for rows
        for (int i = 0; i < n; i++)
 
            // Inner loop for columns
            for (int j = 0; j < n; j++)
 
                // Adding corresponding elements
                // of matrices
                C[i][j] = A[i][j] + B[i][j];
 
        // Returning the resultant matrix
        return C;
    }
 
    
    // Method 4
    // Function to split parent matrix
    // into child matrices
    public void dividir(int[][] P, int[][] C, int iB, int jB)
    {
        // Iterating over elements of 2D matrix
        // using nested for loops
 
        // Outer loop for rows
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
 
            // Inner loop for columns
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
 
                C[i1][j1] = P[i2][j2];
    }
 
    // Method 5
    // Function to join child matrices
    // into (to) parent matrix
    public void unir(int[][] C, int[][] P, int iB, int jB)
 
    {
        // Iterating over elements of 2D matrix
        // using nested for loops
 
        // Outer loop for rows
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
 
            // Inner loop for columns
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
 
                P[i2][j2] = C[i1][j1];
    }
 
       
    
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
    public boolean validarPotencia(int num) {
    	double x=(Math.log10(num) / Math.log10(2));
    	if(x-Math.floor(x)==0.0) {
    		return true;
    	}
		return false;
 	}
}