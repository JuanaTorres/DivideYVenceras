/**
 * El package que contiene la clase
 */
package co.edu.unbosque.view;

import java.util.Arrays;

import javax.swing.JOptionPane;
/**
 * Clase View que contiene los metodos que permite mostrar mensajes o capturar datos.
 * 
 * @authors Paula Andre Anaya Ramirez, Juana
 *          Valentina Torres Parrado and Andres Galvis Bolivar
 *          
 * @version 1.0
 *
 */
public class View {
/**
 * Constructor
 */
	public View() {

	}
/**
 * Imprime un mensaje de advertencia
 * @param m, Mensaje a mostrar
 */
	public void imprimirMensajeAdvertencia(String m) {
		JOptionPane.showMessageDialog(null, m, "Mensaje aviso", JOptionPane.WARNING_MESSAGE);

	}
/**
 * Imprime un mensaje
 * @param m, el mensaje a mostrar
 */
	public void imprimirMensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
/**
 * Imprime un vector
 * @param vector, el vector a mostrar
 */
	public void imprimirVector(int[] vector) {
		JOptionPane.showMessageDialog(null, Arrays.toString(vector));
	}
/**
 * Metodo que captura el dato tipo numero entero
 * @param m, mensaje a mostrar
 * @return el dato tipo int 
 */
	public int pedirDato(String m) {
		int cambio = 0;
		while (cambio == 0) {
			String aux = (JOptionPane.showInputDialog(null, m, "Divide y Venceras",
					JOptionPane.INFORMATION_MESSAGE));
			try {
				cambio = Integer.parseInt(aux);
			} catch (NumberFormatException e) {
				cambio = 0;
				imprimirMensajeAdvertencia("Debes ingresar un número");
			}
		}
		return cambio;
	}

}
