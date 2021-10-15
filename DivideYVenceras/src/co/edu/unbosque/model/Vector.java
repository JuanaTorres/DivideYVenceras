package co.edu.unbosque.model;

public class Vector {
	
	public Vector() {
		
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
