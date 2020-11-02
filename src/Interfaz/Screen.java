package Interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Screen extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	int width, height;
	
	JButton play = new JButton("play");
	JButton mainMenu = new JButton("main menu");
	JButton settingsGroup1 = new JButton("Set data group 1");
	JButton settingsGroup2 = new JButton("Set data group 2");
	JButton backGroup1 = new JButton ("Back");
	JButton backGroup2 = new JButton ("Back");
	
	CardLayout layout = new CardLayout();
	
	JPanel panel = new JPanel();
	JPanel game = new JPanel();
	JPanel menu = new JPanel(); 
	JPanel group1 = new JPanel();
	JPanel group2 = new JPanel();
	
	private JTextField name1Group1;
	private JTextField name2Group1;
	private JTextField name3Group1;
	private JTextField name4Group1;
	private final JLabel lblNamesGroup1 = new JLabel("Nombres");
	private final JLabel lblDeportes = new JLabel("Deportes");
	private final JLabel lblMusica = new JLabel("Musica");
	private final JLabel lblEspectaculos = new JLabel("Espectaculos");
	private final JLabel lblCiencia = new JLabel("Ciencia");
	private final JSpinner depor1Group1 = new JSpinner();
	private final JSpinner depor2Group1 = new JSpinner();
	private final JSpinner depor3Group1 = new JSpinner();
	private final JSpinner depor4Group1 = new JSpinner();
	private final JSpinner music1Group1 = new JSpinner();
	private final JSpinner music2Group1 = new JSpinner();
	private final JSpinner music3Group1 = new JSpinner();
	private final JSpinner music4Group1 = new JSpinner();
	private final JSpinner espec1Group1 = new JSpinner();
	private final JSpinner espec2Group1 = new JSpinner();
	private final JSpinner espec3Group1 = new JSpinner();
	private final JSpinner espec4Group1 = new JSpinner();
	private final JSpinner ciencia1Group1 = new JSpinner();
	private final JSpinner ciencia2Group1 = new JSpinner();
	private final JSpinner ciencia3Group1 = new JSpinner();
	private final JSpinner ciencia4Group1 = new JSpinner();
	


	public Screen(int width, int height) {
	   panel.setLayout(layout);        
	   addButtons();
	
	   setSize(686, 294);
	   setResizable(false);
	   setLocationRelativeTo(null);
	   setVisible(true);
	   setTitle("BUILD YOUR EMPIRE");
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   requestFocus();
	
	}
	
	private void addButtons() {
		
	   play.setBounds(329, 11, 113, 23);
	   play.addActionListener(this);
	   
	   mainMenu.addActionListener(this);
	   
	   settingsGroup1.setBounds(391, 91, 142, 23);
	   settingsGroup1.addActionListener(this);
	   
	   settingsGroup2.setBounds(212, 91, 142, 23);
	   settingsGroup2.addActionListener(this);

	   backGroup1.setBounds(325, 5, 55, 23);
	   backGroup1.addActionListener(this);
	   
	   backGroup2.addActionListener(this);
	   
	   menu.setLayout(null);
	
	   //menu buttons
	   menu.add(play);
	   menu.add(settingsGroup1);
	   menu.add(settingsGroup2);
	
	   //game buttons
	   game.add(mainMenu);
	   group1.setLayout(null);

	   
	   //groups buttons
	   group1.add(backGroup1);
	   group2.add(backGroup2);
	   
	   //background colors
	   game.setBackground(Color.gray);
	   menu.setBackground(Color.DARK_GRAY);
	   group1.setBackground(Color.blue);
	   group2.setBackground(Color.orange);
	
	   //adding children to parent Panel
	   panel.add(menu,"Menu");
	   panel.add(game,"Game");
	   panel.add(group1, "Grupo 1");
	   panel.add(group2, "Grupo 2");
	   
	   name1Group1 = new JTextField();
	   name1Group1.setBounds(29, 79, 86, 20);
	   group1.add(name1Group1);
	   name1Group1.setColumns(10);
	   
	   name2Group1 = new JTextField();
	   name2Group1.setBounds(29, 111, 86, 20);
	   group1.add(name2Group1);
	   name2Group1.setColumns(10);
	   
	   name3Group1 = new JTextField();
	   name3Group1.setBounds(29, 142, 86, 20);
	   group1.add(name3Group1);
	   name3Group1.setColumns(10);
	   
	   name4Group1 = new JTextField();
	   name4Group1.setBounds(29, 173, 86, 20);
	   group1.add(name4Group1);
	   name4Group1.setColumns(10);


	   group1.add(depor1Group1);
	   depor1Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   depor1Group1.setBounds(177, 79, 30, 20);
	   
	   group1.add(depor2Group1);
	   depor2Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   depor2Group1.setBounds(177, 111, 30, 20);
	   
	   group1.add(depor3Group1);
	   depor3Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   depor3Group1.setBounds(177, 142, 30, 20);
	   
	   group1.add(depor4Group1);
	   depor4Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   depor4Group1.setBounds(177, 174, 30, 20);
	   
	   group1.add(music1Group1);
	   music1Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   music1Group1.setBounds(279, 79, 30, 20);
	   
	   group1.add(music2Group1);
	   music2Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   music2Group1.setBounds(279, 111, 30, 20);
	   
	   group1.add(music3Group1);
	   music3Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   music3Group1.setBounds(279, 142, 30, 20);
	   
	   group1.add(music4Group1);
	   music4Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   music4Group1.setBounds(279, 174, 30, 20);
	   
	   group1.add(espec1Group1);
	   espec1Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   espec1Group1.setBounds(416, 79, 30, 20);
	   
	   group1.add(espec2Group1);
	   espec2Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   espec2Group1.setBounds(416, 111, 30, 20);
	   
	   group1.add(espec3Group1);
	   espec3Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   espec3Group1.setBounds(416, 142, 30, 20);
	   
	   group1.add(espec4Group1);
	   espec4Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   espec4Group1.setBounds(416, 174, 30, 20);

	   group1.add(ciencia1Group1);
	   ciencia1Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   ciencia1Group1.setBounds(542, 79, 30, 20);
	   
	   group1.add(ciencia2Group1);
	   ciencia2Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   ciencia2Group1.setBounds(542, 111, 30, 20);
	   
	   group1.add(ciencia3Group1);
	   ciencia3Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   ciencia3Group1.setBounds(542, 142, 30, 20);
	   
	   group1.add(ciencia4Group1);
	   ciencia4Group1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	   ciencia4Group1.setBounds(542, 174, 30, 20);
	   
	   lblNamesGroup1.setBounds(49, 54, 46, 14);
	   group1.add(lblNamesGroup1);
	   
	   lblDeportes.setBounds(177, 54, 46, 14);
	   group1.add(lblDeportes);
	   
	   lblMusica.setBounds(279, 54, 46, 14);
	   group1.add(lblMusica);
	   
	   lblEspectaculos.setBounds(406, 54, 78, 14);
	   group1.add(lblEspectaculos);
	   
	   lblCiencia.setBounds(542, 54, 46, 14);
	   group1.add(lblCiencia);
	   
	   getContentPane().add(panel);
	   layout.show(panel,"Menu");
	
	}
	
	public void actionPerformed(ActionEvent event) {
	
	   Object source = event.getSource();
	
	   if (source == play) {
	       layout.show(panel, "Game");
	   }  else if (source == mainMenu){
	       layout.show(panel, "Menu");
	   } else if (source == settingsGroup1) {
		   layout.show(panel, "Grupo 1");
	   } else if (source == settingsGroup2) {
		   layout.show(panel, "Grupo 2");
	   } else if (source == backGroup1) {
		   layout.show(panel, "Menu");
	   } else if (source == backGroup2) {
		   layout.show(panel, "Menu");
	   }
	
	   }
	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
		
	}
}
