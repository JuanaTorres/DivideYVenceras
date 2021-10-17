/**
* El package que contiene la clase
 */
package co.edu.unbosque.model;

import java.util.Arrays;
import java.util.Random;
/**
 * Clase Vector que encuentra la mediana, ordena el vector y crea un vector
 * 
 * @authors Paula Andre Anaya Ramirez, Juana
 *          Valentina Torres Parrado and Andres Galvis Bolivar
 *          
 * @version 1.0
 *
 */
public class Vector {
/**
 * 	Constructor de la clase
 */
	public Vector() {
		
	}
/**
 * Metodo que crea y guarda los valores en un vector aleatoriamente
 * @param tam,tamano del vector
 * @return el vector
 */
	public  int [] crear(int tam){

		Random rnd = new Random();
		int desde = rnd.nextInt(1000);
		int hasta = rnd.nextInt(1000);
		while(desde == hasta){
			hasta=rnd.nextInt(1000);
		}
		if((desde-hasta) < -10){
			hasta +=10;
		} 
		if((hasta-desde) < 1) {
			var x = hasta;
			hasta = desde+20;
			desde = x;
		}
        int[] numeros = new int[tam];                                                                             
        for (int i = 0; i < numeros.length; i++) {
             numeros[i] = rnd.nextInt(hasta - desde + 1) + desde;                                                 
        }
        Arrays.sort(numeros);
        return numeros;
	}
	/**
	 * Metodo que transforma el vector en String
	 * @param vector, el vector
	 * @return, el vector en String
	 */
	public String toString(int[] vector) {
		return Arrays.toString(vector);
	}
	/**
	 * Une dos vectors en uno solo
	 * @param a, el primer vector o vector
	 * @param b, el segundo vector o vector
	 * @return el nuevo vector o vectos
	 */
	public int[] juntarVectores(int[] a,int[] b) {
		int lenArray1 = a.length;
        int lenArray2 = b.length;
        int[] concate = new int[lenArray1 + lenArray2];
        System.arraycopy(a, 0, concate, 0, lenArray1);  
        System.arraycopy(b, 0, concate, lenArray1, lenArray2);
        Arrays.sort(concate);
        return concate;
	}
	/**
	 * Metodo que ordena un vector 
	 * @param vector, el vector
	 */
	public void ordenar(int[] vector) {
		Arrays.sort(vector);
	}
	/**
	 * Metodo que encuentra la mediana de dos vectores
	 * @param X, primer vector
	 * @param Y, segundo vector
	 * @param primX, la posicion de inicio del primer vector
	 * @param ultX, la posicion final del primer vector
	 * @param primY, la posicion de inicio del segundo vector
	 * @param ultY, la posicion final del segundo vector
	 * @return el valor de la mediana 
	 */
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
