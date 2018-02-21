package control;

import vista.UIbusqui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import modelo.Casilla;
import modelo.Desvelador;
import modelo.Marcador;
import modelo.Tablero;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

public class ParaUIBusqui extends UIbusqui {
	int tamaño = 10;
	Tablero tablero = new Tablero(tamaño);
	Casilla casilla = new Casilla();
//sample text
	Desvelador desvelador = new Desvelador();
	Marcador marcador = new Marcador();

	public ParaUIBusqui() {
		añadirBotones(tamaño);
		botonera.setLayout(new GridLayout(tamaño, tamaño, 0, 0));
		Component[] components = botonera.getComponents();
		for (Component component : components) {
			// ((JButton) component).addActionListener(new ActionListener() {
			// public void actionPerformed(ActionEvent e) {
			// new Marcador().marcarCasilla((JButton) e.getSource(), tablero);
			// }
			// });

			((JButton) component).addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (SwingUtilities.isRightMouseButton(e)) {
						marcador.marcarCasilla((JButton) e.getSource(), tablero);
					} else if (SwingUtilities.isLeftMouseButton(e)) {
						if (casilla.isMina()) {
							desvelador.explotarMinas(boton, tablero, contentPane, components);
						} else {
							new Desvelador().desvelarCasillas((JButton) e.getSource(), tablero);
						}
					}
				}
			});
		}
	}
}