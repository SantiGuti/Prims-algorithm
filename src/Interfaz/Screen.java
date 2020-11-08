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
import javax.swing.tree.DefaultMutableTreeNode;
import codigoNegocio.GenerarArbolPersona;
import codigoNegocio.Persona;
import java.awt.Font;
import javax.swing.JTree;

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
		// Botones agregados a diferentes layouts
		mainMenu.setFont(botones);
		mainMenu.setBounds(10, 10, 55, 31);
		mainMenu.addActionListener(this);
		game.add(mainMenu);
		
		backToMenuFromData.setFont(botones);
		backToMenuFromData.setBounds(10, 10, 55, 31);
		backToMenuFromData.addActionListener(this);
		addData.add(backToMenuFromData);
		
		calculate.setFont(texto12);
		calculate.setBounds(300, 150, 180, 25);
		calculate.addActionListener(this);
		menu.add(calculate);
		
		agregarDatos.setFont(texto12);
		agregarDatos.setBounds(300, 300, 180, 25);
		agregarDatos.addActionListener(this);
		menu.add(agregarDatos);
		
		backToGameFromStats.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		backToGameFromStats.setBounds(10, 10, 55, 31);
		backToGameFromStats.addActionListener(this);
		estadisticas.add(backToGameFromStats);
		
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
		lblSimilaridadA.setFont(texto12);
		lblSimilaridadA.setBounds(15, 490, 243, 68);		
		estadisticas.add(lblSimilaridadA);
		
		lblstats.setFont(texto30);
		lblstats.setBounds(300, 34, 323, 105);
		estadisticas.add(lblstats);
		
		lblSimilaridadB.setFont(texto12);
		lblSimilaridadB.setBounds(410, 490, 243, 68);
		estadisticas.add(lblSimilaridadB);
		
		treeB.setFont(texto20);
		treeB.setBackground(Color.GRAY);
		treeB.setBounds(522, 63, 264, 447);
		game.add(treeB);
		
		treeA.setFont(texto20);
		treeA.setBackground(Color.GRAY);
		treeA.setBounds(26, 63, 264, 447);
		game.add(treeA);
		
		stats.addActionListener(this);
		stats.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		stats.setBounds(300, 491, 213, 45);
		game.add(stats);
		
		lblNames.setBounds(50, 92, 135, 15);
		lblNames.setFont(texto12);
		addData.add(lblNames);

		lblDeportes.setBounds(50, 200, 135, 15);
		lblDeportes.setFont(texto12);
		addData.add(lblDeportes);

		lblMusica.setBounds(50, 270, 135, 15);
		lblMusica.setFont(texto12);
		addData.add(lblMusica);
		
		lblEspectac.setBounds(50, 340, 135, 15);
		lblEspectac.setFont(texto12);
		addData.add(lblEspectac);

		lblCiencia.setBounds(50, 410, 135, 15);
		lblCiencia.setFont(texto12);
		addData.add(lblCiencia);

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
		
		lblIntereses.setFont(texto20);
		lblIntereses.setBounds(50, 146, 100, 31);
		addData.add(lblIntereses);
		
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
		});
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
			else JOptionPane.showMessageDialog(null, "Debe ingresar al menos 2 personas para realizar esta acci�n");
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
