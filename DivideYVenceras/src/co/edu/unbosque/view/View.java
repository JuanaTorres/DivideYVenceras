package co.edu.unbosque.view;
import java.util.Arrays;  

import javax.swing.JOptionPane;

public class View {

	public View() {

	}

	public void imprimirMensajeError(String m) {
		JOptionPane.showMessageDialog(null, m, "Mensaje error", JOptionPane.WARNING_MESSAGE);

	}

	public void imprimirMensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	public void imprimirVector(int[] vector) {
		JOptionPane.showMessageDialog(null,Arrays.toString(vector));
	}
	public int pedirDato(String m) {
		int cambio = 0;
		while (cambio == 0) {
			String aux = (JOptionPane.showInputDialog(null, m, "Titulo del InputDialog",
					JOptionPane.INFORMATION_MESSAGE));
			try {
				cambio = Integer.parseInt(aux);
			} catch (NumberFormatException e) {
				cambio = 0;
				imprimirMensajeError("Debe ingresasr un número");
			}
		}
		return cambio;
	}

}
