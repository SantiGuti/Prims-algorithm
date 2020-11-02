package Interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import codigoNegocio.GenerarArbolPersona;
import codigoNegocio.Persona;

public class Screen extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	int width, height;
	
	GenerarArbolPersona arbol = new GenerarArbolPersona();
	
	JButton calculate = new JButton("Calcular compatibilidad");
	JButton mainMenu = new JButton("Volver al menu");
	JButton agregarDatos = new JButton("Agregar personas");
	JButton backToMenuFromData = new JButton("Volver al menu");
	JButton agregar = new JButton("Agregar persona");

	CardLayout layout = new CardLayout();

	JPanel panel = new JPanel();
	JPanel game = new JPanel();
	JPanel menu = new JPanel();
	JPanel addData = new JPanel();

	JLabel lblNames = new JLabel("Nombres");
	JLabel lblDeportes = new JLabel("Deportes");
	JLabel lblMusica = new JLabel("Musica");
	JLabel lblEspectac = new JLabel("Espectaculos");
	JLabel lblCiencia = new JLabel("Ciencia");
	JTextField name = new JTextField();
	JSpinner deportes = new JSpinner();
	JSpinner musica = new JSpinner();
	JSpinner espectaculos = new JSpinner();
	JSpinner ciencia = new JSpinner();


	public Screen(int width, int height) {
		panel.setLayout(layout);
		addButtons();

		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Tinder 2.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		requestFocus();

	}

	private void addButtons() {

		mainMenu.setBounds(300, 20, 180, 25);
		mainMenu.addActionListener(this);

		backToMenuFromData.setBounds(300, 20, 180, 25);
		backToMenuFromData.addActionListener(this);
		addData.setLayout(null);
		game.setLayout(null);

		// game buttons
		game.add(mainMenu);
		addData.add(backToMenuFromData);

		// background colors
		game.setBackground(Color.gray);
		menu.setBackground(Color.DARK_GRAY);
		addData.setBackground(Color.orange);

		// adding children to parent Panel
		calculate.setBounds(300, 150, 180, 25);
		calculate.addActionListener(this);
		
		menu.setLayout(null);
		menu.add(calculate);
		menu.add(agregarDatos);
		
		agregarDatos.setBounds(300, 300, 180, 25);
		agregarDatos.addActionListener(this);
		
		panel.add(menu, "Menu");
		panel.add(game, "Game");
		panel.add(addData, "Grupo 1");

		lblNames.setBounds(50, 90, 135, 15);
		addData.add(lblNames);

		lblDeportes.setBounds(50, 170, 135, 15);
		addData.add(lblDeportes);

		lblMusica.setBounds(50, 250, 135, 15);
		addData.add(lblMusica);

		lblEspectac.setBounds(50, 330, 135, 15);
		addData.add(lblEspectac);

		lblCiencia.setBounds(50, 410, 135, 15);
		addData.add(lblCiencia);

		name.setBounds(200, 90, 400, 20);
		addData.add(name);

		addData.add(deportes);
		deportes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		deportes.setBounds(200, 170, 30, 20);

		addData.add(musica);
		musica.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		musica.setBounds(200, 250, 30, 20);

		addData.add(espectaculos);
		espectaculos.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		espectaculos.setBounds(200, 330, 30, 20);

		addData.add(ciencia);
		ciencia.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		ciencia.setBounds(200, 410, 30, 20);

		addData.add(agregar);
		agregar.setBounds(300, 500, 180, 25);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valor = JOptionPane.showConfirmDialog(null, "Desea cargar la informacion?", "Confirmacion",	JOptionPane.YES_NO_OPTION);
				if (valor == JOptionPane.YES_OPTION) {
					Persona pers = new Persona(name.getName(), (int) deportes.getValue(), (int) musica.getValue(), (int) espectaculos.getValue(), (int) ciencia.getValue());
					arbol.agregarPersona(pers);
					JOptionPane.showMessageDialog(null, "Persona cargada");
				}
			}
		});

		getContentPane().add(panel);
		layout.show(panel, "Menu");

	}

	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();

		if (source == calculate) {
			layout.show(panel, "Game");
		} else if (source == mainMenu) {
			layout.show(panel, "Menu");
		} else if (source == agregarDatos) {
			layout.show(panel, "Grupo 1");
		} else if (source == backToMenuFromData) {
			layout.show(panel, "Menu");
		}
	}

	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
	}
}
