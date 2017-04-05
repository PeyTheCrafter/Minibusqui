package utiles;

import javax.swing.JButton;
import modelo.Coordenada;

public class Varios {

	public Coordenada obtenerCoordenada(JButton boton) {
		// DE alguna forma entrego una coordenada
		// TODO
		String coordenada = boton.getName();
		return new Coordenada(Integer.valueOf(coordenada.substring(0, 1)), Integer.valueOf(coordenada.substring(1, 2)));
	}
}