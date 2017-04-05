package modelo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import utiles.Varios;

public class Marcador {

	/**
	 * Coloca una bandera si el usuario hace click derecho. La quita si se
	 * vuelve a hacer click derecho
	 * 
	 * @param boton
	 * @param tablero
	 */
	public void marcarCasilla(JButton boton, Tablero tablero) {
		Coordenada coordenada = new Varios().obtenerCoordenada(boton);
		Casilla casillaActual = tablero.getCasilla(coordenada);

		if (casillaActual.isVelada()) {
			casillaActual.setMarcada(!casillaActual.isMarcada());
			if (casillaActual.isMarcada()) {
				ponerBandera(boton);
			} else {
				quitarBandera(boton);
			}
		}
	}
	
	/**
	 * Pone una bandera en la casilla seleccionada
	 * @param boton
	 */
	public void ponerBandera(JButton boton){
		boton.setText("B");
		boton.setBackground(new Color(32, 32, 0));
		boton.setBorder(new LineBorder(new Color(125, 125, 50)));
	}
	
	/**
	 * Quita la bandera de la casilla seleccionada
	 * @param boton
	 */
	public static void quitarBandera(JButton boton){
		boton.setText("");
		boton.setBackground(new Color(0, 32, 0));
		boton.setBorder(new LineBorder(new Color(0, 0, 0)));
	}

}
