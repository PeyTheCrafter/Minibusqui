package modelo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import utiles.Varios;

public class Desvelador {
	/**
	 * Desvela la casilla seleccionada en el caso de no estarlo.
	 * 
	 * @param boton
	 *            : botón actual pulsado
	 * @param tablero
	 *            : tablero de juego..
	 */
	public void desvelarCasillas(JButton boton, Tablero tablero) {
		Coordenada coordenada = new Varios().obtenerCoordenada(boton);
		Casilla casillaActual = tablero.getCasilla(coordenada);

		if (casillaActual.isMina()) {
			esMina(boton);
		} else if (casillaActual.isVelada()) {

			if (casillaActual.isMarcada()) {
				Marcador.quitarBandera(boton);
			}
			casillaActual.setVelada(false);
			desvelarCasilla(boton, tablero);
			numeroMinas(boton, tablero);
		}
	}

	/**
	 * Muestra todas las minas cuando se hace click en alguna. Game over.
	 * 
	 * @param boton
	 * @param cuadrada
	 *            : tamaño del tablero
	 */
	public void explotarMinas(JButton boton, Tablero tablero, JPanel panel, Component[] componente) {
		Coordenada coordenada = new Varios().obtenerCoordenada(boton);
		Casilla casilla = tablero.getCasilla(coordenada);
		if (casilla.isMina()) {
			componente = panel.getComponents();
			for (int i = 0; i < componente.length; i++) {
				componente[i].setEnabled(false);
			}
		}
	}

	public void desvelarCasilla(JButton boton, Tablero tablero) {
		boton.setEnabled(false);
		boton.setBackground(new Color(0, 0, 32));
		boton.setBorder(new LineBorder(new Color(50, 50, 125)));
	}

	public void esMina(JButton boton) {
		boton.setText("M");
		boton.setEnabled(false);
		boton.setBackground(new Color(32, 0, 0));
		boton.setBorder(new LineBorder(new Color(125, 50, 50)));
	}

	public void numeroMinas(JButton boton, Tablero tablero) {
		Casilla casilla = new Casilla();
		int numeroMinas = casilla.getMinasAlrededor();
		boton.setText(String.valueOf(numeroMinas));
	}
}
