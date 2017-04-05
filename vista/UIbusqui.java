package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class UIbusqui extends JFrame {

	protected JPanel contentPane;
	protected JPanel botonera;
	protected JButton boton;
	private JButton btnNewButton;


	/**
	 * Create the frame.
	 */
	public UIbusqui() {
		setTitle("Buscaminuquis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		botonera = new JPanel();
		botonera.setBackground(new Color(0, 0, 0));
		contentPane.add(botonera, BorderLayout.CENTER);
		botonera.setLayout(new GridLayout(3, 3, 0, 0));
	
	}
	
	public void añadirBotones(int n){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boton = new JButton("");
				boton.setName(i+""+j);
				boton.setBackground(new Color(0,32,0));
				boton.setBorder(new LineBorder(new Color(0,0,0)));
				botonera.add(boton);
			}
		}
	}

}
