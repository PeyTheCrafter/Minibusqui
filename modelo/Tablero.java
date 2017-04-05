package modelo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import utiles.Varios;

public class Tablero {
	private Casilla[][] casillas;
	int minas = 20;
	int contador = 0;

	public Tablero(int cuadrada) {
		super();
		generarTablero(cuadrada, cuadrada);
		colocarMinas(minas, cuadrada);
		contarMinasAlrededor();
	}

	/**
	 * Busca las minas en el tablero y si las encuentra, incrementa el valor de
	 * minas encontradas en las casillas contiguas
	 * 
	 * @param tablero
	 *            : tablero de juego
	 * @param cuadrada
	 *            : tamaño del tablero
	 */
	public void contarMinasAlrededor() {
		for (int filas = 0; filas < casillas.length; filas++) {
			for (int columnas = 0; columnas < casillas[0].length; columnas++) {
				if (casillas[filas][columnas].isMina()) {
					incrementarContiguas(filas, columnas);
				}
			}
		}
	}

	/**
	 * Incrementa el valor de las casillas contiguas a la casilla que contiene
	 * la mina
	 * 
	 * @param filas
	 *            : posicion x
	 * @param columnas
	 *            : posicion y
	 */
	public void incrementarContiguas(int filas, int columnas) {
		for (int i = 0; i < 8; i++) {
			int[] coordenada = getCoordenadaAlrededor(filas, columnas, i);
			if (validarCoordenada(coordenada)) {
				incrementarValor(coordenada);
			}
		}
	}

	public boolean validarCoordenada(int[] coordenada) {
		return comprobarLimites(coordenada[0], 0, casillas.length)
				&& comprobarLimites(coordenada[1], 0, casillas[0].length);
	}

	public boolean comprobarLimites(int valor, int minimo, int maximo) {
		return valor >= minimo && valor < maximo;
	}

	/**
	 * Incrementa el valor en 1 de la coordenada
	 * 
	 * @param coordenada
	 *            : coordenada a la que incrementar el valor
	 */
	public void incrementarValor(int[] coordenada) {
		// Hemos llegado aquí porque no han dado una coordenada valida en la que
		// hay que incrementar en 1 el valor de minas alrededor de esa casilla.
		casillas[coordenada[0]][coordenada[1]]
				.setMinasAlrededor(casillas[coordenada[0]][coordenada[1]].getMinasAlrededor() + 1);
	}

	/**
	 * Retorna las coordenadas de alrededor de la casilla que contiene la mina
	 * 
	 * @param filas
	 *            : posicion x
	 * @param columnas
	 *            : posicion y
	 * @param i
	 *            : numero de veces que se realiza
	 * @return coordenadas de alrededor de la casilla con la mina
	 */
	public int[] getCoordenadaAlrededor(int filas, int columnas, int i) {
		int[][] alrededor = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		int[] coordenada = { filas + alrededor[i][0], columnas + alrededor[i][1] };

		return coordenada;
	}

	/**
	 * Crea el tablero de juego.
	 * 
	 * @param filas
	 *            : filas del tablero
	 * @param columnas
	 *            : columnas del tablero
	 */
	public void generarTablero(int filas, int columnas) {
		casillas = new Casilla[filas][columnas];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}

	/**
	 * Coloca las minas en el tablero de forma aleatoria
	 * 
	 * @param minas
	 *            : Número de minas en el tablero
	 * @param cuadrada
	 *            : Dimensión del tablero
	 */
	public void colocarMinas(int minas, int cuadrada) {
		int x;
		int y;
		do {
			x = (int) (Math.random() * cuadrada);
			y = (int) (Math.random() * cuadrada);

			if (!casillas[x][y].isMina()) {
				casillas[x][y].setMina(true);
				contador++;
			}

		} while (contador < minas);
	}

	private Casilla[][] getCasillas() {
		return casillas;
	}

	private void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas[coordenada.getX()][coordenada.getY()];
	}

}
