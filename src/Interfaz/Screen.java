package Interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

	public Screen(int width, int height) {
	   panel.setLayout(layout);        
	   addButtons();
	
	   setSize(width, height);
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
	   
	   backGroup1.addActionListener(this);
	   backGroup2.addActionListener(this);
	   
	   menu.setLayout(null);
	
	   //menu buttons
	   menu.add(play);
	   menu.add(settingsGroup1);
	   menu.add(settingsGroup2);
	
	   //game buttons
	   game.add(mainMenu);
	   
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
