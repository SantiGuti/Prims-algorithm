package Interfaz;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
 
public class PieChart_AWT {
   
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Espectaculos" , new Double( 20 ) );  
      dataset.setValue( "Ciencia" , new Double( 20 ) );   
      dataset.setValue( "etc" , new Double( 40 ) );    
      dataset.setValue( "etc" , new Double( 10 ) );  
      return dataset;         
   }
   
   private static PieDataset cargarDatos(Double deportes, Double musica, Double espectaculos, Double ciencia) {
	   DefaultPieDataset dataset = new DefaultPieDataset( );
	   dataset.setValue("Espectaculos", espectaculos);
	   dataset.setValue("Ciencia", ciencia);
	   dataset.setValue("Musica", musica);
	   dataset.setValue("Deportes", deportes);
	   return dataset;
   }
   
   private static JFreeChart createChart( PieDataset dataset, String title ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         title,   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);
      return chart;
   }
   
   public static ChartPanel createDemoPanel(String title, Double deportes, Double musica, Double espectaculos, Double ciencia) {
      JFreeChart chart = createChart(cargarDatos(deportes, musica, espectaculos, ciencia), title); 
   
      return new ChartPanel( chart, 390, 400, 390, 400,390,400,false,false,false,false,false,false ); 
   }

}