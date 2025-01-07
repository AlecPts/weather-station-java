/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author apeyt
 */
public class ViewPollution extends JPanel{
    
    ChartPanel chartPanel;
    
    public ViewPollution(){
        initChart( ); 
        
        validate();
repaint();
   }

    private void initChart() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Pollution chart",
                "Date",
                "Air Quality Indice",
                createDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);
        
        chartPanel = new ChartPanel( lineChart );
        
        this.add( chartPanel );
        
    }

    @Override
    public Dimension getPreferredSize() {
        
        Dimension dim = this.size();
        chartPanel.setPreferredSize(new Dimension(800, 600));
        return new Dimension(800, 600);
    }
   
    private CategoryDataset createDataset( ) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
        
        dataset.addValue( 0 , "pollution" , "1970" );
        dataset.addValue( 2 , "pollution" , "1980" );
        dataset.addValue( 1.5 , "pollution" ,  "1990" );
        dataset.addValue( 2 , "pollution" , "2000" );
        dataset.addValue( 1 , "pollution" , "2010" );
        dataset.addValue( 3 , "pollution" , "2014" );
        
        return dataset; 
    }

}
