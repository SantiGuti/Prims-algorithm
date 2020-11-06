package Interfaz;

import java.awt.BorderLayout;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.DefaultMutableTreeNode;

import codigoNegocio.GenerarArbolPersona;
import codigoNegocio.Persona;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSlider;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeExpansionEvent;

public class Screen extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	int width, height;
	
	GenerarArbolPersona arbol = new GenerarArbolPersona();
	
	JButton calculate = new JButton("Calcular compatibilidad");
	JButton mainMenu = new JButton("\u2190");
	JButton agregarDatos = new JButton("Agregar personas");
	JButton backToMenuFromData = new JButton("\u2190");
	JButton agregar = new JButton("Agregar persona");
	JButton stats = new JButton("Estadisticas");
	
	CardLayout layout = new CardLayout();

	JPanel panel = new JPanel();
	JPanel game = new JPanel();
	JPanel menu = new JPanel();
	JPanel addData = new JPanel();
	JPanel estadisticas = new JPanel();

	JLabel lblNames = new JLabel("Nombre");
	JLabel lblDeportes = new JLabel("Deportes");
	JLabel lblMusica = new JLabel("Musica");
	JLabel lblEspectac = new JLabel("Espectaculos");
	JLabel lblCiencia = new JLabel("Ciencia");
	JLabel grupoA = new JLabel("grupo A:");
	JLabel grupoB = new JLabel("grupo B:");
	
	JTextField name = new JTextField();
	JSpinner deportes = new JSpinner();
	JSpinner musica = new JSpinner();
	JSpinner espectaculos = new JSpinner();
	JSpinner ciencia = new JSpinner();
	DefaultMutableTreeNode rootB = new DefaultMutableTreeNode("Grupo B");
	JTree treeB = new JTree(rootB);
	DefaultMutableTreeNode rootA = new DefaultMutableTreeNode("Grupo A");
	JTree treeA = new JTree(rootA);
	
	private final JLabel lblIntereses = new JLabel("Intereses:");
	private final JButton backToGameFromStats = new JButton("\u2190");
	private final JLabel lblSimilaridadA = new JLabel("Promedio de similaridad: ");
	private final JLabel lblstats = new JLabel("Estadisticas:");
	private final JLabel lblSimilaridadB = new JLabel("Promedio de similaridad: ");


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
		mainMenu.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		mainMenu.setBounds(10, 10, 55, 31);
		mainMenu.addActionListener(this);
		backToMenuFromData.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));

		backToMenuFromData.setBounds(10, 10, 55, 31);
		backToMenuFromData.addActionListener(this);
		addData.setLayout(null);
		game.setLayout(null);
		estadisticas.setLayout(null);

		// game buttons
		game.add(mainMenu);
		addData.add(backToMenuFromData);

		// background colors
		game.setBackground(Color.gray);
		menu.setBackground(Color.DARK_GRAY);
		addData.setBackground(Color.orange);
		estadisticas.setBackground(Color.GRAY);
		calculate.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));

		// adding children to parent Panel
		calculate.setBounds(300, 150, 180, 25);
		calculate.addActionListener(this);
		
		menu.setLayout(null);
		menu.add(calculate);
		agregarDatos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		menu.add(agregarDatos);
		
		agregarDatos.setBounds(300, 300, 180, 25);
		agregarDatos.addActionListener(this);
		
		
		panel.add(menu, "Menu");
		panel.add(game, "Game");
		panel.add(estadisticas, "Estadisticas");
		backToGameFromStats.addActionListener(this);
		backToGameFromStats.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		backToGameFromStats.setBounds(10, 10, 55, 31);
		
		estadisticas.add(backToGameFromStats);
		lblSimilaridadA.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblSimilaridadA.setBounds(15, 490, 243, 68);
		
		estadisticas.add(lblSimilaridadA);
		lblstats.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
		lblstats.setBounds(300, 34, 323, 105);
		
		estadisticas.add(lblstats);
		lblSimilaridadB.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblSimilaridadB.setBounds(410, 490, 243, 68);
		
		estadisticas.add(lblSimilaridadB);
	//	estadisticas.add(mainMenu, BorderLayout.NORTH);
		
		treeB.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 19));
		treeB.setBackground(Color.GRAY);
		treeB.setBounds(522, 63, 264, 447);
		game.add(treeB);
		
		treeA.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 19));
		treeA.setBackground(Color.GRAY);
		treeA.setBounds(26, 63, 264, 447);
		game.add(treeA);
		stats.addActionListener(this);
		stats.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		stats.setBounds(300, 491, 213, 45);
		game.add(stats);
		
		panel.add(addData, "Personas");
		lblNames.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));

		lblNames.setBounds(50, 92, 135, 15);
		addData.add(lblNames);
		lblDeportes.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));

		lblDeportes.setBounds(50, 200, 135, 15);
		addData.add(lblDeportes);
		lblMusica.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));

		lblMusica.setBounds(50, 270, 135, 15);
		addData.add(lblMusica);
		lblEspectac.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));

		lblEspectac.setBounds(50, 340, 135, 15);
		addData.add(lblEspectac);
		lblCiencia.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));

		lblCiencia.setBounds(50, 410, 135, 15);
		addData.add(lblCiencia);

		name.setBounds(113, 90, 487, 20);
		addData.add(name);

		addData.add(deportes);
		deportes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		deportes.setBounds(200, 195, 30, 20);

		addData.add(musica);
		musica.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		musica.setBounds(200, 265, 30, 20);

		addData.add(espectaculos);
		espectaculos.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		espectaculos.setBounds(200, 335, 30, 20);

		addData.add(ciencia);
		ciencia.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		ciencia.setBounds(200, 405, 30, 20);
		agregar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));

		addData.add(agregar);
		agregar.setBounds(300, 500, 180, 25);
		lblIntereses.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblIntereses.setBounds(50, 146, 100, 31);
		
		addData.add(lblIntereses);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valor = JOptionPane.showConfirmDialog(null, "Desea cargar la informacion?", "Confirmacion",	JOptionPane.YES_NO_OPTION);
				if (valor == JOptionPane.YES_OPTION) {
					if (name.getText().isEmpty()){
						// Si el usuario no ingreso nombre, le avisa
						JOptionPane.showMessageDialog(null, "Ingrese el nombre de la persona");
					} else {
						// Si esta todo ok agrego a la persona
						
						boolean noExiste = arbol.crearYAgregarPersona(name.getText(), (int) deportes.getValue(), (int) musica.getValue(), (int) espectaculos.getValue(), (int) ciencia.getValue());
						if(!noExiste) JOptionPane.showMessageDialog(null, "Esa persona ya existe!");
						// Reinicio los valores de los spinners y del name
						name.setText("");
						deportes.setValue(1);
						musica.setValue(1);
						espectaculos.setValue(1);
						ciencia.setValue(1);
					}
				}
			}
		});

		getContentPane().add(panel);
		layout.show(panel, "Menu");

	}

	private void expandAllNodes(JTree tree) {
	    int j = tree.getRowCount();
	    int i = 0;
	    while(i < j) {
	        tree.expandRow(i);
	        i += 1;
	        j = tree.getRowCount();
	    }
	}
	
	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();

		if (source == calculate) {
			if(!arbol.IsEmpty()) {
				arbol.generarGrupos();
				for(Persona p:arbol.getGrupoA()) {
					DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(p.getNombre());
					rootA.add(nodo);
				}
				for(Persona p:arbol.getGrupoB()) {
					DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(p.getNombre());
					rootB.add(nodo);
				}
				game.revalidate();
				game.repaint();
				expandAllNodes(treeA);
				expandAllNodes(treeB);
				layout.show(panel, "Game");
			}
			else JOptionPane.showMessageDialog(null, "Debe ingresar al menos 2 personas para realizar esta acción");
		} else if (source == mainMenu) {
			layout.show(panel, "Menu");
		} else if (source == agregarDatos) {
			layout.show(panel, "Personas");
		} else if (source == backToMenuFromData) {
			layout.show(panel, "Menu");
		} else if (source == stats) {
			  JPanel jPanel4 = new JPanel();
		      jPanel4.setLayout(new BorderLayout());
		      jPanel4.setBounds(0, 210, 785, 350);
		      jPanel4.add(PieChart_AWT.createDemoPanel("Intereses grupo B", GenerarArbolPersona.porcentajeDeportes(arbol.getGrupoB()), GenerarArbolPersona.porcentajeMusica(arbol.getGrupoB()),
						GenerarArbolPersona.porcentajeEspectaculos(arbol.getGrupoB()), GenerarArbolPersona.porcentajeCiencia(arbol.getGrupoB())), BorderLayout.EAST);
		      jPanel4.add(PieChart_AWT.createDemoPanel("Intereses grupo A" ,GenerarArbolPersona.porcentajeDeportes(arbol.getGrupoA()), GenerarArbolPersona.porcentajeMusica(arbol.getGrupoA()),
							GenerarArbolPersona.porcentajeEspectaculos(arbol.getGrupoA()), GenerarArbolPersona.porcentajeCiencia(arbol.getGrupoA())), BorderLayout.WEST);
		      estadisticas.add(jPanel4);
		      lblSimilaridadA.setText("Promedio de similaridad: "+arbol.promedioSimilaridad(arbol.getGrupoA()));
		      lblSimilaridadB.setText("Promedio de similaridad: "+arbol.promedioSimilaridad(arbol.getGrupoB()));
		      layout.show(panel, "Estadisticas");
		} else if(source == backToGameFromStats) {
			layout.show(panel, "Game");
		}
			
	}

	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
	}
}
