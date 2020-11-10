package Interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import codigoNegocio.GenerarArbolPersona;
import codigoNegocio.Persona;
import codigoNegocio.PersonasJSON;
import java.awt.Font;
import javax.swing.JTree;


public class Screen extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	int width, height;
	
	GenerarArbolPersona arbol = new GenerarArbolPersona();
	PersonasJSON guardarPersonas = new PersonasJSON();
	
	JButton calculate = new JButton("Calcular compatibilidad");
	JButton mainMenu = new JButton("\u2190");
	JButton agregarDatos = new JButton("Agregar personas");
	JButton backToMenuFromData = new JButton("\u2190");
	JButton backToGameFromStats = new JButton("\u2190");
	JButton agregar = new JButton("Agregar persona");
	JButton stats = new JButton("Estadisticas");
	JButton cargarJSON = new JButton ("Cargar JSON");
	
	Font texto12 = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
	Font texto20 = new Font("Microsoft Sans Serif", Font.PLAIN, 20);
	Font texto30 = new Font("Microsoft Sans Serif", Font.PLAIN, 30);
	Font botones = new Font("Segoe UI Symbol", Font.BOLD, 20);
	
	CardLayout layout = new CardLayout();
	JPanel panel = new JPanel();
	JPanel game = new JPanel();
	JPanel menu = new JPanel();
	JPanel addData = new JPanel();
	JPanel estadisticas = new JPanel();
	JPanel jPanel4 = new JPanel();

	JLabel lblNames = new JLabel("Nombre");
	JLabel lblDeportes = new JLabel("Deportes");
	JLabel lblMusica = new JLabel("Musica");
	JLabel lblEspectac = new JLabel("Espectaculos");
	JLabel lblCiencia = new JLabel("Ciencia");
	
	JLabel grupoA = new JLabel("grupo A:");
	JLabel grupoB = new JLabel("grupo B:");
	JLabel lblIntereses = new JLabel("Intereses:");
	JLabel lblSimilaridadA = new JLabel("Promedio de similaridad: ");
	JLabel lblstats = new JLabel("Estadisticas:");
	JLabel lblSimilaridadB = new JLabel("Promedio de similaridad: ");
	
	JTextField name = new JTextField();
	JSpinner deportes = new JSpinner();
	JSpinner musica = new JSpinner();
	JSpinner espectaculos = new JSpinner();
	JSpinner ciencia = new JSpinner();

	DefaultMutableTreeNode rootA = new DefaultMutableTreeNode("Grupo A");
	DefaultMutableTreeNode rootB = new DefaultMutableTreeNode("Grupo B");
	DefaultTreeModel modeloA = new DefaultTreeModel(rootA);
	DefaultTreeModel modeloB = new DefaultTreeModel(rootB);
	JTree treeA = new JTree(modeloA);
	JTree treeB = new JTree(modeloB);
	
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
		// Setteo de los diferentes layouts
		addData.setLayout(null);
		addData.setBackground(Color.orange);
		
		game.setLayout(null);
		game.setBackground(Color.gray);
		
		estadisticas.setLayout(null);
		estadisticas.setBackground(Color.GRAY);
		
		menu.setLayout(null);
		menu.setBackground(Color.DARK_GRAY);
		
		panel.add(menu, "Menu");
		panel.add(game, "Game");
		panel.add(estadisticas, "Estadisticas");
		panel.add(addData, "Personas");

		getContentPane().add(panel);
		layout.show(panel, "Menu");
		
		
		// Monton de labels, trees, spinners que se agregan a diferentes layouts
		calculate.setFont(texto12);
		calculate.setBounds(300, 150, 180, 25);
		calculate.addActionListener(this);
		menu.add(calculate);
		
		agregarDatos.setFont(texto12);
		agregarDatos.setBounds(300, 250, 180, 25);
		agregarDatos.addActionListener(this);
		menu.add(agregarDatos);
		
		cargarJSON.setFont(texto12);
		cargarJSON.setBounds(300, 350, 180, 25);
		menu.add(cargarJSON);
		cargarJSON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valor = JOptionPane.showConfirmDialog(null, "¿Desea cargar archivo JSON de los archivos?", "Archivo JSON", JOptionPane.YES_NO_OPTION);
				File tempDir = new File("Personas.JSON");
				if(valor == JOptionPane.YES_OPTION) {
					if (tempDir.exists()) {
					PersonasJSON cargarPersonas = new PersonasJSON();
					cargarPersonas = PersonasJSON.leerJSON("Personas.JSON");
					guardarPersonas = cargarPersonas;
					JOptionPane.showMessageDialog(null, "Personas en archivo JSON cargadas!");
					} else {
						JOptionPane.showMessageDialog(null, "No se encuentra el archivo JSON");
					}
				}
			}
		});
		
		backToGameFromStats.setFont(botones);
		backToGameFromStats.setBounds(10, 10, 55, 30);
		backToGameFromStats.addActionListener(this);
		estadisticas.add(backToGameFromStats);
		
		lblSimilaridadA.setFont(texto12);
		lblSimilaridadA.setBounds(15, 490, 243, 68);		
		estadisticas.add(lblSimilaridadA);
		
		lblstats.setFont(texto30);
		lblstats.setBounds(300, 34, 323, 105);
		estadisticas.add(lblstats);
		
		lblSimilaridadB.setFont(texto12);
		lblSimilaridadB.setBounds(410, 490, 243, 68);
		estadisticas.add(lblSimilaridadB);

		mainMenu.setFont(botones);
		mainMenu.setBounds(10, 10, 55, 31);
		mainMenu.addActionListener(this);
		game.add(mainMenu);
		
		stats.setFont(texto12);
		stats.setBounds(300, 491, 213, 45);
		stats.addActionListener(this);
		game.add(stats);
		
		treeB.setFont(texto20);
		treeB.setBackground(Color.GRAY);
		treeB.setBounds(522, 63, 264, 447);
		game.add(treeB);
		
		treeA.setFont(texto20);
		treeA.setBackground(Color.GRAY);
		treeA.setBounds(26, 63, 264, 447);
		game.add(treeA);
		
		backToMenuFromData.setFont(botones);
		backToMenuFromData.setBounds(10, 10, 55, 30);
		backToMenuFromData.addActionListener(this);
		addData.add(backToMenuFromData);
		
		lblNames.setFont(texto12);
		lblNames.setBounds(50, 92, 135, 15);
		addData.add(lblNames);

		lblDeportes.setFont(texto12);
		lblDeportes.setBounds(50, 200, 135, 15);
		addData.add(lblDeportes);

		lblMusica.setFont(texto12);
		lblMusica.setBounds(50, 270, 135, 15);
		addData.add(lblMusica);
		
		lblEspectac.setFont(texto12);
		lblEspectac.setBounds(50, 340, 135, 15);
		addData.add(lblEspectac);

		lblCiencia.setFont(texto12);
		lblCiencia.setBounds(50, 410, 135, 15);
		addData.add(lblCiencia);
		
		lblIntereses.setFont(texto20);
		lblIntereses.setBounds(50, 146, 100, 31);
		addData.add(lblIntereses);

		name.setBounds(113, 90, 487, 20);
		addData.add(name);

		deportes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		deportes.setBounds(200, 195, 30, 20);
		addData.add(deportes);

		musica.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		musica.setBounds(200, 265, 30, 20);
		addData.add(musica);

		espectaculos.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		espectaculos.setBounds(200, 335, 30, 20);
		addData.add(espectaculos);
		
		ciencia.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		ciencia.setBounds(200, 405, 30, 20);
		addData.add(ciencia);
		
		agregar.setBounds(300, 500, 180, 25);
		agregar.setFont(texto12);
		addData.add(agregar);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (name.getText().isEmpty()) {
					// Si el usuario no ingreso nombre, le avisa y no agrega a la persona
					JOptionPane.showMessageDialog(null, "Ingrese el nombre de la persona");
				}
				 else {
					// Si esta todo ok agrego a la persona
					Persona pers = new Persona(name.getText(), (int) deportes.getValue(), (int) musica.getValue(), (int) espectaculos.getValue(), (int) ciencia.getValue());
					boolean noExiste = arbol.agregarPersona(pers);
					guardarPersonas.addPers(pers);
					if(!noExiste) JOptionPane.showMessageDialog(null, "Esa persona ya existe!");
					// Reinicio los valores de los spinners y del name
					name.setText("");
					deportes.setValue(1);
					musica.setValue(1);
					espectaculos.setValue(1);
					ciencia.setValue(1);
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();

		if (source == calculate) {
			if(!arbol.IsEmpty()) {
				rootA.removeAllChildren();
				rootB.removeAllChildren();
				arbol.generarGrupos();
				for(Persona p:arbol.getGrupoA()) {
					DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(p.getNombre());
					rootA.add(nodo);
				}
				for(Persona p:arbol.getGrupoB()) {
					DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(p.getNombre());
					rootB.add(nodo);
				}
				modeloA.reload();
				modeloB.reload();
				layout.show(panel, "Game");
				
				String json = guardarPersonas.generarJSON();
				guardarPersonas.guardarJSON(json, "Personas.JSON");
			}
			else JOptionPane.showMessageDialog(null, "Debe ingresar al menos 2 personas para realizar esta acción");
		} else if (source == mainMenu) {
			layout.show(panel, "Menu");
		} else if (source == agregarDatos) {
			layout.show(panel, "Personas");
		} else if (source == backToMenuFromData) {
			layout.show(panel, "Menu");
		} else if (source == stats) {
		      jPanel4.removeAll();
		      jPanel4.setLayout(new BorderLayout());
		      jPanel4.setBounds(0, 210, 785, 350);
		      jPanel4.add(PieChart_AWT.createDemoPanel("Intereses grupo B", GenerarArbolPersona.porcentajeDeportes(arbol.getGrupoB()), GenerarArbolPersona.porcentajeMusica(arbol.getGrupoB()),
						GenerarArbolPersona.porcentajeEspectaculos(arbol.getGrupoB()), GenerarArbolPersona.porcentajeCiencia(arbol.getGrupoB())), BorderLayout.EAST);
		      jPanel4.add(PieChart_AWT.createDemoPanel("Intereses grupo A" ,GenerarArbolPersona.porcentajeDeportes(arbol.getGrupoA()), GenerarArbolPersona.porcentajeMusica(arbol.getGrupoA()),
							GenerarArbolPersona.porcentajeEspectaculos(arbol.getGrupoA()), GenerarArbolPersona.porcentajeCiencia(arbol.getGrupoA())), BorderLayout.WEST);
		      estadisticas.add(jPanel4);
		      DecimalFormat df = new DecimalFormat("#.##");
		      lblSimilaridadA.setText("Promedio de similaridad: "+df.format(arbol.promedioSimilaridad(arbol.getGrupoA())));
		      lblSimilaridadB.setText("Promedio de similaridad: "+df.format(arbol.promedioSimilaridad(arbol.getGrupoB())));
		      layout.show(panel, "Estadisticas");
		} else if(source == backToGameFromStats) {
			layout.show(panel, "Game");
		}
	}

	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
	}
}
