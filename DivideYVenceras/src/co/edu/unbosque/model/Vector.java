package co.edu.unbosque.model;

import java.util.Arrays;
import java.util.Random;

public class Vector {
	
	public Vector() {
		
	}

	public  int [] crearVector(int desde, int hasta, int tam){
        int[] numeros = new int[tam];                                                                             
        Random rnd = new Random();
        for (int i = 0; i < numeros.length; i++) {
             numeros[i] = rnd.nextInt(hasta - desde + 1) + desde;                                                 
        }
        Arrays.sort(numeros);
        return numeros;
	}
	public String toString(int[] vector) {
		return Arrays.toString(vector);
	}
	public int[] juntarVectores(int[] a,int[] b) {
		int lenArray1 = a.length;
        int lenArray2 = b.length;
        int[] concate = new int[lenArray1 + lenArray2];
        System.arraycopy(a, 0, concate, 0, lenArray1);  
        System.arraycopy(b, 0, concate, lenArray1, lenArray2);
        Arrays.sort(concate);
        return concate;
	}
	
	public int mediana(int[] X, int[] Y, int primX, int ultX, int primY, int ultY) {
		int posX;
		int posY;
		int nitems;
		if ((primX >= ultX) && (primY >= ultY)) {
			return Math.min(X[ultX], Y[ultY]);
		}
		nitems = ultX - primX + 1;
		if (nitems == 2) {
			if (X[ultX] < Y[primY]) {
				return X[ultX];
			} else if (Y[ultY] < X[primX]) {
				return Y[ultY];
			} else {
				return Math.max(X[primX], Y[primY]);
			}
		}
		nitems = (nitems - 1) / 2;
		posX = primX + nitems;
		posY = primY + nitems;
		if(X[posX]==Y[posY]) {
			return X[posX];
		}
		else if (X[posX]<Y[posY]) {
			return mediana(X,Y,ultX-nitems,ultX,primY,primY+nitems);
		}
		else {
			return mediana(X,Y,primX,primX+nitems,ultY-nitems,ultY);
		}
	}
	
}
